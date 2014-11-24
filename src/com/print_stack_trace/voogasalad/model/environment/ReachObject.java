package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class ReachObject extends Goal implements GoalElement{

    private Integer mySpriteID;
    private Integer myObjectiveID;

    public ReachObject (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
    }

    
    public Integer getMySpriteID() {
        return mySpriteID;
    }
    
    public Integer getMyObjectiveID() {
        return myObjectiveID;
    }

    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        mySpriteID = myGoalCharacteristics.myObjectID;
        myObjectiveID = myGoalCharacteristics.myObjectiveID;

    }

	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
		
	}

}
