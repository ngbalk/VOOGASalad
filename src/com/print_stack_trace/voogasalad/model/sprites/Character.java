package com.print_stack_trace.voogasalad.model.sprites;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

import javafx.geometry.Point2D;

public abstract class Character extends Sprite {
    private int myHealth;
    private double mySpeed;
    private String myDirectionFacing;
    
    public Character (String id, SpriteCharacteristics spriteCharacteristics) {
        super(id, spriteCharacteristics);
        
    }


    //TODO
    protected void setHealth(int health) {
        
    }
    
    //TODO
    protected void setSpeed(double speed) {
        
    }
    
    //TODO
    protected void setStartLocation(Point2D point) {
        
    }
    
    @Override
    protected void setSpriteProperties () {
        super.setSpriteProperties();
        myHealth = mySpriteCharacteristics.health;
        mySpeed = mySpriteCharacteristics.speed;
        myDirectionFacing = mySpriteCharacteristics.directionFacing;
    }


}
