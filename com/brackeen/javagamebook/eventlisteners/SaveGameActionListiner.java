package com.brackeen.javagamebook.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.brackeen.javagamebook.graphics.SaveGameMenu;
import com.brackeen.javagamebook.tilegame.GameManager;
import com.brackeen.javagamebook.util.SaveGameHandler;

public class SaveGameActionListiner implements ActionListener {

	private int saveNumber;
	private SaveGameMenu saveGameMenu;
	
	public SaveGameActionListiner(int saveNumber, SaveGameMenu saveGameMenu) {
		this.saveNumber = saveNumber;
		this.saveGameMenu = saveGameMenu;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		SaveGameHandler saveGameHandler = GameManager.getGameManagerInstance().getSaveGameHandler();
		
		saveGameHandler.setLocalSaveNumberReferance(saveNumber);
		saveGameHandler.saveCurrentInformation();
		this.saveGameMenu.setVisible(false);
	}

}
