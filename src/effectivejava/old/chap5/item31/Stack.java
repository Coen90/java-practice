package effectivejava.old.chap5.item31;

public class Stack<E>{

    public Stack(){};

    private void push(E e) {
        System.out.println("push method run, item = " + e);
    }

    public void pushAll(Iterable<? extends E> src) {
        for(E e : src) push(e);
    }
}
