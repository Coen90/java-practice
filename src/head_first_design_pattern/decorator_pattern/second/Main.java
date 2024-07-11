package head_first_design_pattern.decorator_pattern.second;

public class Main {

    public static void main(String[] args) {
        HouseBlend houseBlend = new HouseBlend();
        houseBlend.setMilk();
        System.out.println(houseBlend.cost());
    }
}
