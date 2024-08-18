package classes;

public class Calculo {
	
	public static float pesoIdeal(float altura, String genero) {
		if(genero.equals("Masculino")) {
			return (float) (72.7*altura -58); 
		} else {
			return (float) (62.1*altura-44.7);
		}
	}
	
	public static float porcentagemDoPesoIdeal(float pesoIdeal, float peso) {
		return (1-pesoIdeal/peso)*100;
	}
}
