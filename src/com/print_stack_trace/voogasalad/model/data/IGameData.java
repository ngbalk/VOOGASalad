package com.print_stack_trace.voogasalad.model.data;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.google.gson.JsonSyntaxException;

public interface IGameData {
	public void write(Object obj) throws IOException;
	public Object load(File myFile, Class<?> c) throws IOException, JsonSyntaxException, ClassNotFoundException;
	public void storeObject(Object obj, String property) throws IOException;
	public Object getObject(String property, Class<?> c) throws IOException;
}
