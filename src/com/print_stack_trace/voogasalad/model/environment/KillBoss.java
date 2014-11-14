package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class KillBoss extends Goal{
    
    
    private Integer myBossID;

    public KillBoss (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
        // TODO Auto-generated constructor stub
    }


    @Override
    public boolean isCompleted () {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        myBossID = myGoalCharacteristics.myObjectID;
        
    }
    
}
