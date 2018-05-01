package com.brackeen.javagamebook.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.brackeen.javagamebook.graphics.LoadGameMenu;
import com.brackeen.javagamebook.tilegame.GameManager;
import com.brackeen.javagamebook.tilegame.ResourceManager;
import com.brackeen.javagamebook.tilegame.sprites.Player;
import com.brackeen.javagamebook.util.SaveGameHandler;

public class LoadGameSaveActionListiner implements ActionListener {

	private int levelToLoad = 5;
	private int saveNumber = 0;
	private LoadGameMenu loadGameMenuInstance;
	private SaveGameHandler saveGameHandler;
	
	public LoadGameSaveActionListiner(SaveGameHandler saveGameHandler, int saveNumber, LoadGameMenu loadGameMenuInstance) {
		this.saveNumber = saveNumber;
		this.loadGameMenuInstance = loadGameMenuInstance;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Load the level and start the game

		GameManager gameManager = GameManager.getGameManagerInstance();
		SaveGameHandler saveGameHandler = gameManager.getSaveGameHandler();
		saveGameHandler.setLocalSaveNumberReferance(saveNumber);
		
		gameManager.setRunGame(true);
		
		Thread t = new Thread(new Runnable() {
		    @Override
		    synchronized public void run() {
		    	try {
					wait(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	gameManager.loadGameInformation(saveNumber);
		    	loadGameMenuInstance.setVisible(false);
		    }

		   });
		t.start();
		
	}

}
