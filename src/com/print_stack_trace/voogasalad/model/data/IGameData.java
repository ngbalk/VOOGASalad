package com.print_stack_trace.voogasalad.model.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import com.google.gson.JsonSyntaxException;

public interface IGameData {
	public void writeLevel(Object lvl) throws IOException;
	public Map<String, HighScore> getHighScores();
	public void saveHighScore(String name, HighScore highScore);
	public Object loadLevel(FileInputStream myFile, Class<?> c) throws IOException, JsonSyntaxException, ClassNotFoundException;

}
