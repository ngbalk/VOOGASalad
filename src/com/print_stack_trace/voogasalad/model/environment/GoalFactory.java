package com.print_stack_trace.voogasalad.model.environment;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

public class GoalFactory {
    public static final String goalPath = "com.print_stack_trace.voogasalad.model.environment.";

    public enum GoalType {
        REACH_OBJECT,
        REACH_DISTANCE,
        KILL_BOSS,
        POINTS,
        STAY_ALIVE
    }
    
    public Goal buildGoal(GoalCharacteristics myGoalCharacteristics) {
        Constructor<?> con = null;
        Goal newGoal = null;

        try {
            String objectType = reformatTypeString(myGoalCharacteristics.myGoalType.toString());
            Class<?> newGoalClass = Class.forName(goalPath + objectType);
            try {
                con = newGoalClass.getConstructor(GoalCharacteristics.class);
            } catch (NoSuchMethodException | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                newGoal = (Goal) con.newInstance(myGoalCharacteristics);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return newGoal;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private String reformatTypeString(String s) {
        String[] words = s.split("_");
        String reformattedString = "";
        for(String word : words) {
            reformattedString += word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        }
        return reformattedString;
    }
    
}
