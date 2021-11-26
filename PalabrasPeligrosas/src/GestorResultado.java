import java.util.ArrayList;

/*
 * Clase GestorResultado
 * Almacenar la palabra y las líneas donde aparece. (Mejora: y el total veces que aparece en esa línea).
 * 
 * Esta clase es la modificacion de la clase Contador de Palabras. 
 * 
 */
public class GestorResultado {

	private Object cerrojo;
	private ArrayList<Resultado> lista_resultados = new ArrayList<Resultado>();

	public GestorResultado() {

		this.cerrojo = new Object();
	}

	public ArrayList<Resultado> get_lista() {
		return this.lista_resultados;
	}

	/*
	 * Obtenermos como parametro un objeto Resultado con
	 * la palabra peligrosa y la linea donde sale
	 * y lo añadimos a la lista de resultados del gestor
	 */
	public void almacenar_resultado(Resultado res) {
		// 
		try {
			synchronized (cerrojo) {
				lista_resultados.add(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
