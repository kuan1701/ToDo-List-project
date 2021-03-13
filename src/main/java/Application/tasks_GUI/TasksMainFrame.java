package Application.tasks_GUI;

import domain.tasks_models.enums.Categories;
import domain.tasks_models.enums.Priority;
import domain.tasks_models.enums.Repeats;
import domain.tasks_models.enums.Types;
import domain.tasks_models.exceptions.TasksExceptions;
import domain.tasks_models.tasks.OneTimeTask;
import domain.tasks_models.tasks.RecurringTask;
import domain.tasks_models.util.TaskService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.Objects;

public class TasksMainFrame extends JFrame implements ActionListener, ItemListener {
	
	private JTextField taskDescriptionTF;
	private JComboBox<Priority> priorityJComboBox;
	private JComboBox<Categories> categoriesJComboBox;
	private JComboBox<Types> typesJComboBox;
	private JComboBox<Repeats> repeatsJComboBox;
	private JComboBox<String> monthCB;
	private JComboBox<Integer> dayCB;
	private JComboBox<Integer> yearCB;
	private static JPanel addRepeatJComboBox;
	private static JPanel addLabelRepeatJComboBox;
	
	// create Main Frame
	public TasksMainFrame() {
		super("ToDo List Application");
		setBounds(350, 175, 650, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// top part
		JPanel topPart = new JPanel();
		topPart.setBorder(new EmptyBorder(30, 0, 0, 0));
		JLabel labelTitle = new JLabel("Welcome to ToDo List application");
		labelTitle.setFont(new Font("Arial", Font.BOLD, 22));
		topPart.add(labelTitle);
		add(topPart, BorderLayout.NORTH);
		
		// task form
		JPanel taskForm = new JPanel();
		taskForm.setLayout(new GridBagLayout());
		
		//create description text field
		JLabel taskDescriptionL = new JLabel("Description: ");
		taskDescriptionTF = new JTextField();
		
		//create priority combobox
		JLabel taskPriorityL = new JLabel("Priority: ");
		priorityJComboBox = new JComboBox<Priority>(Priority.values());
		
		//create category combobox
		JLabel taskCategoryL = new JLabel("Category: ");
		categoriesJComboBox = new JComboBox<Categories>(Categories.values());
		
		
		//create type combobox
		JLabel taskTypeL = new JLabel("Type: ");
		typesJComboBox = new JComboBox<Types>(Types.values());
		typesJComboBox.addItemListener(this);
		typesJComboBox.addActionListener(this);
		
		// create repeat combobox
		JLabel taskRepeatL = new JLabel("Repeat: ");
		repeatsJComboBox = new JComboBox<Repeats>(Repeats.values());
		
		// create expiration date combobox
		JLabel expDateL = new JLabel("Exp. date: ");
		
		// create day combobox for expiration date combobox
		dayCB = new JComboBox<>();
		for (int i = 1; i < 32; i++) {
			dayCB.addItem(i);
		}
		// create month combobox for expiration date combobox
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		monthCB = new JComboBox<>();
		for (String month : months) {
			monthCB.addItem(month);
		}
		
		// create year combobox for expiration date combobox
		yearCB = new JComboBox<>();
		for (int i = 2020; i < 2100; i++) {
			yearCB.addItem(i);
		}
		
		// right-align form titles
		taskDescriptionL.setHorizontalAlignment(SwingConstants.RIGHT);
		taskPriorityL.setHorizontalAlignment(SwingConstants.RIGHT);
		taskCategoryL.setHorizontalAlignment(SwingConstants.RIGHT);
		taskTypeL.setHorizontalAlignment(SwingConstants.RIGHT);
		taskRepeatL.setHorizontalAlignment(SwingConstants.RIGHT);
		expDateL.setHorizontalAlignment(SwingConstants.RIGHT);
		
		// sizing combo boxes
		taskDescriptionTF.setPreferredSize(new Dimension(200, 25));
		priorityJComboBox.setPreferredSize(new Dimension(110, 25));
		categoriesJComboBox.setPreferredSize(new Dimension(110, 25));
		typesJComboBox.setPreferredSize(new Dimension(110, 25));
		repeatsJComboBox.setPreferredSize(new Dimension(110, 25));
		dayCB.setPreferredSize(new Dimension(50, 25));
		monthCB.setPreferredSize(new Dimension(90, 25));
		yearCB.setPreferredSize(new Dimension(60, 25));
		
		// create a grid for the layout of the form elements
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(0, 0, 10, 0);
		
		// description
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		taskForm.add(taskDescriptionL, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		taskForm.add(taskDescriptionTF, gridBagConstraints);
		
		// priority
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		taskForm.add(taskPriorityL, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		taskForm.add(priorityJComboBox, gridBagConstraints);
		
		//category
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		taskForm.add(taskCategoryL, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		taskForm.add(categoriesJComboBox, gridBagConstraints);
		
		//type
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		taskForm.add(taskTypeL, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		taskForm.add(typesJComboBox, gridBagConstraints);
		
		// expiration date
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		taskForm.add(expDateL, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		taskForm.add(dayCB, gridBagConstraints);
		gridBagConstraints.gridx = 2;
		taskForm.add(monthCB, gridBagConstraints);
		gridBagConstraints.gridx = 3;
		taskForm.add(yearCB, gridBagConstraints);
		
		// repeats
		addRepeatJComboBox = new JPanel(new CardLayout());
		addRepeatJComboBox.add(new JLabel(""), Types.DISPOSABLE.getType());
		addRepeatJComboBox.add(repeatsJComboBox, Types.REUSABLE.getType());
		
		addLabelRepeatJComboBox = new JPanel(new CardLayout());
		addLabelRepeatJComboBox.add(new JLabel(""), Types.DISPOSABLE.getType());
		addLabelRepeatJComboBox.add(taskRepeatL, Types.REUSABLE.getType());
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		taskForm.add(addLabelRepeatJComboBox, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		taskForm.add(addRepeatJComboBox, gridBagConstraints);
		
		add(taskForm, BorderLayout.CENTER);
		
		// buttons part
		JPanel buttonsPart = new JPanel();
		buttonsPart.setPreferredSize(new Dimension(650, 75));
		
		JButton create = new JButton("Create new task");
		create.setPreferredSize(new Dimension(130, 30));
		buttonsPart.add(create);
		
		JButton show = new JButton("Show all tasks");
		show.setPreferredSize(new Dimension(130, 30));
		buttonsPart.add(show);
		
		add(buttonsPart, BorderLayout.SOUTH);
		
		create.addActionListener(this);
		show.addActionListener(this);
		
	}
	
	// method Action Performed
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
		String description = taskDescriptionTF.getText();
		Priority priority = (Priority) priorityJComboBox.getSelectedItem();
		Categories categories = (Categories) categoriesJComboBox.getSelectedItem();
		Types type = (Types) typesJComboBox.getSelectedItem();
		Repeats repeats = (Repeats) repeatsJComboBox.getSelectedItem();
		boolean complete = false;
		
		int year = (int) yearCB.getSelectedItem();
		int month = monthCB.getSelectedIndex() + 1;
		int day = (int) dayCB.getSelectedItem();
		LocalDate expiredDate = LocalDate.of(year, month, day);
		
		if (actionEvent.getActionCommand().equals("Create new task")) {
			
			try {
				
				if (Objects.equals(Objects.requireNonNull(typesJComboBox.getSelectedItem()).toString(), "Reusable")) {
					
					RecurringTask newRecurringTask = new RecurringTask(description, categories, type, priority, complete, expiredDate, repeats);
					TaskService.addTask(newRecurringTask);
					JOptionPane.showMessageDialog(null, "New recurring task created");
				}
				else if (Objects.equals(typesJComboBox.getSelectedItem().toString(), "Disposable")) {
					
					OneTimeTask newOneTimeTask = new OneTimeTask(description, categories, type, priority, complete, LocalDate.of(year, month, day));
					TaskService.addTask(newOneTimeTask);
					JOptionPane.showMessageDialog(null, "New one-time task created");
				}
			}
			catch (TasksExceptions tasksExceptions) {
				
				if (tasksExceptions.getCode() == TasksExceptions.NO_DESCRIPTION) {
					showError("You didn't enter a description!!!");
				}
				else if (tasksExceptions.getCode() == TasksExceptions.DATE_EXPIRED) {
					showError("The entered date is overdue!!!");
				}
			}
		} else if (actionEvent.getActionCommand().equals("Show all tasks")) {
			TaskService.printTasksList();
		}
	}
	
	// method Item State Changed
	@Override
	public void itemStateChanged(ItemEvent itemEvent) {
		
		CardLayout layoutRepeats = (CardLayout) (addRepeatJComboBox.getLayout());
		layoutRepeats.show(addRepeatJComboBox, String.valueOf((Types) itemEvent.getItem()));
		
		CardLayout layoutLabelRepeats = (CardLayout) (addLabelRepeatJComboBox.getLayout());
		layoutLabelRepeats.show(addLabelRepeatJComboBox, String.valueOf((Types) itemEvent.getItem()));
		
	}
	
	private void showError(String textError) {
		JOptionPane.showMessageDialog(this, textError, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
