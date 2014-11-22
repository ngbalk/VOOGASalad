package com.print_stack_trace.voogasalad.model.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public interface AbstractGameData {
	public void writeLevel(Object lvl, BufferedOutputStream outputStream) throws IOException;
	public Object loadLevel(BufferedInputStream inputStream, Object o) throws IOException, JsonSyntaxException, ClassNotFoundException;
	public void saveLevel(String name);
	public Map<String, HighScore> getHighScores();
	public void saveHighScore(String name, HighScore highScore);
}
