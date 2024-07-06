package head_first_design_pattern.strategy_pattern.final_version;

public class RubberDuck extends Duck {
    public RubberDuck() {
        super(new FlyNoWay(), new Squeak());
    }
}
