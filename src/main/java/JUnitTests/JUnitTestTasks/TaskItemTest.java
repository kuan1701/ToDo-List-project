package JUnitTests.JUnitTestTasks;

import domain.tasks_models.enums.Categories;
import domain.tasks_models.enums.Priority;
import domain.tasks_models.enums.Repeats;
import domain.tasks_models.enums.Types;
import domain.tasks_models.exceptions.TasksExceptions;
import domain.tasks_models.tasks.OneTimeTask;
import domain.tasks_models.tasks.RecurringTask;
import domain.tasks_models.tasks.TaskItem;
import domain.tasks_models.util.TaskService;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TaskItemTest {
	
	TaskItem task1 = new OneTimeTask("do homework", Categories.PERSONAL, Types.DISPOSABLE, Priority.IMPORTANT, false, LocalDate.of(2022, 3, 15));
	
	TaskItem task2 = new OneTimeTask("pay for the fine", Categories.PERSONAL, Types.DISPOSABLE, Priority.URGENTLY, false, LocalDate.of(2022, 3, 15));
	
	TaskItem task3 = new RecurringTask("pay for service", Categories.HOUSEWORK, Types.REUSABLE, Priority.URGENTLY, false, LocalDate.of(2023, 3, 15), Repeats.ONCE_A_MONTH);
	
	TaskItem task4 = new RecurringTask("learn english", Categories.PERSONAL, Types.DISPOSABLE, Priority.URGENTLY, false, LocalDate.of(2022, 3, 15), Repeats.ONCE_A_WEEK);
	
	public TaskItemTest() throws TasksExceptions {
	}
	
	@Test
	public void getDescription() {
		String expected = task1.getDescription();
		String actual = "do homework";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getTasks() throws TasksExceptions {
		
		TaskService.addTask(task1);
		TaskService.addTask(task2);
		TaskService.addTask(task3);
		TaskService.addTask(task4);
		List<TaskItem> expected = TaskService.getTasks();
		
		List<TaskItem> actual = new ArrayList<>();
		actual.add(task1);
		actual.add(task2);
		actual.add(task3);
		actual.add(task4);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getTasks_NO_NULL() {
		List<TaskItem> expected = TaskService.getTasks();
		Assert.assertNotNull(expected);
	}
	
	@Test
	public void getPriority() {
		String expected = task1.getPriority().toString();
		String actual = "Important";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getPriority_NO_NULL() {
		String expected;
		for (TaskItem taskItem :
				TaskService.getTasks()) {
			expected = taskItem.getPriority().toString();
			Assert.assertNotNull(expected);
		}
	}
	
	@Test
	public void getCategory() {
		String expected = task1.getCategories().toString();
		String actual = "Personal";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getCategories_NO_NULL() {
		String expected;
		for (TaskItem taskItem :
				TaskService.getTasks()) {
			expected = taskItem.getCategories().toString();
			Assert.assertNotNull(expected);
		}
	}
	
	@Test
	public void getTypes() {
		String expected = task1.getTypes().toString();
		String actual = "Disposable";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getTypes_NO_NULL() {
		String expected;
		for (TaskItem taskItem :
				TaskService.getTasks()) {
			expected = taskItem.getTypes().toString();
			Assert.assertNotNull(expected);
		}
	}
	
	@Test
	public void getDaysLeft() {
		
		long expected = task1.getDaysLeft();
		long actual = ChronoUnit.DAYS.between(LocalDate.now(), task1.getExpirationDateOfTask());
		
		Assert.assertEquals(expected, actual);
	}
}