package head_first_design_pattern.strategy_pattern;

public class MallardDuck extends Duck {

    public MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    @Override
    void display() {
        System.out.println("물오린데요");
    }
}
