package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class StayAlive extends Goal implements GoalElement{
    
    private Integer myHeroID;

    public StayAlive (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
    }

    public Integer getHeroID() {
        return myHeroID;
    }
    
    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        myHeroID = myGoalCharacteristics.myObjectID;
        
    }



	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
		
	}

}
