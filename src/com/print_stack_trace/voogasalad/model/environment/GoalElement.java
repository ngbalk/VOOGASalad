package com.print_stack_trace.voogasalad.model.environment;

public interface GoalElement {
	
	void acceptChecker(GoalElementVisitor visitor);
}
