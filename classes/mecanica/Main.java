package mecanica;
import mecanica.Motor;
import entidade.Banco;
public class Main {

	public static void main(String[] args) {
		Motor motor1 =new Motor(2);
		Banco banco1=new Banco("Banco", 0, 32, 12);
		motor1.cria_tabuleiro1(banco1);
		motor1.imprimi_tabuleiro();
		
		
	}

}
