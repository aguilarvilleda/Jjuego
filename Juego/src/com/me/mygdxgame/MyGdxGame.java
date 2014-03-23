package com.me.mygdxgame;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	Image i;
	Stage s;
	Pelotita mipelotita;
	Pelotitamala mipelotitamala;
	Pelotita p;
	ArrayList<Pelotita>pelotitas = new ArrayList<Pelotita>();
	int frame = 0;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		int randomw = ((int)(Math.random()*1000%w));
		int randomh = ((int)(Math.random()*1000%h));
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		i = new Image(texture);
		s = new Stage();
		s.addActor(i);
		
		
		mipelotita = new Pelotita (randomw, randomh);
		mipelotitamala = new Pelotitamala(randomw, randomh);
		s.addActor(mipelotita);
		s.addActor(mipelotitamala);
		
		Gdx.input.setInputProcessor(s);
		
		
		for (int i = 0; i < 5; i++) {
			Pelotita p = new Pelotita(randomw, randomh);
			Pelotitamala pm = new Pelotitamala(randomw, randomh);
			s.addActor(p);
			s.addActor(pm);
			pelotitas.add(p);
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		batch.setProjectionMatrix(camera.combined);
		//********************************************************************
		batch.begin();
		sprite.draw(batch);
		s.draw();
		s.act();
		batch.end();
		
		if(frame%30==0)
			s.addActor(new Pelotita((int)(Math.random()*1000%w),(int)(Math.random()*1000%h)));
			if(frame%40==0)
				s.addActor(new Pelotitamala((int)(Math.random()*1000%w),(int)(Math.random()*1000%h)));
			frame++;
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
