/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;
import slots.Slot;

/**
 *
 * @author Giovana
 */
public class Jogador extends principal {
	private int ultimoID;
	private int id_jogador;
	private int pos;
	private Slot posses[];


/*Construtor da classe Jogador com 3 parâmetros*/
public Jogador(String nome, int id_jogador, int pos) {
	super(nome);
	this.id_jogador = id_jogador;
	this.pos = 0;
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
}
