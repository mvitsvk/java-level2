package ru.level2.network.client;

import ru.level2.network.client.gui.ChatForm;
import ru.level2.network.client.network.BasicChatNetwork;

import java.util.function.Consumer;


public class ClientChatAdapter {
    private final BasicChatNetwork network;
    private final ChatForm frame;

    public ClientChatAdapter(String host, int port) {
        this.frame = new ChatForm(new Consumer<String>() {
            @Override
            public void accept(String message) {
                network.send(message);
            }
        });
        this.network = new BasicChatNetwork(host, port);

        receive();
    }

    private void receive() {
        new Thread(() -> {
            while (true) {
                String message = network.receive();
                frame.setTextChat(message);
            }
        })
                .start();
    }

}
