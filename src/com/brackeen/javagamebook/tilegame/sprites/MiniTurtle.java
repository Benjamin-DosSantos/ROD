package com.brackeen.javagamebook.tilegame.sprites;
import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.codereflection.*;

public class MiniTurtle extends Creature {

    private Throwable e = new Throwable();

	public MiniTurtle(Animation left, Animation right, Animation deadLeft, Animation deadRight) 
	{
		super(left, right, deadLeft, deadRight);
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=1)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
		//boss tracks player
		this.trackPlayer=true;
		//health is greater than standard boss
		health = 15;
		
		//Make MiniTurtle smarter than the average turtle
		intelligent = true;
	}
	
    public float getMaxSpeed() { //sets miniturtle max speed to faster than your average turtle
        return 0.6f * enemySpeedMultiplier;
    }
    
}