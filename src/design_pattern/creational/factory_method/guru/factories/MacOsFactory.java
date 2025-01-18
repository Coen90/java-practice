package design_pattern.creational.factory_method.guru.factories;

import design_pattern.creational.factory_method.guru.buttons.Button;
import design_pattern.creational.factory_method.guru.buttons.MacOsButton;
import design_pattern.creational.factory_method.guru.checkboxes.Checkbox;
import design_pattern.creational.factory_method.guru.checkboxes.MacOsCheckbox;

public class MacOsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOsCheckbox();
    }
}
