package com.print_stack_trace.voogasalad.model.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public class GameData implements IGameData {
	private Map<String, HighScore> highScores = new HashMap<String, HighScore>();
	private Gson gson;
	/**
	 * constructor for GameData
	 */
	public GameData() {
		gson = new Gson();
	}

	/**
	 * Will take in a level written by authoring environment as a parameter,
	 * write it to a JSON file. location is the directory on user hard drive
	 * that the user selects to save the file
	 * 
	 * @param lvl
	 *            - level created by the authoring environment
	 * @param outputStreawm
	 *            output stream for level to save
	 * @throws IOException
	 */
	@Override
	public void writeLevelMarcus(LevelModel lvl) throws IOException {
			/* Tested out my WriteLevel; The following is its ouput
			 * This is a hero: true
			 *	Object Added ID: 0
			 * gson to Json :{"spriteMap":{"0":{"p":{"x":0.5,"y":10.23,"hash":0},"interactive":true,"objectType":"HERO","health":10,"speed":10.0,"value":0,"directionFacing":""}},"currentID":0,"isLocked":false}
			 * wrote file to C:\Users\Marcus Cain\AppData\Roaming\Microsoft\Windows\Network Shortcuts\json2.txt
			 */
	
		System.out.println(lvl.getLevelCharacteristics().getName());
		
		/* Ensure that levelModel does not contain any javafx objects.
		 * also ensure that objects within levelModel (SpriteCharacteristics) does
		 * not contain any javafx primitive or objets
		 * use transient keyword
		 */
		String json = gson.toJson(lvl);
		System.out.println("gson to Json :" +  json);
		
		/*
		 * Possible workoutaround for gson inability to serialize javafx is to create
		 * classes that extend the javafx class, and implement serialiazable
		 */
		
		/*
		 * 	front end (authoring environment DOES NOT need to know about FILE or Location of FILE -> completely GameData responsibility
		 * 

		 *  store json into a file
		 */
		
		File file = new File(System.getProperty("user.dir")+ "/src/com/print_stack_trace/voogasalad/model/data/" + lvl.getLevelCharacteristics().getName() +".txt");
				
		if(file.getCanonicalPath() != null){
			saveFileMarcus(json,file);
			return;
		}
		throw new IOException("Application did not specify target location to save");
	}

	private void saveFileMarcus(String s, File file) {
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(s);
			fileWriter.close();
			System.out.println("wrote file to " + file.getCanonicalPath());
			System.out.println("Test: " + this.getClass().getName().replace(".", "/"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	public void writeLevel(Object lvl, BufferedOutputStream outputStream)
			throws IOException {
		Gson gson = new GsonBuilder().create();
		Map<String, Object> objMap = new HashMap<String, Object>();
		String json = gson.toJson(lvl);
		byte[] stringInBytes = json.getBytes();
		outputStream.write(stringInBytes);
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * 
	 * @param inputStream
	 *            input stream for level to load
	 * @return an instance of the level model that the game engine or game
	 *         authoring environment will either play or edit
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 * @throws JsonSyntaxException 
	 */
	public Object loadLevel(BufferedInputStream inputStream, Class<?> cls) throws IOException, JsonSyntaxException, ClassNotFoundException {
		Gson gson = new GsonBuilder().create();
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		String json = bytes.toString();
		Object o = cls.cast(gson.fromJson(json, cls));
		return o;
	}
	
	@Override
	public LevelModel loadLevelMarcus(FileInputStream levelName) throws IOException, JsonSyntaxException, ClassNotFoundException{
		//BufferedReader br = new BufferedReader(new FileReader(levelName));
		BufferedReader br = new BufferedReader(new InputStreamReader(levelName));
		LevelModel loadedLevel = gson.fromJson(br.readLine(), LevelModel.class);
		System.out.println(loadedLevel.getLevelCharacteristics().getName());
		SpriteCharacteristics actor = loadedLevel.getSpriteMap().get(0);
		System.out.println("height:" + actor.getHeight());
		System.out.println("width:" + actor.getWidth());
		System.out.println("X: "+ actor.getX());
		System.out.println("Y: " + actor.getY());
		System.out.println("Sprite Name: " + actor.getName());
		return loadedLevel;
	}

	/**
	 * saves the current game being edited by the authoring environment, can
	 * also be used by the engine to update preferences in
	 * 
	 * @param name
	 *            - file that is being overwritten by the save
	 */
	public void saveLevel(String name) {

	}

	/**
	 * adds a new high score to a text file storing the current high scores for
	 * a given level error for now, there is a HighScores class that will be
	 * added when merges take place
	 * 
	 * @param highscore
	 *            - new high score
	 * @param name
	 *            - name of the level that the high score will be associated
	 *            with
	 */
	private void saveHighScores() {// String name) {
		// TODO: name is your job!! You need to put the file in the system
		// directory or something. not the users problem.
		// USE highScores for current the list.
	}

	/**
	 * 
	 * @param name
	 *            - name of the file that the high scores are being loaded for
	 * @return list or text representation of the high scores
	 */
	private void loadHighScores() {// String name) {
		// TODO: name is your job!! You need to put the file in the system
		// directory or something. not the users problem.
		highScores = null; // SET local highScores var once you load;
	}

	public Map<String, HighScore> getHighScores() {
		return highScores;
	}

	public void saveHighScore(String name, HighScore highScore) {
		highScores.put(name, highScore);
		saveHighScores();
	}

	@Override
	public Object loadLevel(BufferedInputStream inputStream, Object o)
			throws IOException, JsonSyntaxException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
