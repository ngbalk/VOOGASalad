package com.print_stack_trace.voogasalad.model.environment;

import javafx.geometry.Point2D;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class ReachYDistance extends Goal implements GoalElement{
    
    private double myYDestination;
    private Integer myHeroID;

    public ReachYDistance (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
    }

    public double getYDestination() {
        return myYDestination;
    }
    
    public Integer getHeroID() {
        return myHeroID;
    }
    
    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        myYDestination = myGoalCharacteristics.myDestination.getY();
        myHeroID = myGoalCharacteristics.myObjectID;
    }

	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
		
	}

}
