package com.print_stack_trace.voogasalad.model.engine.runtime;

import com.print_stack_trace.voogasalad.model.engine.physics.CollisionDetector;
import com.print_stack_trace.voogasalad.model.environment.GoalElementVisitor;
import com.print_stack_trace.voogasalad.model.environment.KillBoss;
import com.print_stack_trace.voogasalad.model.environment.Points;
import com.print_stack_trace.voogasalad.model.environment.ReachDistance;
import com.print_stack_trace.voogasalad.model.environment.ReachObject;
import com.print_stack_trace.voogasalad.model.environment.StayAlive;

public class GoalChecker implements GoalElementVisitor {
	private static final int GOAL_DESTINATION_BUFFER = 2;
	private RuntimeModel myLevel;

	public GoalChecker(RuntimeModel level) {
		myLevel = level;
	}

	@Override
	public boolean visit(KillBoss goal) {
		return myLevel.getRuntimeSpriteMap().get(goal.getBossID()).startingHealth <= 0;
	}

	@Override
	public boolean visit(Points goal) {
		return myLevel.currentPoints >= goal.reqPoints;
	}

	@Override
	public boolean visit(ReachDistance goal) {
		double heroPosition = 0;
		if(goal.isHorizontal()){
			heroPosition = myLevel.getRuntimeSpriteMap().get(goal.getHeroID()).p.getX();
		}
		else{
			heroPosition = myLevel.getRuntimeSpriteMap().get(goal.getHeroID()).p.getY();
		}
		return (heroPosition > (goal.getDestination() - GOAL_DESTINATION_BUFFER)) 
				&& (heroPosition < (goal.getDestination() + GOAL_DESTINATION_BUFFER )); 

	}


	@Override
	public boolean visit(ReachObject goal) {
		return CollisionDetector.haveCollided(myLevel.getRuntimeSpriteMap().get(goal.getMySpriteID()), 
				myLevel.getRuntimeSpriteMap().get(goal.getMyObjectiveID()));
	}


	@Override
	public boolean visit(StayAlive goal) {
		return myLevel.getRuntimeSpriteMap().get(goal.getHeroID()).health <= 0;
	}

}
