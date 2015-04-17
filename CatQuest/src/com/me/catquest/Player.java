package com.me.catquest;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Character{
	public int blocks =  0;
	public int lives = 9;
	public Animation revive;

	
	//loads cat texture and splits into regions, 
	private static Texture catTexture = new Texture(Gdx.files.internal("data/CatTexture.png"));
	private static TextureRegion[][] regions = TextureRegion.split(catTexture, 32, 32);
	
	Player(){
	xDimension = 2;
	yDimension = 2;
	rightOffset = 0.8f;
	leftOffset = 1.5f;
	JUMP_VEL = 20f;  //jump velocity
	MAX_VEL = 9f;  //how fast player moves
	
	deathNoise = Gdx.audio.newSound(Gdx.files.internal("data/Player_Hit.wav"));
	jumpNoise = Gdx.audio.newSound(Gdx.files.internal("data/Jump.wav"));
	
	//determine width and height of player for collision by converting pixel size into world units
	//Player is .7 blocks wide and 1.33 blocks tall
	WIDTH = 0.5f;
	HEIGHT = 1.5f;
	
	//sets animations for each state
	stand = new Animation(0.2f, regions[0][0], regions[0][1], regions[0][2], regions [0][3]);
	walk = new Animation(0.1f, regions[1][0], regions[1][1], regions[1][2], regions [1][3], regions[1][4], 
							regions[1][5], regions[1][6], regions [1][7]);
	jump = new Animation(0.1f, regions[2][0], regions[2][1], regions[2][2], regions [2][3], regions[2][4], 
			regions[2][5], regions[2][6], regions [2][7]);
	death = new Animation(0.1f, regions[3][0], regions[3][1], regions[3][2], regions[3][3], regions[3][4], regions[3][5], regions[3][6]);
	revive = new Animation(0.1f, regions[3][7], regions [3][8]);
	
	
	//sets play modes for the animations
	stand.setPlayMode(4);
	walk.setPlayMode(4);
	jump.setPlayMode(4);
	}
	
	public void death(int[] spawn){
		deathNoise.play();
		lives -= 1;
		
		pos.set(spawn[0],spawn[1]);
	}
	
}
