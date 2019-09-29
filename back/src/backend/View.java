package backend;

public class View {
	
	public static void main(String[] args) {
		Backend back = new Backend();
		System.out.println("En este back hay " + back.darTabla().size() + " palabras en el diccionario:");
		System.out.println("La verificacion del objeto 1 es: " + back.esObjetoReciclable("././data/test.json"));
		System.out.println("La verificacion del objeto 2 es: " + back.esObjetoReciclable("././data/test2.json"));
		System.out.println("La verificacion del objeto 3 es: " + back.esObjetoReciclable("././data/test3.json"));
	}
}
