/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 12/13/14
 */
package com.print_stack_trace.voogasalad.model.engine.runtime;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameWorldModel;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

/**
 * This interface serves as the blueprint for how runtime Engines
 * should work. Our specific implementation for runtime engines is 
 * contained within the RuntimeEngine.java class. Each runtime engine
 * should be able to update itself and return a RuntimeModel, the
 * runtime equivalent of a LevelModel for the front end, through the
 * getStatus() method.
 */
public interface IRuntimeEngine {
	
	/**
	 * This method updates the level during runtime.
	 */
	void update();
	
	/**
	 * Packages the current runtime data into a RuntimeModel class,
	 * which is passed to the front end for visualization. This separates
	 * back end data and operations from the front end.
	 * @return an instance of RuntimeModel
	 */
	RuntimeModel getStatus();
}
