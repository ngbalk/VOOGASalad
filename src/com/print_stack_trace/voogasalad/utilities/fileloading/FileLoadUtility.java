/**
 * @author Pranava Raparla
 */

package com.print_stack_trace.voogasalad.utilities.fileloading;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.exceptions.InvalidImageFileException;
import com.print_stack_trace.voogasalad.exceptions.InvalidTextFileException;

/**
 * This class provides a variety of convenience methods for loading files.
 * A variety of methods can be called depending on the desired file and 
 * knowledge of local directories. The methods are written such that they
 * do not require repeated code .
 */

public class FileLoadUtility {
	
	/**
	 * The default variables include sets for file extension groups and paths.
	 * These are used in subcalls for the argumentless method calls.
	 */
	public static final HashSet<String> DEFAULT_IMAGE_EXTENTIONS = new HashSet<String>(Arrays.asList(".JPG",".PNG","JPEG"));
	public static final HashSet<String> DEFAULT_TEXT_EXTENTIONS = new HashSet<String>(Arrays.asList(".TXT",".MD"));
	public static final String DEFAULT_DIRECTORY_PATH = "./";
	
    /**
     * Given a default String representing the local directory path, returns
     * an initialized instance of the corresponding File using default
     * File constructor. Returns null if string does not name a valid path.
     */
	public static File loadFile(){
		return loadFile(DEFAULT_DIRECTORY_PATH);
	}
	
    /**
     * Given a String representing the local directory path, returns
     * an initialized instance of the corresponding File using default
     * File constructor. Returns null if string does not name a valid path.
     */
	public static File loadFile(String directoryPath) {
		Stage stage=new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select File");
		fileChooser.setInitialDirectory(new File(directoryPath));
		File file = fileChooser.showOpenDialog(stage);
		return file;
	}
	
    /**
     * Given a default String representing the local directory path, returns
     * an initialized instance of the corresponding Text File using default
     * File constructor. Returns null if string does not name a valid path.
     */
	public static File loadTextFile() {
		return loadTextFile(DEFAULT_DIRECTORY_PATH);
	}
	
    /**
     * Given a String representing the local directory path, returns
     * an initialized instance of the corresponding Text File using default
     * File constructor. Returns null if string does not name a valid path.
     */
	public static File loadTextFile(String directoryPath) {
		File file = loadFile(directoryPath);
		if(file != null && !DEFAULT_TEXT_EXTENTIONS.contains(file.getName().toUpperCase())) {
			file = null;
			ViewController.displayError(new InvalidTextFileException());
		}
		return file;
	}
	
    /**
     * Given a String representing the local directory path, returns
     * an initialized instance of the corresponding Image File using default
     * File constructor. Returns null if string does not name a valid path.
     */
	public static File loadImageFile(String directoryPath) {
		File file = loadFile(directoryPath);
		if(file != null && !DEFAULT_IMAGE_EXTENTIONS.contains(file.getName().toUpperCase())) {
			file = null;
			ViewController.displayError(new InvalidImageFileException());
		}
		return file;
	}
	
    /**
     * Given a default String representing the local directory path, returns
     * an initialized instance of the corresponding Image File using buffered
     * and JavaFX Image constructors. Returns null if string does not name a 
     * valid path to an Image.
     */
	public static Image loadImage() {
		return loadImage(DEFAULT_DIRECTORY_PATH);
	}
	
    /**
     * Given a String representing the local directory path, returns
     * an initialized instance of the corresponding Image File using buffered
     * and JavaFX Image constructors. Returns null if string does not name a 
     * valid path to an Image.
     */
	public static Image loadImage(String directoryPath) {
		File file = loadImageFile(directoryPath);
		if(file != null) {
			try {
				return SwingFXUtils.toFXImage(ImageIO.read(file), null);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Please select another Image file");
				ViewController.displayError(new InvalidImageFileException());
			}
		}
		return null;
	}
}
