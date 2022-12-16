package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
import Project.Payload;
import Project.PayloadType;
import Project.RoomResultPayload;
 */
import java.util.Scanner;

/**
 * A server-side representation of a single client
 */
public class ServerThread extends Thread {
    private Socket client;
    private String clientName;
    private boolean isRunning = false;
    private ObjectOutputStream out;// exposed here for send()
    // private Server server;// ref to our server so we can call methods on it
    // more easily
    private Room currentRoom;
    private static Logger logger = Logger.getLogger(ServerThread.class.getName());
    private long myId;
    public List<String> mutedList = new ArrayList<String>();

    public List<String> getMutedClients() {
        return this.mutedList;
    }

	protected boolean send(String clientName, String message) {
        Payload payload = new Payload();
        payload.setPayloadType(PayloadType.MESSAGE);
        payload.setClientName(clientName);
        payload.setMessage(message);
   
        return sendPayload(payload);
    }

    private boolean sendPayload(Payload p) {
        try {
            out.writeObject(p);
            return true;
        }
        catch (IOException e) {
            logger.log(Level.INFO, "Error sending message to client (most likely disconnected)");
            e.printStackTrace();
            cleanup();
            return false;
        }
    }

    public boolean isMuted(String client) {
    	clientName = clientName.trim().toLowerCase(); 
    	return mutedList.contains(client); 
    }
    
    public void mute(String username) {
    	username = username.trim().toLowerCase();
    	if (!isMuted(username)) {
    		mutedList.add(username);
            saveMutedList();
    	}
    }
    
    public void unmute(String username) {
    	username = username.trim().toLowerCase();
    	if (isMuted(username)) {
    		mutedList.remove(username);
            saveMutedList();
    	}
    }
    
    public void saveMutedList() {
        String info = clientName + ": " + String.join(", ", mutedList);
        try
            {
                File mutedList = new File("mutedlist.txt");
                PrintWriter out = new PrintWriter(new FileWriter("mutedlist.txt", true));
                out.write(info);
                out.close();

                if (mutedList.createNewFile())
                {
                    System.out.println("File created: " + mutedList.getName());
                }
                else
                {
                    System.out.println("The File already exists.");
                }
            }
            catch (IOException e)
            {
                System.out.println("Error Occurred.");
                e.printStackTrace();
            }
        }
        public void loadMuteList() {
	   	 File file = new File(clientName + ".txt");
	   	 if (file.exists()) {
		   	 try (Scanner reader = new Scanner(file)) {
		   		String dataFromFile = "";
		   		while (reader.hasNextLine()) {
			   		 String text = reader.nextLine();
			   		 dataFromFile += text;
		   		}
		   		dataFromFile = dataFromFile.substring(dataFromFile.indexOf(" ")+1);;
		   		if (!dataFromFile.strip().equals("") && !dataFromFile.isEmpty()) {
		   			List<String> getClients = Arrays.asList(dataFromFile.split(", "));
		   	    	for (String client : getClients) {
		   	    	    mute(client);
		   	    	    System.out.println("sync");
		   	    	}
		   		}
		   	 }
		   	catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	   	 }
	   	 System.out.println("file doesn't exist");
    }

    public String getUsername()
    {
        return clientName;
    }

    public void setClientId(long id) {
        myId = id;
    }

    public long getClientId() {
        return myId;
    }

    public boolean isRunning() {
        return isRunning;
    }

    private void info(String message) {
        System.out.println(String.format("Thread[%s]: %s", getId(), message));
    }

    public ServerThread(Socket myClient, Room room) {
        info("Thread created");
        // get communication channels to single client
        this.client = myClient;
        this.currentRoom = room;

    }

    protected void setClientName(String name) {
        if (name == null || name.isBlank()) {
            System.err.println("Invalid client name being set");
            return;
        }
        clientName = name;
    }

    protected String getClientName() {
        return clientName;
    }

    protected synchronized Room getCurrentRoom() {
        return currentRoom;
    }

    protected synchronized void setCurrentRoom(Room room) {
        if (room != null) {
            currentRoom = room;
        } else {
            info("Passed in room was null, this shouldn't happen");
        }
    }

    public void disconnect() {
        sendConnectionStatus(myId, getClientName(), false);
        info("Thread being disconnected by server");
        isRunning = false;
        cleanup();
    }

    // send methods
    public boolean sendRoomName(String name) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.JOIN_ROOM);
        p.setMessage(name);
        return send(p);
    }

    public boolean sendRoomsList(String[] rooms, String message) {
        RoomResultPayload payload = new RoomResultPayload();
        payload.setRooms(rooms);
        //Fixed in Module7.Part9
        if(message != null){
            payload.setMessage(message);
        }
        return send(payload);
    }

    public boolean sendExistingClient(long clientId, String clientName) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.SYNC_CLIENT);
        p.setClientId(clientId);
        p.setClientName(clientName);
        return send(p);
    }

    public boolean sendResetUserList() {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.RESET_USER_LIST);
        return send(p);
    }

    public boolean sendClientId(long id) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.CLIENT_ID);
        p.setClientId(id);
        return send(p);
    }

    public boolean sendMessage(long clientId, String message) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.MESSAGE);
        p.setClientId(clientId);
        p.setMessage(message);
        return send(p);
    }

    public boolean sendConnectionStatus(long clientId, String who, boolean isConnected) {
        Payload p = new Payload();
        p.setPayloadType(isConnected ? PayloadType.CONNECT : PayloadType.DISCONNECT);
        p.setClientId(clientId);
        p.setClientName(who);
        p.setMessage(isConnected ? "connected" : "disconnected");
        return send(p);
    }

    private boolean send(Payload payload) {
        // added a boolean so we can see if the send was successful
        try {
            // TODO add logger
            logger.log(Level.FINE, "Outgoing payload: " + payload);
            out.writeObject(payload);
            logger.log(Level.INFO, "Sent payload: " + payload);
            return true;
        } catch (IOException e) {
            info("Error sending message to client (most likely disconnected)");
            // comment this out to inspect the stack trace
            // e.printStackTrace();
            cleanup();
            return false;
        } catch (NullPointerException ne) {
            info("Message was attempted to be sent before outbound stream was opened: " + payload);
            return true;// true since it's likely pending being opened
        }
    }

    // end send methods
    @Override
    public void run() {
        info("Thread starting");
        try (ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());) {
            this.out = out;
            isRunning = true;
            Payload fromClient;
            while (isRunning && // flag to let us easily control the loop
                    (fromClient = (Payload) in.readObject()) != null // reads an object from inputStream (null would
                                                                     // likely mean a disconnect)
            ) {

                info("Received from client: " + fromClient);
                processPayload(fromClient);

            } // close while loop
        } catch (Exception e) {
            // happens when client disconnects
            e.printStackTrace();
            info("Client disconnected");
        } finally {
            isRunning = false;
            info("Exited thread loop. Cleaning up connection");
            cleanup();
        }
    }

    void processPayload(Payload p) {
        switch (p.getPayloadType()) {
            case CONNECT:
                setClientName(p.getClientName());
                break;
            case DISCONNECT:
                Room.disconnectClient(this, getCurrentRoom());
                break;
            case MESSAGE:
                if (currentRoom != null) {
                    currentRoom.sendMessage(this, p.getMessage());
                } else {
                    // TODO migrate to lobby
                    logger.log(Level.INFO, "Migrating to lobby on message with null room");
                    Room.joinRoom("lobby", this);
                }
                break;
            case GET_ROOMS:
                Room.getRooms(p.getMessage().trim(), this);
                break;
            case CREATE_ROOM:
                Room.createRoom(p.getMessage().trim(), this);
                break;
            case JOIN_ROOM:
                Room.joinRoom(p.getMessage().trim(), this);
                break;
            default:
                break;

        }

    }

    private void cleanup() {
        info("Thread cleanup() start");
        try {
            client.close();
        } catch (IOException e) {
            info("Client already closed");
        }
        info("Thread cleanup() complete");
    }
}