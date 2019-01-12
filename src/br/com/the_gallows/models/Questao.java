package br.com.the_gallows.models;


public class Questao{

    private String dica;
    private String resposta;

    public Questao( String dica , String resposta ){
        this.dica = dica;
        this.resposta = resposta;
    }

    public void setDica( String dica ){
        this.dica = dica;
    }

    public void setResposta( String resposta ){
        this.resposta = resposta;
    }

    public String getDica(){
        return this.dica;
    }

    public String getResposta(){
        return this.resposta;
    }

}