package com.print_stack_trace.voogasalad.controller.player;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyEvent;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.player.Score;
import com.print_stack_trace.voogasalad.utilities.reflection.Reflection;

public class PlayerToolBar extends ToolBar {

	private static final String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/";
	private static final String DEFAULT_CLASS_PATH="com.print_stack_trace.voogasalad.controller.guiElements.buttons.";
	private static final String ELEMENT_RESOURCE_NAME="PlayerGUIElements";
	private static final String LABEL_RESOURCE_NAME="PlayerGUILabels";
	
	public PlayerToolBar(GamePlayer gamePlayer){
		Properties classProp = new Properties();
		Properties labelProp = new Properties();
		InputStream classStream = getClass().getClassLoader().getResourceAsStream(DEFAULT_RESOURCE+ELEMENT_RESOURCE_NAME+".Properties");
		InputStream labelStream = getClass().getClassLoader().getResourceAsStream(DEFAULT_RESOURCE+LABEL_RESOURCE_NAME+".Properties");
		try { 
			classProp.load(classStream);
			labelProp.load(labelStream);
			Iterator iterator = classProp.keySet().iterator();
			while(iterator.hasNext()){
				Object key = iterator.next();
				String className = (String) classProp.get(key);
				className = DEFAULT_CLASS_PATH + className; 
				Object newClass = Reflection.createInstance(className, gamePlayer);
				newClass.getClass().getMethod("setLabel", String.class).invoke(newClass, labelProp.get(key));
				this.getItems().add((Node) newClass);
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}