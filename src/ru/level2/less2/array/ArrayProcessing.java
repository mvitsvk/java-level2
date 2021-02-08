package ru.level2.less2.array;

public class ArrayProcessing {

    public int math(String[][] str) {
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].length != 4)
                throw new MyArraySizeException("Array error size. You array line " + i + " is not equal to the 4th");
        }

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {

                try{
                    sum = sum + Integer.parseInt(str[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Array position: "+i+"x"+j+" not convert Integer "+str[i][j],e);
                }

            }

        }

        return sum;
    }



}
