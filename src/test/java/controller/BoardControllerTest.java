package controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardControllerTest {

    private BoardController boardController;

    @Before
    public void initTest() {
        boardController = new BoardController();
    }

    @Test
    public void btnNotNullTest() {
        assertNotNull(boardController.getConnection());
    }

}