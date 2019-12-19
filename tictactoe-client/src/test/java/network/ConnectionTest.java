package network;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectionTest {

    private Connection connection;

    @Before
    public void initTest() {
        connection = new Connection();
    }

    @Test
    public void readerNotNullTest() {
        assertNotNull(connection.getBf());
    }

}