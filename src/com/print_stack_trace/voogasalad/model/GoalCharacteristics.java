package com.print_stack_trace.voogasalad.model;

import java.awt.Point;

import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.geometry.Point2D;


public class GoalCharacteristics {


    private String myName="";
    public GoalType myGoalType;
    public Integer myObjectID;
    public Integer myObjectiveID;
    public Integer myPointTotal;
    public Point myDestination;

    
    public GoalCharacteristics(GoalType goalType) {
        myGoalType = goalType;
    }
    public void setDestination(Point destination){
    	myDestination=destination;
    }
    public void setObjectID(Integer ID){
    	myObjectID=ID;
    }
    public void setObjectiveID(Integer ID){
    	myObjectiveID=ID;
    }
    public void setPointsTotal(Integer points){
    	myPointTotal=points;
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
    public Point getDestination(){
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
   // public void 
}