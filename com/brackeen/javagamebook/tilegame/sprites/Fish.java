
//John Egan 

package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;

public class Fish extends Grub {

	//Animates the fish 
	public Fish(Animation left, Animation right,Animation deadLeft, Animation deadRight){
		super(left, right, deadLeft, deadRight);
		if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
			if(CodeReflection.getAbstactionLevel()>=1)
			{//check to make sure it's this level of abstraction
				e.fillInStackTrace();		
				CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
						e.getStackTrace()[0].getMethodName());
			}
		}
		flying = true;
		
		trackPlayer = false;
		
		health = 2;
		
		setVelocityX(0.25f);
		setVelocityY(0.25f);
		
		//If the fish is hurt it swims faster 
		 if(getState()==STATE_HURT) {
	        	setVelocityX(getVelocityX()*2);
	        	setVelocityY(getVelocityY()*2);
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
	
/*
	public void setHealth(int x){

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
	//If the fish is not hurt it moves normally, if it is hurt its speed doubles 
	public float getMaxSpeed() {
		if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled() && getState()==STATE_NORMAL){
			if(CodeReflection.getAbstactionLevel()>=2){
				//check to make sure it's this level of abstraction
				e.fillInStackTrace();		
				CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
						e.getStackTrace()[0].getMethodName());
			}

		}
		
		return 0.4f * enemySpeedMultiplier;
	}

}
