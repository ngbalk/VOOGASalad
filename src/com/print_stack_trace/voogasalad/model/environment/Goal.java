package com.print_stack_trace.voogasalad.model.environment;

import java.util.ArrayList;
import java.util.Collection;

import com.print_stack_trace.voogasalad.model.sprites.Sprite;

public abstract class Goal {
    
    private double value;
    private Collection<Sprite> mySpriteList;
    
    public Goal() {
        mySpriteList = new ArrayList<Sprite>();
        value = 0;
    }
    
    public Goal(Sprite sprite) {
        this();
        mySpriteList.add(sprite);
    }
    
    public Goal(Collection<Sprite> spriteList){
        this();
        mySpriteList = spriteList;
    }
    
    
    public abstract boolean isCompleted();
    
    
}
