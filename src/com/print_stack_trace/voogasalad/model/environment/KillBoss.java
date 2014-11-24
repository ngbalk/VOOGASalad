package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class KillBoss extends Goal implements GoalElement{
    
    
    private Integer myBossID;

    public KillBoss (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
    }

    public Integer getBossID() {
        return myBossID;
    }

    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        myBossID = myGoalCharacteristics.myObjectID;
        
    }


	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
		
	}
    
}
