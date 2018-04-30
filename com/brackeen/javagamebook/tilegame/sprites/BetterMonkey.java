package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;


public class BetterMonkey
extends Monkey
{
	public BetterMonkey(Animation left, Animation right, Animation deadLeft, Animation deadRight)
	{
		super(left, right, deadLeft, deadRight);
		if ((CodeReflection.isTracing()) && (SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) && 
				(CodeReflection.getAbstactionLevel() >= 1))
		{
			e.fillInStackTrace();
			CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName());
		}

		trackPlayer = true;
		intelligent = true;

		health = 2;
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
}
