package ru.level2.less1.course;

import ru.level2.less1.sport.Participant;
import ru.level2.less1.sport.Team;

public abstract class CourseAbstract implements CourseInterface{

    @Override
    public void doIt(Team team){
        for (int i = 0; i < team.getParticipants().length; i++) {
            doIt(team.getParticipants()[i]);
        }
    }

    protected abstract void doIt(Participant participant);

}
