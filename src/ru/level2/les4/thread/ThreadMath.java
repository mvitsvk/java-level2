package ru.level2.les4.thread;

public class ThreadMath {
    final int size = 10000000;
    final int h = size / 2;
    private float[] arr = new float[size];

    public float[] getArr() {
        return arr;
    }

    public void setArr(float[] arr) {
        this.arr = arr;
    }

    public float[] InitMass() {
        //2) Заполняют этот массив единицами;
        for (int i = 0; i < size; i++) arr[i] = 1F;
        return arr;
    }

    public float[] MassMath(float[] arr) {
        //2) Заполняют этот массив единицами;
        for (int i = 0; i < arr.length; i++) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        return arr;
    }

    public void Combined(float[] arr1, float[] arr2){
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
    }

}
