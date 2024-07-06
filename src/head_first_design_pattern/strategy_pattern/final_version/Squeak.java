package head_first_design_pattern.strategy_pattern.final_version;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak!!");
    }
}
