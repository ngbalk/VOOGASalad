package com.print_stack_trace.voogasalad.model.sprites;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public class Reward extends Sprite {
    
    private int myValue;
    
    public Reward (String id, SpriteCharacteristics spriteCharacteristics) {
        super(id, spriteCharacteristics);
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
