package ru.level2.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import ru.level2.network.SockConnect;

public class Server {
    private ServerSocket server;
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;

    public Server(int port){
        try {

            server = new ServerSocket(port);
            System.out.println("Server is run...");
            System.out.println("Waiting Client connections.");

            try {

                client = server.accept();
                System.out.println("Client connect: " + client.toString());

            } catch (IOException e) {
                throw new RuntimeException("ServerWaitClient" ,e);
            }

            try {

                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());

            } catch (IOException e) {
                throw new RuntimeException("DataStream" ,e);
            }

            new SockConnect(client,in,out);

        } catch (IOException e) {
            throw new RuntimeException("RunServer" ,e);
        }

    };

}
