import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProvaCT {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int qttTemp = 0;
        String tempOrigem;
        String tempSaida;


        double tempsRec;
        double tempsTransf = 0;
        ArrayList<Double>  arrayRecebidas = new ArrayList<>(qttTemp);
        ArrayList<Double>  arrayTransformadas = new ArrayList<>(qttTemp);

        //recebe a quantidade de temperaturas por input

        try {
            System.out.println("Digite a quantidade de temperaturas a serem convertidas:");
            qttTemp = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Este não é um número válido. Digite novamente.");
            scan.next();
            qttTemp = scan.nextInt();
        }


        //recebe a temp de origem
        System.out.println("Digite a temperatura de origem em letras minúsculas:");
        tempOrigem = scan.next();


        if (tempOrigem.matches("celsius")|| tempOrigem.matches("kelvin") || tempOrigem.matches("fahrenheit")) {
        } else {
            System.out.println("Dado inválido. Tente novamente.");
            tempOrigem = scan.next();
        }

        //recebe a temp de saída
        System.out.println("Digite a temperatura de saída em letras minúsculas:");
        tempSaida = scan.next();
        if (tempSaida.matches("celsius")|| tempSaida.matches("kelvin") || tempSaida.matches("fahrenheit")) {
        } else {
            System.out.println("Dado inválido. Tente novamente.");
            tempSaida = scan.next();
        }

        //recebe as temperaturas a serem convertidas e cria uma array que armazena as mesmas
        System.out.println("Digite a(s) temperatura(s) a serem convertidas:");
        for (int i = 0; i < qttTemp; i++) {
            tempsRec = scan.nextDouble();
            arrayRecebidas.add(tempsRec);
        }
        // System.out.println(arrayRecebidas);

        //converte as temperaturas, cria uma array que armazena as mesmas e imprime as conversões
        conversor(qttTemp, tempOrigem, tempSaida, tempsTransf, arrayRecebidas, arrayTransformadas);
        // System.out.println(arrayTransformadas);

        double somaRec = 0;

        System.out.println("\nMÉDIA TEMPERATURAS RECEBIDAS:");
        media(qttTemp, tempOrigem, arrayRecebidas, somaRec);


        double somaTransf = 0;

        System.out.println("\nMÉDIA TEMPERATURAS TRANSFORMADAS");
        media(qttTemp, tempSaida, arrayTransformadas, somaTransf);
    }

    private static void media(int qttTemp, String tempOS, ArrayList<Double> arrayRecTransf, double somaRecTransf) {
        double mediaRecTransf;
        for (int i = 0; i < qttTemp; i++) {
            somaRecTransf += arrayRecTransf.get(i);
        }
        mediaRecTransf = somaRecTransf / qttTemp;

        System.out.println("A lista de temperaturas é: " + arrayRecTransf);
        System.out.println("A média das temperaturas é: " + mediaRecTransf + " " + tempOS + "\n");
    }

    private static void conversor(int qttTemp, String tempOrigem, String tempSaida, double tempsTransf, ArrayList<Double> arrayRecebidas, ArrayList<Double> arrayTransformadas) {
        for (int i = 0; i < qttTemp; i++) {
            if (tempOrigem.equals("celsius") && tempSaida.equals("kelvin")) {
                tempsTransf = arrayRecebidas.get(i) + 273.15;
                System.out.printf(arrayRecebidas.get(i) + " " + tempOrigem + " = " + tempsTransf + " " + tempSaida);
            } else if (tempOrigem.equals("celsius") && tempSaida.equals("fahrenheit")) {
                tempsTransf = (arrayRecebidas.get(i) * 9/5)+32;
                System.out.println(arrayRecebidas.get(i) + " " + tempOrigem + " = " + tempsTransf + " " + tempSaida);
            } else if (tempOrigem.equals("kelvin") && tempSaida.equals("celsius")) {
                tempsTransf = arrayRecebidas.get(i) - 273.15 ;
                System.out.println(arrayRecebidas.get(i) + " " + tempOrigem + " = " + tempsTransf + " " + tempSaida);
            } else if (tempOrigem.equals("kelvin") && tempSaida.equals("fahrenheit")) {
                tempsTransf = (arrayRecebidas.get(i) - 273.15) * 9/5 + 32;
                System.out.println(arrayRecebidas.get(i) + " " + tempOrigem + " = " + tempsTransf + " " + tempSaida);
            } else if (tempOrigem.equals("fahrenheit") && tempSaida.equals("celsius")) {
                tempsTransf = (arrayRecebidas.get(i) - 32) * 5/9;
                System.out.println(arrayRecebidas.get(i) + " " + tempOrigem + " = " + tempsTransf + " " + tempSaida);
            } else if (tempOrigem.equals("fahrenheit") && tempSaida.equals("kelvin")) {
                tempsTransf = (arrayRecebidas.get(i) - 32) * 5/9 + 273.15;
                System.out.println(arrayRecebidas.get(i) + " " + tempOrigem + " = " + tempsTransf + " " + tempSaida);
            } else {
                System.out.println("Tipo de temperatura inválida. Verifique a ortografia e digite novamente. \n");
            }
            arrayTransformadas.add(tempsTransf);
        }
    }
}
