package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;



public class MyGdxGame extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	public Skin skin;
	public TextureAtlas atlas;
	public ButtonStyles buttonStyles;
	public Info info;



	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
		atlas = new TextureAtlas(Gdx.files.internal("texture.atlas"));
		skin = new Skin(atlas);
		info = new Info();
		buttonStyles = new ButtonStyles(this);
		this.setScreen(new MainMenu(this));


	}



	public void render() {
		super.render();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
		skin.dispose();
	}
}
