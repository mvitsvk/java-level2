package ru.level2.network.server;

import java.util.Set;

public class Auth {
    private static Set<UserCtructure> users = Set.of(
            new UserCtructure("user1", "pwd1", "nik1"),
            new UserCtructure("user2", "pwd2", "nik2"),
            new UserCtructure("user3", "pwd3", "nik3"),
            new UserCtructure("user4", "pwd4", "nik4")
    );

    public UserCtructure AuthFind( String login, String pass) {
        for (UserCtructure user: users)
        {
            if (user.getLogin().equals(login) && user.getPass().equals(pass)) return user;
        }
        return null;
    }

}
