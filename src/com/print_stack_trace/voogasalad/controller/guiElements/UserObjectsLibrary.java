package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;
import java.util.Set;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
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
		setObservable2();

	}
	private void setObservable(){
		((GamePane) myMainPane).myObservableData.addListener(new SetChangeListener<SpriteObject>(){

			@Override
			public void onChanged(
					javafx.collections.SetChangeListener.Change<? extends SpriteObject> newValue) {
				addImage(newValue.getSet());

			}
		});
	}
	private void setObservable2(){
		((GamePane) myMainPane).changedSprite.addListener(new ChangeListener<SpriteObject>(){

			@Override
			public void changed(ObservableValue<? extends SpriteObject> arg0,
					SpriteObject arg1, SpriteObject arg2) {
				observableSpriteObject(arg2);

			}

		});
	}
	private void addImage(ObservableSet<? extends SpriteObject> observableSet){
		for (SpriteObject sprite: observableSet){
			SpriteObject currentSprite=myMap.get(sprite.getCode());
			SpriteObject newSprite=new SpriteObject(0, sprite.getImage(), sprite.getImagePath(), sprite.getType(), (ViewObjectDelegate) myMainPane);
			newSprite.setCharacteristics(sprite.getCharacteristics());
			if (currentSprite!=null&& sprite.getCharacteristics().getName().length()>0){
				myMap.put(sprite.getCode(), sprite);
				myImages.get(sprite.getCode()).setImage(sprite.getImage().getImage());
				currentImage=null;
			}
			else if(sprite.getCharacteristics().getName().length()>0){
				myMap.put(sprite.getCode(), sprite);	
				currentImage=newSprite.getImage().getImage();

			}
			if (currentImage!=null){
				ImageView myView=(ImageView) makeImageView(newSprite.getImage().getImage());
				this.addImageToGrid(myView);
				myImages.put(sprite.getCode(), myView);
				myView.setOnMousePressed(event->((GamePane) myMainPane).addExistingObjectToOtherPane(newSprite));
			}
		}
	}
	private void observableSpriteObject(SpriteObject sprite){
		SpriteObject currentSprite=myMap.get(sprite.getCode());
		if (currentSprite!=null&& sprite.getCharacteristics().getName().length()>0){
			myMap.put(sprite.getCode(), sprite);
			myImages.get(sprite.getCode()).setImage(sprite.getImage().getImage());
			currentImage=null;
		}
		else if(sprite.getCharacteristics().getName().length()>0){
			myMap.put(sprite.getCode(), sprite);	
			currentImage=sprite.getImage().getImage();
		}
		if (currentImage!=null){
			ImageView myView=(ImageView) makeImageView(sprite.getImage().getImage());	
			this.addImageToGrid(myView);
			myImages.put(sprite.getCode(), myView);
			myView.setOnMousePressed(event->((GamePane) myMainPane).addExistingObjectToOtherPane(sprite));
		}
	}






}