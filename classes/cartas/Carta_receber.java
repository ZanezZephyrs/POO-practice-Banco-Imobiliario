package cartas;

public class Carta_receber extends Carta {
	private int valor_recebido;

	public Carta_receber(int valor_recebido,String descricao, String nome) {
		super(descricao, nome);
		this.valor_recebido = valor_recebido;
	}
	public void aplicar_efeito(Entidade beneficiario, Entidade pagante) {
		/*implementar transição entre beneficiario e pagante*/
	}
	
	public void aplicar_efeito(Entidade beneficiario, Entidade[] pagantes) {
		/*implementar transição entre beneficiario e todos os pagantes*/
	}
	public String toString() {
		String out=super.toString();
		out+="Carta de beneficio\n";
		out+="valor a receber:"+this.valor_recebido+"\n";
		return out;
	}
}
