package lesson17;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Character[] mass1 = new Character[10];
        char ch = 'a';
        for (int i = 0; i < mass1.length ; i++) {
            mass1[i] = ch;
            ch++;
        }
        System.out.println(Arrays.toString(mass1));
        try {
            swap(mass1, 0,9);
            System.out.println(Arrays.toString(mass1));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        Integer[] mass2 = new Integer[10];
        for (int i = 0; i <mass2.length; i++) {
            mass2[i] = i;
        }
        System.out.println(Arrays.toString(mass2));
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        convertArrToArrayList(mass2,arrayList2);
        for (int i = 0; i < arrayList2.size() ; i++) {
            System.out.print(arrayList2.get(i) + " ");
        }
        System.out.println();

        Box<Apple> withApples = new Box<Apple>();
        withApples.addFruit(new Apple(), 30);
        Box<Orange> withOranges = new Box<Orange>();
        withOranges.addFruit(new Orange(), 20);

        System.out.println("Вес коробки с яблоками: " + withApples.getWeight());
        System.out.println("Вес коробки с апельсинами: " + withOranges.getWeight());
        System.out.println("Вес у коробок одинаковый? : " + withApples.compare(withOranges));

        Box<Apple> withApples2 = new Box<Apple>();
        System.out.println("Вес 2 коробки с яблоками: " + withApples2.getWeight());

        withApples.pourInto(withApples2);
        System.out.println("Вес 2 коробки с яблоками после пересыпки: " + withApples2.getWeight());
        System.out.println("Вес 1 коробки с яблоками после пересыпки в новую коробку: " + withApples.getWeight());
    }

   static void swap(Object[] obj, int firstIndex, int secondIndex) throws ArrayIndexOutOfBoundsException {
        if (firstIndex < 0 || firstIndex > obj.length || secondIndex < 0 || secondIndex > obj.length) {
            throw new ArrayIndexOutOfBoundsException("Введены индексы за пределами массива!" + "\n" + "Значения могут быть от 0 до " + (obj.length - 1) + ".");
        }
        Object x = obj[firstIndex];
        obj[firstIndex] = obj[secondIndex];
        obj[secondIndex] = x;
    }

    static ArrayList convertArrToArrayList(Object[]obj, ArrayList<Object> arrayList){
        for (int i = 0; i < obj.length; i++) {
            arrayList.add(obj[i]);
        }
        return arrayList;
    }

}
