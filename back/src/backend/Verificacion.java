package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Hashtable;

public class Verificacion {
	
	private Hashtable<String, String> tabla;

	public Verificacion() {
		tabla = new Hashtable<>();
		cargarTabla();
	}
	
	
	public boolean verificarPalabra(String palabra){
		
		boolean encontro = tabla.contains(palabra);		
		
		return encontro;
	}
	
	public void cargarTabla(){
		try{
			File archivo = new File("./data/vocabulary.txt");
			FileReader lector = new FileReader(archivo);
			BufferedReader reader = new BufferedReader(lector);
			
			String word = reader.readLine();
			while(word != null)
			{
				tabla.put(word, word);
				word = reader.readLine();
			}
			reader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Verificacion v = new Verificacion();
		v.
	}
	

}
