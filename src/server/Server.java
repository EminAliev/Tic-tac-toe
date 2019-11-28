package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private List<GamersHandler> gamers;

    private int id = 1;


    public Server() {
        gamers = new CopyOnWriteArrayList<>();
    }

    public void start(int port) {
        ServerSocket socket;
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        while (true) {
            try {
                new GamersHandler(socket.accept()).start();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private class GamersHandler extends Thread {
        private Socket socket;
        private BufferedReader in;

        GamersHandler(Socket socket) {
            this.socket = socket;
            gamers.add(this);
            System.out.println("New player " + socket.getPort());
            OutputStream outputStream;
            try {
                outputStream = socket.getOutputStream();
                outputStream.write(id);
                if (id == 1) {
                    id = 2;
                } else {
                    id = 1;
                }
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }

       
    }
}
