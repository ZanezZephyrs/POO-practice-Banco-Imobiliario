package slots;
import entidade.principal;

public class Roads extends Slot{
	private principal dono;/*dono da propriedade, antes da compra por jogador, o banco é dono*/
	
	public Roads(int id, String name, principal dono) {
		super(id, name);
		this.dono=dono;
	}
	
	public String toString() {
		String out=super.toString();
		out+="Dono:" + this.dono.getNome()+"\n";
		return out;
	}
}
