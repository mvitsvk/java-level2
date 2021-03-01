package ru.level2.less1.sport;

public class Participant {
    private String name;
    private int runs;
    private int drift;
    private boolean pass;

    public Participant(String name, int runs, int drift) {
        this.name = name;
        this.runs = runs;
        this.drift = drift;
        this.pass = false;
    }

    public String getName() {
        return name;
    }

    public int getRuns() {
        return runs;
    }

    public int getDrift() {
        return drift;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", runs=" + runs +
                ", drift=" + drift +
                ", pass=" + pass +
                '}';
    }
}
