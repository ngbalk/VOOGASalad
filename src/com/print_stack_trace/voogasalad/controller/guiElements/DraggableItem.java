package com.print_stack_trace.voogasalad.controller.guiElements;
//http://blog.ngopal.com.np/2011/06/09/draggable-node-in-javafx-2-0/
import java.awt.Point;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class DraggableItem {
	private SpriteObject myItem;
	private double mouseXLocation;
	private double mouseYLocation;
	private double myX;
	private double myY;
	private double myWidth;
	private double myHeight;
	private double gridWidth;
	private double gridHeight;
	private double startX;
	private double startY;
	public DraggableItem(SpriteObject item, Number width, Number height, SimpleDoubleProperty x, SimpleDoubleProperty y){
		myItem=item;
		myWidth=item.getImage().getFitWidth();
		myHeight=item.getImage().getFitHeight();
		gridWidth=width.doubleValue();
		gridHeight=height.doubleValue();
		startX=x.getValue().doubleValue();
		startY=y.getValue().doubleValue();
		addChangeListeners(x, y);
		drag();
	}
	private void addChangeListeners(SimpleDoubleProperty x, SimpleDoubleProperty y){
		x.addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1, Number arg2) {
				startX=arg2.doubleValue();
			}	
		});
		y.addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1, Number arg2) {
				startY=arg2.doubleValue();
			}	
		});
	}
	
	private void drag(){
		myItem.getImage().setOnMousePressed(new EventHandler <MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				mouseXLocation=event.getSceneX()-startX;
				mouseYLocation=event.getSceneY()-startY;
			}
		});
		
		myItem.getImage().setOnMouseDragged(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				if (!outOfBounds(new Point((int)event.getSceneX(), (int)event.getSceneY()))){
					myItem.notClicked();
					myX=event.getSceneX()-startX;
					myY=event.getSceneY()-startY;
					translate();
					mouseXLocation=event.getSceneX()-startX;
					mouseYLocation=event.getSceneY()-startY;
				}
			}
		});
	}
	private void translate(){
		myItem.setMyX(myX-myWidth/2);
		myItem.setMyY(myY-myHeight/1.5);
	}
	public Node getMyItem(){
		return myItem.getImage();
	}
	private boolean outOfBounds(Point myLocation){
		if (myLocation.x>gridWidth-10||myLocation.x<45){
			return true;
		}
		if (myLocation.y>gridHeight||myLocation.y<45){
			return true;
		}
		return false;
	}
	

}
