package design_pattern.creational.abstract_factory_method.guru.app;

import design_pattern.creational.abstract_factory_method.guru.buttons.Button;
import design_pattern.creational.abstract_factory_method.guru.checkboxes.Checkbox;
import design_pattern.creational.abstract_factory_method.guru.factories.GUIFactory;

public class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
