// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.demo.demofx.application {

    // Direct dependencies modules
    requires javafx.graphics;
    requires webfx.extras.flexbox;
    requires webfx.lib.demofx;

    // Exported packages
    exports dev.webfx.demo.demofx;

    // Provided services
    provides javafx.application.Application with dev.webfx.demo.demofx.DemoFXApplication;

}