package backend;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class carga {
	
	LinkedList<String> descriptionImage; 
	
	public void Carga() {
	JSONParser parser = new JSONParser();
	descriptionImage= new LinkedList<String>();
	
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

	

	
	
	
}
