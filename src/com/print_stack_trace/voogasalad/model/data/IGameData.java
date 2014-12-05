package com.print_stack_trace.voogasalad.model.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public interface IGameData {
	public void writeLevel(Object lvl) throws IOException;
	public Object loadLevel(BufferedInputStream inputStream, Object o) throws IOException, JsonSyntaxException, ClassNotFoundException;
	public void saveLevel(String name);
	public Object loadLevel(BufferedInputStream inputStream, Class<?> cls) throws IOException, JsonSyntaxException, ClassNotFoundException;
	public Map<String, HighScore> getHighScores();
	public void saveHighScore(String name, HighScore highScore);
	public void writeLevelMarcus(LevelModel lvl) throws IOException;
	public LevelModel loadLevelMarcus(FileInputStream myFile) throws IOException, JsonSyntaxException, ClassNotFoundException;

}
