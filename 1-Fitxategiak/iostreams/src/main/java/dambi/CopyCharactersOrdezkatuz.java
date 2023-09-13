package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Programa honek proiektuaren erroan dagoen xanadu.txt fitxategia karakterez
 * karaktere
 * irakurri egiten du eta karaktere bakoitza character.txt fitxategian idazten
 * ditu eta 'a' letra 'o' letrarekin ordezkatuz
 */

public class CopyCharactersOrdezkatuz {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");
            int c;

            while ((c = inputStream.read()) != -1) {
                if (c == 'a'){  //97
                outputStream.write('o'); //111
            }
                else{
                outputStream.write(c);
            }
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