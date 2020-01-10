package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class ButtonStyles {
    public TextButton.TextButtonStyle longButtonStyle;
    public TextButton.TextButtonStyle pressedCircleButton;
    public TextButton.TextButtonStyle diffButtonsStyle;

    ButtonStyles(MyGdxGame game){
        longButtonStyle = new TextButton.TextButtonStyle();
        pressedCircleButton = new TextButton.TextButtonStyle();
        diffButtonsStyle = new TextButton.TextButtonStyle();

        diffButtonsStyle.checked = game.skin.getDrawable("longpressed");
        diffButtonsStyle.over = game.skin.getDrawable("longpressed");
        diffButtonsStyle.up = game.skin.getDrawable("longunpressed");
        diffButtonsStyle.font = game.font;

        pressedCircleButton.up = game.skin.getDrawable("unpressed");
        pressedCircleButton.over = game.skin.getDrawable("pressed");
        pressedCircleButton.font = game.font;

        longButtonStyle.down = game.skin.getDrawable("longpressed");
        longButtonStyle.over = game.skin.getDrawable("longpressed");
        longButtonStyle.up = game.skin.getDrawable("longunpressed");
        longButtonStyle.font = game.font;


    }
}
