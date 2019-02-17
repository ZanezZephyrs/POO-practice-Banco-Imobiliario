package slots;

public class Slot {
	private int ID;/*id da posição(1~40)*/
	private String nome;/*nome da propriedade*/
	public Slot(int id, String name) {
		this.ID=id;
		this.nome=name;
	}
	
	public void SetID(int id) {
		this.ID=id;
	}
	public int GetID() {
		return this.ID;
	}
	public void SetNome(String nome) {
		this.nome=nome;
	}
	public String GetNome() {
		return this.nome;
	}
	public String toString() {
		String out="";
		out+="ID:"+this.ID+"\n";
		return out;
	}
}
