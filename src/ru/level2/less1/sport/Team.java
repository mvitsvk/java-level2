package ru.level2.less1.sport;

import ru.level2.less1.sport.Participant;

import java.util.Arrays;

public class Team {
    private String name;
    private Participant[] participants;

    public Team(String name, Participant... participants) {
        this.name = name;
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void printAll(){
        //или this.name
        System.out.println("Team name: " + getName());

        for (int i = 0; i < getParticipants().length; i++) {
            System.out.println("is present sportsman " + getParticipants()[i].getName());
        }
    }

    public void printPass(){
        //или this.name
        System.out.println("Team name: " + getName());

        for (int i = 0; i < getParticipants().length; i++) {

            if (getParticipants()[i].isPass()){
                System.out.printf("sportsman %s PASS\n", getParticipants()[i].getName());
            } else System.out.printf("sportsman %s failed to pass\n", getParticipants()[i].getName());
            //вывод для отладки
            System.out.println(getParticipants()[i].toString());
        }

    }

}
