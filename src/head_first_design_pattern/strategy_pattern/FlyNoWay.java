package head_first_design_pattern.strategy_pattern;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I Can Not Fly :(");
    }
}
