package com.print_stack_trace.voogasalad.model.sprites;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public class Reward extends Sprite {
    
    private int myValue;
    
    public Reward (SpriteCharacteristics spriteCharacteristics) {
        super(spriteCharacteristics);
    }

    @Override
    public void update () {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void setSpriteProperties () {
        super.setSpriteProperties();
        myValue = mySpriteCharacteristics.value;
    }

}
