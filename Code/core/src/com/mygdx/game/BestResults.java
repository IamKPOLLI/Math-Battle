package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class BestResults implements Screen {
    private TextButton back;
    private final MyGdxGame game;
    private Stage stage;
    private Label label0;
    private Label label1;
    private Label label2;
    private Label label3;

    BestResults(final MyGdxGame game, int diff, int sc) {

        this.game = game;
        stage = new Stage(new ScreenViewport());

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.font;
        label0 = new Label("Baby:" + game.info.scores0, labelStyle);
        label0.setWidth(500);
        label0.setHeight(200);
        label0.setFontScale(6f, 4f);
        label0.setPosition(40, 1800);
        stage.addActor(label0);

        label1 = new Label("Easy:" + game.info.scores1, labelStyle);
        label1.setWidth(500);
        label1.setHeight(200);
        label1.setFontScale(6f, 4f);
        label1.setPosition(40, 1500);
        stage.addActor(label1);

        label2 = new Label("Normal:" + game.info.scores2, labelStyle);
        label2.setWidth(500);
        label2.setHeight(200);
        label2.setFontScale(6f, 4f);
        label2.setPosition(40, 1200);
        stage.addActor(label2);

        label3 = new Label("Expert:" + game.info.scores3, labelStyle);
        label3.setWidth(500);
        label3.setHeight(200);
        label3.setFontScale(6f, 4f);
        label3.setPosition(40, 900);
        stage.addActor(label3);

        switch (diff) {
            case 0: {
                String[] str0 = label0.getText().toString().split(":");
                if(sc>Integer.parseInt(str0[1])) {
                    label0.setText("Baby" + sc);
                    game.info.scores0 = sc;
                    game.info.saveFile();
                }
                break;
            }
            case 1: {
                String[] str1 = label1.getText().toString().split(":");
                if(sc>Integer.parseInt(str1[1])){
                    label1.setText("Easy"+sc);
                    game.info.scores1 = sc;
                    game.info.saveFile();}
                break;
            }
            case 2: {
                String[] str2 = label2.getText().toString().split(":");
                if(sc>Integer.parseInt(str2[1])){
                    label2.setText("Normal"+sc);
                    game.info.scores2 = sc;
                    game.info.saveFile();}
                break;
            }
            case 3: {
                String[] str3 = label3.getText().toString().split(":");
                if(sc>Integer.parseInt(str3[1])){
                    label3.setText("Expert"+sc);
                    game.info.scores3 = sc;
                    game.info.saveFile();}
                break;
            }
            default: {
                label0.setText("Baby:" + game.info.scores0);
                label1.setText("Easy:" + game.info.scores1);
                label2.setText("Normal:" + game.info.scores2);
                label3.setText("Expert:" + game.info.scores3);
                break;
            }

        }
        back = new TextButton("Back", game.buttonStyles.longButtonStyle);
        back.setWidth(1000);
        back.setHeight(200);
        back.getLabel().setFontScale(2f, 2f);
        back.setPosition(Gdx.graphics.getWidth() / 2 - 500, 40);
        stage.addActor(back);
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new DifficultyMenu(game));
            }
        });


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