package com.print_stack_trace.voogasalad.model.sprites;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public abstract class Sprite {
    protected SpriteCharacteristics mySpriteCharacteristics;
    protected Point2D myPosition;
    protected Image myImage;
    protected SpriteType mySpriteType;
    
    public Sprite(SpriteCharacteristics spriteCharacteristics) {

        mySpriteCharacteristics = spriteCharacteristics;
        setSpriteProperties();
    }
    
    public abstract void update();
    
    protected void setSpriteProperties() {
        myPosition = mySpriteCharacteristics.p;
        myImage = mySpriteCharacteristics.img;
    }
    
    public boolean updateSpriteProperties(SpriteCharacteristics spriteCharacteristics) {
        mySpriteCharacteristics = spriteCharacteristics;
        setSpriteProperties();
        return true;
    }
    
    public SpriteType getMySpriteType() {
        return mySpriteType;
    }
}

