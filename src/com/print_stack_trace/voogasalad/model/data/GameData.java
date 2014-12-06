package com.print_stack_trace.voogasalad.model.data;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class GameData implements IGameData {
	private Map<String, HighScore> highScores = new HashMap<String, HighScore>();
	private Gson gson;
	private String name;

	/**
	 * constructor for GameData
	 */
	public GameData() {
		gson = new Gson();
	}

	private void writeToFile(String s, File file) {
		try {
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
	public void writeLevel(Object lvl) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put(lvl.toString(), lvl);
		String json = gson.toJson(lvl);
		name = System.getProperty("user.dir")
				+ "/src/com/print_stack_trace/voogasalad/model/data/"
				+ lvl.toString() + ".txt";
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
	public Object loadLevel(FileInputStream myFile, Class<?> c)
			throws IOException, JsonSyntaxException, ClassNotFoundException {
		BufferedReader br = new BufferedReader(new InputStreamReader(myFile));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return gson.fromJson(sb.toString(), c);
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
}
