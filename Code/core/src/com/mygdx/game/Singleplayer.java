package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Singleplayer implements Screen {
    Timer timer;
    private Label scoresLabel;
    private final int d;
    private Label sumLabel;
    private int numberscores;
    private final MyGdxGame game;
    private Stage stage;
    private Array<TextButton> textButtonArray;
    public Sum sum;

    Singleplayer(final MyGdxGame game, int diff) {
        textButtonArray = new Array<TextButton>();
        sum = new Sum(diff);
        d = diff;
        numberscores = 0;
        this.game = game;
        stage = new Stage(new ScreenViewport());
        this.timer = new Timer(game,10);
        timer.start();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.font;
        sumLabel = new Label(sum.Sum, labelStyle);
        sumLabel.setWidth(500);
        sumLabel.setHeight(200);
        sumLabel.setFontScale(4f, 4f);
        sumLabel.setPosition(Gdx.graphics.getWidth() / 2 - 100, 1100);
        stage.addActor(sumLabel);

        scoresLabel = new Label("Scores:" + numberscores, labelStyle);
        scoresLabel.setWidth(500);
        scoresLabel.setHeight(200);
        scoresLabel.setFontScale(4f, 4f);
        scoresLabel.setPosition(100, 1700);
        stage.addActor(scoresLabel);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                TextButton textButton = new TextButton("" + sum.answers[i * 3 + j], game.buttonStyles.pressedCircleButton);
                textButton.setWidth(300);
                textButton.setHeight(300);
                textButton.getLabel().setFontScale(2f, 2f);
                textButton.setPosition(40 + (350 * j), 40 + (350 * i));
                textButtonArray.add(textButton);
                stage.addActor(textButton);
            }
        }

        for (int i = 0; i < 9; i++) {
            final int finalI = i;
            textButtonArray.get(i).addListener(new ChangeListener() {
                public void changed(ChangeEvent event, Actor actor) {
                    String a = textButtonArray.get(finalI).getLabel().getText().toString();
                    if (Integer.parseInt(a)== sum.rightAns) {
                        numberscores +=2;
                    } else {
                        numberscores -=1;
                    }
                    scoresLabel.setText("Scores:" + numberscores);
                    loadStage(d);
                }
            });
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

        if(timer.start){
            game.setScreen(new BestResults(game,d,numberscores));
        }
        timer.drawTime();
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

    public void loadStage(int diff) {
        Sum a = new Sum(diff);
        sum = a;
        for (int i = 0; i < 9; i++) {
            textButtonArray.get(i).setText("" + a.answers[i]);
        }
        sumLabel.setText(a.Sum);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
