package com.print_stack_trace.voogasalad.model.sprites;

import java.util.ArrayList;
import java.util.Collection;

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
