package domain.users_models.util;

import domain.users_models.users.User;

import java.io.*;
import java.util.List;

public class UserSerializationService {
	
	public UserSerializationService() {
	}
	
	public static void serialize(List<User<?>> usersList, String fileName) {
		
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
			objectOutputStream.writeObject(usersList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object deserialize(String fileName){
		
		try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
			return objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
