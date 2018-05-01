package com.brackeen.javagamebook.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.brackeen.javagamebook.graphics.SaveGameMenu;
import com.brackeen.javagamebook.test.ScoreBoard;
import com.brackeen.javagamebook.tilegame.GameManager;
import com.brackeen.javagamebook.tilegame.ResourceManager;
import com.brackeen.javagamebook.tilegame.sprites.Player;

public class SaveGameHandler {
	private Player currentPlayer;
	private ResourceManager resourceManager;
	
	private String saveFile = "saveFiles/save.txt";
	
	private int localSaveNumberReferance = -1;
	
	private BufferedReader bufferedFileReader;
	
	private SaveGameMenu savePanel;
	
	public SaveGameHandler() {
	}// End of constructor
	
	public FileReader createFileReader(String fileName) {
		try {
			return new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("There is an error reading in " + fileName);
			e.printStackTrace();
		}
		return null;
	}// End of readFile method 
	
	public BufferedReader createBufferReader(FileReader fileReader) {
		return new BufferedReader(fileReader);
	}// End of createBufferedReader method
	
	public int[][] readFileToArray() {
		String[] saveArray = new String[3];
		String nextLine = "";
		
		bufferedFileReader = createBufferReader(createFileReader(saveFile));
		
		try {
			int row = 0;
			while((nextLine = bufferedFileReader.readLine()) != null) {
				saveArray[row] = (nextLine);
				row++;
			}
		} catch (IOException e) {
			System.out.println("There was an issue parsing through the file");
			e.printStackTrace();
		}
		
		try {
			bufferedFileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int[][] matrix = new int[3][4];
		for (int j = 0; j < 3; j++) {
			if(saveArray[j] != null) {
				String[] currentLine = saveArray[j].split(",");
				for (int i = 0; i < currentLine.length; i++) {
					matrix[j][i] = Integer.parseInt(currentLine[i]);
				}
			}
		}	
		
		return matrix;
	}// End of readFileToArray
	

	public void setLocalSaveNumberReferance(int localSaveNumberReferance) {
		this.localSaveNumberReferance = localSaveNumberReferance;
	}
	
	public void saveCurrentInformation() {
		
		if(localSaveNumberReferance != -1) {
			int[][] currentSaveFile = readFileToArray();
			
			GameManager gameManager = GameManager.getGameManagerInstance();
			ScoreBoard scoreBoard = gameManager.getScoreBoard();
			
			currentSaveFile[localSaveNumberReferance][0] = gameManager.getResourceManagerInstance().getLevel();
			currentSaveFile[localSaveNumberReferance][1] = gameManager.getHealth();
			currentSaveFile[localSaveNumberReferance][2] = Integer.parseInt(scoreBoard.getScore());
			currentSaveFile[localSaveNumberReferance][3] = scoreBoard.getStarTotal();
			
			writeToFile(currentSaveFile);
		}else {
			savePanel = new SaveGameMenu();
			savePanel.setVisible(true);
		}
	}
	
	
	private void writeToFile(int[][] currentSaveFile) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < currentSaveFile.length; i++){
		   for(int j = 0; j < currentSaveFile.length; j++){
		      builder.append(currentSaveFile[i][j]+"");
		      if(j < currentSaveFile.length - 1) {
		         builder.append(",");
		      }
		   }
		   builder.append("\n");
		}
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(saveFile));
			writer.write(builder.toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getSaveLevelData(int saveFile) {
		int[][] saveData = readFileToArray();
		
		return saveData[saveFile][0];
	}

	public int getPlayerHealthFromSave(int saveNumber) {
		int[][] saveData = readFileToArray();
		
		return saveData[saveNumber][1];
	}

	public int getSaveLevelScore(int saveNumber) {
		int[][] saveData = readFileToArray();
		
		return saveData[saveNumber][2];
	}

	public int getSaveLevelStarScore(int saveNumber) {
		int[][] saveData = readFileToArray();
		
		return saveData[saveNumber][3];
	}
}// End of class
