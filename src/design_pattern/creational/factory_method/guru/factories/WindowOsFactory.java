package design_pattern.creational.factory_method.guru.factories;

import design_pattern.creational.factory_method.guru.buttons.Button;
import design_pattern.creational.factory_method.guru.buttons.WindowOsButton;
import design_pattern.creational.factory_method.guru.checkboxes.Checkbox;
import design_pattern.creational.factory_method.guru.checkboxes.WindowOsCheckbox;

public class WindowOsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowOsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowOsCheckbox();
    }
}
