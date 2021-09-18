package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view\\StartMenu.fxml")));

        primaryStage.setTitle("Covid Monitor");
        Scene scene = new Scene(root, Engine.screenWidth, Engine.screenHeight);
        //scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();

        Engine.init();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
