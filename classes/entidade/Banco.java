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
public class Banco {
    private int id_jogador;
    private int num_casas;
    private int num_hoteis;
}

/*Construtor da classe Jogador com 3 parâmetros*/
public Banco(int id_jogador, int num_casas, int num_hoteis) {
		this.id_jogador = 0; /*Primeiro jogador*/
		this.num_casas = 32;
		this.num_hoteis = 12;
}

public int getID_jogador(){
	return id_jogador;
}

public int getNum_casas() {
	return num_casas;
}

public int getNum_hoteis(){
	return num_hoteis;
}

