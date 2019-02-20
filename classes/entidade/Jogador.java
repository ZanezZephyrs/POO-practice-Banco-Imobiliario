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
	private int pos;
	private Slot posses[];
	private int n_rodovias;


/*Construtor da classe Jogador com 3 parâmetros*/
public Jogador(String nome, int id_jogador, int pos) {
	super(nome, id_jogador);
	this.pos = 0;
	this.n_rodovias=0;
}


public int getPos() {
	return pos;
}

public void setPos(int pos) {
	this.pos = pos;
}
public int getN_rodovias() {
	return this.n_rodovias;
}

public void setN_rodovias(int num) {
	this.n_rodovias = num;
}

}
