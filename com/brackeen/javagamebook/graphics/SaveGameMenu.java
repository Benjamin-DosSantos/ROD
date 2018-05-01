package com.brackeen.javagamebook.graphics;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.brackeen.javagamebook.eventlisteners.DoneButtonListener;
import com.brackeen.javagamebook.eventlisteners.LoadGameSaveActionListiner;
import com.brackeen.javagamebook.eventlisteners.SaveGameActionListiner;
import com.brackeen.javagamebook.tilegame.GameManager;
import com.brackeen.javagamebook.util.SaveGameHandler;

public class SaveGameMenu extends JFrame{
	
	private JButton doneButton;
	private JButton save1Button;
	private JButton save2Button;
	private JButton save3Button;
	
	private JPanel optionsContainer;
	private JPanel donePanel;
	
	private GameManager localGameManager;
	
	
	public SaveGameMenu(){
		this.setAlwaysOnTop(true);
		
		localGameManager = GameManager.getGameManagerInstance();
		SaveGameHandler saveGameHandler = localGameManager.getSaveGameHandler();
		
		JLabel overrideLabel = new JLabel("Override an Existing save File");
		
		save1Button = new JButton("<html> Save 1 <br /> Level: " + saveGameHandler.getSaveLevelData(0) + "</html>");
		save1Button.addActionListener(new SaveGameActionListiner(0, this));
		
		save2Button = new JButton("<html> Save 2 <br /> Level: " + saveGameHandler.getSaveLevelData(1) + "</html>");
		save2Button.addActionListener(new SaveGameActionListiner(1, this));
		
		save3Button = new JButton("<html> Save 3 <br /> Level: " + saveGameHandler.getSaveLevelData(2) + "</html>");
		save3Button.addActionListener(new SaveGameActionListiner(2, this));

		
		doneButton = new JButton("Don't Save");
		doneButton.addActionListener(new DoneButtonListener(this));
		
		donePanel = new JPanel(new GridLayout(5,0));
		donePanel.add(overrideLabel);
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
