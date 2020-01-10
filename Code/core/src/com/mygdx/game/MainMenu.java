package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenu implements Screen {
    private final MyGdxGame game;
    private Stage stage;
    private Array<TextButton> textButtonArray;

    public MainMenu(final MyGdxGame game){
        this.game = game;
        stage = new Stage(new ScreenViewport());
        textButtonArray = new Array<TextButton>();

        TextButton textButton = new TextButton("Singleplayer", game.buttonStyles.longButtonStyle);
        textButton.setWidth(1000);
        textButton.setHeight(300);
        textButton.getLabel().setFontScale(2f, 2f);
        textButton.setPosition(40, 1600);
        textButtonArray.add(textButton);

        TextButton textButton1 = new TextButton("Multiplayer", game.buttonStyles.longButtonStyle);
        textButton1.setWidth(1000);
        textButton1.setHeight(300);
        textButton1.getLabel().setFontScale(2f, 2f);
        textButton1.setPosition(40, 1250);
        textButtonArray.add(textButton1);

        TextButton textButton2 = new TextButton("Bests results", game.buttonStyles.longButtonStyle);
        textButton2.setWidth(1000);
        textButton2.setHeight(300);
        textButton2.getLabel().setFontScale(2f, 2f);
        textButton2.setPosition(40, 900);
        textButtonArray.add(textButton2);

        TextButton textButton3 = new TextButton("FAQ", game.buttonStyles.longButtonStyle);
        textButton3.setWidth(1000);
        textButton3.setHeight(300);
        textButton3.getLabel().setFontScale(2f, 2f);
        textButton3.setPosition(40, 550);
        textButtonArray.add(textButton3);

        TextButton textButton4 = new TextButton("Exit", game.buttonStyles.longButtonStyle);
        textButton4.setWidth(1000);
        textButton4.setHeight(300);
        textButton4.getLabel().setFontScale(2f, 2f);
        textButton4.setPosition(40, 200);
        textButtonArray.add(textButton4);


        textButtonArray.get(0).addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new DifficultyMenu(game));
            }
        });
        textButtonArray.get(3).addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new FAQ(game));
            }
        });
        textButtonArray.get(4).addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.info.saveFile();
                Gdx.app.exit();
            }
        });

        textButtonArray.get(2).addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new BestResults(game,13,-1));
            }
        });

        for(int i=0;i<5;i++){
            stage.addActor(textButtonArray.get(i));
        }
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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

    }
}
