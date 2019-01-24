package ver2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        //start server
        try {
            server = new ServerSocket(9000);
            System.out.println("Server created. Waiting for client...");
            //client connection monitoring
            while (true) {
                socket = server.accept();
                System.out.println("Client connected");
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
                System.out.println("Server closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
    class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private Scanner in;
        private String name;

        //IO settings
        public ClientHandler(Socket socket) {
            try {
                this.socket = socket;
                out = new PrintWriter(socket.getOutputStream());
                in = new Scanner(socket.getInputStream());
                name = "Client";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                if (in.hasNext()) {
                    String w = in.nextLine();
                    System.out.println(name + ": " + w);
                    out.println("echo: " + w);
                    out.flush();
                    if (w.equalsIgnoreCase("END")) break;
                }
            }
            try{
                System.out.println("Client disconnected");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
