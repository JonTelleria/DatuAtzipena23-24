package dambi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private static String[] cell;

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.println("1.- Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2.- Mendirik altuena bistaratu");
            System.out.println("3.- Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv, Nafarroa.csv)");
            System.out.println("4.- ...");
            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    mendienZerrendaIkusi();
                    break;
                case 2:
                    mendiAltuena();
                    break;
                case 3:
                    importatuCsv();
                    break;


                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
    }

    public static void mendienZerrendaIkusi() throws IOException {
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("Mendiak.csv"));
            String l;

            while ((l = inputStream.readLine()) != null) {

                cell = l.split(";");
                System.out.printf("%-25s | %-25s | %-25s |", cell[0], cell[1], cell[2]);
                System.out.println();

            }
        } catch (FileNotFoundException e) {
            System.out.println("Ez da fitxategia aurkitu");
        }
    }

    public static void mendiAltuena() throws IOException {
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("Mendiak.csv"));
            String l;
            String altuenaIzena = "";
            int altuenaZenbakia = 0;

            while ((l = inputStream.readLine()) != null) {
                String[] cell = l.split(";");

                try {
                    if (Integer.parseInt(cell[1]) > altuenaZenbakia) {
                        altuenaIzena = cell[0];
                        altuenaZenbakia = Integer.parseInt(cell[1]);
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            System.out.println("Mendi altuena " + altuenaIzena + " da, " + altuenaZenbakia + " metrorekin.");

        } catch (FileNotFoundException e) {
            System.out.println("Ez da fitxategia aurkitu");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
    public static void importatuCsv() throws IOException{
        String l;
        BufferedReader inputStream = null;
        PrintWriter outputStreamGip = null;
        PrintWriter outputStreamBizk = null;
        PrintWriter outputStreamAra = null;
        PrintWriter outputStreamNaf = null;
         try {
            inputStream = new BufferedReader(new FileReader("Mendiak.csv"));
            outputStreamGip = new PrintWriter(new FileWriter("Gipuzkoa.csv"));
            outputStreamBizk = new PrintWriter(new FileWriter("Bizkaia.csv"));
            outputStreamAra = new PrintWriter(new FileWriter("Araba.csv"));
            outputStreamNaf = new PrintWriter(new FileWriter("Nafarroa.csv"));

            while ((l = inputStream.readLine()) != null) {
               
                if (l.contains("PROBINTZIA")){
                    outputStreamGip.println(l);
                    outputStreamAra.println(l);
                    outputStreamBizk.println(l);
                    outputStreamNaf.println(l);
                }
                else if(l.contains("Gipuzkoa")){
                    outputStreamGip.println(l);
                }
                else if(l.contains("Bizkaia")){
                    outputStreamBizk.println(l);
                }
                else if(l.contains("Araba")){
                    outputStreamAra.println(l);
                }
                else if(l.contains("Nafarroa")){
                    outputStreamNaf.println(l);
                }
                

            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStreamGip != null) {
                outputStreamGip.close();
            }
            if (outputStreamBizk != null) {
                outputStreamBizk.close();
            }
            if (outputStreamAra != null) {
                outputStreamAra.close();
            }
            if (outputStreamNaf != null) {
                outputStreamNaf.close();
            }

        }
    }
}
