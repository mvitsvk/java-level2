import ru.level2.less2.array.ArrayProcessing;
import ru.level2.less2.array.MyArrayDataException;
import ru.level2.less2.array.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
//Если честно, философия почему надо вылавливать исключения по типам
//                не савсем понятна.
//    с тем с чем сталкивался я , программа должна была работать дальше, но это только мой опыт

                mathArray();
    }

    static void mathArray(){

        String [][] str = {
                {"12", "34", "3", "2"},
                {"12", "34", "3", "2"},
                {"12", "34", "3", "4"},
                {"12", "34", "-5", "2"}
        };


        String [][] str4X4 = {
                {"12", "34", "3", "2"},
                {"12", "34", "3", "2"},
                {"12", "34", "3", "d"},
                {"12", "34", "we", "2"}
        };

        String [][] str5X5 = {
                {"12", "34", "3", "2","55"},
                {"12", "34", "3", "2","33"},
                {"12", "34", "3", "2","23"},
                {"12", "34", "3", "2","12"},
                {"12", "34", "3", "2","12"}
        };

//        Вот об этом я говорил, что бывают случаи, что надо чтобы программа
//                продолжила работу по любому, даже если свалится в ошибку.

//        поэтому сделал именно так
//                возможно это было грубо.
//        сначала я просто сделал исключение от  Exception
//    потом посмотрел разбор и уже сузил круг подозреваемых.

    try{
            System.out.println(new ArrayProcessing().math(str4X4));
        }catch (MyArrayDataException | MyArraySizeException e){
            e.printStackTrace();
        }

        try{
            System.out.println(new ArrayProcessing().math(str5X5));
        }catch (MyArrayDataException | MyArraySizeException e){
            e.printStackTrace();
        }

        try {
            System.out.println(new ArrayProcessing().math(str));
        }catch (MyArrayDataException | MyArraySizeException e){
            e.printStackTrace();
        }

        System.out.println("FINISH");
    }

}
