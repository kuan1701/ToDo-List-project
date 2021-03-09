package Application.users_GUI;

import domain.users_models.exceptions.UserException;
import domain.users_models.interfaces.iUsersStorageService;
import domain.users_models.users.User;
import domain.users_models.util.UserDataBase;
import domain.users_models.util.UserStorageService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class UserMainFrame<T> extends JFrame implements ActionListener {
	
	private static final String FILENAME = "D:\\ToDo-List-project\\src\\main\\java\\resources\\users.txt";
	private static final iUsersStorageService iUsersStorageService = new UserStorageService();
	
	private JTextField userFirstNameTF;
	private JTextField userLastNameTF;
	private JTextField usernameTF;
	private JTextField passwordTF;
	
	public UserMainFrame() {
		
		super("ToDo List registration");
		setBounds(350, 175, 650, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Top part
		JPanel topPart = new JPanel();
		topPart.setBorder(new EmptyBorder(20, 0, 0, 0));
		JLabel labelTitle = new JLabel("Welcome to ToDo List application");
		labelTitle.setFont(new Font("Arial", Font.BOLD, 22));
		topPart.add(labelTitle);
		add(topPart, BorderLayout.NORTH);
		
		// registration part
		JPanel registrationForm = new JPanel();
		registrationForm.setLayout(new GridBagLayout());
		JLabel userFirstNameL = new JLabel("First name: ");
		userFirstNameTF = new JTextField();
		JLabel userLastNameL = new JLabel("Last name: ");
		userLastNameTF = new JTextField();
		JLabel usernameL = new JLabel("Username: ");
		usernameTF = new JTextField();
		JLabel passwordL = new JLabel("Password: ");
		passwordTF = new JTextField();
		
		userFirstNameL.setHorizontalAlignment(SwingConstants.RIGHT);
		userLastNameL.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameL.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordL.setHorizontalAlignment(SwingConstants.RIGHT);
		
		userFirstNameTF.setPreferredSize(new Dimension(200, 25));
		userLastNameTF.setPreferredSize(new Dimension(200, 25));
		usernameTF.setPreferredSize(new Dimension(200, 25));
		passwordTF.setPreferredSize(new Dimension(200, 25));
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(0, 0, 10, 5);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		registrationForm.add(userFirstNameL, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		registrationForm.add(userFirstNameTF, gridBagConstraints);
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		registrationForm.add(userLastNameL, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		registrationForm.add(userLastNameTF, gridBagConstraints);
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		registrationForm.add(usernameL, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		registrationForm.add(usernameTF, gridBagConstraints);
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		registrationForm.add(passwordL, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		registrationForm.add(passwordTF, gridBagConstraints);
		add(registrationForm, BorderLayout.CENTER);
		
		// buttons part
		JPanel btnPart = new JPanel();
		btnPart.setPreferredSize(new Dimension(650, 75));
		
		JButton createBtn = new JButton("Create new user");
		createBtn.setPreferredSize(new Dimension(130, 30));
		btnPart.add(createBtn, BorderLayout.NORTH);
		//btnPart.setBorder(new EmptyBorder(0, 0, 40, 0));
		
		JButton showBtn = new JButton("Show all users");
		showBtn.setPreferredSize(new Dimension(130, 30));
		btnPart.add(showBtn, BorderLayout.NORTH);
		//btnPart.setBorder(new EmptyBorder(0, 0, 40, 0));
		
		add(btnPart, BorderLayout.SOUTH);
	
		
		createBtn.addActionListener(this);
		showBtn.addActionListener(this);
	}
	
	// action event
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Create new user")) {
			
			//JOptionPane.showMessageDialog(null, "New user created");
			String firstName = userFirstNameTF.getText();
			String lastName = userLastNameTF.getText();
			String username = usernameTF.getText();
			String password = passwordTF.getText();
			
			try {
				T id = (T) UUID.randomUUID();
				
				User<T> user = new User.Builder<T>()
						.withFirstName(firstName)
						.withLastName(lastName)
						.withUsername(username)
						.withPassword(password)
						.withID(id)
						.build();
				
				UserDataBase.addUser(user);


				// Save tasks
				iUsersStorageService.writeUsers(UserDataBase.getUsers());
			
			} catch (UserException userException) {
				
				if (userException.getCode() == UserException.NO_FIRST_NAME) {
					showError("You didn't enter a first name");
				}
				else if (userException.getCode() == UserException.NO_LAST_NAME) {
					showError("You didn't enter a last name");
				}
				else if (userException.getCode() == UserException.NO_USERNAME) {
					showError("You didn't enter a username");
				}
				else if (userException.getCode() == UserException.NO_PASSWORD) {
					showError("You didn't enter a password");
				}
				else if (userException.getCode() == UserException.SHORT_USERNAME) {
					showError("Username must be at least 4 characters long");
				}
				else if (userException.getCode() == UserException.BUSY_USERNAME) {
					showError("This username already exists");
				}
			}
		} else if (e.getActionCommand().equals("Show all users")) {
			//UserDataBase.printListOfUsers();
			
			// Read tasks
			iUsersStorageService.readUsers();
		}
	}
	
	private void showError(String textError) {
		JOptionPane.showMessageDialog(this, textError, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
