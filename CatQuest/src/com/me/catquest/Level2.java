package com.me.catquest;

public class Level2 extends Level{
	static int[] spawn = {1, 5};
	Level2()
	{
		super(99, 20, "level2", spawn);
	}
	
	@Override
	protected void addEnemies(){
	}
	
	@Override
	protected void renderEnemies(){
	}
	@Override
	protected void enemyAI1(){
	}
	@Override
	protected void enemyAI2(){
	}
	@Override
	protected void colision(){
	}
	
	@Override 
	protected void load_next_level(){
		GameController.load_level(3);
	}
	
	protected void load_previous_level(){
		GameController.load_level(1);
	}
}