package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private final int PORT = 8189;

    private List<ClientHandler> clients;
    private AuthService authService;

    public Server() {
        clients = new CopyOnWriteArrayList<>();
        authService = new SimpleAuthService();

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(ClientHandler sender, String msg){
        String message = String.format("[ %s ]: %s", sender.getNickname(), msg);

        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }
    //Home work_7
    public void privateMsg(ClientHandler sender, String recevier, String msg){
        String message = String.format("[ %s ] to [ %s ]: %s", sender.getNickname(), recevier, msg);

        for (ClientHandler c : clients) {
            if(c.getNickname().equals(recevier)){
                c.sendMsg(message);
                if(!sender.getNickname().equals(recevier)){
                    sender.sendMsg(message);
                }
                return;
            }
        }

        sender.sendMsg("not found user: "+ recevier);
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public AuthService getAuthService() {
        return authService;
    }
}
