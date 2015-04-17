package com.me.catquest;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

public abstract class Character {
	float JUMP_VEL;  //jump velocity
	float MAX_VEL;  //how fast player moves
	static float DAMP = .5f;
	float GRAVITY = -1.0f;  //gravity to be used when falling
	Vector2 pos = new Vector2();  //character's position vector
	Vector2 vel = new Vector2();  //the character's velocity
	boolean grounded = false;  //tells if character is grounded so it knows if character can jump or not
	boolean facesRight = true;  //indicates if character is facing right.  If not facing right, then it's facing left.  
	float stateTime = 0;
	float WIDTH;
	float HEIGHT;
	enum State {Stand, Walk, Jump}//character states for animations.
	State state = State.Stand;
	protected int xDimension;
	protected int yDimension;
	protected float leftOffset;
	protected float rightOffset;
	protected Sound deathNoise;
	protected Sound jumpNoise;
	
	//sets animations for each state
	public Animation stand;  
	public Animation walk;
	public Animation jump;
	public Animation death;
	
	
	public void renderCharacter(OrthogonalTiledMapRenderer renderer) {
		TextureRegion frame = null;
		switch (state){
		case Stand:
			frame = stand.getKeyFrame(stateTime);
			break;
		case Walk:
			frame = walk.getKeyFrame(stateTime);
			break;
		case Jump:
			frame = jump.getKeyFrame(stateTime);
		}
		
		// draw the player, depending on the current velocity
		// on the x-axis, draw the player facing either right
		// or left
		SpriteBatch batch = renderer.getSpriteBatch();
		batch.begin();
		if (facesRight) {
			batch.draw(frame, pos.x - rightOffset, pos.y, xDimension, yDimension);
		} else {
			batch.draw(frame, pos.x + leftOffset, pos.y, -xDimension, yDimension);
		}
		batch.end();	
	}
}