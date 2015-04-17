package com.me.catquest;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "CatQuest: Quest for the Baby Red Pandas";
		cfg.useGL20 = false;
		cfg.width = 640;
		cfg.height = 640;
		 
		new LwjglApplication(new CatQuest(), cfg);
	}
}
