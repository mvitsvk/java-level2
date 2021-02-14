package ru.level2.les4.chat;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChatListener implements ActionListener {
    private JTextField textSend;
    private JTextArea textChat;

    public ChatListener (JTextField textSend, JTextArea textChat){
        this.textSend = textSend;
        this.textChat = textChat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.textChat.append(this.textSend.getText()+"\n");
        this.textSend.setText("");

    }

}
