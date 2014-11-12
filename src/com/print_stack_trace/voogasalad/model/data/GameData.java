package com.print_stack_trace.voogasalad.model.data;

import java.lang.reflect.Type;

import com.print_stack_trace.voogasalad.model.LevelModel;

public class GameData {
	
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
	 * 
	 * @param name
	 *            - name of the file to be saved
	 */
	public void writeLevel(LevelModel lvl, String location, String name) {

	}

	/**
	 * 
	 * @param fileName
	 *            name of the game that the user wants
	 * @return an instance of the level model that the game engine or game
	 *         authoring environment will either play or edit
	 */
	public LevelModel loadLevel(String fileName) {
		return null;

	}

	/**
	 * saves the current game being edited by the authoring environment, can
	 * also be used by the engine to update preferences in
	 * 
	 * @param name
	 *            - ile that is being overwritten by the save
	 */
	public void saveLevel(String name) {

	}
}
