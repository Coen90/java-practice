package design_pattern.creational.abstract_factory_method.guru.buttons;

public class WindowOsButton implements Button{

    @Override
    public void paint() {
        System.out.println("You have created WindowOsButton.");
    }
}
