package app;

import server.Server;

public class ServerMain {
    public static void main(String[] args) {
        Server server = new Server();
        server.start(1234);
    }
}