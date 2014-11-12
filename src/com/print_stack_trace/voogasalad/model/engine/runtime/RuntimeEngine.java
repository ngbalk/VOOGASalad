/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/11/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.LevelModel;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public class RuntimeEngine {
	private LevelModel currentLevel;
	//-------------------CONSTRUCTORS-------------------//
	
	/**
	 * Constructor Method.
	 */
	public RuntimeEngine() {
		//TODO: Implement Constructor
	}
	
	public RuntimeEngine(LevelModel currentLevel) {
		//TODO: Implement Constructor
	}
	
	//-------------------PUBLIC METHODS-------------------//
		
	/**
	 * 
	 * @param currentLevel
	 */
	public void update(LevelModel currentLevel) {
		
	}
		
	//GAME AUTHORING
	
	
	//GAME PLAYER
	
	public RuntimeModel getStatus() {
		RuntimeModel ret = new RuntimeModel();
		/*TODO: Implement -- this is looks like an accessor to everyone else but
		 *a RuntimeModel should be created at the time it is called and built 
		 *from all of the various at time of call. */
		return ret;
	}
	
	
	//-------------------ACCESSORS-------------------//
	
	
	//-------------------PRIVATE METHODS-------------------//
	
}
