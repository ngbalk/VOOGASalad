package com.print_stack_trace.voogasalad.model.engine.runtime;

import com.print_stack_trace.voogasalad.model.environment.GoalElementVisitor;
import com.print_stack_trace.voogasalad.model.environment.KillBoss;
import com.print_stack_trace.voogasalad.model.environment.Points;
import com.print_stack_trace.voogasalad.model.environment.ReachDistance;
import com.print_stack_trace.voogasalad.model.environment.ReachObject;
import com.print_stack_trace.voogasalad.model.environment.StayAlive;

public class GoalChecker implements GoalElementVisitor {

	//TODO: Change this class as expands
	
	@Override
	public boolean visit(KillBoss goal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Points goal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(ReachDistance goal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(ReachObject goal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(StayAlive goal) {
		// TODO Auto-generated method stub
		return false;
	}

}
