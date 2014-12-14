package com.print_stack_trace.voogasalad.model.environment;

import java.util.List;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class KillBoss extends Goal implements GoalElement{
    
    
    private List<Integer> myBossID;

    public KillBoss (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
    }

    public List<Integer> getBossID() {
        return myBossID;
    }

    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        myBossID = myGoalCharacteristics.getObjectiveID();
        
    }


	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
		
	}
    
}