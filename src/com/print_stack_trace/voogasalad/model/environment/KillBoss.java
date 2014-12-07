package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class KillBoss extends Goal implements GoalElement{
    
    
    public KillBoss (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
    }


    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        
    }


	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
		
	}
    
}
