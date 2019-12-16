package server;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServerTest {

    private Server server;

    @Before
    public void initTest() {
        server = new Server();
    }

    @Test
    public void startTest() {
        Server server = new Server();
        assertEquals(server.getId(),"1");
    }



}