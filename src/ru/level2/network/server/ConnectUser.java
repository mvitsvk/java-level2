package ru.level2.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Set;

public class ConnectUser {

    //поиск уже имеющегося пользователя
    public boolean FindListConnectUser(Set<ListUser> listUserAuth, String nikName){
        if (listUserAuth.size() > 0) {
            for (ListUser user : listUserAuth) {
                //если есть
                if (user.getNikname().equals(nikName)) {
                    return false;
                }
            }
        }
        return true;
    }

    //добавляем в список еще нового
    public synchronized void Subscribe (Set<ListUser> listUserAuth, Socket client,
            DataInputStream in, DataOutputStream out, String nikName) {
        listUserAuth.add(new ListUser(nikName, client, in, out));
    }

    //добавляем в список еще нового
    public synchronized void UnSubscribe (Set<ListUser> listUserAuth, String nikName){
        for (ListUser user: listUserAuth) {
            if (user.getNikname().equals(nikName)) {
                listUserAuth.remove(user);
                break;
            }
        }
    }

}
