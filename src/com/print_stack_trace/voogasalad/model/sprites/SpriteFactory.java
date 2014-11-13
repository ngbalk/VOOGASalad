package com.print_stack_trace.voogasalad.model.sprites;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public class SpriteFactory {
    public static final String spritePath = "com.print_stack_trace.voogasalad.model.sprites.";

    protected Sprite buildSprite(SpriteCharacteristics mySpriteCharacteristics) {
        Constructor<?> con = null;
        Sprite newSprite = null;

        try {
            String objectType = reformatTypeString(mySpriteCharacteristics.objectType.toString());
            Class<?> newSpriteClass = Class.forName(spritePath + objectType);
            try {
                con = newSpriteClass.getConstructor(SpriteCharacteristics.class);
            } catch (NoSuchMethodException | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                newSprite = (Sprite) con.newInstance(mySpriteCharacteristics);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return newSprite;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private String reformatTypeString(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
