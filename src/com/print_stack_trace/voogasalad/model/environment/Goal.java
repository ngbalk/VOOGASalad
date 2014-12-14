package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;
/**
 * 
 * @author Ethan Chang, Jack Baskin, Nick Widmaier
 * 
 * This class is a superclass from which any specific type of goal
 * would extend from. Every goal also implements GoalElement, meaning
 * each goal would implement a method that takes in a GoalChecker and checks
 * if the goal is completed. In essence, this meand our goals are checked 
 * using our implementation of the visitor pattern. Each instance of a Goal
 * is created via a GoalFactory in the LevelModel class, based off the
 * GoalCharacteristics that are set by the user and passed by the front
 * end. Each goal is then stored in a map within that LevelModel. Each goal
 * can then be checked at runtime to see if it is completed.
 *
 */
public abstract class Goal implements GoalElement {
	public boolean isCompleted = false;
    public GoalCharacteristics myGoalCharacteristics;
    public GoalType myGoalType;
    
    /**
     * Constructor to initialize a new instance of a goal
     * @param goalCharacteristics the characteristics of the particular goal
     * being created which are set by the user in the authoring environment
     */
    public Goal(GoalCharacteristics goalCharacteristics) {
        myGoalCharacteristics = goalCharacteristics;
        setGoalProperties();
    }
    
    /**
     * Sets the instance variables for each goal using the values
     * from the GoalCharacteristics used to make the goal
     * Overridden by subclasses to include more variables to be set
     */
    protected void setGoalProperties() {
        myGoalType = myGoalCharacteristics.myGoalType;
    }
    
    /**
     * Used if the user wants to change a previously created goal in any way
     * They simply set new values for the goal, and the front end passes back another
     * GoalCharacteristics allowing the goal to be changed in LevelModel
     * @param goalCharacteristics the new characteristics the user wants associated with
     * a previously created goal
     * @return true? can this be changed to void?
     */
    public boolean updateGoalCharacteristics(GoalCharacteristics goalCharacteristics) {
        myGoalCharacteristics = goalCharacteristics;
        setGoalProperties();
        return true;
    }

	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
	}
    
    public GoalCharacteristics getGoalCharacteristics() {
		return myGoalCharacteristics;
	}

	public GoalType getGoalType() {
		return myGoalType;
	}

}
