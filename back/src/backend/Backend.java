package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Hashtable;

public class Backend {
	private Hashtable<String, String> tabla;

	public Backend()
	{
		tabla = new Hashtable<String, String>();
		cargarTabla();
	}
	
	public Hashtable<String, String> darTabla()
	{
		return tabla;
	}
	
	public void cargarTabla(){
		try{
			File archivo = new File("././data/vocabulary");
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
	
	public boolean esObjetoReciclable(String pRuta)
	{
		Verificacion v = new Verificacion(pRuta);
		return v.verificarTodo(tabla);
	}
}
