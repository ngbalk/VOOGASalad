package com.print_stack_trace.voogasalad.model;

import javafx.geometry.Point2D;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.GoalType;


public class GoalCharacteristics {

    public GoalType myGoalType;
    public Integer myObjectID;
    public Integer myPointTotal;
    public Point2D myDestination;
    
    public GoalCharacteristics(GoalType goalType) {
        myGoalType = goalType;
    }
}