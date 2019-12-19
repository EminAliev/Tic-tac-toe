package controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseControllerTest {

    private BaseController baseController;

    @Before
    public void initTest() {
        baseController = new BaseController();
    }

    @Test
    public void btnNotNullTest() {
        assertNotNull(baseController.getBtn());
    }

}