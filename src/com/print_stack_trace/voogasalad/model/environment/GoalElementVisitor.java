package com.print_stack_trace.voogasalad.model.environment;

public interface GoalElementVisitor {
	/** 
	 * Need a different one for every class that implements GoalElement.
	 * @param goal
	 * @return
	 */
	boolean visit(KillBoss goal);
	boolean visit(Points goal);
	boolean visit(ReachDistance goal);
	boolean visit(ReachObject goal);
	boolean visit(StayAlive goal);

}
