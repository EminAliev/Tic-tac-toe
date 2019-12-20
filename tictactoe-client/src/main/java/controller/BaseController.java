package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import network.Connection;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class BaseController {

    @FXML
    private Button btn00;


    @FXML
    private Button btn01;


    @FXML
    private Button btn02;


    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn12;

    @FXML
    private Button btn20;

    @FXML
    private Button btn21;

    @FXML
    private Button btn22;

    @FXML
    private AnchorPane anchorPane;

    private Button[][] btn;

    private Connection connection;

    private String id;


    @FXML
    public void initialize() {
        connection = new Connection();
        btn = new Button[3][3];
        ObservableList<Node> marks = anchorPane.getChildren();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int i1 = i;
                int j1 = j;
                btn[i][j] = (Button) marks.stream().filter(node -> node.getId().equals("btn" + i1 + j1)).collect(Collectors.toList()).get(0);
                btn[i][j].setOnAction(event -> connection.writeMessage(id + "," + i1 + "," + j1));
            }
        }
        BoardController boardController = new BoardController(connection, this);
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.execute(boardController);
    }

    public void clearBoard() {
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(btn00);
        anchorPane.getChildren().add(btn01);
        anchorPane.getChildren().add(btn02);
        anchorPane.getChildren().add(btn10);
        anchorPane.getChildren().add(btn11);
        anchorPane.getChildren().add(btn12);
        anchorPane.getChildren().add(btn20);
        anchorPane.getChildren().add(btn21);
        anchorPane.getChildren().add(btn22);
        //setButtonsEnabled();
    }

    private void setButtonsEnabled() {
        btn00.setDisable(false);
        btn01.setDisable(false);
        btn02.setDisable(false);
        btn10.setDisable(false);
        btn11.setDisable(false);
        btn12.setDisable(false);
        btn20.setDisable(false);
        btn21.setDisable(false);
        btn22.setDisable(false);

    }

    public Button[][] getBtn() {
        return btn;
    }

    public void setBtn(Button[][] btn) {
        this.btn = btn;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Button getBtn00() {
        return btn00;
    }

    public void setBtn00(Button btn00) {
        this.btn00 = btn00;
    }

    public Button getBtn01() {
        return btn01;
    }

    public void setBtn01(Button btn01) {
        this.btn01 = btn01;
    }

    public Button getBtn02() {
        return btn02;
    }

    public void setBtn02(Button btn02) {
        this.btn02 = btn02;
    }

    public Button getBtn10() {
        return btn10;
    }

    public void setBtn10(Button btn10) {
        this.btn10 = btn10;
    }

    public Button getBtn11() {
        return btn11;
    }

    public void setBtn11(Button btn11) {
        this.btn11 = btn11;
    }

    public Button getBtn12() {
        return btn12;
    }

    public void setBtn12(Button btn12) {
        this.btn12 = btn12;
    }

    public Button getBtn20() {
        return btn20;
    }

    public void setBtn20(Button btn20) {
        this.btn20 = btn20;
    }

    public Button getBtn21() {
        return btn21;
    }

    public void setBtn21(Button btn21) {
        this.btn21 = btn21;
    }

    public Button getBtn22() {
        return btn22;
    }

    public void setBtn22(Button btn22) {
        this.btn22 = btn22;
    }

    @FXML
    public void onMouseClickedCancelBtn(InputEvent e) {
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}

