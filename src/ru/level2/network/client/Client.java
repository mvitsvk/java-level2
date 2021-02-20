package ru.level2.network.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import ru.level2.network.SockConnect;

public class Client {
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;

    public Client(String host,int port) {
        System.out.println("Client started");



        //попытка подключения к серверу
        //чтобы точно знать что и курица и яйцо могут быть первыми
        while (!connect(host,port)) delay(1000);

        try {
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException("DataStreamIN_OUT" ,e);
        }

        new SockConnect(client,in,out);

        }

    //пауза путём использования отдельного потока
    private void delay (int time){
        Thread times = new Thread(()->{
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        times.start();
        try {
            times.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //попытка соединения
    private boolean connect (String host,int port){
        try {
            client = new Socket(host,port);
            System.out.println("Client connected to server");
            return true;
        } catch (IOException e){
            System.out.println("Client not connect");
            return false;
        }
    }

}
