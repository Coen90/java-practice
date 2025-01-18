package design_pattern.creational.factory_method.guru.checkboxes;

public class WindowOsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created WindowsOsCheckbox.");
    }
}
