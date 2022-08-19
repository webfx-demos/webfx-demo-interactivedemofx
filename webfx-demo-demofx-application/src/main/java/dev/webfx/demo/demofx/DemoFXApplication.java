package dev.webfx.demo.demofx;

import com.chrisnewland.demofx.DemoConfig;
import com.chrisnewland.demofx.DemoFX;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DemoFXApplication extends Application {

    private final StackPane root = new StackPane();
    private final Scene scene = new Scene(root, 800, 600);
    private final HBox topBox = new HBox(10,
            createDemoButton("Burst", "burst"),
            createDemoButton("Chord", "chord"),
            createDemoButton("Concentric", "concentric"),
            createDemoButton("Falling", "falling"),
            createDemoButton("Glow board", "glowboard"),
            createDemoButton("Rings", "rings"),
            createDemoButton("Snow field", "snowfieldsprite")
    );
    private DemoFX demoFX;

    @Override
    public void start(Stage stage) {
        topBox.setAlignment(Pos.TOP_CENTER);
        StackPane.setMargin(topBox, new Insets(10));
        stage.setTitle("DemoFX");
        stage.setScene(scene);
        stage.show();
        runDemo("concentric");
    }

    private Node createDemoButton(String text, String effect) {
        Button button = new Button(text);
        button.setOnAction(e -> runDemo(effect));
        button.setCursor(Cursor.HAND);
        return button;
    }

    private void runDemo(String effect) {
        if (demoFX != null)
            demoFX.stopDemo();
        DemoConfig config = DemoConfig.buildConfig("-e", effect, "-w", "" + scene.getWidth(), "-h", "" + scene.getHeight());
        demoFX = new DemoFX(config);
        root.getChildren().setAll(demoFX.getPane(), topBox);
        demoFX.runDemo();
    }

}