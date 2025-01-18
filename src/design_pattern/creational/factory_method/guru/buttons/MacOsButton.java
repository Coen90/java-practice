package design_pattern.creational.factory_method.guru.buttons;

public class MacOsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
