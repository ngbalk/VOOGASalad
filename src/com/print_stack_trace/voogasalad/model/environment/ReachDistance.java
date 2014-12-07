package com.print_stack_trace.voogasalad.model.environment;

import java.awt.Point;

import javafx.geometry.Point2D;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class ReachDistance extends Goal implements GoalElement{
    

    public ReachDistance (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
    }


	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
		
	}

}
