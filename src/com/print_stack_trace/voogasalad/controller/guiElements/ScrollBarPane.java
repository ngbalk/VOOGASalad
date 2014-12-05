package com.print_stack_trace.voogasalad.controller.guiElements;




import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class ScrollBarPane extends ScrollPane{
	public ScrollBarPane(Number width, Number height, Node data){
		this.setContent(data);
		this.setPrefHeight(((Region) data).getPrefHeight());
		this.setPrefWidth(((Region)data).getPrefWidth());
		//setUpScrollBars(width.intValue(), height.intValue(), data);
		setHbarPolicy(ScrollBarPolicy.ALWAYS);
		setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setPrefViewportWidth(width.doubleValue()*2);
		this.setPrefViewportHeight(height.doubleValue()*2);
		/*
		this.setVvalue(0);
		this.setHvalue(0);
		this.setVmax(this.getPrefHeight());
		this.setHmax(this.getPrefWidth());
		this.setVmin(0);
		this.setHmin(0);
		changeScrollBar(data);
		*/
	}
	private void changeScrollBar(Node myPane){
		this.hvalueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number old_val, Number new_val) {
			
				if (new_val.doubleValue()>0){
					System.out.println(new_val);
					if (new_val.doubleValue()>0){
						
					//setValue(new_val.doubleValue(),new_val.doubleValue()-old_val.doubleValue(), (Pane) myPane);
					}
				}
			}
		});
		this.vvalueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number old_val, Number new_val) {
				if (new_val.doubleValue()>0){
					if (new_val.doubleValue()>0){
						//setValue(new_val.doubleValue(),new_val.doubleValue()-old_val.doubleValue(), (Pane) myPane);
						
					}
				}
			}
		});
	}
	private void setValue(double new_val,double difference, Pane myPane){
		//this.setPrefWidth(this.getWidth()+difference);
		this.setPrefHeight(this.getHeight()+difference);
		myPane.setPrefSize(this.getPrefWidth(),this.getPrefHeight()+difference);
		//this.setHmin(0);
		//this.setHvalue(new_val);
		//this.setVmax(this.getPrefHeight()+difference);
		
	}
	private void setValue2(double new_val,double difference, Pane myPane){
		myPane.setPrefSize(this.getPrefWidth(),this.getPrefHeight()+difference);
		this.setVmax(this.getPrefHeight()+difference);
		

	}
	
}