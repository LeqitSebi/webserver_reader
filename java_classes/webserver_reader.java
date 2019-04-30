package java_classes;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class webserver_reader {

    public static void main(String[] args) throws IOException {
        read_from_server();
    }

    public static void read_from_server() throws IOException {
        URL url = new URL("http://christoph.tauchner.me");
        String text = new Scanner(url.openStream()).useDelimiter("\\A").next();
        System.out.println(remove_tags(text));
    }

    public static StringBuilder remove_tags(String input) {
        StringBuilder output = new StringBuilder();
        int j = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '<') {
                j++;
            }
            if (j == 0) {
                output.append(c);
            }
            if (c == '>') {
                j--;
            }
        }
        return output;
    }
}
