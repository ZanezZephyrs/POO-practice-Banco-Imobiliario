package mecanica;
import slots.*;


public class Util {
	
	public static int numero_rodovias(Slot vetor[]) {
		int i;
		int total=0;
		for(i=0;i<vetor.length;i++) {
			if(vetor[i] instanceof Roads) {
				total++;
			}
		}
		return total;
	}
}
