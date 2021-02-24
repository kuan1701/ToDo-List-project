package domain.util;

import domain.models.tasks.TaskItem;

import java.io.*;
import java.util.List;

public class SerializationTaskService {
	
	public SerializationTaskService() {
	}
	
	public static void serialize(List<TaskItem> taskItem, String fileName) {
		
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
			objectOutputStream.writeObject(taskItem);
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
