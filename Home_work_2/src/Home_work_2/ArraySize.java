package Home_work_2;

public class ArraySize {
    static int S = 4;
    static int sum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != S) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != S) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("не правильный формат " + i + " " + j, i, j);
                }
            }
        }
        return sum;
    }
}
