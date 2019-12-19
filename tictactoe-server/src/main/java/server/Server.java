package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private List<GamersHandler> gamers;

    private String id = "1";

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

    public List<GamersHandler> getGamers() {
        return gamers;
    }

    public void setGamers(List<GamersHandler> gamers) {
        this.gamers = gamers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private class GamersHandler extends Thread {
        private Socket socket;
        private BufferedReader in;

        GamersHandler(Socket socket) {
            this.socket = socket;
            gamers.add(this);
            System.out.println("New player " + socket.getPort());
            PrintWriter writer;
            try {
                writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println(id);
                if (id.equals("1")) {
                    id = "2";
                } else {
                    id = "1";
                }
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                    for (GamersHandler client : gamers) {
                        PrintWriter out = new PrintWriter(client.socket.getOutputStream(), true);
                        out.println(line);
                    }
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
