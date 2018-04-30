package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;

public class Bulldozer extends HomingFly{

	public Bulldozer(Animation left, Animation right, Animation deadLeft,Animation deadRight) {
		//Call the constructor for Creature
		super(left, right, deadLeft, deadRight);

		//Code Tracing
		if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
			if(CodeReflection.getAbstactionLevel()>=1)
			{//check to make sure it's this level of abstraction
				e.fillInStackTrace();		
				CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
						e.getStackTrace()[0].getMethodName());
			}
		}
		
		//The bulldozer cannot fly
		flying = false;
		
		trackPlayer = true;
		
		setVelocityY(0.25f);
		
	}
	
	//If the bulldozer crashes into something it breaks down 
	 public void collideHorizontal() {	
	    	super.collideVertical();
	    	setVelocityX(0);
	    	setState(STATE_DEAD);
	    }
		
	
	
}
