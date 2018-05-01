package com.brackeen.javagamebook.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.brackeen.javagamebook.graphics.LoadGameMenu;
import com.brackeen.javagamebook.graphics.OptionsMenu;
import com.brackeen.javagamebook.graphics.SaveGameMenu;

public class DoneButtonListener implements ActionListener {

	private OptionsMenu optionsMenuInstance;
	private LoadGameMenu loadMenuInstance;
	private SaveGameMenu saveMenuInstance;
	
	public DoneButtonListener(OptionsMenu om)
	{
		optionsMenuInstance = om;
	}
	
	public DoneButtonListener(LoadGameMenu loadGameMenu) {
		loadMenuInstance = loadGameMenu;
	}
	
	public DoneButtonListener(SaveGameMenu saveGameMenu) {
		saveMenuInstance = saveGameMenu;
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if(optionsMenuInstance != null) {
			optionsMenuInstance.setVisible(false);
		}
		
		if(loadMenuInstance != null) {
			loadMenuInstance.setVisible(false);
		}
		
		if(saveMenuInstance != null) {
			saveMenuInstance.setVisible(false);
		}
	}
}
