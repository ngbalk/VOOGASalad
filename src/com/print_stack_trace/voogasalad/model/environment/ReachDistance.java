package com.print_stack_trace.voogasalad.model.environment;

import java.awt.Point;
import java.util.List;

import javafx.geometry.Point2D;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class ReachDistance extends Goal implements GoalElement{
    
    private double myDestination;
    private Integer myHeroID;
    private boolean myHorizontal;

    public ReachDistance (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
    }

    public double getDestination() {
        return myDestination;
    }
    
    public Integer getHeroID() {
        return myHeroID;
    }
    
    public boolean isHorizontal(){
    	return myHorizontal;
    }

    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        myDestination = myGoalCharacteristics.getDestination();
        myHeroID = myGoalCharacteristics.getObjectID();
        myHorizontal = myGoalCharacteristics.getHorizontalDestination();

    }

	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
		
	}

}