package com.print_stack_trace.voogasalad.model.environment;

import java.util.List;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class ReachObject extends Goal implements GoalElement{

    private Integer mySpriteID;
    private List<Integer> myObjectiveID;

    public ReachObject (GoalCharacteristics goalCharacteristics) {
        super(goalCharacteristics);
    }

    
    public Integer getMySpriteID() {
        return mySpriteID;
    }
    
    public List<Integer> getMyObjectiveID() {
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
