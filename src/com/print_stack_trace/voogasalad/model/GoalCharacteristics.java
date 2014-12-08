package com.print_stack_trace.voogasalad.model;

import java.awt.Point;

import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;


public class GoalCharacteristics {

    private String myName="";
    public GoalType myGoalType=GoalType.POINTS;
    public Integer myObjectID=0;
    public Integer myObjectiveID=0;
    public Integer myPointTotal=0;
    public double myDestination=0;
    private boolean myHorizontalDestination=true;


    
    public GoalCharacteristics(GoalType goalType) {
        myGoalType = goalType;
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
    public void setObjectiveID(Integer ID){
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
    public Integer getObjectiveID(){
    	return myObjectiveID;
    }
    public Integer getPointsTotal(){
    	return myPointTotal;
    }
    public void setPointsTotal(int points){
    	myPointTotal=points;
    }
   // public void 
}