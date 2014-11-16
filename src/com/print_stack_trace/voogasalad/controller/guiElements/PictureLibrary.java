package com.print_stack_trace.voogasalad.guiElements;

import java.io.InputStream;
import java.util.Properties;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.JOptionPane;

public class PictureLibrary extends AbstractLibraryPane{
	public PictureLibrary(Number width, Number height, String resources) {
		super(width, height, resources);
	}
	private String DEFAULT_RESOURCE;
	@Override
	protected void loadAndAddData() {
		try {
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream(myResources);
			prop.load(stream);
			for(Object pictureName : prop.keySet()){
				Image myImage=new Image(prop.getProperty((String) pictureName));
				ImageView myView=new ImageView(myImage);
				myView.setFitHeight(100);
				myView.setFitHeight(100);
				myView.setPreserveRatio(true);
				myView.setSmooth(true);
				myView.setVisible(true);
				this.getChildren().add(myView);
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}
	
}
