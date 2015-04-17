package com.me.catquest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;



public class MainMenu implements Screen{
	Stage stage;
	Image logo;
	Texture catQuest;
	SpriteBatch batch;
	BitmapFont white;
	Label label;
	float scaler = 1;
	boolean increasingScaler = true;
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.7f, 0.7f, 1.0f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		

		stage.act(delta);
		batch.begin();
		stage.draw();
		batch.end();
		
		if (Gdx.input.isKeyPressed(Keys.ANY_KEY) || Gdx.input.isTouched()){
			GameController.load_level(1);
			this.dispose();
		}
		

		label.setFontScale(scaler);
		if(increasingScaler)
			scaler += .0025;
		else
			scaler -= .0025;
		
		if(scaler > 1.25)
			increasingScaler = false;
		else if(scaler < 1)
			increasingScaler = true;
	}

	@Override
	public void resize(int width, int height) {
		if (stage == null)
			stage = new Stage(width, height, true);
		stage.clear();
		
		catQuest = new Texture("data/CatQuest.png");
		logo = new Image(catQuest);
		logo.setHeight(150);
		logo.setWidth(600);
		logo.setPosition(20, 320);
		stage.addActor(logo);
		
		white = new BitmapFont(Gdx.files.internal("data/whitefont.fnt"), false);
		LabelStyle style = new LabelStyle(white, Color.WHITE);
		label = new Label("PUSH ANY KEY TO BEGIN", style);
		label.setWidth(64);
		label.setPosition(290,200);
		label.setAlignment(Align.center);
		stage.addActor(label);
		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
	}

}
