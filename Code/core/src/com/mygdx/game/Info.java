package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;



public class Info {

    public int scores0;
    public int scores1;
    public int scores2;
    public int scores3;

    Info(){
        loadFile();
    }



    public void loadFile(){
        boolean exists = Gdx.files.local("stats1.txt").exists();
        if(!exists){
            createFile();
        }
        FileHandle file = Gdx.files.local("stats1.txt");
        String text = file.readString();
        splitString(text);
    }


    public String createString(){
        String str= Integer.toString(scores0)+'@'+scores1+'@'+scores2+'@'+scores3;
        return str;
    }


    public void saveFile(){
        FileHandle file = Gdx.files.local("stats1.txt");
        file.writeString(createString(), false);
    }




    public void splitString(String text){
        String[] parts = text.split("@");
        scores0 =Integer.parseInt(parts[0]);
        scores1 =Integer.parseInt(parts[1]);
        scores2 =Integer.parseInt(parts[2]);
        scores3 =Integer.parseInt(parts[3]);
    }
    public void createFile(){
        FileHandle file = Gdx.files.local("stats1.txt");
        file.writeString("1@1@1@1", false);
    }
}

