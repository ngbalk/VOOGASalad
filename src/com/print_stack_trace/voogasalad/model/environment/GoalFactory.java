package com.print_stack_trace.voogasalad.model.environment;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;

/**
 * 
 * @author Ethan Chang, Jack Baskin, Nick Widmaier
 *
 * This class is a factory which allows us to create particular instances of
 * specific subclasses of Goal based on the characteristics given from the user.
 * The GoalType value is set by the user and is the basis for creating the correct instance of a Goal.
 * To build a goal you take an instance of GoalCharacteristics as passed
 * from the front end to the LevelModel, who calls on the factory to
 * create the goal, which is ultimately stored in a map in the LevelModel
 * 
 */
public class GoalFactory {
    public static final String goalPath = "com.print_stack_trace.voogasalad.model.environment.";
    
    /**
     * 
     * @author Ethan Chang, Jack Baskin, Nick Widmaier
     * an enumeration of all possible subclasses of goal the author can create
     * Whenever a new subclass is added, an appropriate value must be added to
     * this enumeration - this allows the full list of options for the author to always be
     * displayed correctly.
     */
    public enum GoalType {
        REACH_OBJECT,
        REACH_DISTANCE,
        KILL_BOSS,
        POINTS,
        STAY_ALIVE
    }
    
    /**
     * Creates an instance of the correct subclass of Goal based off
     * the GoalType field as set by the author
     * @param myGoalCharacteristics the characteristics passed from the
     * front end containing all the relevant information used to create
     * a goal
     * @return the goal created by the factory
     */
    public Goal buildGoal(GoalCharacteristics myGoalCharacteristics) {
        Constructor<?> con = null;
        Goal newGoal = null;

        try {
            String objectType = reformatTypeString(myGoalCharacteristics.getMyGoalType().toString());
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
