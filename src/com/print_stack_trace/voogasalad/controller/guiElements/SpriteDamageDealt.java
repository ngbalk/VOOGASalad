package com.print_stack_trace.voogasalad.controller.guiElements;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

public class SpriteDamageDealt extends SpriteCharacteristicController{
        public SpriteDamageDealt(String[] values,  double width, double height, double x, double y, GameObject object){
                super(values, width, height, x, y, object);
        }
        @Override
        public void setCharacteristic(String newValue){
                int newDamageDealt = ((SpriteObject)mySprite).getCharacteristics().getDamageDealt();
                try{
                        newDamageDealt = Integer.parseInt(newValue);
                }
                catch(NumberFormatException e){
                        
                }
                
                ((SpriteObject)mySprite).getCharacteristics().setDamageDealt(newDamageDealt);
                mySprite.getDelegate().update((SpriteObject) mySprite);
        }
        @Override
        protected void populateDefaultText() {
                myTextBox.setText(Double.toString(((SpriteObject)mySprite).getCharacteristics().getDamageDealt()));
        }

}
