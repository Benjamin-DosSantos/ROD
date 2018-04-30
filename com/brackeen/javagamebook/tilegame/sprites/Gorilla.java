package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;


public class Gorilla
  extends Grub
{
  public Gorilla(Animation left, Animation right, Animation deadLeft, Animation deadRight)
  {
    super(left, right, deadLeft, deadRight);
    if ((CodeReflection.isTracing()) && (SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) && 
      (CodeReflection.getAbstactionLevel() >= 1))
    {
      e.fillInStackTrace();
      CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(), 
        e.getStackTrace()[0].getMethodName());
    }
    

    trackPlayer = false;
    if (getState() == 3) {
      trackPlayer = true;
      setVelocityX(getVelocityX() * 2.0F);
    }
  }
  

  public void setHealth(int x)
  {
    x = 3;
    if ((CodeReflection.isTracing()) && (SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) && 
      (CodeReflection.getAbstactionLevel() >= 3))
    {
      e.fillInStackTrace();
      CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(), 
        e.getStackTrace()[0].getMethodName());
    }
    
    health = x;
  }
  
  public float getMaxSpeed() {
    if ((CodeReflection.isTracing()) && (SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) && 
      (CodeReflection.getAbstactionLevel() >= 2))
    {
      e.fillInStackTrace();
      CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(), 
        e.getStackTrace()[0].getMethodName());
    }
    
    return 0.01F * enemySpeedMultiplier;
  }
}
