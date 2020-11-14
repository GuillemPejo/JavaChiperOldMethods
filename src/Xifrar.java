//Guillem Pejó - 05.01.2019 190118_Pr_2DAM_M09UF1_Criptografia

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Xifrar {

    private char[] msg;
    private String claunica;
    private String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final char[][] m = {
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
            {'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A'},
            {'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B'},
            {'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C'},
            {'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D'},
            {'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E'},
            {'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F'},
            {'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G'},
            {'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'},
            {'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'},
            {'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'},
            {'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'},
            {'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'},
            {'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'},
            {'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'},
            {'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'},
            {'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'},
            {'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q'},
            {'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R'},
            {'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S'},
            {'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'},
            {'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'},
            {'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'},
            {'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W'},
            {'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'},
            {'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'}};
    private static final char[][] n = new char[m.length][m.length];

    protected Xifrar(int tipus, char opcio, String missatge) {

        if (Character.toUpperCase(opcio) == 'X') {
            switch (tipus) {
                case 1: System.out.println("Text xifrat: " + xifratCesar(missatge)); //Xifrat amb Cesar, li pasa el missatge a xifrar agafat per l'usuari
                    break;
                case 2:  //Clau();
                    System.out.println("Text xifrat: " + xifratVigenereC(missatge, Clau())); //Xifrat amb V_C, li pasa el missatge a xifrar i la clau agafat per l'usuari
                    break;
                case 3:  //Clau();
                         System.out.println("Text xifrat: " + xifratVigenereA(missatge, Clau())); //Xifrat amb V_A, li pasa el missatge a xifrar i la clau agafat per l'usuari
                         System.out.print("Clau única: "); ////Generació de la clau única (String de 676 caràcters, que ve a ser l'array aleatòri de lletres que ha usat per xifrar-lo)
                            for (int i = 0; i < n.length; i++) {
                                System.out.print(String.valueOf(n[i]));
                            }
                    break;
                default:
                    break;
            }

        } else {
            switch (tipus) {
                case 1: System.out.println("Text xifrat: " + desxifratCesar(missatge)); //Desxifrat amb Cèsar, li pasa el missatge a desxifrar agafat per l'usuari
                    break;
                case 2: System.out.println("Text xifrat: " + desxifratVigenereC(missatge, Clau()));  //Desxifrat amb V_C, li pasa el missatge a desxifrar i la clau agafat per l'usuari
                    break;
                case 3:    //Introducció de la clau unica (String de 676 caràcters, que ve a ser l'array aleatòri de lletres que necessita usar per desxifrar-lo)
                            do {

                                System.out.print("Clau única: ");
                                claunica = new Scanner(System.in).nextLine().toUpperCase();

                            } while (claunica.isEmpty());
                    System.out.println("Text xifrat: " + desxifratVigenereA(missatge, Clau(), claunica));  //Desxifrat amb V_A, li pasa el missatge a desxifrar, la clau i la clau unica agafat per l'usuari

                    break;
                default:
                    break;
            }
        }
    }


    //Mètode per xifrar el missatge en xifratge Cèsar
    private static String xifratCesar(String missatge) {
        StringBuilder xifrat = new StringBuilder();
        int codi = -3; //numero de poscions que avança les lletres (en aquest cas es -3 perquè recula 3 posicions cada lletra)
        codi = codi % 26;

        for (int i = 0; i < missatge.length(); i++) {

            if (missatge.charAt(i) == ' ') {

                xifrat.append((char) (missatge.charAt(i)));

            } else if(missatge.charAt(i) >= 'A' && missatge.charAt(i) <= 'Z') {

                if ((missatge.charAt(i) + codi) < 'A') {

                    xifrat.append((char) (missatge.charAt(i) + codi + 26));

                } else {

                    xifrat.append((char) (missatge.charAt(i) + codi));
                }
            }
        }

        return xifrat.toString();
    }

    //Mètode per desxifrar el missatge en xifratge Cèsar
    private static String desxifratCesar(String missatge) {

        StringBuilder xifrat = new StringBuilder();
        int codi = -3;
        codi = codi % 26;

        for (int i = 0; i < missatge.length(); i++) {

            if (missatge.charAt(i) == ' ') {

                xifrat.append((char) (missatge.charAt(i)));

            } else if(missatge.charAt(i) >= 'A' && missatge.charAt(i) <= 'Z') {

                if ((missatge.charAt(i) - codi) > 'Z') {

                    xifrat.append((char) (missatge.charAt(i) - codi - 26));

                } else {

                    xifrat.append((char) (missatge.charAt(i) - codi));

                }
            }
        }

        return xifrat.toString();
    }


    //Mètode per xifrar el missatge en xifratge Vigenere Clàssic
    private String xifratVigenereC(String missatge, String clau) {

        this.msg = missatge.toCharArray(); //Converteix el missatge entrat per l'usuari en un array de caràcters
        char[] clauT = clau.toCharArray(); //Converteix la clau entrada per l'usuari en un array de caràcters
        char[] clau_def = new char[msg.length];

        int cont=0;

        //Omple l'array CLAU_DEF amb la CLAU repetida tantes vegades com lletres tingui el MSG, de tal manera que: CLAU_DEF.length == MSG.length
        for(int i=0;i<msg.length;i++)
        {
            clau_def[i]=clauT[cont];
            cont++;
            if(cont==clauT.length)
                cont=0;
        }

        char[] xifrat = new char[missatge.length()];

        //Busca en l'array M la posició on és troba la columna la qual la seva fila perpendicular és la posició a l'abacedari de cada lletra de la CLAU_DEF, i en ella busca la posició a l'abacedari de cada lletra del MSG. Fa servir l'String.valueOf per tal de poder fer l'indexOf del missatge.

        //x = iteració de cada lletra de CLAU_DEF
        //y = iteració de cada lletra de MSG
        //[fila x] {y0, y1, y2, y3, y4, y5}
        //--> amb la posició d'aquesta lletra, després fa un indexOf al abecedari (abc) i obté la lletra original
        for (int i = 0; i<missatge.length(); i++)
        {
            xifrat[i]=(m[abc.indexOf(clau_def[i])][abc.indexOf(msg[i])]);
        }

        String x_resultat = new String(xifrat); //Converteix l'array xifrat amb l'String x_resultat

        return x_resultat;
    }

    //Mètode per desxifrar el missatge en xifratge Vigenere Clàssic
    private String desxifratVigenereC(String missatge, String clau) {

        this.msg = missatge.toCharArray(); //Converteix el missatge entrat per l'usuari en un array de caràcters
        char[] clauT = clau.toCharArray(); //Converteix la clau entrada per l'usuari en un array de caràcters
        char[] clau_def = new char[msg.length];
        int cont=0;

        //Omple l'array CLAU_DEF amb la CLAU repetida tantes vegades com lletres tingui el MSG, de tal manera que: CLAU_DEF.length == MSG.length
        for(int i=0;i<msg.length;i++)
        {
            clau_def[i]=clauT[cont];
            cont++;
            if(cont==clauT.length)
                cont=0;
        }

        char[] desxifrat = new char[missatge.length()];

        for (int i = 0; i<missatge.length(); i++)
        {
            desxifrat[i]= m[0][String.valueOf(m[abc.indexOf(clau_def[i])]).indexOf(msg[i])];
        }
        String x_resultat = new String(desxifrat);

        return x_resultat;

    }


    //Mètode per xifrar el missatge en xifratge Vigenere Avançat
    private String xifratVigenereA(String missatge, String clau) {
        //Fa exactament el mateix que el mètode xifratVigenereC(), però abans crida el mètode AbcRandom() per obtenir la nova matriu N aleatòria.
        this.msg = missatge.toCharArray();
        char[] clauT = clau.toCharArray();
        char[] definitivo = new char[msg.length];

        int cont=0;

        AbcRandom();

        for(int i=0;i<msg.length;i++)
        {
            definitivo[i]=clauT[cont];
            cont++;
            if(cont==clauT.length)
                cont=0;
        }

        char[] xifrat = new char[missatge.length()];
        for (int i = 0; i<missatge.length(); i++)
        {
            xifrat[i]=(n[abc.indexOf(definitivo[i])][abc.indexOf(msg[i])]); //indexof
        }

        String x_resultat = new String(xifrat);

        return x_resultat;
    }

    //Mètode per desxifrar el missatge en xifratge Vigenere Avançat
    private String desxifratVigenereA(String missatge, String clau, String claunica) {
        //Fa exactament el mateix que el mètode desxifratVigenereC(), però amb alguns petits canvis
        int desde = 0, finsa = abc.length();

        //Agafa l'array de 676 càracters i el converteix en un abacedari, tallant en les parts corresponents (abc.length())
        for (int i = 0; i <abc.length(); i++) {
            n[i] = claunica.substring(desde,finsa).toCharArray();
            desde+= abc.length();
            finsa+=abc.length();
        }

        this.msg = missatge.toCharArray();
        char[] clauT = clau.toCharArray();
        char[] definitivo = new char[msg.length];

        int cont=0;

        for(int i=0;i<msg.length;i++)
        {
            definitivo[i]=clauT[cont];
            cont++;
            if(cont==clauT.length)
                cont=0;
        }

        char[] desxifrat = new char[missatge.length()];

        for (int i = 0; i<missatge.length(); i++)
        {
            desxifrat[i]= abc.toCharArray()[String.valueOf(n[abc.indexOf(definitivo[i])]).indexOf(msg[i])];
        }

        String x_resultat = new String(desxifrat);

        return x_resultat;
    }


    //Generador d'abacedari random
    private char[][] AbcRandom() {

        ArrayList<Integer> numeros = new ArrayList<>(m.length);

        Random random = new Random();

        for (int i = 0; i < abc.length(); i++) {
            for (int k=0;k<m.length;k++){
                numeros.add(k); //Omple l'ArrayList amb numeros
            }
            for (int j = 0; j < abc.length(); j++) {
                int randomIndex = random.nextInt(numeros.size());
                n[i][j]= abc.toCharArray()[numeros.get(randomIndex)]; //Otorga al nou Array N la lletra corresponent al ArrayList
                numeros.remove(randomIndex); //Borra el número de l'ArrayList per tal de no obtenir lletres repetides
            }
        }

        return n;
    }


    //Entrada de la clau
    private static String Clau(){
        String clau;
        boolean compleix;
        //Entrada de la clau per part de l'usuari, amb un patró unicament alfabètic.
        do {
            System.out.print("Clau: ");
            clau = new Scanner(System.in).nextLine().toUpperCase();
            Pattern p= Pattern.compile("^[a-zA-Z]*$");
            Matcher m=p.matcher(clau);
            if(m.find()){
                compleix = true;
            }
            else{
                System.err.println("El text no pot contenir números ni simbols");
                compleix = false;
            }
        } while (compleix == false);

        return clau;
    }
}
