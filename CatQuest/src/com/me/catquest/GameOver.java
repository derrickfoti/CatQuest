package com.me.catquest;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;



public class GameOver implements Screen{
	Stage stage;
	SpriteBatch batch;
	BitmapFont white;
	Label label;
	Label label2;
	Random rand = new Random();
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		

		stage.act(delta);
		batch.begin();
		stage.draw();
		batch.end();
		
		if (Gdx.input.isTouched()){
			GameController.load_main_menu(rand.nextInt(3)+2);
			this.dispose();
		}
	}


	@Override
	public void resize(int width, int height) {
		if (stage == null)
			stage = new Stage(width, height, true);
		stage.clear();
		
		
		white = new BitmapFont(Gdx.files.internal("data/whitefont.fnt"), false);
		LabelStyle style = new LabelStyle(white, Color.WHITE);
		label = new Label("GAME OVER", style);
		label.setWidth(64);
		label.setFontScale(2f);
		label.setPosition(290,320);
		label.setAlignment(Align.center);
		stage.addActor(label);
		
		label2 = new Label("Click Screen to Restart", style);
		label2.setWidth(64);
		label2.setPosition(290, 200);
		label2.setAlignment(Align.center);
		stage.addActor(label2);
		
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
