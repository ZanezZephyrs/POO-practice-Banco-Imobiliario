package slots;
import entidade.Jogador;
import mecanica.Motor;

public class Imposto extends Slot {
	private int valor_imposto;
	
	public Imposto(int id, String name, int val) {
		super(id, name);
		this.valor_imposto=val;
	}

	public String toString() {
		String out=super.toString();
		out+="Valor do Imposto:"+this.valor_imposto+"\n";
		return out;
	}
	
	public void executar(Jogador alvo, Motor motor) {
		System.out.printf("Imposto, %d será descontado de seu dinheiro\n", this.valor_imposto);
		alvo.setDinheiro_total(alvo.getDinheiro_total()-this.valor_imposto);
		if(alvo.getDinheiro_total()<0) {
			motor.getJogadores().remove(alvo);
			System.out.printf("Jogador %s, não possui dinheiro para pagar o imposto\n "
					+ "Jogador %s Faliu e foi removido do jogo\n", alvo.getNome(),alvo.getNome());
		}
	}
}
