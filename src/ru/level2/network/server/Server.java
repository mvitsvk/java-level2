package ru.level2.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;


public class Server {
    private ServerSocket server;
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;
    private Auth authUser;
    private Set<ListConnectUser> listUserAuth;


    public Server(int port) {
        authUser = new Auth();
        listUserAuth = new HashSet<>();

        try {
            server = new ServerSocket(port);
            System.out.println("Server is run...");
            System.out.println("Waiting Client connections.");
        } catch (IOException e) {
            throw new RuntimeException("ServerWaitClient", e);
        }

        while (true) {
            try {

                client = server.accept();
                System.out.println("Client connect: " + client.toString());
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());

                new Thread (()->{
                    SockConnect(client, in, out,
                            listUserAuth,
                            authUser
                    );
                })
                    .start();


            } catch(IOException e){
                throw new RuntimeException("Client connect error", e);
        }
    }

    };

        private void SockConnect(Socket client, DataInputStream in, DataOutputStream out,
                                 Set<ListConnectUser> listUserAuth,
                                 Auth authUser
                                 ) {
                String str;
                String nikname ="";
                String[] strSplit;

                while (true) {
                    try {
                        str = in.readUTF();
                        //разобрали строку
                        strSplit = str.split(" ");

                        //проверка
                        if (str.startsWith("/auth")) {
                            //проверили наличие
                            if (authUser.AuthFind(strSplit[1],strSplit[2]) != null) {
                                nikname = authUser.AuthFind(strSplit[1],strSplit[2]).getNikname();
                                //проверяем нет ли такого уже в списке подключенных
                                if(FindListConnectUser(listUserAuth, nikname)){
                                    message("", "User " + nikname + " connet to chat.");
                                } else out.writeUTF("User " + nikname + " already connected to the chat.");
                            } else out.writeUTF("User unknown");
                        //выход пользователя
                        } else if (str.startsWith("/w") && !nikname.equals("")) {
                            //тут не допилил. надо отрезать начало строки вырезав /w и никнейм
                            message(strSplit[1], strSplit[1] + " sey:" + str);
                        } else if (str.startsWith("/exit")) {
                            message("", "User" + nikname + " connet to chat.");
                            client.close();
                            break;
                        } else if (!nikname.equals("")){
                            message("", nikname + ": " + str);
                        } else out.writeUTF("command unknown");
                    } catch (IOException e) {
                        System.out.println("Connect close");
                        break;
                    }
                }
        }

    //поиск уже имеющегося пользователя
    public boolean FindListConnectUser(Set<ListConnectUser> listUserAuth, String nikName){
            if (listUserAuth.size() > 0) {
                for (ListConnectUser user : listUserAuth) {
                    //если есть
                    if (user.getNikname().equals(nikName)) {
                        return false;
                    }
                }
            }
        //добавляем в список еще нового
        listUserAuth.add(new ListConnectUser(nikName, client, in, out));
        return true;
    }

        private void message (String nikname, String message){
            if (nikname.equals("")) {
                System.out.println("> " + message);
                for (ListConnectUser user: listUserAuth) {
                    try {
                        user.getOut().writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                System.out.println("> " + message);
                for (ListConnectUser user: listUserAuth) {
                    try {
                        if (user.getNikname().equals(nikname)) {
                            user.getOut().writeUTF(message);
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

}
