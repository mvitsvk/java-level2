package ru.level2.les4.thread;

public class Main {

    public static void main(String[] args) {

        math();

    }

    public static void math(){

        ThreadMath metod = new ThreadMath();


//данную конструкцию предложила ИДЕЯ
// на сколько я помню, из потока можно забрать только объект поэтому реализация именно такая.

        //metod.h
        // h и size финальны, посчитал, что GET избыточен.

        var ref = new Object() {
            float[] arr1 = new float[metod.h];
            float[] arr2 = new float[metod.h];
        };



//metod 1
       metod.InitMass();

        long a = System.currentTimeMillis();

        metod.MassMath(metod.getArr());

        long b = System.currentTimeMillis();
        System.out.println("Lambda time: " + (b - a));


        //просто смотрю на посчитанные цифры
        System.out.println(metod.getArr()[0]);
        System.out.println(metod.getArr()[metod.size-1]);

//metod 2


        metod.InitMass();

        a = System.currentTimeMillis();

        System.arraycopy(metod.getArr(), 0, ref.arr1, 0, metod.h);
        System.arraycopy(metod.getArr(), metod.h, ref.arr2, 0, metod.h);


        //расчёт запускаем одновременный
        new Thread(()->{
            synchronized (ref.arr1) {
                ref.arr1 = metod.MassMath(ref.arr1);
            }
        }).start();

        new Thread(()->{
            synchronized (ref.arr2) {
                ref.arr2 = metod.MassMath(ref.arr2);
            }
        }).start();

        //а вот уже слияние надо синхронизировать
//        подсмотрел реализацию из разбора урока
//                у самого так и не получилось сделать
//                забыл что synchronized захватывает объект и пока не отпустит
//                новый поток его трогать не будет

            synchronized (ref.arr1) {
                synchronized (ref.arr2) {
                    metod.Combined(ref.arr1,ref.arr2);
                    b = System.currentTimeMillis();
                    System.out.println("Lambda time: " + (b - a));

                    System.out.println(metod.getArr()[0]);
                    System.out.println(metod.getArr()[metod.size-1]);

                }
            }

    };


}

//        Lambda time: 1703
//        0.17933902
//        0.06892343
//        Lambda time: 844
//        0.17933902
//        0.06320445
// странно но цифры разные. не стал заморачиваться, а стоило бы...