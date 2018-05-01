package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.codereflection.*;

/*
 * The fireball is a flying enemy that does not track the player
 */

public class Fireball extends SinuousFly {

	public Fireball(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		// Call the constructor for Creature
		super(left, right, deadLeft, deadRight);

		// Code Tracing
		if (CodeReflection.isTracing()
				&& SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
			if (CodeReflection.getAbstactionLevel() >= 1) {// check to make sure it's this level of abstraction
				e.fillInStackTrace();
				CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
						e.getStackTrace()[0].getMethodName());
			}
		}

		// We don't apply gravity to the fireball
		flying = true;

		intelligent = true;
		
		// Set Vertical speed
		setVelocityY(0.20f);

		// Set Horizontal Response Time
		setHorizontalResponceTime(225.0f);

		// Set Vertical Responce Time
		setVerticalResponceTime(0.4f);
	}

	// Health is set to 1
	public void setHealth(int x) {

		x = 1;

		if (CodeReflection.isTracing()
				&& SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
			if (CodeReflection.getAbstactionLevel() >= 3) {// check to make sure it's this level of abstraction
				e.fillInStackTrace();
				CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
						e.getStackTrace()[0].getMethodName());
			}
		}

		health = x;
	}

	public void collideVertical() { // Reset the Velocity to regular Y velocity
		super.collideVertical();
		setVelocityY(0.15f);
	}

	public void setState(int state) {
		// Call setState
		super.setState(state);

		// and override the y velocity if hurt
		if (state == STATE_HURT)
			this.setVelocityY(0.15f);
	}
}