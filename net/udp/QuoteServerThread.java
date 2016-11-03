package net.udp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class QuoteServerThread extends Thread {

    protected DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean moreQuotes = true;

    public QuoteServerThread() throws IOException{
        this("quoteServerThread");
    }

    public QuoteServerThread(String name) throws SocketException {
        super(name);
        socket = new DatagramSocket(8888);
        try {
            in = new BufferedReader(new FileReader("test.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("cant find the file");
        }
    }

    public void run() {
        while (moreQuotes) {
            try {
                byte[] buf = new byte[256];
                // receive request
                DatagramPacket packet = new DatagramPacket(buf, buf.length);

                // block until a packet arrives
                socket.receive(packet);

                // figure out response
                String dString = null;
                if (in == null) {
                    dString = new Date().toString();
                } else {
                    dString = getNextQuote();
                }
                buf = dString.getBytes();

                // send the response to the client at address and port
                InetAddress address = packet.getAddress();
                int port = packet.getPort();

                // need address and port if send a datagram packet.
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
                moreQuotes = false;
            }
            socket.close();
        }
    }

    protected String getNextQuote() {
        String returnValue = null;
        try {
            if ((returnValue = in.readLine()) == null) {
                in.close();
                moreQuotes = false;
                returnValue = "no more quotes";
            }
        } catch (IOException e) {
            returnValue = "IOException occurs";
        }
        return returnValue;
    }
}
