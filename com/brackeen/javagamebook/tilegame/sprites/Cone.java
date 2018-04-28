package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;

public class Cone extends Creature{
	public Cone(Animation left, Animation right, Animation deadLeft,Animation deadRight) {
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
		
        setVelocityX(0);
        setVelocityY(0);
        
        //The cone cannot die 
        if(getState()==STATE_HURT) {
        	int x=2;
        	setHealth(x);
        }
        
	}
	
	//Health is set to 2
    public void setHealth(int x){

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
