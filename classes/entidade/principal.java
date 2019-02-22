/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author Giovana
 */
public class principal {
	private String nome;
	private int ID;
    private int dinheiro_total;
    private int notas_100;
    private int notas_50;
    private int notas_20;
    private int notas_10;
    private int notas_5;
    private int notas_1;
    
    public principal(String name, int id) {
    	this.nome=name;
    	this.ID=id;
    	this.dinheiro_total=1500;
    	/*inserir o numero de notas padrão por jogador*/
    }
    public int getID() {
    	return this.ID;
    }
    
    public int getDinheiro_total() {
        return dinheiro_total;
    }
    public int getNotas_100() {
        return notas_100;
    }
    public int getNotas_50() {
        return notas_50;
    }
    public int getNotas_20() {
        return notas_20;
    }
    public int getNotas_10() {
        return notas_10;
    }
    public int getNotas_5() {
        return notas_5;
    }
    public int getNotas_1() {
        return notas_1;
    }
    public String getNome() {
    	return this.nome;
    }
    public void setDinheiro_total(int dinheiro_total) {
        this.dinheiro_total = dinheiro_total;
    }
    public void setNotas_100(int notas_100) {
        this.notas_100 = notas_100;
    }
    public void setNotas_50(int notas_50) {
        this.notas_50 = notas_50;
    }
    public void setNotas_20(int notas_20) {
        this.notas_20 = notas_20;
    }
    public void setNotas_10(int notas_10) {
        this.notas_10 = notas_10;
    }
    public void setNotas_5(int notas_5) {
        this.notas_5 = notas_5;
    }
    public void setNotas_1(int notas_1) {
        this.notas_1 = notas_1;
    }
    public void setNome(String name) {
    	this.nome=name;
    }
    public void Pagamento() {
    	
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
