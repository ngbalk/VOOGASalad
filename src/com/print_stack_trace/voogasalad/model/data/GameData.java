package com.print_stack_trace.voogasalad.model.data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public class GameData {
	private Map<String, HighScore> highScores = new HashMap<String, HighScore>();

	/**
	 * constructor for GameData
	 */
	public GameData() {

	}

	/**
	 * Will take in a level written by authoring environment as a parameter,
	 * write it to a JSON file. location is the directory on user hard drive
	 * that the user selects to save the file
	 * 
	 * @param lvl
	 *            - level created by the authoring environment
	 * @param location
	 *            - provides the location ont he hard drive to store the file
	 * @param name
	 *            - name of the file to be saved
	 */
	public void writeLevel(LevelModel lvl, String location, String name) throws IOException {

	}

	/**
	 * 
	 * @param fileName
	 *            name of the game that the user wants
	 * @return an instance of the level model that the game engine or game
	 *         authoring environment will either play or edit
	 */
	public LevelModel loadLevel(String fileName) throws FileNotFoundException {
		return null;

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
	private void saveHighScores(){//String name) {
		//TODO: name is your job!! You need to put the file in the system directory or something. not the users problem.
		//USE highScores for current the list.
	}
	
	

	/**
	 * 
	 * @param name
	 *            - name of the file that the high scores are being loaded for
	 * @return list or text representation of the high scores
	 */
	private void loadHighScores(){//String name) {
		//TODO: name is your job!! You need to put the file in the system directory or something. not the users problem.
		highScores = null; //SET local highScores var once you load;
	}
	
	public Map<String, HighScore> getHighScores() {
		return highScores;
	}
	
	public void saveHighScore(String name, HighScore highScore) {
		highScores.put(name, highScore);
		saveHighScores();
	}
}
