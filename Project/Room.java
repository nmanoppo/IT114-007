package Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.*;

//import Project.Constants;
//import Project.GeneralUtils;



public class Room implements AutoCloseable{
	private String name;
	private List<ServerThread> clients = Collections.synchronizedList(new ArrayList<ServerThread>());
	private boolean isRunning = false;
	// Commands
	private final static String COMMAND_TRIGGER = "/";
	private final static String CREATE_ROOM = "createroom";
	private final static String JOIN_ROOM = "joinroom";
	private final static String DISCONNECT = "disconnect";
	private final static String LOGOUT = "logout";
	private final static String LOGOFF = "logoff";
	private final static String FLIP = "flip";
	private final static String ROLL = "roll";
	private final static String COMMAND_TRIGGER2 = "@";
	private final static String UNMUTE = "unmute";
	private final static String MUTE = "mute";
	private static Logger logger = Logger.getLogger(Room.class.getName());
	private HashMap<String, String> converter = null;

	public Room(String name) {
		this.name = name;
		isRunning = true;
	}

	private void info(String message) {
		System.out.println(String.format("Room[%s]: %s", name, message));
	}

	public String getName() {
		return name;
	}

	public boolean isRunning() {
		return isRunning;
	}

	protected synchronized void addClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		client.setCurrentRoom(this);
		if (clients.indexOf(client) > -1) {
			info("Attempting to add a client that already exists");
		} else {
			clients.add(client);
			sendConnectionStatus(client, true);
			sendRoomJoined(client);
			sendUserListToClient(client);
		}
	}

	protected synchronized void removeClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		clients.remove(client);
		// we don't need to broadcast it to the server
		// only to our own Room
		if (clients.size() > 0) {
			//sendMessage(client, "left the room");
			sendConnectionStatus(client, false);
		}
		checkClients();
	}

	/***
	 * Checks the number of clients.
	 * If zero, begins the cleanup process to dispose of the room
	 */
	private void checkClients() {
		// Cleanup if room is empty and not lobby
		if (!name.equalsIgnoreCase("lobby") && clients.size() == 0) {
			close();
		}
	}

	/***
	 * Helper function to process messages to trigger different functionality.
	 * 
	 * @param message The original message being sent
	 * @param client  The sender of the message (since they'll be the ones
	 *                triggering the actions)
	 */
	private boolean processCommands(String message, ServerThread client) {
		boolean wasCommand = false;
		try {
			if (message.startsWith(COMMAND_TRIGGER)) {
				String[] comm = message.split(COMMAND_TRIGGER);
				String part1 = comm[1];
				String[] comm2 = part1.split(" ");
				String command = comm2[0];
				String roomName;
				wasCommand = true;
				switch (command) {
					case CREATE_ROOM:
						roomName = comm2[1];
						Room.createRoom(roomName, client);
						break;
					case JOIN_ROOM:
						roomName = comm2[1];
						Room.joinRoom(roomName, client);
						break;
					case FLIP:
						String coinFlip = Room.flip();
						String username1 = client.getClientName();
						sendMessage(client, username1 + " Flipped a coin and got: " + coinFlip);
						break;
					case ROLL:
						String number = Room.roll();
						String username = client.getClientName();
						sendMessage(client, username + " Rolled a dice and got: " + number);
						break;
					case MUTE:
						String[] UserName = message.split(" ");
						String userToBeMuted = UserName[1];
						client.mutedList.add(userToBeMuted);
						client.mute(userToBeMuted);
						sendMessage(client, userToBeMuted + " Has been muted!");
						break;
					case UNMUTE:
						String[] UserName1 = message.split(" ");
						String userToBeUnmuted = UserName1[1];
						for (String name : client.mutedList) {
							if(name.equals(userToBeUnmuted)) {
								client.mutedList.remove(userToBeUnmuted);
								client.unmute(userToBeUnmuted);
								sendMessage(client, "You have unmuted " + userToBeUnmuted + "!");
								break;
							}
						}
					case DISCONNECT:
					case LOGOUT:
					case LOGOFF:
						Room.disconnectClient(client, this);
						break;
					default:
						wasCommand = false;
						break;
				}
			} else if (message.startsWith(COMMAND_TRIGGER2)) {
				String[] comm = message.split(COMMAND_TRIGGER2);
				String part2 = comm[1];
				String[] comm1 = part2.split(" ");
				String username = comm1[0];
				logger.log(Level.INFO, "Whispered username: " + username);
				wasCommand = true;
				synchronized (clients) {
					Iterator<ServerThread> iter = clients.iterator();
					while (iter.hasNext()) {
						ServerThread target = iter.next();
						logger.log(Level.INFO, "Checking against username: " + target.getUsername());
						if (username.equals(target.getUsername())) {
							boolean messagesend = target.sendMessage(target.getClientId(), message);
							if (!messagesend) {
								handleDisconnect(iter, client);
							}

						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wasCommand;
	}

	// Command helper methods
	protected static void getRooms(String query, ServerThread client) {
		String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
		client.sendRoomsList(rooms,(rooms!=null&&rooms.length==0)?"No rooms found containing your query string":null);
	}

	protected static void createRoom(String roomName, ServerThread client) {
		if (Server.INSTANCE.createNewRoom(roomName)) {
			Room.joinRoom(roomName, client);
		} else {
			client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
			client.sendRoomsList(null, String.format("Room %s already exists", roomName));
		}
	}

	protected static void joinRoom(String roomName, ServerThread client) {
		if (!Server.INSTANCE.joinRoom(roomName, client)) {
			client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
			client.sendRoomsList(null, String.format("Room %s doesn't exist", roomName));
		}
	}

	public static String flip() {
		Random rand = new Random();
		String sideUp;
		int sideup = rand.nextInt(2);
		if (sideup == 0) {
			sideUp = "heads";
		} else {
			sideUp = "tails";
		}
		return sideUp;
	}

	public static String roll() {
		Random rand = new Random();
		int random = rand.nextInt(10) + 1;
		for (int i = 0; i < 10; i++) {
			System.out.println(random);
		}
		String number = " " + random;
		return number;
	}

	protected static void disconnectClient(ServerThread client, Room room) {
		client.setCurrentRoom(null);
		client.disconnect();
		room.removeClient(client);
	}
	// end command helper methods

	/***
	 * Takes a sender and a message and broadcasts the message to all clients in
	 * this room. Client is mostly passed for command purposes but we can also use
	 * it to extract other client info.
	 * 
	 * @param sender  The client sending the message
	 * @param message The message to broadcast inside the room
	 */
	protected synchronized void sendMessage(ServerThread sender, String message) {
		if (!isRunning) {
			return;
		}
		info("Sending message to " + clients.size() + " clients");
		if (sender != null && processCommands(message, sender)) {
			// it was a command, don't broadcast
			return;
		}
		message = formatMessage(message);
		long from = (sender == null) ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
		synchronized (clients) {
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread client = iter.next();
				boolean messageSent = client.sendMessage(from, message);
				if (!messageSent) {
					handleDisconnect(iter, client);
				}
			}
		}
	}

	protected synchronized void sendUserListToClient(ServerThread receiver) {
		logger.log(Level.INFO, String.format("Room[%s] Syncing client list of %s to %s", getName(), clients.size(),
				receiver.getClientName()));
		synchronized (clients) {
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread clientInRoom = iter.next();
				if (clientInRoom.getClientId() != receiver.getClientId()) {
					boolean messageSent = receiver.sendExistingClient(clientInRoom.getClientId(),
							clientInRoom.getClientName());
					// receiver somehow disconnected mid iteration
					if (!messageSent) {
						handleDisconnect(null, receiver);
						break;
					}
				}
			}
		}
	}


	protected synchronized void sendRoomJoined(ServerThread receiver) {
		boolean messageSent = receiver.sendRoomName(getName());
		if (!messageSent) {
			handleDisconnect(null, receiver);
		}
	}

	protected String formatMessage(String message) {
		String alteredMessage = message;
		if(converter == null) {
			converter = new HashMap<String, String>();
			converter.put("\\*{2}", "<b>|</b>");
			converter.put("--", "<i>|</i>");
			converter.put("__", "<u>|</u>");
			converter.put("#r#", "<font color=\"red\">|</font>");
			converter.put("#g#", "<font color=\"green\">|</font>");
			converter.put("#b#", "<font color=\"blue\">|</font>");
		}
		for (Entry<String, String> kvp : converter.entrySet()) {
			if (GeneralUtils.countOccurencesInString(alteredMessage, kvp.getKey().toLowerCase()) >= 2) {
				String[] s1 = alteredMessage.split(kvp.getKey().toLowerCase());
				String m = "";
				for (int i = 0; i < s1.length; i++) {
					if (i % 2 == 0) {
						m += s1[i];
					} else {
						String[] wrapper = kvp.getValue().split("\\|");
						m += String.format("%s%s%s", wrapper[0], s1[i], wrapper[1]);
					}
				}
				alteredMessage = m;
			}
		}

		return alteredMessage;
	}
	protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
		// converted to a backwards loop to help avoid concurrent list modification
		// due to the recursive sendConnectionStatus()
		// this should only be needed in this particular method due to the recusion
		if (clients == null) {
			return;
		}
		synchronized (clients) {
			for (int i = clients.size() - 1; i >= 0; i--) {
				ServerThread client = clients.get(i);
				boolean messageSent = client.sendConnectionStatus(sender.getClientId(), sender.getClientName(),
						isConnected);
				if (!messageSent) {
					clients.remove(i);
					info("Removed client " + client.getClientName());
					checkClients();
					sendConnectionStatus(client, false);
				}
			}
		}
	}

	private synchronized void handleDisconnect(Iterator<ServerThread> iter, ServerThread client){
		if (iter != null) {
			iter.remove();
		}
		info("Removed client " + client.getClientName());
		checkClients();
		sendConnectionStatus(client, false);
	}

	public void close() {
		Server.INSTANCE.removeRoom(this);
		isRunning = false;
		clients = null;
	}
}
