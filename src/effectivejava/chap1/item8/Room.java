package effectivejava.chap1.item8;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable{

    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {

        int numJunk;

        State(int numJunk) {
            this.numJunk = numJunk;
        }

        @Override
        public void run() {
            System.out.println("Junk 청소");
            numJunk = 0;
        }
    }

    private final State state;

    private final Cleaner.Cleanable cleanable;

    public Room(State state, Cleaner.Cleanable cleanable) {
        this.state = state;
        this.cleanable = cleanable;
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
