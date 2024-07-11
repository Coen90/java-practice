package head_first_design_pattern.decorator_pattern.second;

public class HouseBlend extends Beverage {

    private final int cost;

    public HouseBlend() {
        this.cost = 5_000;
    }

    @Override
    public int cost() {
        return super.cost() + this.cost;
    }
}
