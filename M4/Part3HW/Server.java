package M4.Part3HW;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Server {
    int port = 3001;
    // connected clients
    private List<ServerThread> clients = new ArrayList<ServerThread>();

    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            System.out.println("Server is listening on port " + port);
            do {
                System.out.println("waiting for next client");
                if (incoming_client != null) {
                    System.out.println("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, this);
                    
                    clients.add(sClient);
                    sClient.start();
                    incoming_client = null;
                    
                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            System.err.println("Error accepting connection");
            e.printStackTrace();
        } finally {
            System.out.println("closing server socket");
        }
    }
    protected synchronized void disconnect(ServerThread client) {
		long id = client.getId();
    client.disconnect();
		broadcast("Disconnected", id);
	}
    
    protected synchronized void broadcast(String message, long id) {
        if(processCommand(message, id)){

            return;
        }
        // let's temporarily use the thread id as the client identifier to
        // show in all client's chat. This isn't good practice since it's subject to
        // change as clients connect/disconnect
        message = String.format("User[%d]: %s", id, message);
        // end temp identifier
        
        // loop over clients and send out the message
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            boolean wasSuccessful = client.send(message);
            if (!wasSuccessful) {
                System.out.println(String.format("Removing disconnected client[%s] from list", client.getId()));
                it.remove();
                broadcast("Disconnected", id);
            }
        }
    }
    
    /**
     * @param message
     * @param clientId
     * @return
     */
    private boolean processCommand(String message, long clientId) {
        System.out.println("Checking command: " + message);
        if(message.equalsIgnoreCase("disconnect")){
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()) {
                ServerThread client = it.next();
                if(client.getId() == clientId){
                    it.remove();
                    disconnect(client);
                    break;
                }
            }
            return true;
        }
        else if (message.equalsIgnoreCase("Coin Flip")) { //NADIA, NM94, Oct 12th 2022; Coin flip implementation, which returns HEADS or TAILS to all connected clients
            Random random = new Random();
            String sideUp;
            int sideup = random.nextInt(2);
                if (sideup == 0) {
                    broadcast("HEADS", clientId);
                }
                else {
                    broadcast("TAILS", clientId);
                }
            }
        else if (message.equalsIgnoreCase("Guess a number")) { //NADIA, NM94, Oct 12th 2022; Number guesser implementation, which generates a random number for the clients to guess
            Random rand = new Random();
            int randomNum = rand.nextInt(10);
            int userGuess;
            boolean correct = false;

            Scanner guess = new Scanner(System.in);
            System.out.println("I've chosen a number from 1-10, can you guess it?");

            while (!correct) {
                userGuess = guess.nextInt();

                if (userGuess == randomNum) {
                    correct = true;
                    broadcast("You guessed correctly!", clientId);
                }
                else if (userGuess < randomNum) {
                    broadcast("Guess Higher", clientId);
                }
                else if (userGuess > randomNum) {
                    broadcast("Guess Lower", clientId);
                }

            } 
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println("Starting Server");
        Server server = new Server();
        int port = 3000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        server.start(port);
        System.out.println("Server Stopped");
    }
}
