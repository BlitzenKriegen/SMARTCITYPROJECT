package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
/**
 * This class creates the windows that get displayed to the user  
 * @author Izzah,Kiril,Vincent
 *
 */
public class Main extends Application {
	private static Stage stg;
/**
 * Sets the window that is displayed to the user
 */
	@Override
	public void start(Stage primaryStage) {
		try {
			stg = primaryStage;

			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root, 800, 400); // setting the height and width
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setResizable(true); // user cant resize the screen 
			primaryStage.setScene(scene);
			primaryStage.setTitle("CALGARY SMART CITY");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/**
 * Allows for different windows to get displayed 
 * @param fxml
 * @throws IOException
 */
	public void changeScene(String fxml) throws IOException {
		BorderPane pane = (BorderPane) FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

	public static void main(String[] args) {

		launch(args);

	}
}
