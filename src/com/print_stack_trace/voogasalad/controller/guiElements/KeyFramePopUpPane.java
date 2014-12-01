package com.print_stack_trace.voogasalad.controller.guiElements;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.SpriteMovement.PossibleSpriteAction;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class KeyFramePopUpPane extends GeneralPane {
	private KeyFrameBox myBox;
	private Label myCurrentKey;
	private HashMap<PossibleSpriteAction, ArrayList<Image>> myAnimations=new HashMap<PossibleSpriteAction, ArrayList<Image>>();
	public KeyFramePopUpPane(){
		super();
		makeMovementMap();
		this.getStylesheets().add("./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css");
		setPrefSize(this.getPrefWidth(), this.getPrefHeight());
		myBox=new KeyFrameBox(myAnimations,this.getPrefWidth(), this.getPrefHeight()*.1);
		this.getChildren().add(myBox);
		currentKeyFramePane();
	}
	private void makeMovementMap(){
		for (PossibleSpriteAction action: PossibleSpriteAction.values()){
			myAnimations.put(action, new ArrayList());
		}
	}
	public void currentKeyFramePane(){
		Pane myPane=new Pane();
		myPane.setStyle("-fx-background-color: BLACK");
		myPane.setPrefSize(this.getPrefWidth(), this.getPrefHeight()*.2);
		myPane.relocate(0, this.getPrefHeight()-this.getPrefHeight()*.2);
		getChildren().add(myPane);
		this.addCurrentKeyLabel(myPane);
	}
	private void addCurrentKeyLabel(Pane pane){
		myCurrentKey=new Label("Current KeyFrame: "+ myBox.getCurrentKeyFrame().getValue().getTag()+myBox.getCurrentKeyFrame().getValue().getIndex());
		myCurrentKey.setTextFill(Paint.valueOf("WHITE"));
		myCurrentKey.relocate(0, 0);
		myCurrentKey.setPrefSize(pane.getPrefWidth()/2, pane.getPrefHeight());
		setObservable();
		Button addButton=new Button();
		addButton.setText("Add KeyFrame");
		addButton.relocate(pane.getPrefWidth()/2, pane.getPrefHeight()/4);
		addButton.getStyleClass().add("buttonTemplate");
		addButton.setPrefSize(pane.getPrefWidth()/3, pane.getPrefHeight()/2);
		addButton.setOnAction(e->myBox.addKeyFrame());
		pane.getChildren().addAll(addButton, myCurrentKey);
		Button imageButton=new Button();
		imageButton.setText("Choose Image");
	}
	private void setObservable(){
		myBox.getCurrentKeyFrame().addListener(new ChangeListener<KeyFrameBlock>(){
			@Override
			public void changed(ObservableValue<? extends KeyFrameBlock> arg0,
					KeyFrameBlock oldFrame, KeyFrameBlock newFrame) {
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
	public void setImageOnAction(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("./"));
		File file = fileChooser.showOpenDialog(new Stage());
		if(file != null&&(file.getName().toUpperCase().contains(".JPG")||file.getName().toUpperCase().contains(".PNG")||file.getName().toUpperCase().contains(".JPEG"))){
			BufferedImage buffer;
			try {
				buffer = ImageIO.read(file);
				Image img=SwingFXUtils.toFXImage(buffer, null);

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Please select another file");
			}
		}

	}

}
