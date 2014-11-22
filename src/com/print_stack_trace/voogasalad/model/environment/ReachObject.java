package com.print_stack_trace.voogasalad.model.environment;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class ReachObject extends Goal implements GoalElement{

    private Integer mySpriteID;

    public ReachObject (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
        // TODO Auto-generated constructor stub
    }


    @Override
    protected void setGoalProperties() {
        super.setGoalProperties();
        mySpriteID = myGoalCharacteristics.myObjectID;

    }

	@Override
	public void acceptChecker(GoalElementVisitor visitor) {
		isCompleted = visitor.visit(this);
		
	}

}
