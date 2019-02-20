package cartas;
import slots.*;
import entidade.Jogador;

public class Carta_move_prox_road extends Carta_move {
	public Carta_move_prox_road(int dest, String desc, String nome) {
		super(dest, desc, nome);
		
	}
	public void aplicar_efeito(Jogador player, Slot tabuleiro[] ) {
		int i;
		for (i=player.getPos()+1;i<tabuleiro.length;i++) {
			if(tabuleiro[i] instanceof Roads) {
				
			}
		}
	}
}
