import ru.level2.less1.course.CourseDrift;
import ru.level2.less1.course.CourseInterface;
import ru.level2.less1.course.CourseRun;
import ru.level2.less1.sport.Participant;
import ru.level2.less1.sport.Team;

public class Main {

//сказали бы что надо поступить как с котами и собаками :)

    public static void main(String[] args) {
        teamRun();
    }

    public static void teamRun(){

        //комманду создал
        Team team = new Team("buffalo",
                new Participant("sportsman1", 200, 40),
                new Participant("sportsman2", 155, 70),
                new Participant("sportsman3", 210, 51),
                new Participant("sportsman4", 90, 30),
                new Participant("sportsman5", 180, 54),
                new Participant("sportsman6", 201, 94));
        //теперь надо отправить её на препядствия
        team.printAll();

        CourseInterface[] courses = {new CourseRun(), new CourseDrift()};

        for (int i = 0; i < courses.length; i++) {
            courses[i].doIt(team);
        }

        //кто прошёл
        team.printPass();

    }
}
