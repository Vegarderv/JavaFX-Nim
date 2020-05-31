package app;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NimController implements Initializable{
	@FXML TextField row1Text;
	@FXML TextField row2Text;
	@FXML TextField row3Text;
	@FXML TextField row4Text;
	@FXML ImageView fyr11;
	@FXML ImageView fyr21;
	@FXML ImageView fyr22;
	@FXML ImageView fyr23;
	@FXML ImageView fyr31;
	@FXML ImageView fyr32;
	@FXML ImageView fyr33;
	@FXML ImageView fyr34;
	@FXML ImageView fyr35;
	@FXML ImageView fyr41;
	@FXML ImageView fyr42;
	@FXML ImageView fyr43;
	@FXML ImageView fyr44;
	@FXML ImageView fyr45;
	@FXML ImageView fyr46;
	@FXML ImageView fyr47;
	@FXML HBox gameWindow;
	@FXML Label overLabel;
	NimGame nim;
	int pile0 = 1;
	int pile1 = 3;
	int pile2 = 5;
	int pile3 = 7;
	List<ImageView> row1 = new ArrayList<ImageView>();
	List<ImageView> row2 = new ArrayList<ImageView>();
	List<ImageView> row3 = new ArrayList<ImageView>();
	List<ImageView> row4 = new ArrayList<ImageView>();
	private int difficulity = 1;
	private boolean onePlayer = true;
	private String player1;
	private String player2;
	private int turn = 0;

	@FXML
	public void initialize(URL arg0, ResourceBundle arg1) {
		NimSaver load = new NimSaver();
		List<String> lst = load.loadFromFile("gamedifficulity.txt");
		this.difficulity =  Integer.parseInt(lst.get(0));
		if (lst.get(1).equals("0"))
			onePlayer = false;
		
		NewGame();
		player1 = lst.get(2);
		player2 = lst.get(3);
		
	}
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	@FXML
	public void handeOnClick1() {
		if (row1Text.getText().trim().isEmpty())
			return;
		if (!isNumeric(row1Text.getText()))
			return;
		int remove = Integer.parseInt(row1Text.getText());
		if(nim.isValidMove(remove, 0)) {
			nim.removePieces(remove, 0);
			for (int i = 0; i < remove; i++) {
				ImageView img = row1.get(0);
				img.setOpacity(0);
				row1.remove(0);
			}
			if (nim.isGameOver()){
				gameOver(true);
				return;
			}
			if(onePlayer)
				makeAIMove();
			else
				turn ++;
			row1Text.clear();

		}
		if (nim.isGameOver()){
			gameOver(false);
		}
	}
	@FXML
	public void handeOnClick2() {
		if (row2Text.getText().trim().isEmpty())
			return;
		if (!isNumeric(row2Text.getText()))
			return;
		int remove = Integer.parseInt(row2Text.getText());
		if(nim.isValidMove(remove, 1)) {
			nim.removePieces(remove, 1);
			for (int i = 0; i < remove; i++) {
				ImageView img = row2.get(0);
				img.setOpacity(0);
				row2.remove(0);
			}
			if (nim.isGameOver()){
				gameOver(true);
				return;
			}
			if(onePlayer)
				makeAIMove();
			else
				turn ++;
			row2Text.clear();
		}
		if (nim.isGameOver()){
			gameOver(false);
		}
	}
	@FXML
	public void handeOnClick3() {
		if (row3Text.getText().trim().isEmpty())
			return;
		if (!isNumeric(row3Text.getText()))
			return;
		int remove = Integer.parseInt(row3Text.getText());
		if(nim.isValidMove(remove, 2)) {
			nim.removePieces(remove, 2);
			for (int i = 0; i < remove; i++) {
				ImageView img = row3.get(0);
				img.setOpacity(0);
				row3.remove(0);
			}
			if (nim.isGameOver()){
				gameOver(true);
				return;
			}
			if(onePlayer)
				makeAIMove();
			else
				turn ++;
			row3Text.clear();
		}
		if (nim.isGameOver()){
			gameOver(false);
		}
	}
	@FXML
	public void handeOnClick4() {
		if (row4Text.getText().trim().isEmpty())
			return;
		if (!isNumeric(row4Text.getText()))
			return;
		int remove = Integer.parseInt(row4Text.getText());
		if(nim.isValidMove(remove, 3)) {
			nim.removePieces(remove, 3);
			for (int i = 0; i < remove; i++) {
				ImageView img = row4.get(0);
				img.setOpacity(0);
				row4.remove(0);
			}
			if (nim.isGameOver()){
				gameOver(true);
				return;
			}
			if(onePlayer)
				makeAIMove();
			else
				turn ++;
			row4Text.clear();
		}
		if (nim.isGameOver()){
			gameOver(false);
		}
	}
	
	@FXML
	public void saveGame() {
		List<String> list = Arrays.asList(Integer.toString(nim.getPile(0)), Integer.toString(nim.getPile(1)), Integer.toString(nim.getPile(2)), Integer.toString(nim.getPile(3)));
		NimSaver saver = new NimSaver();
		saver.saveToFile(list, "gamedata.txt");
	}

	public void loadGame() {
		NimSaver load = new NimSaver();
		List<String> lst = load.loadFromFile("gamedata.txt");
		pile0 = Integer.parseInt(lst.get(0));
		pile1 = Integer.parseInt(lst.get(1));
		pile2 = Integer.parseInt(lst.get(2));
		pile3 = Integer.parseInt(lst.get(3));
		NewGame();
	}
	
	@FXML
	public void NewGame() {
		nim = new NimGame(pile0, pile1, pile2, pile3, difficulity);
		row1 = new ArrayList<ImageView>();
		row2 = new ArrayList();
		row3 = new ArrayList();
		row4 = new ArrayList();
		row1.add(fyr11);
		
		row2.add(fyr21);
		row2.add(fyr22);
		row2.add(fyr23);
		
		row3.add(fyr31);
		row3.add(fyr32);
		row3.add(fyr33);
		row3.add(fyr34);
		row3.add(fyr35);
		
		row4.add(fyr41);
		row4.add(fyr42);
		row4.add(fyr43);
		row4.add(fyr44);
		row4.add(fyr45);
		row4.add(fyr46);
		row4.add(fyr47);
		for (int i = 0; i < 1; i++) {
			try{
				row1.get(i).setOpacity(0);
			} finally {}
		}
		for (int i = 0; i < 3; i++) {
			try{
				row2.get(i).setOpacity(0);
			} finally {}
		}
		for (int i = 0; i < 5; i++) {
			try{
				row3.get(i).setOpacity(0);
			} finally {}
		}
		for (int i = 0; i < 7; i++) {
			try{
				row4.get(i).setOpacity(0);
			} finally {}
		}
		
		for (int i = 0; i < pile0; i++) {
			row1.get(i).setOpacity(1);
		}
		for (int i = 0; i < pile1; i++) {
			row2.get(i).setOpacity(1);
		}
		for (int i = 0; i < pile2; i++) {
			row3.get(i).setOpacity(1);
		}
		for (int i = 0; i < pile3; i++) {
			row4.get(i).setOpacity(1);
		}
		
		gameWindow.setOpacity(1);
		try {
			overLabel.setOpacity(0);
		}
		finally{
			
		}
		pile0 = 1;
		pile1 = 3;
		pile2 = 5;
		pile3 = 7;
	}
	
	private void makeAIMove() {
		String str = nim.makeMove();
		int rowNum = Integer.parseInt(str.substring(1,2));
		int num = Integer.parseInt(str.substring(0,1));
		List<ImageView> lst = null;
		if (rowNum == 0) {
			lst = row1;
		}
		if (rowNum == 1) {
			lst = row2;
		}
		if (rowNum == 2) {
			lst = row3;
		}
		if (rowNum == 3) {
			lst = row4;
		}
		for (int i = 0; i < num; i++) {
			ImageView img = lst.get(0);
			img.setOpacity(0);
			lst.remove(0);
		}
	}

	@FXML
	public void toMainMenu(ActionEvent event) throws Exception {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Main Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
		}
	
	@FXML
	public void gameOver(boolean vant) {
		String winner = "Du";
		if(!onePlayer) {
			if(turn%2 == 1)
				winner = player2;
			else
				winner = player1;
		}
		if(vant)
			overLabel.setText(winner + " Vant!");
		else
			overLabel.setText("Game Over");
		gameWindow.setOpacity(0);
		overLabel.setOpacity(1);
		
	}
	
}
