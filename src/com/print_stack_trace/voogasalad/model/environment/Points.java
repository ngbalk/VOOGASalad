package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class Points extends Goal implements GoalElement{
    
    public int reqPoints;

    public Points (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
    }


    
    @Override
    protected void setGoalProperties() {
    	reqPoints = myGoalCharacteristics.getPointsTotal();
        
    }



	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);		
	}

}
