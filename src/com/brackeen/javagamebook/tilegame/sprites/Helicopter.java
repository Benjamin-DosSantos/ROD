
//John Egan 

package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;

public class Helicopter extends HomingFly{
	
	public Helicopter(Animation left, Animation right, Animation deadLeft,Animation deadRight) {
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
        
        //Set Vertical speed
        setVelocityY(0.20f);
        
        //Set Horizontal Response Time
        setHorizontalResponceTime(225.0f);
        
        //Set Vertical Responce Time
        setVerticalResponceTime(0.4f);
		
	}
	
	//Health is set to 3
		public void setHealth(int x){

			x=3;

			if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
				if(CodeReflection.getAbstactionLevel()>=3)
				{//check to make sure it's this level of abstraction
					e.fillInStackTrace();		
					CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
							e.getStackTrace()[0].getMethodName());
				}
			}

			health=x;
		}

}
