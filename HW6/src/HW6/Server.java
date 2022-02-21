package HW6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
        Socket clientSocket = null;
        Scanner scanner = new Scanner(System.in);

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server started");
            clientSocket = serverSocket.accept(); //сервер будет ждать, пока на порт никто не постучиться пообщаться
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

            Thread threadReader = new Thread(() -> {
                try {
                    while (true) {
                        outputStream.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            threadReader.setDaemon(true);
            threadReader.start();

            while (true) {
                String str = inputStream.readUTF();
                if (str.equals("/end")) {
                    System.out.println("Client покинул сервер");
                    outputStream.writeUTF("/end");
                    break;
                } else {
                    System.out.println("Client: " + str);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                assert clientSocket != null;
                clientSocket.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}