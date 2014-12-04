package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

public class PictureLibrary extends AbstractLibraryPane{
	private int myRows;
	private int myColumns;
	private int pictureSize=100;
	private int currentRow=0;
	private int currentColumn=0;
	public PictureLibrary(Number width, Number height,Pane otherPane) {
		super(width, height, otherPane);
		myColumns=width.intValue()/pictureSize;
		myRows=height.intValue()/pictureSize;
		this.setStyle("-fx-background-color: BLACK");
	}

	@Override
	protected void loadAndAddData() {
		try {
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream(myResources);
			prop.load(stream);
			for (Object pictureName: prop.keySet()){
				String imagePath=split(prop.getProperty((String) pictureName));
				Image image=new Image(imagePath);
				ImageView myView=(ImageView) makeImageView(image);
				myView.setOnMousePressed(event->addToOtherPane(image, imagePath));
				addImageToGrid(myView);
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}

	protected void addToOtherPane(Image image, String imagePath){
		GamePane gamerPane=(GamePane)myMainPane;
		if (gamerPane.isReady()){
			gamerPane.addGameObject((ImageView) makeImageView(image), imagePath);
		};

	}

	protected void addImageToGrid(ImageView imgView){
		this.addRow(currentRow, imgView);
		if (++currentColumn>myColumns){
			currentRow++;
			currentColumn=0;
			return;
		}
		else if (currentRow>myRows&&currentColumn>myColumns){
			JOptionPane.showMessageDialog(null, "Can't add any more photos");
		}
		else{
			currentColumn++;
		}
	}
	protected Node makeImageView(Image myImage){
		ImageView myView=new ImageView(myImage);
		myView.setFitHeight(pictureSize);
		myView.setFitWidth(pictureSize);
		myView.setPreserveRatio(true);
		myView.setSmooth(true);
		myView.setVisible(true);
		return myView;
	}
	private String split(String value){
		String[] values=value.split(";");
		Iterator<String> nextValue=Arrays.asList(values).iterator();
		nextValue.next();
		return nextValue.next();
	}
}
