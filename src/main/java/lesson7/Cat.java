package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;
    private int infoPlate;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        satiety = plate.plateCheck(appetite);
        infoPlate = plate.getFood();
    }

    public void info() {
        System.out.println(name + " " + (satiety ? " сыт " : " голоден ") + " (В тарелке осталось " + infoPlate + " единиц)");
    }
}