/*
 * Clase que sera gestionada por el objeto compartido
 * 
 */
public class Resultado {

	private String palabra; //palabra peligrosa
	private int num_linea; // linea en la que aparece la palabra peligrosa
	private int num_veces; //numero de veces que aparece la palabra peligrosa

	/*
	 * Constructor del Resultado
	 * recibe la palabra peligrosa, 
	 * la linea donde se ha encontrado
	 * y el numero de veces que se ha encontrado
	 */
	public Resultado(String p, int num_line, int repeticiones) {
		
		this.palabra = p;
		this.num_linea = num_line;
		this.num_veces = repeticiones;
	}

	/*
	 * ToString para pintar el resultado
	 */
	@Override
	public String toString() {
		String msg = "\n Palabra: " +palabra+ "; Numero de Linea: " +num_linea + "; " +num_veces+" veces;" ;
		return msg;
	}
	
}
