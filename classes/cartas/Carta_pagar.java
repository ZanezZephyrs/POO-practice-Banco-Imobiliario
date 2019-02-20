package cartas;
import entidade.*;

public class Carta_pagar extends Carta {
	private int valor_pago;

	public Carta_pagar(int val,String descricao, String nome) {
		super(descricao, nome);
		this.valor_pago = val;
	}
	public void aplicar_efeito(Banco beneficiario ,Jogador pagante ) {
			int tot=pagante.getDinheiro_total();
			
			if(tot<this.valor_pago) {/*não ha dinheiro suficiente do jogador*/
				/*hipoteca aqui*/
				pagante.setDinheiro_total(-1);
				beneficiario.setDinheiro_total(beneficiario.getDinheiro_total()+tot);
			}else {
				beneficiario.setDinheiro_total(beneficiario.getDinheiro_total()+this.valor_pago);
				pagante.setDinheiro_total(pagante.getDinheiro_total()-this.valor_pago);
		}
	}
	
	
	public void aplicar_efeito(principal beneficiario, principal[] pagantes) {
		/*implementar transição entre beneficiario e todos os pagantes*/
	}
	public String toString() {
		String out=super.toString();
		out+="Carta de prejuizo\n";
		out+="valor a pagar:"+this.valor_pago+"\n";
		return out;
	}
}
