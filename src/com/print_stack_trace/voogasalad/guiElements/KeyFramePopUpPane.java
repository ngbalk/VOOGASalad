package com.print_stack_trace.voogasalad.guiElements;

import java.util.Collection;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class KeyFramePopUpPane extends GeneralPane {
	private KeyFrameBox myBox;
	private Label myCurrentKey;
	public KeyFramePopUpPane(){
		super();
		myBox=new KeyFrameBox(this.getWidth(), this.getHeight());
		this.getChildren().add(myBox);
		currentKeyFramePane();
	}
	public void currentKeyFramePane(){
		Pane myPane=new Pane();
		myPane.setStyle("-fx-background-color: BLACK");
		myPane.setPrefSize(this.getWidth(), this.getHeight()*.2);
		myPane.relocate(0, this.getHeight()-this.getHeight()*.2);
		System.out.println(myPane.getWidth());
		getChildren().add(myPane);
		this.addCurrentKeyLabel(myPane);
	}
	private void addCurrentKeyLabel(Pane pane){
		myCurrentKey=new Label("Current KeyFrame: "+ myBox.getCurrentKeyFrame().getValue().getTag()+myBox.getCurrentKeyFrame().getValue().getIndex());
		myCurrentKey.setTextFill(Paint.valueOf("WHITE"));
		myCurrentKey.relocate(0, 0);
		myCurrentKey.setPrefSize(pane.getPrefWidth()/2,pane.getPrefHeight());
		setObservable();
		pane.getChildren().add(myCurrentKey);
	}
	private void setObservable(){
		System.out.println(myBox.getCurrentKeyFrame().getValue());
		myBox.getCurrentKeyFrame().addListener(new ChangeListener<KeyFrameBlock>(){
			@Override
			public void changed(ObservableValue<? extends KeyFrameBlock> arg0,
					KeyFrameBlock oldFrame, KeyFrameBlock newFrame) {
				System.out.println("HA");
				myCurrentKey.setText("Current KeyFrame: "+ newFrame.getTag()+newFrame.getIndex());
				
			}
		});
	}

	
	@Override
	public void createTextFields() {
		
		
	}

	@Override
	public void makeObservable(Collection toObserve) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadInData(Collection myData) {
		// TODO Auto-generated method stub
		
	}

}
