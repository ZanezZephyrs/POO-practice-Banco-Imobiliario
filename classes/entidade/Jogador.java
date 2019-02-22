/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;
import slots.Slot;
import java.util.Vector;

/**
 *
 * @author Giovana
 */
public class Jogador extends principal {
	private int pos;
	private Slot posses[];
	private int total_posses;/*usado de index*/
	private int n_rodovias;
    private int n_servicos;


/*Construtor da classe Jogador com 3 parâmetros*/
public Jogador(String nome, int id_jogador, int pos) {
	super(nome, id_jogador);
	this.pos = 0;
	this.n_rodovias=0;
	this.n_servicos=0;
	this.total_posses=0;
	this.posses=new Slot[30];/*revisar a quantidade/outras opcoes de armazenamento*/
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

public void add_posse(Slot novo) {
	this.posses[this.total_posses]=novo;
	this.total_posses++;
}

public Slot[] getPosses() {
	return this.posses;
}

public void setN_rodovias(int num) {
	this.n_rodovias = num;
}
public int getN_servicos() {
	return this.n_servicos;
}

public void setN_servicos(int num) {
	this.n_servicos = num;
}

}
