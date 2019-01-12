package br.com.the_gallows.app;

import br.com.the_gallows.interfaces.Jogo;
import br.com.the_gallows.utils.Biblioteca;
import br.com.the_gallows.models.Questao;
import java.util.Scanner;
import java.util.ArrayList;

public class JogoDaForca implements Jogo{

    private Scanner sc = new Scanner( System.in ); //Sccanner
    private Biblioteca lib = new Biblioteca(); //Biblioteca que contem as questoes
    private Questao questao; //Armazena a questao em jogo
    private ArrayList<Character> respostaUser = new ArrayList<>(); //Armazena as letras acertadas pelo usuario
    private ArrayList<Character> respostaCorreta = new ArrayList<>();
    private int vidas; //Armazena o numero de chances restantes


    //Inicia o jogo
    public void start(){

        respostaUser.clear(); //Limpa o array
        respostaCorreta.clear(); //Limpa os array

        this.questao = lib.sortear(); //Escolhe a palavra
        this.vidas = 5; //Seta 5 vidas

        //Acerta os arrays de reposta
        String resposta = questao.getResposta();
        for( int i = 0 ; i < resposta.length() ; i++ ){

            //IF para pular espaços
            if( resposta.charAt(i) != ' '  ) {
                respostaUser.add('_');
            }else {
                respostaUser.add(' ');
            }

            respostaCorreta.add(resposta.charAt(i));
        }

        mostrarStatus(); // Mostra o status

    }

    //Mostra o Status do Jogo
    private void mostrarStatus(){


        lib.cabecalho();
        System.out.println("\nVidas restantes : " + vidas );
        System.out.println("Dica : " + questao.getDica() );
        System.out.println("Respota: " + charToString(respostaUser) );
        //System.out.println("Resposa correta : " + charToString(respostaCorreta) );

        verificarLetra( getLetra() );

    }

    //Pega a letra inserida
    private String getLetra(){
        System.out.print("R: ");
        return sc.nextLine();
    }

    //Verifica se a letra esta correta
    private void verificarLetra( String letra ){

        boolean errou = true;

        //Verifica se o usuario digitou uma letra ou tentou a palavra
        if( letra.length() == 1 ) {

            //Percorre o array de char comparando com a string digitada
            for( int i = 0 ; i < respostaCorreta.size() ; i++ ){

                //Letra normal
                if( respostaCorreta.get(i).equals( letra.charAt(0) ) ){
                    respostaUser.set( i , letra.charAt(0) );
                    errou = false;
                }


                //Letra maiuscula
                if(  respostaCorreta.get(i).equals( Character.toUpperCase(letra.charAt(0) ) ) ) {
                    respostaUser.set( i , letra.charAt(0) );
                    errou = false;
                }

            }

        }else {

            if( letra.equalsIgnoreCase( charToStringCompare(respostaCorreta) ) ){

                errou = false;
                respostaUser.clear();
                respostaUser.addAll(respostaCorreta);

            }

        }

        if( errou ){

            tirarVida();

        }else{

            if( faltaLetras() ){

                mostrarStatus();

            }else{

                lib.win( questao );

            }

        }

    }

    //Tira uma vida do usuario
    private void tirarVida(){

        this.vidas -= 1;
        if( this.vidas > 0 ){
            mostrarStatus();
        }else{
            lib.gameOver();
        }

    }

    //Verifica se falta letras
    private boolean faltaLetras(){

        boolean falta = false;

        for( int i = 0 ; i < respostaUser.size() ; i++ ){
            if( respostaUser.get(i).equals('_') ){
                falta = true;
            }
        }

        return falta;
    }

    //Coverte um ArrayList de char em uma String para Print
    private String charToString( ArrayList<Character> chars ){

        String palavra = "";

        for( int i = 0 ; i < chars.size() ; i++){
            palavra += chars.get(i) + " ";
        }
        return palavra;
    }

    //Coverte um ArrayList de char em uma String para Comparar ( tira os espacos da string )
    private String charToStringCompare( ArrayList<Character> chars ){

        String palavra = "";

        for( int i = 0 ; i < chars.size() ; i++){
            palavra += chars.get(i) + "";
        }
        return palavra;
    }

}
