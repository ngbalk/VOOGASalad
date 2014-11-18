package com.print_stack_trace.voogasalad.model.environment;

import javafx.geometry.Point2D;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class ReachDistance extends Goal implements GoalElement{
    
    private Point2D myDestination;

    public ReachDistance (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
        // TODO Auto-generated constructor stub
    }


    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        myDestination = myGoalCharacteristics.myDestination;

    }

	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
		
	}

}
