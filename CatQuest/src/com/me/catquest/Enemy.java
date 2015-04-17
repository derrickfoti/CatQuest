package com.me.catquest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemy extends Character{
	//loads enemy texture and splits into regions, 
	private static Texture charTexture = new Texture(Gdx.files.internal("data/Enemy.png"));
	public static TextureRegion[][] regions = TextureRegion.split(charTexture, 32, 32);
	
	//current movement direction for AI.  True if moving right, false if moving left
	private boolean currentDirection = true;
	float deltaTime;
	
	
	
	Enemy(){
		xDimension = 2;
		yDimension = 2;
		rightOffset = 0f;
		leftOffset = 1.5f;
		JUMP_VEL = 25f;  //jump velocity
		MAX_VEL = 2f;  //how fast enemy moves
		deathNoise = Gdx.audio.newSound(Gdx.files.internal("data/Enemy_Hit.wav"));
		
		//determine width and height of player for collision by converting pixel size into world units
		//Player is .7 blocks wide and 1.33 blocks tall
		WIDTH = 1.5f;
		HEIGHT = 1.5f;
		
		//sets animations for each state
		stand = new Animation(0.2f, regions[0][0]);
		walk = new Animation(0.2f, regions[0][0], regions[0][1], regions[0][2]);
		jump = new Animation(0.1f, regions[0][0]);
		
		//sets play modes for the animations
		stand.setPlayMode(4);
		walk.setPlayMode(4);
		jump.setPlayMode(4);
		}
		
	//pre-colision AI
	public void aI1(){
		deltaTime = Gdx.graphics.getDeltaTime();
		if(currentDirection){
			vel.x = MAX_VEL; 
		}
		else{
			vel.x = -MAX_VEL;   
		}
		//applies gravity if we are falling
		vel.add(0, GRAVITY);		
		if (Math.abs(vel.x) < 1)  {
			vel.x = 0; 
		}
		vel.scl(deltaTime); 
	}
	//post colision AI
	public void aI2(){
		if(vel.x == 0){
			if(currentDirection)
				currentDirection = false;
			else
				currentDirection = true;
		}
		if(vel.x > 0)
			facesRight = false;
		else
			facesRight = true;
		// unscale the velocity by the inverse delta time and set
		// the latest position
		pos.add(vel);
		vel.scl(1 / deltaTime);
		vel.x *= DAMP;
	}
	
	public void destroy(){
		
	}
}
