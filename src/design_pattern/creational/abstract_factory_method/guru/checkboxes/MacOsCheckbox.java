package design_pattern.creational.abstract_factory_method.guru.checkboxes;

public class MacOsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
