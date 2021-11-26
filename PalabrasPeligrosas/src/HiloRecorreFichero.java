import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * Hilo que recorre un fichero en busca de 
 * palabras peligrosas y va levantando hilos
 * por cada palabra en cada liena
 * 
 */
public class HiloRecorreFichero extends Thread {

	private FileReader fr = null;
	private BufferedReader br = null;
	private String ruta_archivo;
	private ArrayList<String> palabras_peligrosas;
	private GestorResultado gestor = new GestorResultado();
	private int numeroLinea;
	ArrayList<HiloRecorreLineas> hilos_recorre_lineas; 

	/*
	 * Constructor HiloRecorreFichero 
	 * Recibe como parametro el nombre del fichero que va a recorrer
	 * y la lista de palabras peligrosas
	 */
	public HiloRecorreFichero(String nombre_archivo,  ArrayList<String> palabras_pelig) {
		this.hilos_recorre_lineas = new ArrayList<HiloRecorreLineas>();
		this.palabras_peligrosas = palabras_pelig;
		this.ruta_archivo = nombre_archivo;
		this.numeroLinea = 0;
	}

	/*
	 * Reccorre el fichero 
	 * y por cada linea del fichero levanta un HiloRecorreLineas
	 * para cada palabra peligrosa que haya en la lista
	 */
	@Override
	public void run() {

		try {
			fr = new FileReader(new File(ruta_archivo));
			br = new BufferedReader(fr);
			String texto_linea;
			//por cada linea del fichero...
			while ((texto_linea = br.readLine()) != null) {
				//y para cada palabra de la lista de palabras prohibidas...
				for(String palabra : palabras_peligrosas){
					this.numeroLinea++;
					//se crea un hilo que recorra esa linea
					HiloRecorreLineas hilo = new HiloRecorreLineas(palabra, numeroLinea,texto_linea,gestor);
					hilo.start();
					hilos_recorre_lineas.add(hilo);
				}
			}
			for (HiloRecorreLineas h : hilos_recorre_lineas) {
				h.join();
			}
		} catch (Exception e) {
			System.out.println("Error al abrir el fichero: " + this.ruta_archivo);

		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				System.out.println("Error al cerrar el fichero");
			}
		}
	}
}
