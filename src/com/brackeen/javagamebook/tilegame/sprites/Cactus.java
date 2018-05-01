package com.brackeen.javagamebook.tilegame.sprites;
import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.codereflection.*;

public class Cactus extends Creature {
	public Cactus(Animation left, Animation right, Animation deadLeft,Animation deadRight) {
		//Call the constructor for Creature
        super(left, right, deadLeft, deadRight);
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=1)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
    	health = 9000; //sets health to 9000, making it impossible to kill normally because the player will never have that much health to counter it.
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

    public float getMaxSpeed() {
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=2)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
        return 0 * enemySpeedMultiplier;
    }
}