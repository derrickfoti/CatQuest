package com.me.catquest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Audio {
	Audio() 
	{
	}

	
	
	private static Music marioTheme = Gdx.audio.newMusic(Gdx.files.internal("data/Theme.mp3"));
	private static Music cantina = Gdx.audio.newMusic(Gdx.files.internal("data/Cantina.mp3"));
	private static Music caramell = Gdx.audio.newMusic(Gdx.files.internal("data/Caramell.mp3"));
	private static Music guile = Gdx.audio.newMusic(Gdx.files.internal("data/Guile.mp3"));
	private static Music ninja = Gdx.audio.newMusic(Gdx.files.internal("data/Ninja.mp3"));
	private static Music saxguy = Gdx.audio.newMusic(Gdx.files.internal("data/Saxguy.mp3"));
	public static void playMusic(int s) {
		switch(s){
		case 1:
			marioTheme.setLooping(true);
			marioTheme.play();
			break;
		case 2:
			cantina.setLooping(true);
			cantina.play();
			break;
		case 3:
			saxguy.setLooping(true);
			saxguy.play();
			break;	
		case 4:
			guile.setLooping(true);
			guile.play();
			break;
		case 5:
			ninja.setLooping(true);
			ninja.play();
			break;
		case 6:	
			caramell.setLooping(true);
			caramell.play();
			break;
		}
	}

	public static void stopMusic() {
		marioTheme.stop();
		cantina.stop();
		caramell.stop();
		guile.stop();
		ninja.stop();
		saxguy.stop();
		
	}

	public static void dispose() {
		marioTheme.dispose();
		cantina.dispose();
		caramell.dispose();
		guile.dispose();
		ninja.dispose();
		saxguy.dispose();
	}
	
	public static void pause(){
		marioTheme.pause();
		cantina.pause();
		caramell.pause();
		guile.pause();
		ninja.pause();
		saxguy.pause();
	}
}
