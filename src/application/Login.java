package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * This class is used to check if user exists in the database and allows the user 
 * to go to the next screen once they have logged in 
 * @author Izzah,Kiril,Vincent
 *
 */
public class Login {

	public Login() {
		
	}
    @FXML
    private Button exit;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private TextField username;

    @FXML
    private Button register;
/**
 * checks if user exists in the system 
 * @param event
 * @throws IOException
 */
	@FXML
	public void userLogin(ActionEvent event)throws IOException{
		checkLogin();
	}

/**
 * searches through data is user exists and prints out appropriate error message 
 * @throws IOException
 */
	private void checkLogin() throws IOException {
		Main m = new Main();
		
    	   	 					
            String data;			//reader buffer
            String [] totalinfo;	//split reader buffer
            boolean check = false;	//true if no previous existing
            						//username exist
            
            File accountInfo = new File("C:\\Users\\izzah\\OneDrive\\Documents\\New folder\\SMART CITY FX\\src\\application\\UserData");			//<=====================================================Put in save data location
            try {
				Scanner reader = new Scanner(accountInfo);
				while (reader.hasNextLine()) {
					data = reader.nextLine();
					totalinfo = data.split(",");
					if (username.getText().toString().equals(totalinfo[0]) && password.getText().toString().equals(totalinfo[1])) {
						check = true;
					}
				}
			} catch (FileNotFoundException e1) {
				System.out.println("Can't find file");
				e1.printStackTrace();
			}
              
            if (check == true) {
            	m.changeScene("afterLogin.fxml");
             
            } 
            else {
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setTitle("Error");
            	alert.setContentText("Please enter valid login details or create new user");
            	alert.showAndWait();
            }		
		
	}
/**
 * When button is clicked takes user to register page 
 * @param event
 * @throws IOException
 */
    @FXML
    void userRegister(ActionEvent event) throws IOException {
    	registerPage();
    }

/**
 * Takes user to register page
 * @throws IOException
 */
	private void registerPage() throws IOException {
		Main m = new Main();
		m.changeScene("register.fxml");
		
	}
/**
 * Exit the screen button	
 * @param event
 */
    @FXML
    void exit(ActionEvent event) {
    	Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
    	stage.close();
    }
	
	
}
