package com.brackeen.javagamebook.graphics;

import java.awt.*;
import javax.swing.*;
import com.brackeen.javagamebook.eventlisteners.*;
import com.brackeen.javagamebook.tilegame.GameManager;
import com.brackeen.javagamebook.util.SaveGameHandler;

public class LoadGameMenu extends JFrame{
	
	private JButton doneButton;
	private JButton save1Button;
	private JButton save2Button;
	private JButton save3Button;
	
	private JPanel optionsContainer;
	private JPanel donePanel;
	
	private GameManager localGameManager;
	
	
	public LoadGameMenu(){
		localGameManager = GameManager.getGameManagerInstance();
		SaveGameHandler saveGameHandler = localGameManager.getSaveGameHandler();
		
		JLabel loadLabel = new JLabel("Load an Existing save File");
		
		save1Button = new JButton("<html> Save 1 <br /> Level: " + saveGameHandler.getSaveLevelData(0) + "</html>");
		save1Button.addActionListener(new LoadGameSaveActionListiner(saveGameHandler, 0, this));
		
		save2Button = new JButton("<html> Save 2 <br /> Level: " + saveGameHandler.getSaveLevelData(1) + "</html>");
		save2Button.addActionListener(new LoadGameSaveActionListiner(saveGameHandler, 1, this));
		
		save3Button = new JButton("<html> Save 3 <br /> Level: " + saveGameHandler.getSaveLevelData(2) + "</html>");
		save3Button.addActionListener(new LoadGameSaveActionListiner(saveGameHandler, 2, this));

		
		doneButton = new JButton("Exit");
		doneButton.addActionListener(new DoneButtonListener(this));
		
		donePanel = new JPanel(new GridLayout(5,0));
		donePanel.add(loadLabel);
		donePanel.add(save1Button);
		donePanel.add(save2Button);
		donePanel.add(save3Button);
		donePanel.add(doneButton);
		
		optionsContainer = new JPanel();
		optionsContainer.add(donePanel);
		
		this.setSize(400,400);
    	this.add(optionsContainer);
    	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
