package com.print_stack_trace.voogasalad.model;

import java.io.File;

import javafx.scene.image.Image;

public class LevelCharacteristics {
	private String name;
	public File nextLevel = null;
	public Image backgroundImg = null;
	public int requiredNumberOfGoals = 0;
	//TODO: More...
	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}
