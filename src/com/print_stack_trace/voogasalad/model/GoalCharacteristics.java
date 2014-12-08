package com.print_stack_trace.voogasalad.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;


public class GoalCharacteristics {

    private String myName="";
    public GoalType myGoalType=GoalType.POINTS;
    public Integer myObjectID = 0;
    public List<Integer> myObjectiveID = new ArrayList<>();
    public Integer myPointTotal=0;
    public double myDestination=0;
    private boolean myHorizontalDestination=true;


    
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
   // public void 
}