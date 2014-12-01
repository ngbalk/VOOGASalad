package com.print_stack_trace.voogasalad.controller.guiElements;
//http://blog.ngopal.com.np/2011/06/09/draggable-node-in-javafx-2-0/
import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class DraggableItem {
	private GameObject myItem;
	private double mouseXLocation;
	private double mouseYLocation;
	private double myX;
	private double myY;
	private double myWidth;
	private double myHeight;
	private double gridWidth;
	private double gridHeight;
	public DraggableItem(GameObject item, Number width, Number height){
		myItem=item;
		myWidth=item.getImage().getFitWidth();
		myHeight=item.getImage().getFitHeight();
		gridWidth=width.doubleValue()-15;
		gridHeight=height.doubleValue()-15;
		drag();
	}
	private void drag(){
		myItem.getImage().setOnMousePressed(new EventHandler <MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				mouseXLocation=event.getSceneX();
				mouseYLocation=event.getSceneY();
			}
		});
		
		myItem.getImage().setOnMouseDragged(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				if (!outOfBounds(new Point((int)event.getSceneX(), (int)event.getSceneY()))){
					myItem.notClicked();
					myX=event.getSceneX();
					myY=event.getSceneY();
					translate();
					mouseXLocation=event.getSceneX();
					mouseYLocation=event.getSceneY();
				}
			}
		});
	}
	private void translate(){
		myItem.getImage().relocate(myX-myWidth/2, (myY-myHeight/1.5));
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
