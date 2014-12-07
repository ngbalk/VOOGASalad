package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

public class Goal implements GoalElement {
	public boolean isCompleted = false;
    
    protected GoalCharacteristics myGoalCharacteristics;
    protected GoalType myGoalType;
    
    
    public Goal(GoalCharacteristics goalCharacteristics) {
        myGoalCharacteristics = goalCharacteristics;
        setGoalProperties();
    }
    
    protected void setGoalProperties() {
        myGoalType = myGoalCharacteristics.myGoalType;
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
    
}
