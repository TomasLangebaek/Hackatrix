package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Verificacion {
	
	private LinkedList<String> descriptionImage; 
	private Hashtable<String, String> tabla;

	public void Carga() {
		JSONParser parser = new JSONParser();
		
		
		 try (Reader reader = new FileReader("c:\\projects\\test.json")) {

	         JSONArray jsonArray = (JSONArray) parser.parse(reader);
	         System.out.println(jsonArray);
	        
	         int i=0;
	         while(i<jsonArray.size()) {
	         JSONObject ob = (JSONObject) jsonArray.get(i);
	         String description=(String) ob.get("description");
	         descriptionImage.add(description);
	         System.out.println(description);
	         i++;
	         }

		 }
		 
	      catch (IOException e) {
	         e.printStackTrace();
	      }
	      catch (ParseException e) {
	         e.printStackTrace();
	     }

	 }
	public Verificacion() {
		Carga();
		tabla = new Hashtable<>();
		descriptionImage= new LinkedList<String>();
		cargarTabla();
	}
	
	
	public boolean verificarPalabra(String palabra){
		
		boolean encontro = tabla.contains(palabra);		
		
		return encontro;
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
	
	public static void main(String[] args) {
		String[] arreglo = {"plastico", "naranjas","papel", "vidrio", "carton"};
		Verificacion v = new Verificacion();
		for(int i = 0; i < arreglo.length; i++)
		{
			String siONo = " no esta ";
			if(v.verificarPalabra(arreglo[i]))
				siONo = " esta ";
			System.out.println(arreglo[i] + siONo + "en la tabla!");
		}
	}
	

}
