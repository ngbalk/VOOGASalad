package com.print_stack_trace.voogasalad.model;

import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.geometry.Point2D;


public class GoalCharacteristics {

    public GoalType myGoalType;
    public Integer myObjectID;
    public Integer myObjectiveID;
    public Integer myPointTotal;
    public Point2D myDestination;
    
    public GoalCharacteristics(GoalType goalType) {
        myGoalType = goalType;
    }
    public void setDestination(){
    	
    }
   // public void 
}