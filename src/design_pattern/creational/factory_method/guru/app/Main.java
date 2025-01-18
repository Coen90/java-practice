package design_pattern.creational.factory_method.guru.app;

import design_pattern.creational.factory_method.guru.factories.GUIFactory;
import design_pattern.creational.factory_method.guru.factories.MacOsFactory;

public class Main {
    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }

    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOsFactory();
        } else {
            factory = new MacOsFactory();
        }
        app = new Application(factory);
        return app;
    }
}
