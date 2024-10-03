package effectivejava.old.chap1.item8;

public class FinalizerTest implements AutoCloseable {

    public void hello() {
        System.out.println("hello");
        throw new RuntimeException("hello 예외발생!");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        throw new RuntimeException("finalize 예외발생!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("close");
        throw new RuntimeException("close 예외발생!");
    }
}
