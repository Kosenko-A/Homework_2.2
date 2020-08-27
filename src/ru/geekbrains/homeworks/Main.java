package ru.geekbrains.homeworks;

public class Main {

    public static void main(String[] args){
	String [][] arr = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
	try {
        System.out.println(submit(arr));
    }
	catch (MyArraySizeException | MyArrayDataException e){
	    e.printStackTrace();
    }
    }

    public static int submit (String [][] arr) throws MyArraySizeException, MyArrayDataException{
        int result = 0;
        if (arr.length == 4 && arr[0].length == 4){
            for (int i = 0; i<arr.length; i++){
                for (int j = 0; j<arr[i].length; j++){
                    if (isNumeric(arr[i][j])) {
                        result += Integer.parseInt(arr[i][j]);
                    } else {
                        throw new MyArrayDataException("В массиве есть неверный элемент [" + i + ";" + j + "]");
                    }
                }
            }
            return result;
        } else {
            throw new MyArraySizeException("Передан неверный размер массива");
        }
    }
    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
