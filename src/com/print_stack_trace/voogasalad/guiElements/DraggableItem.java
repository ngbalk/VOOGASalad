package com.print_stack_trace.voogasalad.guiElements;
//http://blog.ngopal.com.np/2011/06/09/draggable-node-in-javafx-2-0/
import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class DraggableItem {
	//blah{
		//for (x: x list)
			//x.dosomething(myPrivateData)
	//instead 
	//pass in an interface with its function defined .
	//blahInClass(Consumer <x> func){
		//myList.map(func);
	//}
	//blah{
		//this.blahInclass(X::doSomething());
		//this.blahInClass(e-->callCode(myPrivateData));
	//}
	private ImageView myItem;
	private double mouseXLocation;
	private double mouseYLocation;
	private double myX;
	private double myY;
	private double myWidth;
	private double myHeight;
	private double gridWidth;
	private double gridHeight;
	private GeneralPane myNewPane=new SpritePane();
	public DraggableItem(ImageView item, Number width, Number height){
		myItem=item;
		myWidth=item.getFitWidth();
		myHeight=item.getFitHeight();
		gridWidth=width.doubleValue()-15;
		gridHeight=height.doubleValue()-15;
		drag();
	}
	private void drag(){
		myItem.setOnMousePressed(new EventHandler <MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				mouseXLocation=event.getSceneX();
				mouseYLocation=event.getSceneY();
			}
		});
		
		myItem.setOnMouseDragged(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				if (!outOfBounds(new Point((int)event.getSceneX(), (int)event.getSceneY()))){
					myX=event.getSceneX();
					myY=event.getSceneY();
					myNewPane.openPane();
					translate();
					mouseXLocation=event.getSceneX();
					mouseYLocation=event.getSceneY();
				}
			}
		});
	}
	private void translate(){
		myItem.relocate(myX-myWidth/2, (myY-myHeight/1.5));
	}
	private void click(){
		myItem.setOnMousePressed(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	public Node getMyItem(){
		return myItem;
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
