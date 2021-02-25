package ru.level2.network.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

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

        SockConnect(client,in,out);

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

    public void SockConnect(Socket client,
                       DataInputStream in,
                       DataOutputStream out){

        Thread conIN = new Thread(()->{
            String str;
            while (true) {
                try {
                    str = in.readUTF();
                    if (str.equals("exit")) {
                        System.out.println("> " + str);
                        client.close();
                        break;
                    } else {
                        System.out.println("> " + str);
                    }
                } catch (IOException e) {
                    System.out.println("Connect close");
                    break;
                }
            }
        });


        Thread conOUT = new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            String str;
            while (true) {
                try {
                    str = scanner.nextLine();

                    if (str.equals("exit") && conIN.isAlive()) {
                        out.writeUTF(str);
                        client.close();
                        System.out.println("Connect close local");
                        break;
                    }

                    if (conIN.isAlive()) {
                        out.writeUTF(str);
                    }
                    else {
                        System.out.println("Connect close remove");
                        break;
                    }
                } catch (IOException e) {
                    throw new RuntimeException("DataStreamOUT" ,e);
                }
            }

        });

        conIN.start();
        conOUT.start();

    }



}
