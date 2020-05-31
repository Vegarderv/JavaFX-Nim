package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class NimApp extends Application{
	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("Nim");
		primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Main Menu.fxml"))));
		primaryStage.show();
	}
	
	public static void main(final String[] args) {
		launch(args);
	}
}
