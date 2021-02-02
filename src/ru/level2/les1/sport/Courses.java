package ru.level2.les1.sport;

import java.util.Random;

public class Courses implements Course{
    Random rand = new Random();

    public void dolt(Team team) {
        for (int i = 0; i < team.getName().length; i++) {
            team.setSportStatus(i, randomSport());
        }
    }

    private boolean randomSport(){
        return (rand.nextInt(2) == 0) ? false : true;
    }

    public String listSport() {

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < course.length; i++) {
            str.append(course[i]+ ", ");
        }
        str.replace(str.length()-2, str.length(),".");
        return str.toString();
    }

}
