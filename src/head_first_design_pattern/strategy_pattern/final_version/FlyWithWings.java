package head_first_design_pattern.strategy_pattern.final_version;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Food Duck");
    }
}
