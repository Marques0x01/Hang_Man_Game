package br.com.the_gallows.utils;

import java.util.ArrayList;
import java.util.Random;
import br.com.the_gallows.models.Questao;

public class Biblioteca{

    ArrayList<Questao> questoes = new ArrayList<>();
    Random random = new Random();

    //Inicializa as Palavras
    public Biblioteca(){

        questoes.add( new Questao("Qual é a cidade que mais produz lixo diariamente no Brasil?" , "Sao Paulo") );
        questoes.add( new Questao("Qual o animal mais ameaçado pelo Aquecimento Global?" , "Coala") );
        questoes.add( new Questao("O seletor verde serve para que tipo de material?" , "Vidro") );
        questoes.add( new Questao("O seletor verde amarelo para que tipo de material?" , "Metal") );
        questoes.add( new Questao("O seletor azul serve para que tipo de material?" , "Papel") );
        questoes.add( new Questao("Qual o material demora mais tempo para se decompor na natureza?" , "Vidro") );
        questoes.add( new Questao("Nome do local conhecido pelo descarte de lixo" , "Aterro") );
        questoes.add( new Questao("Qual o tipo de gás gerado pelas plantas?" , "Oxigenio") );
        questoes.add( new Questao("Qual o país que mais contribui para o Aquecimento Global?" , "China") );
        questoes.add( new Questao("É um dos tres R's da coleta seletiva" , "Reduzir") );
        questoes.add( new Questao("É um dos tres R's da coleta seletiva" , "Reutilizar") );
        questoes.add( new Questao("É um dos tres R's da coleta seletiva" , "Reciclar") );
        questoes.add( new Questao("Qual o tipo de material que nao pode ser reciclado ?" , "Radioativo") );
        questoes.add( new Questao("É um dos tres R's da coleta seletiva" , "Reutilizar") );
        questoes.add( new Questao("País que mais recicla aluminio no mundo" , "Brasil") );
        questoes.add( new Questao("É usado para produzir um combustivel renovavel" , "Milho") );
        questoes.add( new Questao("Material que mais gera residuo no Brasil" , "Organico") );
        questoes.add( new Questao("Concequencias do descarte incorreto de lixo" , "Enchentes e Doencas") );
        questoes.add( new Questao("Qual cuidado ao ser tomado ao enviar um material a reciclagem" , "Limpa lo") );

    }

    public ArrayList<Questao> listar(){
        return this.questoes;
    }

    public Questao sortear(){
        int indice = random.nextInt( questoes.size() );
        return questoes.get( indice );
    }

    public void gameOver(){
        System.out.println("\n\n\n\n\n\n\n\nGame Over !!!!!!!!");
    }

    public void win( Questao questao ){
        System.out.println( "\n\n\n\n\n\n\n\n" + questao.getDica() + "  " + questao.getResposta() +
                "\nParabens ! Voce ganhou !!!" );
    }

    public void cabecalho(){

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\tJogo da Forca !!!");
        System.out.println("___________________________________________________________________");


    }

}
