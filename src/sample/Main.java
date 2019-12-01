package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(new Group(), 100, 100);

        primaryStage.setOnCloseRequest(evt -> {
            // allow user to decide between yes and no
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to close this application?", ButtonType.YES, ButtonType.NO);

            // clicking X also means no
            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);

            if (ButtonType.NO.equals(result)) {
                // consume event i.e. ignore close request
                evt.consume();
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
