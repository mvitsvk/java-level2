package ru.level2.les1.sport;

public class Main {

    public static void main(String[] args) {
	// write your code here
        sport();

    }

    static void sport(){
        Teams commanda = new Teams();

        Courses cours = new Courses();
        commanda.printTeam(false, cours);
        cours.dolt(commanda);
        commanda.printTeam(true, cours);
    }
}
