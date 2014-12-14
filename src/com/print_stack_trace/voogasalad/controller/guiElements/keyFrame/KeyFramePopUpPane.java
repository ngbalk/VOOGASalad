package com.print_stack_trace.voogasalad.controller.guiElements.keyFrame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.imageio.ImageIO;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.GeneralPane;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.ImageUpload;
import com.print_stack_trace.voogasalad.controller.popUpPanes.MessagePopUp;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;
import com.print_stack_trace.voogasalad.utilities.fileloading.FileLoadUtility;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;


public class KeyFramePopUpPane extends GeneralPane {
	private KeyFrameBox myBox;
	private Label myCurrentKey;
	private Pane keyFramePane;
	private Pane picturePane;
	private SpriteObject mySprite;
	private HashMap<KeyResult, ArrayList<File>> myAnimations=new HashMap<KeyResult, ArrayList<File>>();
	public KeyFramePopUpPane(GameObject object){
		super();
		Pane mainPane=new Pane();
		myNode=mainPane;
		mySprite=(SpriteObject) object;
		picturePane=new Pane();
		makeMovementMap();
		((Pane)myNode).getStylesheets().add("./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css");
		setPrefSize(this.getPrefWidth(), this.getPrefHeight());
		myBox=new KeyFrameBox(myAnimations,this.getPrefWidth(), this.getPrefHeight()*.1);
		currentKeyFramePane();
		this.setStyle("-fx-background-color:BLACK; -fx-border-color: BLUE");
		this.getChildren().addAll(myBox, picturePane);
		myCurrentKey.setText("Current KeyFrame: "+ myBox.getCurrentKeyFrame().
				getValue().getTag()+myBox.getCurrentKeyFrame().getValue().getIndex());	
		addKeyImage(myBox.getCurrentKeyFrame().getValue().getImagePath());
		picturePane.relocate(0,myBox.getPrefHeight());
		picturePane.setPrefSize(this.getPrefWidth(), this.getPrefHeight()-myBox.getPrefHeight()-keyFramePane.getPrefHeight());
		mainPane.getChildren().addAll(picturePane, keyFramePane, myBox);
		mainPane.setPrefSize(GeneralPane.DEFAULT_WIDTH,GeneralPane.DEFAULT_HEIGHT);
		this.initiate();
	}
	private void makeMovementMap(){
		for (KeyResult action: KeyResult.values()){
			myAnimations.put(action, mySprite.getCharacteristics().getAnimationPath(action));
		}
	}
	public void currentKeyFramePane(){
		keyFramePane=new Pane();
		keyFramePane.setStyle("-fx-background-color: BLACK");
		keyFramePane.setPrefSize(this.getPrefWidth(), this.getPrefHeight()*.3);
		keyFramePane.relocate(0, this.getPrefHeight()-this.getPrefHeight()*.3);
		this.addCurrentKeyLabel(keyFramePane);
	}
	
	private void addCurrentKeyLabel(Pane pane){
		pane.getChildren().addAll(makeAddButton(pane), makeCurrentKeyLabel(pane), makeImageButton(pane));
		setCurrentKeyObservable();
	}
	
	private Label makeCurrentKeyLabel(Pane pane){
		myCurrentKey=new Label("Current KeyFrame: "+ myBox.getCurrentKeyFrame().getValue().getTag()+myBox.getCurrentKeyFrame().getValue().getIndex());
		myCurrentKey.setTextFill(Paint.valueOf("WHITE"));
		myCurrentKey.relocate(0, 0);
		myCurrentKey.setPrefSize(pane.getPrefWidth()/2, pane.getPrefHeight());
		return myCurrentKey;
	}
	
	private Button makeImageButton(Pane pane){
		ImageUpload imageButton=new ImageUpload();
		imageButton.relocate(pane.getPrefWidth()/4*3, pane.getPrefHeight()/4);
		imageButton.getStyleClass().add("buttonTemplate");
		imageButton.setPrefSize(pane.getPrefWidth()/5, pane.getPrefHeight()/2);
		imageButton.setOnAction(e->addKeyImage(imageButton.doAction()));
		return imageButton;
	}
	
	private Button makeAddButton(Pane pane){
		Button addButton=new Button();
		addButton.setText("Add KeyFrame");
		addButton.relocate(pane.getPrefWidth()/2, pane.getPrefHeight()/4);
		addButton.getStyleClass().add("buttonTemplate");
		addButton.setPrefSize(pane.getPrefWidth()/5, pane.getPrefHeight()/2);
		addButton.setOnAction(e->add());
		return addButton;
	}
	
	private void setCurrentKeyObservable(){
		myBox.getCurrentKeyFrame().addListener(new ChangeListener<KeyFrameBlock>(){
			@Override
			public void changed(ObservableValue<? extends KeyFrameBlock> arg0,
					KeyFrameBlock oldFrame, KeyFrameBlock newFrame) {
				myCurrentKey.setText("Current KeyFrame: "+ newFrame.getTag()+" "+newFrame.getIndex());	
				addKeyImage(newFrame.getImagePath());

			}
		});
	}
	
	private void add(){
		myBox.addKeyFrame();
		setCurrentKeyImage(null, null);
	}
	
	private void setCurrentKeyImage(Image img, File imagePath){
		myBox.getCurrentKeyFrame().getValue().setImage(img);
		myBox.getCurrentKeyFrame().getValue().setImagePath(imagePath);
		for (KeyResult action: KeyResult.values()){
			if (action.name().equals(myBox.getCurrentKeyFrame().getValue().getName())&&img!=null){
				mySprite.getCharacteristics().addAnimation(action,(myBox.getCurrentKeyFrame().getValue().getIndex()-1), imagePath);
				mySprite.update();
			}
		}
	}
	
	@Override
	public void createTextFields() {
	}
	@Override
	public void makeObservable(Collection toObserve) {}
	@Override
	public void loadInData(Collection myData) {}
	private void setImageObservable(){}
	
	private void addKeyImage(File imgPath){
		BufferedImage buffer;
		Image img=null;
		
		if (imgPath!=null){
			try {
				buffer = ImageIO.read(imgPath);
				img=SwingFXUtils.toFXImage(buffer, null);
			} catch (IOException e) {
				new MessagePopUp().showMessageDialog("Couldn't upload Image");
				return;
			}
		}
		ImageView myView=setImageStyle(img);
		myView.relocate(picturePane.getPrefWidth()/2-myView.getFitWidth()/2, picturePane.getPrefHeight()/2-myView.getFitHeight()/2);
		picturePane.getChildren().clear();
		picturePane.getChildren().add(myView);
		setCurrentKeyImage(myView.getImage(), imgPath);
	}
	
	private ImageView setImageStyle(Image img){
		ImageView myView=new ImageView(img);
		myView.setFitHeight(picturePane.getPrefHeight()/2);
		myView.setFitWidth(picturePane.getPrefWidth()/2);
		myView.setPreserveRatio(true);
		return myView;
	}
	
	public Image setImageOnAction(){
		return FileLoadUtility.loadImage();
	}
	private String iterate(Iterator<String> myValueIterator){
		return (myValueIterator.hasNext())? myValueIterator.next():null;
	}
}
