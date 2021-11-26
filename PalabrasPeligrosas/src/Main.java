import java.io.File;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {

		File resources = new File("resources\\");
		String[] archivos = resources.list();
		FicheroResultado fichero_resultado = new FicheroResultado();

		ArrayList<String> palabras_peligrosas = new ArrayList<String>();
		palabras_peligrosas.add("Bomba");
		palabras_peligrosas.add("Atentado");
		palabras_peligrosas.add("Droga");
		palabras_peligrosas.add("Asesinato");
		palabras_peligrosas.add("Terrorismo");
		palabras_peligrosas.add("Ilegal");

		GestorResultado gestor = new GestorResultado();

		try {
			for (String fich : archivos) {
				//escribe en nuestro fichero_resultado el titulo del fichero que va a recorrer
				fichero_resultado.escribeFichero(fich.toString().toUpperCase());
				
				String fichero = "resources\\" + fich.toString(); 
				HiloRecorreFichero h = new HiloRecorreFichero(fichero, palabras_peligrosas); //crea un hilo que recorrera ese fichero
				h.start(); //arranca el hilo
				h.join(); 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("MAIN FINALIZANDO");
	}
}
