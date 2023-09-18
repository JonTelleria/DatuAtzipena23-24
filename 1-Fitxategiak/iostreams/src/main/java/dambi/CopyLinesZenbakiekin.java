package dambi;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
/**
 * Programa honek proiektuaren erroan dagoen xanadu.txt fitxategia lerroz lerro
 * irakurri egiten du eta lerro bakoitza outagain.txt fitxategian idazten ditu
 */
public class CopyLinesZenbakiekin {

public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

            
            String l;
            int count = 0;
            while ((l = inputStream.readLine()) != null) {
                count++;
                outputStream.println(count + ".  " + l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
