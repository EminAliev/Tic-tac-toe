package app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/board.fxml"));
        primaryStage.setTitle("Tic tac toe");
        primaryStage.setScene(new Scene(root, 600, 650));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}