package head_first_design_pattern.decorator_pattern.first;

public class HouseBlendWithMilk implements Beverage{

    @Override
    public int cost() {
        return 5_500;
    }

    @Override
    public String description() {
        return "하우스 블랜드 우유 추가";
    }

}
