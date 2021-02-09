package Application;

import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.models.tasks.OneTimeTask;
import domain.models.tasks.RecurringTask;
import domain.models.tasks.TaskItem;
import domain.models.users.User;

import java.util.Collections;

public class Application {
	
	public static void main(String[] args) {

		//Create a one-time task
		OneTimeTask oneTimeTask = new OneTimeTask(
				"buy products",
				"02.02.2021 11:20",
				TaskCategory.SHOPPING,
				TaskType.IMPORTANT,
				false,
				"08.02.2021");
		
		OneTimeTask oneTimeTask2 = new OneTimeTask(
				"buy cat food",
				"04.02.2021 16:48",
				TaskCategory.SHOPPING,
				TaskType.URGENTLY,
				false,
				"10.02.2021");
		
		//Create a recurring task
		TaskItem recurringTask = new RecurringTask(
				"pay utility bills",
				"20.02.2021 14:38",
				TaskCategory.HOUSEWORK,
				TaskType.IMPORTANT,
				false,
				"25.02.2021",
				"every month");
		
		RecurringTask recurringTask2 = new RecurringTask(
				"go to the car diagnostics",
				"02.02.2021 13:27",
				TaskCategory.PERSONAL,
				TaskType.IMPORTANT,
				false,
				"20.02.2021",
				"every month");
		
		//------------------------------------------------------------------------------------------
		
		//Displaying all and creating one-time tasks
		System.out.println("One-time task list");
		System.out.println("------------------");
		
		//List of one-time tasks
		Collections.sort(OneTimeTask.getOneTimeTaskList());
		
		//Displaying one-time tasks
		for (TaskItem oTT: OneTimeTask.getTasks()) {

			//oTT.createTask();
			//The second way to display task
			System.out.println(oTT);
		}
		
		System.out.println("");
		
		//--------------------------------------------------------------------------------------------
		
		//Displaying and creating all recurring tasks
		System.out.println("Recurring task list");
		System.out.println("-------------------");
		
		//List of recurring tasks
		Collections.sort(RecurringTask.getRecurringTaskList());
		
		//Displaying recurring tasks
		for (TaskItem rT : RecurringTask.getTasks()) {
			
			rT.createTask();
			//The second way to display task
			//System.out.println(rT);
		}
		
		//Total numbers of tasks
		System.out.println("-------------------");
		System.out.println("In total, you have " + TaskItem.getNumberOfTask() + " tasks.\n");
		
		//-----------------------------------------------------------------------------------------------
		
		//Displaying and creating users
		System.out.println("       Users       ");
		System.out.println("-------------------");
		
		User<String> user = new User.Builder<String>()
				.withFirstName("Kuan")
				.withLastName("Chin")
				.withUserName("kuan1701")
				.withPassword("17011993")
				.withID("id1701")
				.build();
		System.out.println(user + "\n");
		
		User<Integer> admin = new User.Builder<Integer>()
				.withFirstName("Kuan")
				.withLastName("Chin")
				.withUserName("Admin")
				.withPassword("123456")
				.withID(1234567)
				.build();
		System.out.println(admin);
	}
}
