package controller;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class MenuController {
    @FXML
    private Button btnExit;

    @FXML
    private Button btnGame;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label label;

    @FXML
    public void onEntered(MouseEvent e) {
        Button btn = (Button) e.getSource();
        btn.setEffect(new DropShadow());
        ScaleTransition transition = new ScaleTransition(Duration.seconds(0.2), btn);
        transition.setToX(1.2);
        transition.setToY(1.2);
        transition.play();
    }

    @FXML
    public void onExited(MouseEvent e) {
        Button btn = (Button) e.getSource();
        btn.setEffect(null);
        ScaleTransition transition = new ScaleTransition(Duration.seconds(0.2), btn);
        transition.setFromX(1.2);
        transition.setFromY(1.2);
        transition.setToX(1);
        transition.setToY(1);
        transition.play();
    }

    @FXML
    public void onActionExit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onActionPlay() throws IOException {
        btnGame.setDisable(true);
        Stage stage = (Stage) btnGame.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/board.fxml"));
        stage.setResizable(false);
        stage.setTitle("Tic tac toe");
        stage.setScene(new Scene(root, 600, 650));
        stage.sizeToScene();
        stage.show();
    }


}
