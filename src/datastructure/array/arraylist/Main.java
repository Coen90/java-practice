package datastructure.array.arraylist;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> arrayList = new CustomArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(1);
        System.out.println(arrayList.size());
        arrayList.remove(2);
        System.out.println(arrayList.size());
        arrayList.remove(1);
        System.out.println(arrayList.size());
        ArrayList<Integer> arr = new ArrayList<>();
    }
}
