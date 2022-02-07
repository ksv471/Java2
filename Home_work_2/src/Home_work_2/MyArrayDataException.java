package Home_work_2;

public class MyArrayDataException extends Exception {
    private final int r;
    private final int c;

    public int getRow() {
        return r;
    }

    public int getCol() {
        return c;
    }

    public MyArrayDataException(String str, int r, int c) {
        super(str);
        this.r = r;
        this.c = c;
    }
}