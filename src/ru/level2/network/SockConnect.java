package ru.level2.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SockConnect {
    public SockConnect(Socket client,
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
