package com.print_stack_trace.voogasalad.controller.guiElements.gameObjects;
//http://blog.ngopal.com.np/2011/06/09/draggable-node-in-javafx-2-0/
import java.awt.Point;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
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
	private double myX;
	private double myY;
	private double myWidth;
	private double myHeight;
	private double gridWidth;
	private double gridHeight;
	private double initialWidth;

	private ReadOnlyDoubleProperty scrollHVal;
	private ReadOnlyDoubleProperty scrollVVal;
	private double startX;
	private double startY;
	private int buffer=30;
	public DraggableItem(SpriteObject item, ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height, ReadOnlyDoubleProperty hVal, ReadOnlyDoubleProperty vVal, SimpleDoubleProperty x, SimpleDoubleProperty y){
		myItem=item;
		myWidth=item.getImage().getFitWidth();
		myHeight=item.getImage().getFitHeight();
		gridWidth=width.getValue().doubleValue();
		gridHeight=height.getValue().doubleValue();
		startX=x.getValue().doubleValue();
		startY=y.getValue().doubleValue();
		scrollHVal=hVal;
		scrollVVal=vVal;
		addListener(x, (toChange)->changeX(toChange));
		addListener(y, (toChange)->changeY(toChange));
		addListener(myItem.getObservableWidth(), (toChange)->changeWidth(toChange));
		addListener(myItem.getObservableHeight(), (toChange)->changeHeight(toChange));
		addListener(width, (toChange)->changeGridWidth(toChange));
		addListener(height, (toChange)->changeGridHeight(toChange));
		drag();
	}

	public interface DoubleChangeListener{
		public void change(double toChange);
	}
	private void addListener(ReadOnlyDoubleProperty readOnlyDoubleProperty, DoubleChangeListener doubleChange){
		readOnlyDoubleProperty.addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1, Number arg2) {
				doubleChange.change((arg2.doubleValue()));
			}	
		});
	}
	private void changeGridWidth(double width){
		gridWidth=width;

	}
	private void changeGridHeight(double height){
		gridHeight=height;
	}
	private void changeWidth(double width){
		myWidth=width;
	}
	private void changeHeight(double height){
		myHeight=height;
	}
	private void changeX(double x){
		startX=x;
	}
	private void changeY(double y){
		startY=y;
	}

	private void drag(){
		myItem.getImage().setOnMouseDragged(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				if (!outOfBounds(new Point((int)(event.getSceneX()), (int)(event.getSceneY())))){
					myItem.notClicked();
					myX=event.getSceneX()-startX;
					myY=event.getSceneY()-startY;
					translate();
				}
			}
		});
	}


	private void translate(){
		myItem.setSpriteX(myX-myWidth/2);
		myItem.setSpriteY(myY-myHeight/2);
	}

	private boolean outOfBounds(Point myLocation){
		return (myLocation.x> (gridWidth-(myWidth/2))||(myLocation.x<startX)||(myLocation.y>gridHeight)|| (myLocation.y<startY));
	}
}
