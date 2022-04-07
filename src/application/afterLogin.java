package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * This class takes the user to the next window after they have logged in 
 * using a valid username and password. 
 * @author Izzah,Kiril,Vincent
 *
 */
public class afterLogin {

	@FXML
	private Button logout;

	@FXML
	private Button searchUni;

	@FXML
	private Button searchSchools;

	@FXML
	private Button searchBusiness;

	@FXML
	private Button searchMuseum;

	@FXML
	private Button searchTourism;

	Stage stage;
/**
 * Searches through the web once button is clicked for universities in Calgary
 * @param event
 * @throws IOException
 */
	@FXML
	void University(ActionEvent event) throws IOException {
		webScraper obj = new webScraper();
		obj.searchMaps("Universities in Calgary");
		Main m = new Main();
		m.changeScene("image.fxml"); //changes screen

	}
/**
 * Searches through the web once button is clicked for museums in Calgary
 * @param event
 * @throws IOException
 */
	@FXML
	void Museum(ActionEvent event) throws IOException {
		webScraper obj = new webScraper();
		obj.searchMaps("Museums in Calgary");
		Main m = new Main();
		m.changeScene("image.fxml");
	}
/**
 * Searches through the web once button is clicked for schools in Calgary
 * @param event
 * @throws IOException
 */
	@FXML
	void School(ActionEvent event) throws IOException {
		webScraper obj = new webScraper();
		obj.searchMaps("Schools in Calgary");
		Main m = new Main();
		m.changeScene("image.fxml");
	}
/**
 * Searches through the web once button is clicked for tourists attractions in Calgary
 * @param event
 * @throws IOException
 */
	@FXML
	void Tourism(ActionEvent event) throws IOException {
		webScraper obj = new webScraper();
		obj.searchMaps("Tourists attractions in Calgary");
		Main m = new Main();
		m.changeScene("image.fxml");
	}
/**
 * Searches through the web once button is clicked for businesses in Calgary
 * @param event
 * @throws IOException
 */
	@FXML
	void Business(ActionEvent event) throws IOException {
		webScraper obj = new webScraper();
		obj.searchMaps("Businesses in Calgary");
		Main m = new Main();
		m.changeScene("image.fxml");
	}
/**
 * goes back to the main screen and logs out the user
 * @param event
 * @throws IOException
 */
	@FXML
	void logout(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Main.fxml");
	}
}
