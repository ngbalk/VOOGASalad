package com.print_stack_trace.voogasalad.model;

import java.awt.Point;

import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.geometry.Point2D;


public class GoalCharacteristics {

    private GoalType myGoalType=null;
    private Integer myObjectID=0;
    private Integer myObjectiveID=0;
    private Integer myPointTotal=0;
    private Point2D myDestination=new Point2D(0,0);
    private String myName="";
    
    public GoalCharacteristics(GoalType goalType) {
        myGoalType = goalType;
    }
    public void setDestination(Point2D destination){
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
    public Point2D getDestination(){
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