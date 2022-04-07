package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
/**
 * This class allows the user to make a new username and checks if the username is already present in the database
 * @author Izzah,Kiril,Vincent 
 *
 */
public class register {
	@FXML
	private Button BacktoLogin;
	@FXML
	private PasswordField registerPass;

	@FXML
	private TextField registerUser;

	@FXML
	private Button registerbutton;
/**
 * Button allows user to get registered in the system 
 * @param event
 * @throws IOException
 */
	@FXML
	void registerPerson(ActionEvent event) throws IOException {
		registerPage();
	}
/**
 * Allows user to go back to login screen
 * @param event
 * @throws IOException
 */
	@FXML
	void LogIn(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Main.fxml");
	}
/**
 * Once details are entered allows the user to be registered in the database
 * @throws IOException
 */
	private void registerPage() throws IOException {
		String userValue = registerUser.getText(); // user entered username
		String passValue = registerPass.getText(); // user entered password
		String data; // reader buffer
		String[] totalinfo; // split reader buffer
		boolean check; // true if no previous existing
						// username exist

		check = true;
		File accountInfo = new File(
				"C:\\Users\\izzah\\OneDrive\\Documents\\New folder\\SMART CITY FX\\src\\application\\UserData"); // saves data in location
		try {
			Scanner reader = new Scanner(accountInfo);
			while (reader.hasNextLine()) {
				data = reader.nextLine();
				totalinfo = data.split(",");
				System.out.println(data);
				if (userValue.equals(totalinfo[0])) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setContentText("User already exists");
					alert.showAndWait();
					check = false;
				}
			}
			reader.close();
			if (check) { // on successful check record account
				PrintWriter newData = new PrintWriter(new FileWriter(accountInfo, true)); // info on to file
				newData.write(userValue + "," + passValue + "\n");
				newData.close();
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Success");
				alert.setContentText("User added to the database");
				alert.showAndWait();
				Main m = new Main();
				m.changeScene("Main.fxml");

			}
		} catch (FileNotFoundException e1) {
			System.out.println("Can't find file");
		} catch (IOException e1) {
			System.out.println("Can't write to file");
		}

	}

}
