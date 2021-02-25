package ru.level2.network.server;

public class UserCtructure {
    private String login;
    private String pass;
    private String nikname;


    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getNikname() {
        return nikname;
    }

    public UserCtructure(String login, String pass, String nikname) {
        this.login = login;
        this.pass = pass;
        this.nikname = nikname;
    }


}
