package ru.level2.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ListConnectUser {
    private String nikname;
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;

    public ListConnectUser(String nikname, Socket client, DataInputStream in, DataOutputStream out) {
        this.nikname = nikname;
        this.client = client;
        this.in = in;
        this.out = out;
    }

    public String getNikname() {
        return nikname;
    }

    public DataOutputStream getOut() {
        return out;
    }


}
