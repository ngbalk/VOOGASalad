package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class GoalEXAMPLeSUBCLASS extends Goal implements GoalElement {

	public GoalEXAMPLeSUBCLASS(GoalCharacteristics goalCharacteristics) {
		super(goalCharacteristics);
		// TODO Auto-generated constructor stub
	}
	
	//!!!: YOU CANNOT PUT THIS IN THE ABSTRACT. Must be called from the subclass even though it is the same everytime.
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
	}
}
