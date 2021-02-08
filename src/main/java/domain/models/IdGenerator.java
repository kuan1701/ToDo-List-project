package domain.models;

public class IdGenerator {

	private static int id = 1;
	
	public static int newId() {
		return id++;
	}
}
