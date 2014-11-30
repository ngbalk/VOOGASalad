package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;
import java.util.Set;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class UserObjectsLibrary extends PictureLibrary{
	private HashMap<String, SpriteObject> myMap=new HashMap<String, SpriteObject>();
	private HashMap<String, ImageView> myImages=new HashMap<String, ImageView>();
	private Image currentImage;
	public UserObjectsLibrary(Number width, Number height, Pane otherPane) {
		super(width, height, otherPane);
		loadAndAddData();
	}

	@Override
	protected void loadAndAddData() {
		setObservable();

	}
	private void setObservable(){
		((GamePane) myMainPane).myObservableData.addListener(new ChangeListener<Set<SimpleObjectProperty<SpriteObject>>>(){
			@Override
			public void changed(
					ObservableValue<? extends Set<SimpleObjectProperty<SpriteObject>>> arg0,
							Set<SimpleObjectProperty<SpriteObject>> arg1,
							Set<SimpleObjectProperty<SpriteObject>> newValue) {
				addImage(newValue);
			}
		});

	}
	private void addImage(Set<SimpleObjectProperty<SpriteObject>> newValue){
		for (SimpleObjectProperty<SpriteObject> sprite: newValue){
			SpriteObject currentSprite=myMap.get(sprite.getValue().getCode());
			SpriteObject newSprite=new SpriteObject(0, sprite.getValue().getImage(), sprite.getValue().getType(), (ViewObjectDelegate) myMainPane);
			newSprite.getImage().setFitHeight(sprite.getValue().getImage().getFitHeight());
			newSprite.getImage().setFitWidth(sprite.getValue().getImage().getFitWidth());
			newSprite.setCharacteristics(sprite.getValue().getCharacteristics());
			if (currentSprite!=null&& sprite.getValue().getCharacteristics().getName().length()>0){
				myMap.put(sprite.getValue().getCode(), sprite.getValue());
				myImages.get(sprite.getValue().getCode()).setImage(sprite.getValue().getImage().getImage());
				currentImage=null;
			}
			else if(sprite.getValue().getCharacteristics().getName().length()>0){
				myMap.put(sprite.getValue().getCode(), sprite.getValue());	
				currentImage=newSprite.getImage().getImage();
				
			}
			if (currentImage!=null){
				ImageView myView=(ImageView) makeImageView(newSprite.getImage().getImage());
				this.addImageToGrid(myView);
				myImages.put(sprite.getValue().getCode(), myView);
				myView.setOnMousePressed(event->((GamePane) myMainPane).addExistingObjectToOtherPane(newSprite));
			}
		}
	}
	


	

}