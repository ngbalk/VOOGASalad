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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class KeyFramePopUpPane extends GeneralPane {
	private KeyFrameBox myBox;
	private Label myCurrentKey;
	private Pane keyFramePane;
	private Pane picturePane;
	private SpriteObject mySprite;
	private HashMap<PossibleSpriteAction, ArrayList<Image>> myAnimations=new HashMap<PossibleSpriteAction, ArrayList<Image>>();
	public KeyFramePopUpPane(SpriteObject object){
		super();
		mySprite=object;
		picturePane=new Pane();
		makeMovementMap();
		this.getStylesheets().add("./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css");
		setPrefSize(this.getPrefWidth(), this.getPrefHeight());
		myBox=new KeyFrameBox(myAnimations,this.getPrefWidth(), this.getPrefHeight()*.1);
		currentKeyFramePane();
		picturePane.relocate(0,myBox.getPrefHeight());
		picturePane.setPrefSize(this.getPrefWidth(), this.getPrefHeight()-myBox.getPrefHeight()-keyFramePane.getPrefHeight());
		this.setStyle("-fx-background-color:BLACK; -fx-border-color: BLUE");
		this.getChildren().addAll(myBox, picturePane);

	}
	private void makeMovementMap(){
		for (PossibleSpriteAction action: PossibleSpriteAction.values()){
			myAnimations.put(action, new ArrayList());
		}
	}
	public void currentKeyFramePane(){
		keyFramePane=new Pane();
		keyFramePane.setStyle("-fx-background-color: BLACK");
		keyFramePane.setPrefSize(this.getPrefWidth(), this.getPrefHeight()*.3);
		keyFramePane.relocate(0, this.getPrefHeight()-this.getPrefHeight()*.3);
		getChildren().add(keyFramePane);
		this.addCurrentKeyLabel(keyFramePane);
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
		addButton.setPrefSize(pane.getPrefWidth()/5, pane.getPrefHeight()/2);
		addButton.setOnAction(e->myBox.addKeyFrame());
		pane.getChildren().addAll(addButton, myCurrentKey);
		ImageUpload imageButton=new ImageUpload();
		imageButton.getType().relocate(pane.getPrefWidth()/4*3, pane.getPrefHeight()/4);
		imageButton.getType().getStyleClass().add("buttonTemplate");
		((Button) imageButton.getType()).setPrefSize(pane.getPrefWidth()/5, pane.getPrefHeight()/2);
		((Button)imageButton.getType()).setOnAction(e->addKeyImage(imageButton.doAction()));
		pane.getChildren().add(imageButton.getType());
	}
	private void setObservable(){
		myBox.getCurrentKeyFrame().addListener(new ChangeListener<KeyFrameBlock>(){
			@Override
			public void changed(ObservableValue<? extends KeyFrameBlock> arg0,
					KeyFrameBlock oldFrame, KeyFrameBlock newFrame) {
				myCurrentKey.setText("Current KeyFrame: "+ newFrame.getTag()+newFrame.getIndex());	
				addKeyImage(newFrame.getImage());
				
			}
		});
	}
	private void setCurrentKeyImage(Image img){
		myBox.getCurrentKeyFrame().getValue().setImage(img);
		for (PossibleSpriteAction action: PossibleSpriteAction.values()){
			if (action.name().equals(myBox.getCurrentKeyFrame().getValue().getName())&&img!=null){
				mySprite.getCharacteristics().addAnimation(action,(myBox.getCurrentKeyFrame().getValue().getIndex()-1), img);
				mySprite.getDelegate().update(mySprite);
			}
		}
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
	private void setImageObservable(){

	}
	private void addKeyImage(Image img){
		ImageView myView=new ImageView(img);
		myView.setFitHeight(picturePane.getPrefHeight()/2);
		myView.setFitWidth(picturePane.getPrefWidth()/2);
		myView.setPreserveRatio(true);
		myView.relocate(picturePane.getPrefWidth()/2-myView.getFitWidth()/2, picturePane.getPrefHeight()/2-myView.getFitHeight()/2);
		picturePane.getChildren().clear();
		picturePane.getChildren().add(myView);
		setCurrentKeyImage(myView.getImage());

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
