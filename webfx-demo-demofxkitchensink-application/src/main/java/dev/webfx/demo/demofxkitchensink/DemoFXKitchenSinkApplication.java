package dev.webfx.demo.demofxkitchensink;

import com.chrisnewland.demofx.DemoConfig;
import com.chrisnewland.demofx.DemoFX;
import com.chrisnewland.demofx.util.ImageUtil;
import dev.webfx.extras.flexbox.FlexBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
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

    private boolean showButtons = true;

    private final FlexBox topBox = new FlexBox(10, 10,
            createDemoButton("Bobs", "bobs"),
            createDemoButton("Burst", "burst"),
            createDemoButton("Chord", "chord"),
            createDemoButton("Checkerboard", "checkerboard"),
            createDemoButton("Concentric", "concentric"),
            createDemoButton("Credits", "credits"),
            createDemoButton("Equaliser ♪", "equaliser", "https://cdn.pixabay.com/download/audio/2022/03/15/audio_8cb749d484.mp3?filename=happy-ukulele-fun-positive-comedy-glockenspiel-music-93694.mp3"),
            createDemoButton("Falling", "falling"),
            createDemoButton("Fractal rings", "fractalrings"),
            createDemoButton("Honeycomb", "honeycomb"),
            createDemoButton("Mandala", "mandala"),
            createDemoButton("Mandelbrot", "mandelbrot"),
            createDemoButton("Mask stack", "maskstack"),
            createDemoButton("Moire", "moire"),
            createDemoButton("Moire 2", "moire2"),
            //createDemoButton("Moremoire", "moremoire"), // too slow to start
            createDemoButton("Glow board", "glowboard"),
            createDemoButton("Grid", "grid"),
            //createDemoButton("Rainbow", "rainbow"), // Performance problem with PixelWrite.setPixels()
            createDemoButton("Rings", "rings"),
            createDemoButton("Sea", "sea"),
            createDemoButton("Sine lines", "sinelines"),
            createDemoButton("Spin", "spin"),
            createDemoButton("Stars", "stars"),
            createDemoButton("Sierpinski", "sierpinski"),
            createDemoButton("Snow field", "snowfieldsprite"),
            createDemoButton("Star field", "starfieldsprite"),
            createDemoButton("Text flash", "textflash"),
            createDemoButton("Text ring", "textring"),
            //createDemoButton("Text wave", "textwave"), // to slow to start
            createDemoButton("Text wave sprite", "textwavesprite"),
            createDemoButton("Tiles", "tiles"),
            createDemoButton("Twister", "twister"),
            createDemoButton("Word search", "wordsearch"),
            createDemoButton("Hide", null)
    );
    private DemoFX demoFX;
    private BorderPane demoPane;

    @Override
    public void start(Stage stage) {
        topBox.setSpaceTop(true);
        topBox.setSpaceLeft(true);
        topBox.setSpaceRight(true);
        StackPane.setMargin(topBox, new Insets(10));
        stage.setTitle("DemoFX Kitchen Sink");
        stage.setScene(scene);
        stage.show();
        runDemo("textwavesprite");
        root.setOnMouseClicked(e -> showButtons());
        GraphicsContext loadingContext = new Canvas().getGraphicsContext2D();
        loadingContext.drawImage(ImageUtil.loadImageFromResources("tiger.jpeg"), 0, 0);
    }

    private Node createDemoButton(String text, String effect) {
        return createDemoButton(text, effect, null);
    }

    private Node createDemoButton(String text, String effect, String audioUrl) {
        Text buttonText = new Text(text);
        buttonText.setFont(BUTTON_FONT);
        buttonText.setFill(Color.WHITE);
        StackPane.setMargin(buttonText, BUTTON_PADDING);
        StackPane button = setBackgroundColor(buttonColor, new StackPane(buttonText));
        // Rotating color for next node
        buttonColor = buttonColor.deriveColor(20, 1d, 1d, 1d);
        if (effect != null)
            button.setOnMousePressed(e -> {
                runDemo(effect, audioUrl);
                e.consume();
            });
        else
            button.setOnMouseClicked(e -> hideButtons());
        button.setCursor(Cursor.HAND);
        return button;
    }

    private void runDemo(String effect) {
        runDemo(effect, null);
    }

    private void runDemo(String effect, String audioUrl) {
        if (demoFX != null)
            demoFX.stopDemo();
        DemoConfig config = audioUrl == null ? DemoConfig.buildConfig("-e", effect, "-w", "" + scene.getWidth(), "-h", "" + scene.getHeight()) : DemoConfig.buildConfig("-e", effect, "-a", audioUrl, "-w", "" + scene.getWidth(), "-h", "" + scene.getHeight());
        demoFX = new DemoFX(config);
        demoPane = demoFX.getPane();
        updateRootContent();
        demoFX.runDemo();
    }

    private void updateRootContent() {
        if (showButtons)
            root.getChildren().setAll(demoPane, topBox);
        else
            root.getChildren().setAll(demoPane);
        root.setCursor(showButtons ? Cursor.DEFAULT : Cursor.HAND);
    }

    private void showButtons() {
        if (!showButtons) {
            showButtons = true;
            updateRootContent();
        }
    }

    private void hideButtons() {
        if (showButtons) {
            showButtons = false;
            updateRootContent();
        }
    }

    private static <R extends Region> R setBackgroundColor(Color color, R region) {
        region.setBackground(new Background(new BackgroundFill(color, null, null)));
        return region;
    }

}