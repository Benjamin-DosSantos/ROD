
//John Egan

package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;

public class Shark extends HomingFly{
	
	public Shark(Animation left, Animation right, Animation deadLeft,Animation deadRight) {
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
    	
    	//We don't apply gravity to the shark
        flying = true;
        
        //The shark is following the player
        trackPlayer = true;
        
        health = 3;
        
        //Set Vertical speed
        setVelocityY(0.25f);
        
        //Set Horizontal Response Time
        setHorizontalResponceTime(225.0f);
        
        //Set Vertical Responce Time
        setVerticalResponceTime(0.4f);
		
	}
	

}
