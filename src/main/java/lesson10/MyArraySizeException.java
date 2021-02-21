package lesson10;

public class MyArraySizeException extends Exception {
    private int x,y;

    public MyArraySizeException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }
}
