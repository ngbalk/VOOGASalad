package com.print_stack_trace.voogasalad.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;

/**
 * 
 * @author Ethan Chang, Jack Baskin, Nick Widmaier
 * This class contains all the possible properties that a particular goal
 * could have. The level author in creating a goal sets a GoalType which
 * is required to create a particular instance of a Goal that is stored
 * in the LevelModel. GoalType is an enumeration containing all possible
 * subclasses of Goal that have been implemented.
 *
 */
public class GoalCharacteristics {

    private String myName="";
    public GoalType myGoalType=GoalType.POINTS;
    public Integer myObjectID = 0;
    private List<Integer> myObjectiveID = new ArrayList<>();
    public Integer myPointTotal=0;
    public double myDestination=0;
    private boolean myHorizontalDestination=true;


    /**
     * Constructor for a new instance of GoalCharacteristics
     * Takes in a GoalType so the GoalFactory knows which subclass of goal
     * should be instantiated 
     * @param goalType the GoalType selected by the user from the enumeration
     * of all the goal types
     */
    public GoalCharacteristics(GoalType goalType) {
        myGoalType = goalType;
        myObjectiveID.add(0);
    }
    public void setHorizontalDestination(boolean dest){
    	myHorizontalDestination=dest;
    }
    public boolean getHorizontalDestination(){
    	return myHorizontalDestination;
    }
    public void setDestination(double destination){
    	myDestination=destination;
    }
    
    public void setObjectID(Integer ID){
    	myObjectID=ID;
    }
    public void setObjectiveID(List<Integer> ID){
    	myObjectiveID=ID;
    }
  
    public void setName(String name){
    	myName=name;
    }
    public String getName(){
    	return myName;
    }
    public GoalType getCharacteristics() {
        return myGoalType;
    }
    public double getDestination(){
    	return myDestination;
    }
    public Integer getObjectID(){
    	return myObjectID;
    }
    public List<Integer> getObjectiveID(){
    	return myObjectiveID;
    }
    public Integer getPointsTotal(){
    	return myPointTotal;
    }
    public void setPointsTotal(int points){
    	myPointTotal=points;
    }
	public GoalType getGoalType() {
		return myGoalType;
	}
}