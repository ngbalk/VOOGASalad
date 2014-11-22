package com.print_stack_trace.voogasalad.model.environment;

import javafx.geometry.Point2D;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class ReachXDistance extends Goal implements GoalElement{
    
    private double myXDestination;
    private Integer myHeroID;

    public ReachXDistance (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
    }

    public double getXDestination() {
        return myXDestination;
    }
    
    public Integer getHeroID() {
        return myHeroID;
    }

    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        myXDestination = myGoalCharacteristics.myDestination.getX();
        myHeroID = myGoalCharacteristics.myObjectID;

    }

	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
		
	}

}
