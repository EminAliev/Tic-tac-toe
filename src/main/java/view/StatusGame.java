package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StatusGame {
    public static void status(String player) {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        Pane pane = new Pane();
        Label winner = new Label(player);
        winner.setFont(new Font("Arial", 96));
        winner.setTranslateY(150);
        winner.setTranslateX(50);

        pane.getChildren().add(winner);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Status Game");
        primaryStage.showAndWait();
    }
}
