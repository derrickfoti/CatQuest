package com.me.catquest;


public class GameController{
	static CatQuest catquest;
	
	
	public GameController(CatQuest n)
	{
		catquest = n;	
	}

	public static void load_level(int level)
	{
		Audio.stopMusic();
		Audio.playMusic(6);
		switch(level){
		case 1: 	
			catquest.setScreen(new Level1());
			break; 
		case 2:
			catquest.setScreen(new Level2());
			break;
		case 3:
			catquest.setScreen(new Level3());
			break;
		}
	}
	
	public static void load_main_menu(int x){
		Audio.stopMusic();
		Audio.playMusic(x);
		catquest.setScreen(new MainMenu());

	}
	
	public static void game_over(){
		Audio.stopMusic();
		catquest.setScreen(new GameOver());
	}	
}
