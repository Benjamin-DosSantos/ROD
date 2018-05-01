package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;


public class Wolf
  extends Grub
{
  public Wolf(Animation left, Animation right, Animation deadLeft, Animation deadRight)
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
    

    setVelocityX(getVelocityX() * 2.0F);
  }
  
  public float getMaxSpeed() {
    if ((CodeReflection.isTracing()) && (SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) && 
      (CodeReflection.getAbstactionLevel() >= 2))
    {
      e.fillInStackTrace();
      CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(), 
        e.getStackTrace()[0].getMethodName());
    }
    
    return 0.05F * enemySpeedMultiplier;
  }
}