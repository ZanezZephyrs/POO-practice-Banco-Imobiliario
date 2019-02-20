package cartas;
import entidade.*;

public class Carta_move extends Carta {
	private int destino;
	public Carta_move(int dest, String descricao, String nome) {
		super(descricao, nome);
		this.destino=dest;
	}
	
	
	public void aplicar_efeito(Jogador player) {
		
	}
	public String toString() {
		String out=super.toString();
		out+="Carta de movimentação\n";
		out+="Id do destino:"+this.destino+"\n";
		return out;
	}
}
