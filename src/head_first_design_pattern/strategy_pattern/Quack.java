package head_first_design_pattern.strategy_pattern;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Quack!!");
    }
}
