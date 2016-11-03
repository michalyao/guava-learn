package net;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        // absolute url.
        // overload URL(URL baseURL, String relativeURL)
        // URL page1BottomURL = new URL(page1URL,"#BOTTOM");
        // getFile will return the Path and the query param
        URL baidu = new URL("https://baidu.com/index.html?q=yaoyao#header");
        URL baidus = new URL("https", "baidu.com", "index.html"); // component constructor

        // parse url
        System.out.println(baidu.getContent());
        System.out.println(baidu.getProtocol());
        System.out.println(baidu.getPath());
        System.out.println(baidu.getHost());
        System.out.println(baidu.getFile());
        System.out.println(baidu.getQuery());
        System.out.println(baidu.getPort());
        System.out.println(baidu.getUserInfo());
        System.out.println(baidu.getAuthority());
        System.out.println(baidu.getRef());

        // read directly from url
        BufferedReader in = new BufferedReader(new InputStreamReader(baidu.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();

        // URLConnection
        URLConnection connection = baidu.openConnection();
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = input.readLine()) != null ) {
            System.out.println(line);
        }
        input.close();

        // post to URL

        // 1. create a url

        // 2. get a URLConnection Object

        // 3. set capability on the URLConnection Object

        // 4. open a connection to the resource

        // 5. get an output stream from the connection

        // 6. write to the output stream

        // 7. close the stream

    }
}
