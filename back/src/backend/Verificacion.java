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
	
	public Verificacion(String pRuta) {
		descriptionImage= new LinkedList<String>();
		Carga(pRuta);
	}
	
	public void Carga(String pRuta) {
		JSONParser parser = new JSONParser();
		
		
		 try (Reader reader = new FileReader(pRuta)) {

	         JSONArray jsonArray = (JSONArray) parser.parse(reader);

	        
	         int i=0;
	         while(i<jsonArray.size()) {
	         JSONObject ob = (JSONObject) jsonArray.get(i);
	         String description=(String) ob.get("description");
	         descriptionImage.add(description);

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
	
	public boolean verificarPalabra(String palabra, Hashtable<String, String> tabla){
		
		boolean encontro = tabla.containsKey(palabra);	
		
		return encontro;
	}
	
	public boolean verificarTodo(Hashtable<String, String> tabla){
		
		boolean esta = false;
		
		for(int i = 0; i < descriptionImage.size() && !esta; i++)
		{	
			if(verificarPalabra(descriptionImage.get(i), tabla))
				esta = true;
		}
		return esta;
	}
	
	

}
