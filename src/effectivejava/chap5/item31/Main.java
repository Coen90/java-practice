package effectivejava.chap5.item31;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        List<Integer> list = listMaker();
        Iterable<Integer> integers = (Iterable<Integer>) list;
        numberStack.pushAll(integers); // 매개변수화 타입이 불공변
    }

    public static List<Integer> listMaker () {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        return list;
    }
}
