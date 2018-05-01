package com.brackeen.javagamebook.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.brackeen.javagamebook.graphics.LoadGameMenu;
import com.brackeen.javagamebook.graphics.OptionsMenu;

public class LoadGameSaveMenuListiner implements ActionListener {

	private LoadGameMenu loadMenuInstance;
	
	public LoadGameSaveMenuListiner(LoadGameMenu lm){
		loadMenuInstance = lm;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		loadMenuInstance.setVisible(true);
	}

}
