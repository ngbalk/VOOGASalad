package com.print_stack_trace.voogasalad.controller.author;

import javafx.geometry.Point2D;

public abstract class Sprite {
    private String myId;
    
    public Sprite(String id) {
        myId = id;
    }
    
    //TODO
    protected void setImage(String imagePatch) {
       
    }
    
    //TODO
    protected void setPosition(Point2D location) {
        
    }
    
    //TODO
    protected void setDimensions(int width, int height) {
        
    }
    
    public abstract void update();

}
