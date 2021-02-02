package ru.level2.les1.sport;

public interface Team {

    void printTeam(boolean status, Courses list);
    void setSportStatus(int i, boolean status);
    String [] getName();
}
