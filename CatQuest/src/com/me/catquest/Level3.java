package com.me.catquest;

import java.util.Random;

public class Level3 extends Level{
	Random rand = new Random();
	Enemy enemy;
	Enemy enemy2;
	Enemy enemy3;
	Enemy enemy4;
	static int[] spawn = {1, 16};
	Level3()
	{
		super(199, 20, "level3", spawn);
	}
	
	@Override
	protected void addEnemies(){
		enemy = new Enemy();
		enemy.pos.set(67, 13);
		enemy2 = new Enemy();
		enemy2.pos.set(129, 3);
		enemy3 = new Enemy();
		enemy3.pos.set(156, 4);
		enemy4 = new Enemy();
		enemy4.pos.set(178, 5);
	}
	
	@Override
	protected void renderEnemies(){
		if(enemy != null)
			enemy.renderCharacter(renderer);
		if(enemy2 != null)
			enemy2.renderCharacter(renderer);
		if(enemy3 != null)
			enemy3.renderCharacter(renderer);
		if(enemy4 != null)
			enemy4.renderCharacter(renderer);
		
	}
	@Override
	protected void enemyAI1(){
		if(enemy != null)
			enemy.aI1();
		if(enemy2 != null)
			enemy2.aI1();
		if(enemy3 != null)
			enemy3.aI1();
		if(enemy4 != null)
			enemy4.aI1();
	}
	@Override
	protected void enemyAI2(){
		if(enemy != null)
			enemy.aI2();
		if(enemy2 != null)
			enemy2.aI2();
		if(enemy3 != null)
			enemy3.aI2();
		if(enemy4 != null)
			enemy4.aI2();
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
		if(enemy4 != null){
			colisionDetection(enemy4);
			if(enemyColision(enemy4)){
				enemy4.deathNoise.play();
				enemy4 = null;
			}
		}
	}
	@Override 
	protected void load_next_level(){
		GameController.load_main_menu(rand.nextInt(3)+2);
	}
	
	protected void load_previous_level(){
		GameController.load_level(2);
	}
}