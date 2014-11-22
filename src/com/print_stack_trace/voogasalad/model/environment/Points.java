package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class Points extends Goal implements GoalElement{
    
    private int myPoints;

    public Points (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
        // TODO Auto-generated constructor stub
    }


    
    @Override
    protected void setGoalProperties() {
        myPoints = myGoalCharacteristics.myPointTotal;
        
    }



	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);		
	}

}
