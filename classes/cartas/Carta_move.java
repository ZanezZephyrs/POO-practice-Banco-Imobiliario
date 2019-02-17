package cartas;

public class Carta_move extends Carta {
	private int destino;
	public Carta_move(int dest, String descricao, String nome) {
		super(descricao, nome);
		this.destino=dest;
	}
	
	public void aplicar_efeito(Jogador player) {
		/*mover posição do jogador até o destino,
		 * destino pode contem o id do slot
		 *  da posição q deve-se mover no tabuleiro*/
	}
	public String toString() {
		String out=super.toString();
		out+="Carta de movimentação\n";
		out+="Id do destino:"+this.destino+"\n";
		return out;
	}
}
