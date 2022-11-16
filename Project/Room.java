package Project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import java.util.*;

public class Room implements AutoCloseable{
	protected static Server server;// used to refer to accessible server functions
	private String name;
	private List<ServerThread> clients = new ArrayList<ServerThread>();
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
	private final static String TEXT_TRIGGER = "!";

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

	protected synchronized void addClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		client.setCurrentRoom(this);
		if (clients.indexOf(client) > -1) {
			info("Attempting to add a client that already exists");
		} else {
			clients.add(client);
			new Thread() {
				@Override
				public void run() {
					// slight delay to let potentially new client to finish
					// binding input/output streams
					// comment out the Thread.sleep to see what happens
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//sendMessage(client, "joined the room " + getName());
					sendConnectionStatus(client, true);
				}
			}.start();

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
					case FLIP: //Nadia Manoppo, nm94
						String coinFlip = Room.flip();
						sendMessage(client, coinFlip);
						break;
					case ROLL: //Nadia Manoppo, nm94
						String number = Room.roll();
						sendMessage(client, number);
						break;
					case DISCONNECT:
					case LOGOUT:
					case LOGOFF:
						Room.disconnectClient(client, this);
						break;
					default:
						wasCommand = false;
						break;
				}
<<<<<<< HEAD
			
			} else if (message.startsWith(TEXT_TRIGGER)) { //text trigger is '!', NADIA MANOPPO, nm94
				String tags1 = "**";
				String tags2 = "<b>r";
				String tags3 = "<b>b";
				String tags4 = "<b>g";
				String tags5 = "<b>y";
=======
        
			} else {
				//bold (#)
				//I used regex to read through a message user sends and determine if it contains the indicators of bold and/or italics, underline, or color. If true it will enter the if statement, and it will split
				//the text by the indicator [bold(#), italics(_), bold & italics (**_ _**), underline (~), color (#r)], and if the sentence has matching tags at the beginning and end, it will replace the tags with html characters
				// such as [<b></b> for bold, <i></i> for italics, <b><i></i></b> for bold & italics, <u></u> for underline, <color></color>] and it will send the revised text back to the client. However, if it does not have
				//matching opening and closing tags, it will first split by the first tag and put it into a list containing two strings. then I will get the string at index 1 (should be text after the first tag)
				//Then i will split it again by the closing tag, and then I will take the index of 0 (should be the text before the closing tag), and then append the html characters to the desired text.
>>>>>>> 61c3cbbae0d32ff5b5f17577f2c6a7225404f760
				if (message.matches("(.*)#(.+)#(.*)")) {
					message = message.replace("#", "</b>");
					message = message.replaceFirst("</b>", "<b>");
					sendMessage(client, message);
				}
				if (message.matches("(.*)_(.+)_(.*)")) {
<<<<<<< HEAD
					message = message.replace("_", "</i>");
					message = message.replaceFirst("</i>", "<i>");
					sendMessage(client, message);
				} 
				if (message.contains(tags1)) {
					message = message.replace("**", "<b>");
					message = message.replaceFirst("<b>", "</b>");
					sendMessage(client, message);
				} 
				if (message.matches("(.*)~(.+)~(.*)")) {
					message = message.replace("~", "</u>");
					message = message.replaceFirst("</u>", "<u>");
					sendMessage(client, message);
				} 
				if (message.contains(tags2)) {
					message = message.replace("<b>r", "<color=red>");
					message = message.replaceFirst("</b>r", "</color=red>");
					sendMessage(client, message);
				} 
				if (message.matches(tags3)) {
					message = message.replace("<b>b", "<color=blue>");
					message = message.replaceFirst("</b>r", "</color=blue>");
					sendMessage(client, message);
				} 
				if (message.matches(tags4)) {
					message = message.replace("<b>g", "<color=green>");
					message = message.replaceFirst("</b>g", "</color=green>");
					sendMessage(client, message);
				} 
				if (message.matches(tags5)) {
					message = message.replace("<b>y", "<color=yellow>");
					message = message.replaceFirst("</b>y", "</color=yellow>");
					sendMessage(client, message);
=======
				String[] plainText2 = message.split("_");
				String text2 = "<i>" + plainText2[1] + "</i>";
				sendMessage(client, text2);
				}
				//bold & italics (**_ _**)
				if (message.matches("(.*)**_(.+)_**(.*)")) {
					String[] plainText3 = message.split("**_");
					String[] newText3 = plainText3[1].split("_**");
					String text3 = "<b><i>" + newText3[0] + "</i></b>";
					sendMessage(client, text3);
				}
				//underline (~)
					String text = "<b><i>" + newText3[0] + "</i></b>";
					sendMessage(client, text);
				}
				//underline
				if (message.matches("(.*)~(.+)~(.*)")) {
					String[] plainText4 = message.split("~");
					String text4 = "<u>" + plainText4[1] + "<u>";
					sendMessage(client, text4);
				}
				//color (#r)
				if (message.matches("(.*)#r(.+)#r(.*)")) {
					String[] plainText5 = message.split("#r");
					String[] newText5 = plainText5[1].split("r#");
					String text5 = "<color>" + newText5[0] + "</color>";
					sendMessage(client, text5);
>>>>>>> 61c3cbbae0d32ff5b5f17577f2c6a7225404f760
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wasCommand;
	}

	// Command helper methods
	protected static void createRoom(String roomName, ServerThread client) {
		if (server.createNewRoom(roomName)) {
			//server.joinRoom(roomName, client);
			Room.joinRoom(roomName, client);
		} else {
			client.sendMessage("Server", String.format("Room %s already exists", roomName));
		}
	}

	protected static void joinRoom(String roomName, ServerThread client) {
		if (!server.joinRoom(roomName, client)) {
			client.sendMessage("Server", String.format("Room %s doesn't exist", roomName));
		}
	}

	public static String flip() { //Nadia Manoppo, nm94
		Random rand = new Random();
		String sideUp;
		int sideup = rand.nextInt(2);
		if (sideup == 0) {
			sideUp = "Flipped a coin and got HEADS";
		} else {
			sideUp = "Flipped a coin and got TAILS";
		}
		return sideUp;
	}

	public static String roll() { //Nadia Manoppo, nm94
		Random rand = new Random();
		int random = rand.nextInt(10) + 1;
		String number = "I rolled a number between 1-10, and got: " + random;
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
		
		String from = (sender == null ? "Room" : sender.getClientName());
		Iterator<ServerThread> iter = clients.iterator();
		while (iter.hasNext()) {
			ServerThread client = iter.next();
			boolean messageSent = client.sendMessage(from, message);
			if (!messageSent) {
				handleDisconnect(iter, client);
			}
		}
	}
	protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected){
		Iterator<ServerThread> iter = clients.iterator();
		while (iter.hasNext()) {
			ServerThread client = iter.next();
			boolean messageSent = client.sendConnectionStatus(sender.getClientName(), isConnected);
			if (!messageSent) {
				handleDisconnect(iter, client);
			}
		}
	}
	private void handleDisconnect(Iterator<ServerThread> iter, ServerThread client){
		iter.remove();
		info("Removed client " + client.getClientName());
		checkClients();
		sendMessage(null, client.getClientName() + " disconnected");
	}
	public void close() {
		server.removeRoom(this);
		server = null;
		isRunning = false;
		clients = null;
	}
}
