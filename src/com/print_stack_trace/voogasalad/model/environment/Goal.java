package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

public abstract class Goal implements GoalElement {
	public boolean isCompleted = false;
    public GoalCharacteristics myGoalCharacteristics;
    public GoalType myGoalType;
    
    public Goal(GoalCharacteristics goalCharacteristics) {
        myGoalCharacteristics = goalCharacteristics;
        setGoalProperties();
    }
    
    protected void setGoalProperties() {
        myGoalType = myGoalCharacteristics.getMyGoalType();
    }
    
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
