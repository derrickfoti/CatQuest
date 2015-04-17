package com.me.catquest;

import java.util.Random;

import com.badlogic.gdx.Game;

public class CatQuest extends Game{

	static GameController controller;
	static MainMenu mainMenu;
	Random rand = new Random();
	
	public CatQuest()
	{
		super();
		controller = new GameController(this);
		mainMenu = new MainMenu();
	}

	@Override
	public void create() 
	{
		GameController.load_main_menu(rand.nextInt(3)+2);
		
	}
	@Override
	public void dispose()
	{
		super.dispose();
	}
	
	@Override
	public void resize(int width, int height)
	{
		super.resize(width, height);
	}
	
}
