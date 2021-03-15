package domain.tasks_models.util.JUnitTestTasks;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class TaskItemTest {
	
	TaskItem task1;
	TaskItem task2;
	TaskItem task3;
	TaskItem task4;
	
	@BeforeEach
	void setUp() throws TasksExceptions {
		
		task1 = new OneTimeTask("do homework", Categories.PERSONAL, Types.DISPOSABLE, Priority.IMPORTANT, false, LocalDate.of(2022, 3, 15));
		
		task2 = new OneTimeTask("pay for the fine", Categories.PERSONAL, Types.DISPOSABLE, Priority.URGENTLY, false, LocalDate.of(2021, 3, 15));
		
		task3 = new RecurringTask("pay for service", Categories.HOUSEWORK, Types.REUSABLE, Priority.URGENTLY, false, LocalDate.of(2021, 3, 15), Repeats.ONCE_A_MONTH);
		
		task4 = new RecurringTask("learn english", Categories.PERSONAL, Types.DISPOSABLE, Priority.URGENTLY, false, LocalDate.of(2021, 3, 15), Repeats.ONCE_A_WEEK);
	}
	
	@Test
	void getDescription() {
		String expected = task1.getDescription();
		String actual = "do homework";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void getTasks() throws TasksExceptions {
		
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
	void getPriority() {
		String expected = task1.getPriority().toString();
		String actual = "Important";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void getPriority_NO_NULL() {
		String expected;
		for (TaskItem taskItem:
		     TaskService.getTasks()) {
			expected = taskItem.getPriority().toString();
			Assert.assertNotNull(expected);
		}
	}
	
	@Test
	void getCategory() {
		String expected = task1.getCategories().toString();
		String actual = "Personal";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void getCategories_NO_NULL() {
		String expected;
		for (TaskItem taskItem:
				TaskService.getTasks()) {
			expected = taskItem.getCategories().toString();
			Assert.assertNotNull(expected);
		}
	}
	
	@Test
	void getTypes() {
		String expected = task1.getTypes().toString();
		String actual = "Disposable";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void getTypes_NO_NULL() {
		String expected;
		for (TaskItem taskItem:
				TaskService.getTasks()) {
			expected = taskItem.getTypes().toString();
			Assert.assertNotNull(expected);
		}
	}
	
	@Test
	void getDaysLeft(){
		
		long expected = task1.getDaysLeft();
		long actual = ChronoUnit.DAYS.between(LocalDate.now(), task1.getExpirationDateOfTask());
		
		Assert.assertEquals(expected, actual);
	}
}