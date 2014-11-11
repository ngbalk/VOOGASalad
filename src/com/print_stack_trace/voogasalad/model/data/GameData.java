package com.print_stack_trace.voogasalad.model.data;

import java.lang.reflect.Type;

import com.print_stack_trace.voogasalad.model.LevelModel;

public class GameData {
	public GameData() {

	}

	/**
	 * Will take in a level written by authoring environment as a parameter,
	 * write it to a JSON file
	 * 
	 * @param lvl
	 */
	public void writeLevel(LevelModel lvl) {

	}

	/**
	 * GamePlayer pushing gameinfo
	 */
	public void writeGameData() {

	}

	/**
	 * Will convert a src object, with its type paramter, into its equivalent
	 * JSON representation to be saved
	 * 
	 * @param src
	 * @param typeOfSrc
	 * @return
	 */
	public String toJson(Object src, Type typeOfSrc) {
		return null;

	}
}
