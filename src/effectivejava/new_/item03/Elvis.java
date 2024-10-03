package effectivejava.new_.item03;

public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
        if (INSTANCE != null) {
            throw new IllegalStateException("This instance is already created.");
        }
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }
}
