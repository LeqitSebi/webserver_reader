package java_classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class inhabitant_check {

    public static void main(String[] args) throws IOException {
        System.out.println(get_inhabitants("Parndorf"));
    }

    public static int get_inhabitants(String city) throws IOException {
        BufferedReader in = Files.newBufferedReader(Paths.get("resources/inhabitant_list.txt"), Charset.forName("UTF-8"));
        String line;
        String inhabs="";
        while ((line = in.readLine()) != null) {
            String current_city="";
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i)!=':'){
                    current_city += line.charAt(i);
                }
                else{break;}
            }
            if (current_city.equals(city)){
                for (int i = city.length()+1; i < line.length(); i++) {
                    inhabs += line.charAt(i);
                }
            }
        }
        return Integer.parseInt(inhabs);
    }
}
