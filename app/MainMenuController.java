package app;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuController implements Initializable{
	
	@FXML RadioButton easy;
	@FXML RadioButton medium;
	@FXML RadioButton hard;
	@FXML RadioButton impossible;
	@FXML RadioButton onePlayer;
	@FXML RadioButton twoPlayer;
	@FXML VBox diff;
	@FXML TextField playerOne;
	@FXML TextField playerTwo;
	@FXML VBox names;
	private List<String> difficulity = new ArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		names.setDisable(true);
	}
	
	@FXML
	public void getPlayerNames() {
		String player1 = "Player 1";
		String player2 = "Player 2";
		if (!playerOne.getText().trim().isEmpty())
			player1 = playerOne.getText();
		if (!playerTwo.getText().trim().isEmpty())
			player2 = playerTwo.getText();
		difficulity.add(player1);
		difficulity.add(player2);
		
	}
	
	@FXML
	public void getDifficulity() {
		if (easy.isSelected())
			difficulity.add("1");
		if (medium.isSelected())
			difficulity.add("2");
		if (hard.isSelected())
			difficulity.add("3");
		if (impossible.isSelected())
			difficulity.add("4");
	}
	
	@FXML
	public void getPlayers(){
		if (twoPlayer.isSelected())
			difficulity.add("0");
		else
			difficulity.add("1");
	}
	
	@FXML
	public void disableDifficulity() {
		diff.setDisable(true);
		names.setDisable(false);
	}
	@FXML
	public void ableDifficulity() {
		diff.setDisable(false);
		names.setDisable(true);
	}
	
	@FXML
	public void toGame(ActionEvent event) throws Exception {
		NimSaver saver = new NimSaver();
		getDifficulity();
		getPlayers();
		getPlayerNames();
		saver.saveToFile(difficulity, "gamedifficulity.txt");
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Nim.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
        
		}
	
	@FXML
	public void toInstructions(ActionEvent event) throws Exception {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Instructions.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
		}

}
