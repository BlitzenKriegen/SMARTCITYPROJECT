package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * This class is used to display the results to the user
 * @author Izzah,Kiril,Vincent
 *
 */
public class image {
	@FXML
	private ImageView display;
	private String path;
	@FXML
	private Button goBack;

	private FileInputStream inputstream;

	private Image image;
/**
 * searches the file path to display the screenshot taken by the webscraper
 * @throws FileNotFoundException
 */
	public void initialize() throws FileNotFoundException {
		path = "C:\\SeleniumDocs\\ScreenShot\\searchResult.png";
		File f = new File(path);

		inputstream = new FileInputStream(path);
		image = new Image(path);
		display.setImage(image);

	}
/**
 * When clicked button takes user back to the search window
 * @param event
 * @throws IOException
 */
	@FXML
	void Back(ActionEvent event) throws IOException {
		goBack();
	}

	private void goBack() throws IOException {

		Main m = new Main();
		m.changeScene("afterLogin.fxml"); // back to search window
		display.setImage(null);
		image = null;
		System.gc(); 
		path = "C:\\SeleniumDocs\\ScreenShot\\searchResult.png";
		Files.delete(Path.of(path)); // deletes the previous screenshot for a new search

	}

}
