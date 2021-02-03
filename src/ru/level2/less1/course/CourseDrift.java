package ru.level2.less1.course;

import ru.level2.less1.sport.Participant;

public class CourseDrift extends CourseAbstract{
    private int distance = 49;

    @Override
    protected void doIt(Participant participant) {
        if (participant.getDrift()>= distance) participant.setPass(true);
    }

}
