package com.print_stack_trace.voogasalad.controller.guiElements;




import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class ScrollBarPane extends ScrollPane{
	double myWidth;
	double myHeight;
	int count=1;
	SimpleDoubleProperty myWidthDouble=new SimpleDoubleProperty();
	SimpleDoubleProperty myHeightDouble=new SimpleDoubleProperty();
	public ScrollBarPane(Number width, Number height, Node data){
		this.setContent(data);
		myWidth=width.doubleValue();
		myHeight=height.doubleValue();
		this.setPrefHeight(((Region) data).getPrefHeight());
		this.setPrefWidth(((Region)data).getPrefWidth());
		//setUpScrollBars(width.intValue(), height.intValue(), data);
		setHbarPolicy(ScrollBarPolicy.ALWAYS);
		setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setPrefViewportWidth(width.doubleValue()*2);
		this.setPrefViewportHeight(height.doubleValue()*2);
		this.setVvalue(0);
		this.setHvalue(0);
		this.setVmax(this.getPrefHeight());
		this.setHmax(this.getPrefWidth());
		this.setVmin(0);
		this.setHmin(0);
		change((Pane) data);
		System.out.println("INitial width"+this.getHmax());

	}
	/*
	private void changeBars(Pane data){
		
		myWidthDouble.bind(data.prefWidthProperty());
		myHeightDouble.bind(data.prefHeightProperty());
		myWidthDouble.addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1, Number newValue) {
				System.out.println("ChangingWIdth");
				setHmax(newValue.doubleValue());
			}
		});
		change(data);

	}
	*/
	private void change(Pane data){
		this.hvalueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1, Number newValue) {
				if(newValue.doubleValue()==getHmax()){
					data.setPrefSize(data.getPrefWidth()+myWidth*count, data.getPrefHeight());
					setPrefWidth(getPrefWidth()+myWidth*count);
					ImageView myImage=((GamePane) data).getBackgroundImage();
					ImageView copy=new ImageView(myImage.getImage());
					copy.setFitHeight(myImage.getFitHeight());
					copy.setFitWidth(myImage.getFitWidth());
					copy.setPreserveRatio(true);
					copy.setSmooth(true);
					copy.relocate(myWidth*count,0);
					setHmax(getHmax()+myWidth);
					setHvalue(getHmax()-myWidth);
					data.getChildren().add(0,copy);
					count++;
				}

			}

		});
	}
	private double getHorizontal(){
		System.out.println("YIKES"+this.getHmax());
		return this.getHmax();
	}

}