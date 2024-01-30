package loadworld;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SpiderWorldApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Spider World App");

        Label spiderConfigLabel = new Label("Spider World: Loading...");

        SpiderConfiguration spiderConfig = GameLoader.loadSpiderConfiguration();
        if (spiderConfig != null) {
            spiderConfigLabel.setText("Spider Color: " + spiderConfig.getSpiderColor());
        } else {
            spiderConfigLabel.setText("Failed to load Spider Configuration.");
        }

        StackPane root = new StackPane();
        root.getChildren().add(spiderConfigLabel);
        primaryStage.setScene(new Scene(root, 300, 200));

        primaryStage.show();
    }
}