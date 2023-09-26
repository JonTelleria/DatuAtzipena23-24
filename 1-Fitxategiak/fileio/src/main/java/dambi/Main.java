package dambi;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static int aukera = 0;
    public static void main(String[] args) throws IOException {
        while(aukera != 4){
            System.out.println("MENUA");
            System.out.println("----------------------");
            System.out.println("1.Erabiltzaileari fitxategi/direktorio baten path absolutoa eskatu eta gure fitxategi sisteman ba ote daukagun egiaztatu.");
            System.out.println("2.Karpeta jakin baten edukia bistaratu. Lehen mailako edukia (bilaketa sakona zailagoa izango da, ezta?");
            System.out.println("3.Fitxategia sortu");
            System.out.println("4.Irten");
            System.out.print("Sartu zenbaki bat: ");
            aukera = in.nextInt();

            switch(aukera){
                case 1:
                    direktorioExistitzenDa();
                    break;
                case 2:
                    edukiaBistaratu();
                    break;
                case 3:
                    fitxategiaSortu();
                    break;
            }
        }
    }

    private static void 

}