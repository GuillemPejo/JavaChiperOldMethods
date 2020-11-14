import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Guillem Pejó - 05.01.2019 190118_Pr_2DAM_M09UF1_Criptografia

public class Main {

    public static void main(String[] args){

        Xifrar x1 = new Xifrar(TipusXifrat(), Opcio(), Missatge());
    }

    private static int TipusXifrat() {
        int tipusxifrat = 0;
        //Entrada numèrica del tipus de xifratge, per part de l'usuari, amb un control d'errors perquè l'entrada sigui unicament numèrica i repeteix el bucle mentre l'usuari no trii entre 1, 2 o 3
        do {
            System.out.println("\n--------------------------------------------");
            System.out.println("=========== Xifrador i Desxifrador ===========");
            System.out.println("----------------------------------------------");
            System.out.println("Cèsar(1) | Vigenere Clàssic(2) | Vigenere Avançat(3)");
            System.out.println("----------------------------------------------");
            System.out.print("En quin mètode vols xifrar?: ");
            try {
                tipusxifrat = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Entrada incorrecte! Has d'entrar un número comprès entre l'1 i el 3");            }
            
        } while (tipusxifrat< 1|| tipusxifrat > 3);

        return tipusxifrat;
    }

    private static String Missatge(){
        String missatge;
        boolean compleix;
        //Entrada del missatge per part de l'usuari, amb un patró unicament alfabètic.
        do {
            System.out.print("Introdueixi el missatge: ");
            missatge = new Scanner(System.in).nextLine().toUpperCase();

            Pattern p= Pattern.compile("^[a-zA-Z]*$"); //patró alfabètic
            Matcher m=p.matcher(missatge);
            if(m.find()){
                compleix = true;
            }
            else{
                System.err.println("El text no pot contenir números, espais ni simbols");
                compleix = false;
            }
        } while (compleix == false);

        return missatge;
    }

    private static char Opcio() {
        //Entrada de l'opcio de xifrar o desxifrar per part de l'usuari, es repeteix el bucle mentre l'usuari no trii entre X o D.
        char opcio;
        do {
            System.out.print("Vols xifrar (X) o desxifrar (D)?: ");
            opcio = new Scanner(System.in).next().charAt(0);
        } while (Character.toUpperCase(opcio) != 'X' && Character.toUpperCase(opcio) != 'D');

        return opcio;
    }

}







