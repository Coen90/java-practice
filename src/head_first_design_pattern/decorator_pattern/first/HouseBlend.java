package head_first_design_pattern.decorator_pattern.first;

public class HouseBlend implements Beverage{

    @Override
    public int cost() {
        return 5_000;
    }

    @Override
    public String description() {
        return "하우스 블랜드";
    }

}
