package controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import network.Connection;
import view.StatusGame;

import java.io.IOException;

public class BoardController extends Task {
    private Connection connection;
    private BaseController baseController;


    public BoardController(Connection connection, BaseController baseController) {
        this.connection = connection;
        this.baseController = baseController;
    }

    private boolean win(char mark) {
        Button[][] btn = baseController.getBtn();
        if (btn[0][0].getText().equals(String.valueOf(mark))) {
            if (btn[0][1].getText().equals(String.valueOf(mark))) {
                return btn[0][2].getText().equals(String.valueOf(mark));
            } else if (btn[1][0].getText().equals(String.valueOf(mark))) {
                return btn[2][0].getText().equals(String.valueOf(mark));
            } else if (btn[1][1].getText().equals(String.valueOf(mark))) {
                return btn[2][2].getText().equals(String.valueOf(mark));
            }
        } else if (btn[1][0].getText().equals(String.valueOf(mark))) {
            if (btn[1][1].getText().equals(String.valueOf(mark))) {
                return btn[1][2].getText().equals(String.valueOf(mark));
            }
        } else if (btn[2][0].getText().equals(String.valueOf(mark))) {
            if (btn[2][1].getText().equals(String.valueOf(mark))) {
                return btn[2][2].getText().equals(String.valueOf(mark));
            }
        } else if (btn[0][1].getText().equals(String.valueOf(mark))) {
            if (btn[1][1].getText().equals(String.valueOf(mark))) {
                return btn[2][1].getText().equals(String.valueOf(mark));
            }
        } else if (btn[0][2].getText().equals(String.valueOf(mark))) {
            if (btn[1][1].getText().equals(String.valueOf(mark))) {
                return btn[2][0].getText().equals(String.valueOf(mark));
            } else if (btn[1][2].getText().equals(String.valueOf(mark))) {
                return btn[2][2].getText().equals(String.valueOf(mark));
            }
        }
        return false;
    }


    @Override
    protected Void call() throws IOException {
        while (true) {
                if (connection.getBf().ready()) {
                    String line = connection.getBf().readLine();
                    if (line != null) {
                        if (line.length() == 1) {
                            baseController.setId(line);
                        } else {
                            String userId = line.split(",")[0];
                            int row = Integer.parseInt(line.split(",")[1]);
                            int column = Integer.parseInt(line.split(",")[2]);

                            Platform.runLater(() -> {
                                if (userId.equals("1")) {
                                    baseController.getBtn()[row][column].setText(String.valueOf('x'));
                                    if (win('x')) {
                                        // todo: очистить поле
                                        //	должно появиться некое окошко с выигрышом x 
                                    }
                                } else {
                                    baseController.getBtn()[row][column].setText(String.valueOf('o'));
                                    if (win('o')) {
                                        // todo: очистить поле
                                        //	должно появиться некое окошко с выигрышом y
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }
    }


