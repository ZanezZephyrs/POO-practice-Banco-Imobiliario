package cartas;
import entidade.*;

public class Carta_receber extends Carta {
	private int valor_recebido;

	public Carta_receber(int valor_recebido,String descricao, String nome) {
		super(descricao, nome);
		this.valor_recebido = valor_recebido;
	}
	public void aplicar_efeito(Banco pagante ,Jogador beneficiario ) {
			beneficiario.setDinheiro_total(beneficiario.getDinheiro_total()+this.valor_recebido);
			pagante.setDinheiro_total(pagante.getDinheiro_total()-this.valor_recebido);
		}
	
	
	public String toString() {
		String out=super.toString();
		out+="Carta de beneficio\n";
		out+="valor a receber:"+this.valor_recebido+"\n";
		return out;
	}
}
