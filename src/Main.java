class Atom {
    Atom() {
        System.out.print("atom ");
    }
}

class Rock extends Atom {
    Rock(String type) {
        System.out.print(type);
    }
}

public class Main extends Rock {
    Main() {
        super("granite ");
        new Rock("granite ");
    }

    public void getMain() {
        System.out.println(":asd".concat("123"));
    }

    public static void main(String[] a) {
        new Main().getMain();
    }
}