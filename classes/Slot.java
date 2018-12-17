
public class Slot {
	private int ID;/*id da posição(1~40)*/
	public Slot(int id) {
		this.ID=id;
	}
	
	public void SetID(int id) {
		this.ID=id;
	}
	public int GetID() {
		return this.ID;
	}
	public String toString() {
		String out="";
		out+="ID:"+this.ID+"\n";
		return out;
	}
}
