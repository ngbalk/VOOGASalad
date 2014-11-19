package com.print_stack_trace.voogasalad.model.environment;

import javafx.geometry.Point2D;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class ReachDistance extends Goal{
    
    private Point2D myDestination;

    public ReachDistance (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isCompleted () {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        myDestination = myGoalCharacteristics.myDestination;

    }

}
