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
            createDemoButton("Mandala", "mandala"),
            createDemoButton("Mandelbrot", "mandelbrot", 800d * 600), // Limit size, otherwise too slow
            createDemoButton("Glow board", "glowboard"),
            createDemoButton("Rings", "rings"),
            createDemoButton("Sine lines", "sinelines"),
            createDemoButton("Stars", "stars"),
            createDemoButton("Sierpinski", "sierpinski"),
            createDemoButton("Tiles", "tiles"),
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
        return createDemoButton(text, effect, null);
    }

    private Node createDemoButton(String text, String effect, Double maxPixels) {
        Button button = new Button(text);
        button.setOnAction(e -> runDemo(effect, maxPixels));
        button.setCursor(Cursor.HAND);
        return button;
    }

    private void runDemo(String effect) {
        runDemo(effect, null);
    }

    private void runDemo(String effect, Double maxPixels) {
        if (demoFX != null)
            demoFX.stopDemo();
        double width = scene.getWidth();
        double height = scene.getHeight();
        if (maxPixels != null) {
            double r = Math.sqrt(width * height / maxPixels);
            if (r > 1) {
                width /= r;
                height /= r;
            }
        }
        DemoConfig config = DemoConfig.buildConfig("-e", effect, "-w", "" + width, "-h", "" + height);
        demoFX = new DemoFX(config);
        root.getChildren().setAll(demoFX.getPane(), topBox);
        demoFX.runDemo();
    }

}