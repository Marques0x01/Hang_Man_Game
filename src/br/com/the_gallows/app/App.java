package br.com.the_gallows.app;

import java.util.Scanner;

public class App{

    public static void main( String[] args ){

        Scanner sc = new Scanner(System.in);
        JogoDaForca jogo = new JogoDaForca();
        int op = 1;

        do{

            System.out.println("\nBem vindo ao jogo da forca");
            System.out.println("---------------------------------");
            System.out.println("| 1 - Novo Jogo                 |");
            System.out.println("| 2 - Sair                      |");
            System.out.println("---------------------------------\n");

            try {
                op = sc.nextInt();
            }catch( Exception e ) {
                System.out.println("Bye...");
                op = 0;
            }


            if( op == 1 ){
                jogo.start();
            }
            if( op ==2 ) {
                System.out.println("Jogo terminado !");
            }

        }while( op == 1 );

        if( op == 0 ){
            sc.close();
            System.exit(0);
        }


    }

}
