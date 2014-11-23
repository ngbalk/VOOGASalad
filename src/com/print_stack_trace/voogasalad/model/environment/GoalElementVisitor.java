package com.print_stack_trace.voogasalad.model.environment;

public interface GoalElementVisitor {
	//TODO: Need a different one for every class that impliments GoalElement.
	boolean visit(KillBoss goal);
	boolean visit(Points goal);
	boolean visit(ReachXDistance goal);
	boolean visit(ReachObject goal);
	boolean visit(StayAlive goal);
	boolean visit(ReachYDistance goal);

}