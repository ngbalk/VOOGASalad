package com.print_stack_trace.voogasalad.model.sprites;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public abstract class Block extends Sprite {

    public Block (String id, SpriteCharacteristics spriteCharacteristics) {
        super(id, spriteCharacteristics);
        
    }
    
    @Override
    protected void setSpriteProperties () {
        super.setSpriteProperties();
    }


}
