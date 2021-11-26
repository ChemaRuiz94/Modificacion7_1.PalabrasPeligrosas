import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/*
 * Clase para manejar el fichero de resultados
 */
public class FicheroResultado {

	private File archivo;
	private FileWriter fich = null;
	private PrintWriter pwriter = null;

	
	public FicheroResultado() {
		this.archivo = new File("resultado.txt");
	}

	/*
	 * Recibe un mensaje y lo escribe en el fichero 
	 */
	public void escribeFichero(String mensaje){
     try {
    	 fich = new FileWriter(archivo,true);
   
    	 pwriter = new PrintWriter(fich);
    	 pwriter.println(mensaje);
     } catch (IOException e) {
         e.printStackTrace();
     }finally{
         try {
        	 fich.close();
        	 pwriter.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     }
}
