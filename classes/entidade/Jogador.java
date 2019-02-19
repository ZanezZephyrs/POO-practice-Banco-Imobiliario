/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author Giovana
 */
public class Jogador {
	private int ultimoID = 0;
	private String nome;
	private int id_jogador;
	private int pos;
}

/*Construtor da classe Jogador com 3 parâmetros*/
public Jogador(String nome, int id_jogador, int pos) {
	this.nome = nome;
	this.id_jogador = ultimoID++;
	this.pos = 0;
}

public String getNome(){
	return nome;
}

public int getID_jogador(){
	return id_jogador;
}

public int getPos() {
	return pos;
}

public void setPos(int pos) {
	this.pos = pos;
}
