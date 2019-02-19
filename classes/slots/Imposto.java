package slots;

public class Imposto extends Slot {
	int valor_imposto;
	
	public Imposto(int id, String name, int val) {
		super(id, name);
		this.valor_imposto=val;
	}

	public String toString() {
		String out=super.toString();
		out+="Valor do Imposto:"+this.valor_imposto+"\n";
		return out;
	}
}
