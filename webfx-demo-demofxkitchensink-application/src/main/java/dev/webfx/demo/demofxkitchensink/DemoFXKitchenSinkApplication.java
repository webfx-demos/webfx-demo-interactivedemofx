package dev.webfx.demo.demofxkitchensink;

import com.chrisnewland.demofx.DemoConfig;
import com.chrisnewland.demofx.DemoFX;
import dev.webfx.extras.flexbox.FlexBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DemoFXKitchenSinkApplication extends Application {

    private final StackPane root = new StackPane();
    private final Scene scene = new Scene(root, 800, 600);

    private final static Font BUTTON_FONT = Font.font(18);
    private final static Insets BUTTON_PADDING = new Insets(5);
    private Color buttonColor = Color.PURPLE; // Initial node color

    private final FlexBox topBox = new FlexBox(10, 10,
            createDemoButton("Burst", "burst"),
            createDemoButton("Chord", "chord"),
            createDemoButton("Checkerboard", "checkerboard"),
            createDemoButton("Concentric", "concentric"),
            createDemoButton("Falling", "falling"),
            createDemoButton("Fractal rings", "fractalrings"),
            createDemoButton("Honeycomb", "honeycomb"),
            createDemoButton("Mandala", "mandala"),
            createDemoButton("Mandelbrot", "mandelbrot", 800d * 600), // Limit size, otherwise too slow
            createDemoButton("Moire", "moire"),
            //createDemoButton("Moremoire", "moremoire"), // too slow to start
            createDemoButton("Glow board", "glowboard"),
            createDemoButton("Grid", "grid"),
            createDemoButton("Rings", "rings"),
            createDemoButton("Sea", "sea"),
            createDemoButton("Sine lines", "sinelines"),
            createDemoButton("Spin", "spin"),
            createDemoButton("Stars", "stars"),
            createDemoButton("Sierpinski", "sierpinski"),
            createDemoButton("Snow field", "snowfieldsprite"),
            createDemoButton("Star field", "starfieldsprite"),
            createDemoButton("Text ring", "textring"),
            createDemoButton("Text wave", "textwave"),
            createDemoButton("Tiles", "tiles"),
            createDemoButton("Word search", "wordsearch"),
            createDemoButton("Stop", null)
    );
    private DemoFX demoFX;

    @Override
    public void start(Stage stage) {
        topBox.setSpaceTop(true);
        topBox.setSpaceLeft(true);
        topBox.setSpaceRight(true);
        StackPane.setMargin(topBox, new Insets(10));
        stage.setTitle("DemoFX Kitchen Sink");
        stage.setScene(scene);
        stage.show();
        runDemo("concentric");
    }

    private Node createDemoButton(String text, String effect) {
        return createDemoButton(text, effect, null);
    }

    private Node createDemoButton(String text, String effect, Double maxPixels) {
        Text buttonText = new Text(text);
        buttonText.setFont(BUTTON_FONT);
        buttonText.setFill(Color.WHITE);
        StackPane.setMargin(buttonText, BUTTON_PADDING);
        StackPane button = setBackgroundColor(buttonColor, new StackPane(buttonText));
        // Rotating color for next node
        buttonColor = buttonColor.deriveColor(20, 1d, 1d, 1d);
        button.setOnMouseClicked(e -> runDemo(effect, maxPixels));
        button.setCursor(Cursor.HAND);
        return button;
    }

    private void runDemo(String effect) {
        runDemo(effect, null);
    }

    private void runDemo(String effect, Double maxPixels) {
        if (demoFX != null)
            demoFX.stopDemo();
        if (effect == null)
            return;
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

    private static <R extends Region> R setBackgroundColor(Color color, R region) {
        region.setBackground(new Background(new BackgroundFill(color, null, null)));
        return region;
    }

}