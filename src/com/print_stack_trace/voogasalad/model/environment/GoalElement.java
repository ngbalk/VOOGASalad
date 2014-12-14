package com.print_stack_trace.voogasalad.model.environment;
/**
 * Interface which adds a method which accepts a goal checker
 * @author Ethan Chang, Zach Podbela
 *
 */
public interface GoalElement {
	
	void acceptChecker(GoalElementVisitor visitor);
}
