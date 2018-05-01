package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;

public class Eel extends Creature{
	
	public Eel(Animation left, Animation right, Animation deadLeft,Animation deadRight) {
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
        
        health = 2;
        
        setVelocityX(0.25f);
        setVelocityY(0.25f);
        
        //The eel only attacks the player if provoked 
        if(getState()==STATE_HURT) {
        	trackPlayer=true;
        	setVelocityX(getVelocityX()*2);
        	setVelocityY(getVelocityY()*2);
        }else {
        	setVelocityX(getVelocityX());
        	setVelocityY(getVelocityY());
        }
        
	}
	
	public void decrementHealth()
	{
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=3)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
		health--;
	}

	
	//Health is set to 2
  /*  public void setHealth(int x){

		x=2;

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
 */
}