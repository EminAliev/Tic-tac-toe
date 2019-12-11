package controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import network.Connection;
import view.StatusGame;

import java.io.IOException;

public class BoardController{
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
}
