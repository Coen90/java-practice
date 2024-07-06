package head_first_design_pattern.strategy_pattern;

public class RubberDuck extends Duck {
    public RubberDuck() {
        super(new FlyNoWay(), new Squeak());
    }
}
