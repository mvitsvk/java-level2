package ru.level2.les1.sport;

public class Teams implements Team{
    private String [] name = new String [4];
    private boolean [] sportStatus = new boolean[4];

    public Teams (){
        name[0] = "Ivan";
        sportStatus[0] = false;
        name[1] = "Jan";
        sportStatus[1] = false;
        name[2] = "Sapsan";
        sportStatus[2] = false;
        name[3] = "Ruslan";
        sportStatus[3] = false;
    }
    //status true - print Course complite
    // false - all print
    public void printTeam(boolean status, Courses  list) {
        for (int i = 0; i < name.length; i++) {
            if (sportStatus[i] == true & status == true) System.out.println("Course complite Name: " + name[i]
            +   ". List Course: " + list.listSport());
            else if (status == false) System.out.println("Team Name: " + name[i]);
        }
    }

    public void setSportStatus(int i, boolean status) {
        sportStatus[i] = status;
    }

    public String [] getName(){
        return name;
    }
}
