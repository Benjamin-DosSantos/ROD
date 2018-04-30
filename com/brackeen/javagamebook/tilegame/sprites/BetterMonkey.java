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
  }
  
  public void setHealth(int x)
  {
    x = 2;
    if ((CodeReflection.isTracing()) && (SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) && 
      (CodeReflection.getAbstactionLevel() >= 3))
    {
      e.fillInStackTrace();
      CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(), 
        e.getStackTrace()[0].getMethodName());
    }
    
    health = x;
  }
}
