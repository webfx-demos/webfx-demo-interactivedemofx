// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.demo.demofxkitchensink.application {

    // Direct dependencies modules
    requires javafx.graphics;
    requires javafx.media;
    requires webfx.extras.flexbox;
    requires webfx.lib.demofx;

    // Exported packages
    exports dev.webfx.demo.demofxkitchensink;

    // Provided services
    provides javafx.application.Application with dev.webfx.demo.demofxkitchensink.DemoFXKitchenSinkApplication;

}