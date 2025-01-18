package design_pattern.creational.factory_method.guru.factories;

import design_pattern.creational.factory_method.guru.buttons.Button;
import design_pattern.creational.factory_method.guru.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
