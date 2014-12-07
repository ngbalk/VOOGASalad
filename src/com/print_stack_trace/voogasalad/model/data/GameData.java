package com.print_stack_trace.voogasalad.model.data;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class GameData implements IGameData {
	private Gson gson;
	private String filePath;
	/**
	 * constructor for GameData
	 */
	public GameData() {
		gson = new GsonBuilder().setPrettyPrinting().create();
	}

	private void writeToFile(String s, File file) {
		try {
			System.out.println("name of the file is: " + file.getName());
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(file));
			byte[] stringInBytes = s.getBytes();
			bos.write(stringInBytes);
			bos.flush();
			bos.close();
			System.out.println("wrote file to " + file.getCanonicalPath());
			System.out.println("Test: "
					+ this.getClass().getName().replace(".", "/"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	/**
	 * Takes an object and will save it to the current working directory as a
	 * json representation in a .txt file
	 * 
	 * @param lvl
	 *            - the object to be saved as a json representation
	 * 
	 */
	public void writeLevel(Object o) throws IOException {
		String json = gson.toJson(o);
		String name = System.getProperty("user.dir")
				+ "/src/com/print_stack_trace/voogasalad/model/data/games/"
				+ o.toString() + ".txt";
		File file = new File(name);
		if (file.getCanonicalPath() != null) {
			writeToFile(json, file);
			return;
		}
		throw new IOException(
				"Application did not specify target location to save");
	}

	/**
	 * Will look at the file specified by myFile and then return the object type
	 * that is saved in that file that is specified by c
	 * 
	 * @param myFile
	 *            - the file to be loaded from
	 * @param c
	 *            - the class that is to be returned
	 * 
	 * @return the object type referred to by c saved in myFile
	 */
	public Object loadLevel(File myFile, Class<?> c)
			throws IOException, JsonSyntaxException, ClassNotFoundException {
		filePath = myFile.getPath();
		filePath = filePath.substring(0,filePath.length()-4);
		System.out.println(filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(myFile)));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return gson.fromJson(sb.toString(), c);
	}

	
	public void storeObject(Object o, String property) throws IOException{
		String json = gson.toJson(o);
		String name = filePath + property + ".txt";
		File file = new File(name);
		if (file.getCanonicalPath() != null) {
			writeToFile(json, file);
			return;
		}
		throw new IOException(
				"Application did not specify target location to save");
	}

	public Object getObject(String property, Class<?> c) throws IOException{
		File file = new File(filePath + property + ".txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return gson.fromJson(sb.toString(), c);
	}
	
	
	@Override
	public Map<String, HighScore> getHighScores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveHighScore(String name, HighScore highScore) {
		// TODO Auto-generated method stub
		
	}
	
}
