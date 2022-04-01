
import javafx.fxml.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class App extends Application {

	private Stage primnaryStage;
	TabPane root;
	
	private Tab createTab(String tabName, String FXMLFilename) {
		Tab aTab = null;
		try {
			FXMLLoader loader = new FXMLLoader();
			aTab = new Tab(tabName, loader.load(new FileInputStream(FXMLFilename)));
		
			aTab.setOnSelectionChanged (e -> controller.refresh());
			controller.setGameApp(this);
		} catch (IOException e1) {
			System.out.println("Problem loading FXML file " + FXMLFilename);
		}
		return aTab;
	}
}
