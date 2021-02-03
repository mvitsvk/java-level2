package ru.level2.less1.course;

import ru.level2.less1.sport.Participant;

public class CourseRun extends CourseAbstract{
    private int distance = 190;

    @Override
    protected void doIt(Participant participant) {
        if (participant.getRuns()>= distance) participant.setPass(true);
    }
}
