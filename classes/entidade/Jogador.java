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
    private int id_jogador;
    private int pos;          
}

/*Construtor da classe Jogador com 2 parâmetros*/
public Jogador(int id_jogador, int pos){
   this.id_jogador = id_jogador;
   this.pos = pos;
}
