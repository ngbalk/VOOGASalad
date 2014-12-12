package com.print_stack_trace.voogasalad.model.data;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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

	private void writeToFile(String content, String fileName) {
		try {
			File file = new File(fileName);
			System.out.println("name of the file is: " + file.getName());
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(file));
			byte[] stringInBytes = content.getBytes();
			bos.write(stringInBytes);
			bos.flush();
			bos.close();
			System.out.println("wrote file to " + file.getCanonicalPath());
			System.out.println("Test: "
					+ this.getClass().getName().replace(".", "/"));

		} catch (IOException e) {
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
	public void write(Object o) {
		filePath = System.getProperty("user.dir")
				+ "/src/com/print_stack_trace/voogasalad/model/data/"
				+ o.toString() + ".txt";
		writeToFile(gson.toJson(o), filePath);
	}

	/**
	 * Takes in an object and stores that object as a json representation and
	 * will label it with the associated property. The file that it is being
	 * saved to is an extension of the file that is currently loaded, hence this
	 * will just save a file that is associated with a main file.
	 * 
	 * @param o
	 *            - The object to be stored
	 * @param property
	 *            - a short modifier that is used to describe this particular
	 *            object for the purpose of the current open file.
	 */

	public void storeObject(Object o, String property) throws IOException {
		filePath = filePath + property + ".txt";
		writeToFile(gson.toJson(o), filePath);
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
	public Object load(File myFile, Class<?> c) throws IOException,
			JsonSyntaxException, ClassNotFoundException {
		filePath = myFile.getPath();
		System.out.println(filePath);
		filePath = filePath.substring(0, filePath.length() - 4);
		return convertFromFile(c, myFile);
	}

	/**
	 * Returns an associated object that has been saved under the certain
	 * property as a particular class.
	 * 
	 * @param property
	 *            - the modifier that is used to describe how this particular
	 *            object refers to the current file
	 * @param c
	 *            - the class of the object that is to be returned
	 */

	public Object getObject(String property, Class<?> c) throws IOException {
		File myFile = new File(filePath + property + ".txt");
		return convertFromFile(c, myFile);
	}

	private Object convertFromFile(Class<?> c, File file)
			throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return gson.fromJson(sb.toString(), c);
	}

}
