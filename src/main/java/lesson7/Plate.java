package lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean plateCheck(int appetite) {
        if (food - appetite < 0) {

            return false;
        } else {
            food -= appetite;
            return true;
        }
    }

    public void addFood(int food) {
        this.food += food;
    }
}