package com.print_stack_trace.voogasalad.model.engine.runtime;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.environment.GoalElementVisitor;
import com.print_stack_trace.voogasalad.model.environment.KillBoss;
import com.print_stack_trace.voogasalad.model.environment.Points;
import com.print_stack_trace.voogasalad.model.environment.ReachXDistance;
import com.print_stack_trace.voogasalad.model.environment.ReachObject;
import com.print_stack_trace.voogasalad.model.environment.ReachYDistance;
import com.print_stack_trace.voogasalad.model.environment.StayAlive;

public class GoalChecker implements GoalElementVisitor {
    private static final int GOAL_DESTINATION_BUFFER = 2;
    private LevelModel myLevel;
    private CollisionDetector myCollisionDetector;

    public GoalChecker(LevelModel level) {
        myLevel = level;
        myCollisionDetector = new CollisionDetector();
    }

    @Override
    public boolean visit(KillBoss goal) {
        return myLevel.getSpriteMap().get(goal.getBossID()).health <= 0;
    }

    //TODO: after we know how points work
    @Override
    public boolean visit(Points goal) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean visit(ReachXDistance goal) {
        double heroXPosition = myLevel.getSpriteMap().get(goal.getHeroID()).p.getX();
        return (heroXPosition > (goal.getXDestination() - GOAL_DESTINATION_BUFFER)) 
                && (heroXPosition < (goal.getXDestination() + GOAL_DESTINATION_BUFFER )); 
    }

    @Override
    public boolean visit(ReachYDistance goal) {
        double heroYPosition = myLevel.getSpriteMap().get(goal.getHeroID()).p.getY();
        return (heroYPosition > (goal.getYDestination() - GOAL_DESTINATION_BUFFER)) 
                && (heroYPosition < (goal.getYDestination() + GOAL_DESTINATION_BUFFER )); 
    }

    @Override
    public boolean visit(ReachObject goal) {
        return myCollisionDetector.haveCollided(myLevel.getSpriteMap().get(goal.getMySpriteID()), 
                myLevel.getSpriteMap().get(goal.getMyObjectiveID()));

    }


    @Override
    public boolean visit(StayAlive goal) {
        return myLevel.getSpriteMap().get(goal.getHeroID()).health <= 0;
    }

}
