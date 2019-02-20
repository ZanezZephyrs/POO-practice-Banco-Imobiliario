package mecanica;
import slots.*;

import entidade.Jogador;
import entidade.principal;
import java.util.Random;



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
		tabuleiro[5]=new Roads(5,"Reading Railroad", Banco,200);
		tabuleiro[6]=new Propriedade(6,cria_vetor(6,30,90,270,400,550),"Oriental Avenue", 0, Banco, 100, 50);
		tabuleiro[7]=new Sorte(7, "Sorte");
		tabuleiro[8]=new Propriedade(8,cria_vetor(6,30,90,270,400,550),"Vermont Avenue", 0, Banco, 100,50);
		tabuleiro[9]=new Propriedade(9,cria_vetor(8,40,100,300,450,600),"Connecticut Avenue", 0, Banco, 120,60);
		tabuleiro[10]=new Slot(10, "Prisão");
		tabuleiro[11]=new Propriedade(11,cria_vetor(10,50,150,450,625,750),"St. Charles Place", 0, Banco, 140,70);
		tabuleiro[12]=new Servico(12, "Electric Company");
		tabuleiro[13]=new Propriedade(13,cria_vetor(10,50,150,450,625,750),"States Avenue", 0, Banco, 140,70);
		tabuleiro[14]=new Propriedade(14,cria_vetor(12,60,180,500,700,900),"Virginia Avenue", 0, Banco, 160,80);
		tabuleiro[15]=new Roads(15,"Pennsylvania Railroad", Banco,200);
		tabuleiro[16]=new Propriedade(16,cria_vetor(14,70,200,550,750,950),"St. James Place", 0, Banco, 180,90);
		tabuleiro[17]=new Sorte(17, "Sorte");
		tabuleiro[18]=new Propriedade(18,cria_vetor(14,70,200,550,750,950),"Tennessee Avenue", 0, Banco, 180,90);
		tabuleiro[19]=new Propriedade(19,cria_vetor(16,80,220,600,800,1000),"New York Avenue", 0, Banco, 200,100);
		tabuleiro[20]=new Slot(20, "Free Parking");
		tabuleiro[21]=new Propriedade(21,cria_vetor(18,90,250,700,875,1050),"Kentucky Avenue", 0, Banco, 220,110);
		tabuleiro[22]=new Sorte(22, "Sorte");
		tabuleiro[23]=new Propriedade(23,cria_vetor(18,90,250,700,875,1050),"Indiana Avenue", 0, Banco, 220,110);
		tabuleiro[24]=new Propriedade(24,cria_vetor(20,100,300,750,925,1100),"Illinois Avenue", 0, Banco, 240,120);
		tabuleiro[25]=new Roads(25,"B & O Railroad", Banco,200);
		tabuleiro[26]=new Propriedade(26,cria_vetor(22,110,330,800,975,1150),"Atlantic Avenue", 0, Banco, 260,130);
		tabuleiro[27]=new Propriedade(27,cria_vetor(22,110,330,800,975,1150),"Ventnor Avenue", 0, Banco, 260,130);
		tabuleiro[28]=new Servico(28, "Water Works");
		tabuleiro[29]=new Propriedade(29,cria_vetor(24,120,360,850,1025,1200),"Marvin Gardens", 0, Banco, 280,140);
		tabuleiro[30]=new Slot(30, "Prisão");
		tabuleiro[31]=new Propriedade(31,cria_vetor(26,130,390,900,1100,1275),"Pacific Avenue", 0, Banco, 300,150);
		tabuleiro[32]=new Propriedade(32,cria_vetor(26,130,390,900,1100,1275),"North Carolina Avenue", 0, Banco, 300,150);
		tabuleiro[33]=new Sorte(33, "Sorte");
		tabuleiro[34]=new Propriedade(34,cria_vetor(28,150,450,1000,1200,1400),"Pennsylvania Avenue", 0, Banco, 320,160);
		tabuleiro[35]=new Roads(35,"Short Line Railroad", Banco,200);
		tabuleiro[36]=new Sorte(36, "Sorte");
		tabuleiro[37]=new Propriedade(37,cria_vetor(35,175,500,1100,1300,1500),"Park Place", 0, Banco, 350,175);
		tabuleiro[38]=new Imposto(38,"Luxury Tax",75);
		tabuleiro[39]=new Propriedade(39,cria_vetor(50,200,600,1400,1700,2000),"	Boardwalk", 0, Banco, 400,200);
		
	}
	
	public void Jogada(Jogador player) {
		/*numeros iguais?
		 * preso?*/
		 
		int dados[]=lanca_dados();
		int mover=dados[0]+dados[1]+player.getPos();
		if(mover>39) {
			mover_jogador(player, mover-40);
		}else {
			mover_jogador(player,mover);
		}
	}
	
	public int[] lanca_dados() {
		Random rand=new Random();
		int dado1=rand.nextInt(6)+1;
		int dado2=rand.nextInt(6)+1;
		int dados[]= {dado1,dado2};
		return dados;
	}
	
	public void imprimi_tabuleiro() {
		int i;
		for(i=0;i<tabuleiro.length;i++) {
			System.out.print(tabuleiro[i].toString());
			System.out.println("-----------------------------");
		}
	}
	
	public void mover_jogador(Jogador player, int dest) {
		if(dest<player.getPos()) {/*passou pelo meio*/
			player.setDinheiro_total(player.getDinheiro_total()+200);
		}
		player.setPos(dest);
		this.tabuleiro[dest].executar(player);
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
