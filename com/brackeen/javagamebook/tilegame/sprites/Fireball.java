package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;

/*
 * The fireball is a flying enemy that 
 */

public class Fireball extends Creature {

	public Fireball(Animation left, Animation right, Animation deadLeft,
			Animation deadRight) {
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
    	
        //Sets the health to 100, which is more than the player has health.
        health=100;
    	//We don't apply gravity to the fireball
        flying = true;
               
        //Set Vertical speed
        setVelocityY(0.25f);
        
        //Set Horizontal Responce Time
        setHorizontalResponceTime(225.0f);
        
        //Set Vertical Responce Time
        setVerticalResponceTime(0.5f);
		
	}
	public void decrementHealth() //changes decrementHealth so that the health never lowers, making in invinsible
	{
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=3)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
		health=health+0;
	}
	
	public float getMaxSpeed() 
    {//Return the max speed of this Fireball
    	
    	//Code Tracing
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=2)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
        return 0.25f * enemySpeedMultiplier;
    }
	
    public boolean isFlying() 
    {//Override isFlying method to check to see if the fireball is alive
    	
    	//Code Tracing
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=4)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
    	
        return isAlive() && super.isFlying();
    }
    
    public void collideVertical() 
    {	//Reset the Velocity to regular Y velocity
    	super.collideVertical();
    	setVelocityY(0.15f);
    }
    
    public void setState(int state)
    {
    	//Call setState 
    	super.setState(state);
    	
    	//and override the y velocity if hurt
    	if (state == STATE_HURT)
    		this.setVelocityY(0.15f);
    }
}