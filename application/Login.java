package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class Login {

	public Login() {
		
	}
	@FXML
	private Button login;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML 
	private Button register;
	@FXML 
	private Button exit;
	@FXML 
	private Button searchUni;
	
	public void userLogin(ActionEvent event)throws IOException{
		checkLogin();
	}


	private void checkLogin() throws IOException {
		Main m = new Main();
		if((username.getText().toString().equals("smartcity")) && (password.getText().toString().equals("123")));
		
		m.changeScene("afterLogin.fxml");
		
	}
	
	public void userRegister(ActionEvent event)throws IOException{
		registerPage();
	}


	private void registerPage() throws IOException {
	Main m = new Main();
	m.changeScene("register.fxml");
		
	}
	public void University(ActionEvent event)throws IOException{
		
	}
}
