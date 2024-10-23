package effectivejava.new_.item08;

public class TryWithResource {
    public static class Room implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("Goodbye in close method");
        }
    }

    public static void main(String[] args) {
        try (Room room = new Room()) {
            System.out.println("Goodbye in try block");
        }
    }
}
