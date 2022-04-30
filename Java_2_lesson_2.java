package HomeWork_Java_lvl_2;

public class Java_2_lesson_2 extends Exception {

    public static void main(String[] args) {
        String[][] arr1 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "s", "15", "16"}};

        String[][] arr2 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}};

        try {
            arrStringToInt(arr1);
        } catch (MyArrayDataException | MyArraySizeException  e) {
            e.printStackTrace();
        }


    }

    static void arrStringToInt(String[][] array) throws MyArraySizeException, MyArrayDataException {
    if (array.length != 4) throw new MyArraySizeException("Неверная длина массива"); else System.out.println("OK");

    int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    Integer.parseInt(array[i][j]);
                    sum += Integer.parseInt(array[i][j]);

                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка. Символ в " + i + " ряду, " + j + " колонне");
                }
            }
            System.out.println("Значение составило: " + sum);
        }
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String exception) {
        super(exception);
    }
}

class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(String exception) {
        super(exception);
    }
}
