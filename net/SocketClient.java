package net;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println("Usage: java SocketClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int port = Integer.parseInt(args[1]);

        try (
                Socket echoClinet = new Socket(hostName, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoClinet.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(echoClinet.getOutputStream()));
        ) {
            String userInput;
            while ((userInput = in.readLine()) != null) {
                System.out.println(userInput);
            }
        }
    }
}
