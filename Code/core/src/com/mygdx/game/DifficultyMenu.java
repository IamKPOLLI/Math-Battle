package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class DifficultyMenu implements Screen {
    private TextButton back;
    private TextButton play;
    private final MyGdxGame game;
    private int diff;
    private Stage stage;
    private int updateRate;
    private Array<TextButton> textButtonArray;

    DifficultyMenu(final MyGdxGame game) {
        diff = 0;
        this.game = game;
        stage = new Stage(new ScreenViewport());
        textButtonArray = new Array<TextButton>();

        TextButton textButton = new TextButton("Baby", game.buttonStyles.diffButtonsStyle);
        textButton.setWidth(1000);
        textButton.setHeight(200);
        textButton.getLabel().setFontScale(2f, 2f);
        textButton.setPosition(40, 1800);
        textButtonArray.add(textButton);

        TextButton textButton1 = new TextButton("Easy", game.buttonStyles.diffButtonsStyle);
        textButton1.setWidth(1000);
        textButton1.setHeight(200);
        textButton1.getLabel().setFontScale(2f, 2f);
        textButton1.setPosition(40, 1570);
        textButtonArray.add(textButton1);

        TextButton textButton2 = new TextButton("Normal", game.buttonStyles.diffButtonsStyle);
        textButton2.setWidth(1000);
        textButton2.setHeight(200);
        textButton2.getLabel().setFontScale(2f, 2f);
        textButton2.setPosition(40, 1340);
        textButtonArray.add(textButton2);

        TextButton textButton3 = new TextButton("Expert", game.buttonStyles.diffButtonsStyle);
        textButton3.setWidth(1000);
        textButton3.setHeight(200);
        textButton3.getLabel().setFontScale(2f, 2f);
        textButton3.setPosition(40, 1110);
        textButtonArray.add(textButton3);

        back = new TextButton("Back", game.buttonStyles.longButtonStyle);
        back.setWidth(1000);
        back.setHeight(200);
        back.getLabel().setFontScale(2f, 2f);
        back.setPosition(Gdx.graphics.getWidth() / 2 - 500, 40);
        textButtonArray.add(back);

        play = new TextButton("Play", game.buttonStyles.longButtonStyle);
        play.setWidth(1000);
        play.setHeight(200);
        play.getLabel().setFontScale(2f, 2f);
        play.setPosition(Gdx.graphics.getWidth() / 2 - 500, 270);
        textButtonArray.add(play);


        textButtonArray.get(0).addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                diff = 0;
            }
        });

        textButtonArray.get(1).addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                diff = 1;
            }
        });

        textButtonArray.get(2).addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                diff = 2;
            }
        });

        textButtonArray.get(3).addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                diff = 3;
            }
        });

        for (int i = 0; i < 6; i++) {
            stage.addActor(textButtonArray.get(i));
        }

        ButtonGroup<TextButton> buttonGroup = new ButtonGroup<TextButton>(
                textButtonArray.get(0),
                textButtonArray.get(1),
                textButtonArray.get(2),
                textButtonArray.get(3));
        buttonGroup.setMaxCheckCount(1);

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {//насрано
                game.setScreen(new MainMenu(game));
            }
        });
        stage.addActor(back);

        play.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {//насрано
                game.setScreen(new Singleplayer(game, diff));
            }
        });
        stage.addActor(play);

        loadStage();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    private void loadStage() {
        updateRate = 0;
        stage.clear();
        textButtonArray.get(4).setPosition(Gdx.graphics.getWidth() / 2 - 500, 40);
        textButtonArray.get(5).setPosition(Gdx.graphics.getWidth() / 2 - 500, 270);


        for (int i = 0; i < textButtonArray.size; i++) {
            stage.addActor(textButtonArray.get(i));
        }

        textButtonArray.get(diff).setChecked(true);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (updateRate > 100) {
            loadStage();
        }
        updateRate++;

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
