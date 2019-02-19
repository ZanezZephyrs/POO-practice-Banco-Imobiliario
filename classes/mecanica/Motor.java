package mecanica;
import slots.Slot;
import slots.Propriedade;
import entidade.principal;
import slots.Roads;
import slots.Inicio;
import slots.Sorte;
import slots.Imposto;


public class Motor {
	private int n_jogadores;
	private Slot[] tabuleiro;
	private int jogadores_restantes;
	
	public Motor(int jogadores) {
		this.n_jogadores=jogadores;
		this.jogadores_restantes=jogadores;
	}
	
	public void cria_tabuleiro1(principal Banco) {
		this.tabuleiro=new Slot[40];
		/*construtor propriedade(id, vetor de valores, nome, casas, dono, compra, hipoteca)*/
		tabuleiro[0]=new Inicio(0, "Inicio");
		tabuleiro[1]=new Propriedade(1,cria_vetor(2,10,30,90,160,250),"Mediterranean Avenue",0,Banco,60,30);
		tabuleiro[2]=new Sorte(2, "Sorte");
		tabuleiro[3]=new Propriedade(3,cria_vetor(4,20,60,180,320,450),"Baltic Avenue", 0, Banco, 60, 30);
		tabuleiro[4]=new Imposto(4,"Income Tax", 200);
		tabuleiro[5]=new Roads(5,"Reading Railroad", Banco);
		tabuleiro[6]=new Propriedade(6,cria_vetor(6,30,90,270,400,550),"Oriental Avenue", 0, Banco, 100, 50);
		tabuleiro[7]=new Sorte(7, "Sorte");
		tabuleiro[8]=new Propriedade(8,cria_vetor(6,30,90,270,400,550),"Vermont Avenue", 0, Banco, 100,50);
		tabuleiro[9]=new Propriedade(9,cria_vetor(8,40,100,300,450,600),"Connecticut Avenue", 0, Banco, 120,60);
		tabuleiro[10]=new Slot(10, "Prisão");
		
	}
	
	public void imprimi_tabuleiro() {
		int i;
		for(i=0;i<11;i++) {
			System.out.print(tabuleiro[i].toString());
			System.out.println("-----------------------------");
		}
	}
	
	public int[] cria_vetor(int um, int dos, int tres, int quat, int cin, int seis) {
		int vetor[]=new int[6];
		vetor[0]=um;
		vetor[1]=dos;
		vetor[2]=tres;
		vetor[3]=quat;
		vetor[4]=cin;
		vetor[5]=seis;
		return vetor;
	}
}
