package com.print_stack_trace.voogasalad.model.data;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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

	private void saveFileMarcus(String s, File file) {
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

	public void writeLevel(Object lvl) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put(lvl.toString(), lvl);
		String json = gson.toJson(lvl);

		System.out.println("gson to Json :" + json);
		File file = new File(System.getProperty("user.dir")
				+ "/src/com/print_stack_trace/voogasalad/model/data/"
				+ lvl.toString() + ".txt");

		if (file.getCanonicalPath() != null) {
			saveFileMarcus(json, file);
			return;
		}
		throw new IOException(
				"Application did not specify target location to save");
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
	public Object loadLevel(BufferedInputStream inputStream, Class<?> cls)
			throws IOException, JsonSyntaxException, ClassNotFoundException {
		Gson gson = new GsonBuilder().create();
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		String json = bytes.toString();
		Object o = cls.cast(gson.fromJson(json, cls));
		return o;
	}

	@Override
	public LevelModel loadLevelMarcus(FileInputStream levelName) throws IOException, JsonSyntaxException, ClassNotFoundException{
		BufferedReader br = new BufferedReader(new InputStreamReader(levelName));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while((line = br.readLine()) != null){
			sb.append(line);
		}
		LevelModel loadedLevel = gson.fromJson(sb.toString(), LevelModel.class);
		System.out.println(loadedLevel.getLevelCharacteristics().getName());
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
