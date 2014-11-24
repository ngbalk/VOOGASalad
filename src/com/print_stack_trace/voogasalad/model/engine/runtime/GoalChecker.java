package com.print_stack_trace.voogasalad.model.engine.runtime;

import com.print_stack_trace.voogasalad.model.engine.physics.CollisionDetector;
import com.print_stack_trace.voogasalad.model.environment.GoalElementVisitor;
import com.print_stack_trace.voogasalad.model.environment.KillBoss;
import com.print_stack_trace.voogasalad.model.environment.Points;
import com.print_stack_trace.voogasalad.model.environment.ReachXDistance;
import com.print_stack_trace.voogasalad.model.environment.ReachObject;
import com.print_stack_trace.voogasalad.model.environment.ReachYDistance;
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
    public boolean visit(ReachXDistance goal) {
        double heroXPosition = myLevel.getRuntimeSpriteMap().get(goal.getHeroID()).p.getX();
        return (heroXPosition > (goal.getXDestination() - GOAL_DESTINATION_BUFFER)) 
                && (heroXPosition < (goal.getXDestination() + GOAL_DESTINATION_BUFFER )); 
    }

    @Override
    public boolean visit(ReachYDistance goal) {
        double heroYPosition = myLevel.getRuntimeSpriteMap().get(goal.getHeroID()).p.getY();
        return (heroYPosition > (goal.getYDestination() - GOAL_DESTINATION_BUFFER)) 
                && (heroYPosition < (goal.getYDestination() + GOAL_DESTINATION_BUFFER )); 
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
