package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FAQ implements Screen {
    private TextButton back;
    private final MyGdxGame game;
    private Stage stage;
    private Texture FAQ;

    FAQ(final MyGdxGame game){
        this.game = game;
        stage = new Stage(new ScreenViewport());

        FAQ = new Texture(Gdx.files.internal("FAQ.png"));

        back = new TextButton("Back", game.buttonStyles.longButtonStyle);
        back.setWidth(1000);
        back.setHeight(250);
        back.getLabel().setFontScale(2f, 2f);
        back.setPosition(Gdx.graphics.getWidth()/2 - 500, 40);

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });
        stage.addActor(back);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(FAQ, 0,300, 1080, Gdx.graphics.getHeight() - 300);
        game.batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        FAQ.dispose();
        stage.dispose();
    }
}
