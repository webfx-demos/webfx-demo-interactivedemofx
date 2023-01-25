// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.demo.interactivedemofx.application {

    // Direct dependencies modules
    requires javafx.graphics;
    requires javafx.media;
    requires webfx.extras.flexbox;
    requires webfx.kit.util.scene;
    requires webfx.lib.demofx;
    requires webfx.platform.audio;
    requires webfx.platform.resource;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.demo.interactivedemofx;

    // Resources packages
    opens dev.webfx.demo.interactivedemofx;

    // Provided services
    provides javafx.application.Application with dev.webfx.demo.interactivedemofx.InteractiveDemoFXApplication;

}