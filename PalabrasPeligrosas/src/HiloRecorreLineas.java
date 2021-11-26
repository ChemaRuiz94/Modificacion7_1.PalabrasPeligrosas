/*
 *  Hilo que busca la palabra pasada al constructor en la línea recibida, también en el constructor.
 *  Si la encuentra almacenar/contabilizarla en el objeto compartido (Gestor de resultados)
 *
 */
public class HiloRecorreLineas extends Thread {

	private String palabra_clave; //palabra peligrosa que busca
	private int num_linea_actual; //numero de linea
	private int contador_palabras; //contador repeticiones
	private GestorResultado gestor; //objeto compartido
	private String linea; //linea que va a revisar en busca de la palabra
	private FicheroResultado fichero_resultado; // fichero donde 

	/*
	 * Constructor del HiloRecorreLineas 
	 * recibe como parametros la palabra peligrosa, 
	 * el numero de linea, la linea que recorre
	 * y el objeto compartido f
	 */
	public HiloRecorreLineas(String word, int num_line, String line, GestorResultado ges) {
		this.palabra_clave = word.toUpperCase();
		this.num_linea_actual = num_line;
		this.contador_palabras = 0;
		this.gestor = ges;
		this.linea = line.toUpperCase();
		fichero_resultado = new FicheroResultado();
	}

	/*
	 * Run que comprueba si la linea recibida contiene la palabra peligrosa
	 * Si contiene la palabara, comprueba cuantas veces se repite 
	 * Crea un resultado y lo almacena 
	 */
	@Override
	public void run() {

		//solo si la linea contiene esa palabra 
		if (linea.contains(palabra_clave)) {
			int repeticiones = 0;
			try {
				//comprueba cuantas veces repite esa palabra en la linea
				while (linea.indexOf(palabra_clave) > -1) {
				      linea = linea.substring(linea.indexOf(
				    		  palabra_clave)+palabra_clave.length(),linea.length());
				      repeticiones++; 
				}
				//crea on objeto resultado
				Resultado res = new Resultado(palabra_clave, num_linea_actual, repeticiones);
				//el gestor de resultados lo almacena
				gestor.almacenar_resultado(res);

				//añadimos el resultado al fichero
				fichero_resultado.escribeFichero(res.toString());
				System.out.println(res.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
