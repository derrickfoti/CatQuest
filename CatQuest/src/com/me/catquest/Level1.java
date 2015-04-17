package com.me.catquest;

public class Level1 extends Level{
	Enemy enemy;
	Enemy enemy2;
	Enemy enemy3;
	static int[] spawn = {2, 5};
	Level1()
	{
		super(99, 20, "level1", spawn);
	}
	
	@Override
	protected void addEnemies(){
		enemy = new Enemy();
		enemy.pos.set(15, 5);
		enemy2 = new Enemy();
		enemy2.pos.set(60, 7);
		enemy3 = new Enemy();
		enemy3.pos.set(95, 3);
	}
	
	@Override
	protected void renderEnemies(){
		if(enemy != null)
			enemy.renderCharacter(renderer);
		if(enemy2 != null)
			enemy2.renderCharacter(renderer);
		if(enemy3 != null)
			enemy3.renderCharacter(renderer);
		
	}
	@Override
	protected void enemyAI1(){
		if(enemy != null)
			enemy.aI1();
		if(enemy2 != null)
			enemy2.aI1();
		if(enemy3 != null)
			enemy3.aI1();
	}
	@Override
	protected void enemyAI2(){
		if(enemy != null)
			enemy.aI2();
		if(enemy2 != null)
			enemy2.aI2();
		if(enemy3 != null)
			enemy3.aI2();
	}
	@Override
	protected void colision(){
		if(enemy != null){
			colisionDetection(enemy);
			if(enemyColision(enemy)){
				enemy.deathNoise.play();
				enemy = null;
			}
		}
		if(enemy2 != null){
			colisionDetection(enemy2);
			if(enemyColision(enemy2)){
				enemy2.deathNoise.play();
				enemy2 = null;
			}
		}
		if(enemy3 != null){
			colisionDetection(enemy3);
			if(enemyColision(enemy3)){
				enemy3.deathNoise.play();
				enemy3 = null;
			}
		}
	}
	
	@Override 
	protected void load_next_level(){
		GameController.load_level(2);
	}
	
	protected void load_previous_level(){
	}
}

