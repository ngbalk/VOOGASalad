package com.print_stack_trace.voogasalad.model.engine.physics;

/**
 * @author Pranava Raparla
 * Date Created: 11/22/14
 * Date Modified: 11/22/14
 */
import java.lang.reflect.Constructor;

public class CollisionFactory {
	//TODO: verify that this path takes us to the right package
	public static final String collisionResultPath = "com.print_stack_trace.voogasalad.model.enginge.physics.collisions";
	
	public enum CollisionResult {
		ObjectOneFullDisplacement,
		ObjectTwoFullDisplacement,
		ObjectBothFullDisplacement,
		ObjectBothNoDisplacement,
		NoAction,
		ObjectOneDisappear,
		ObjectTwoDisappear,
		ObjectBothDisappear,
	};
	
	public enum UserDefinedCollisionParams {
		
		
		PointsAwarded,
		DamageDealt
	}
	
	//TODO: make sure its collision result vs. collision handler and vice-versa
    public CollisionHandler buildCollisionHandler(CollisionResult myCollisionResult) {
        Constructor<?> con = null;
        CollisionHandler newCollisionResult = null;

        try {
            String objectType = myCollisionResult.name(); //TODO: explore using toString() instead of name()
            Class<?> newCollisionResultClass = Class.forName(collisionResultPath + objectType);
            try {
                con = newCollisionResultClass.getConstructor(CollisionHandler.class);
            } catch (NoSuchMethodException | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
            	newCollisionResult = (CollisionHandler) con.newInstance();
            	//if constructor changes, updated the newInstance() call
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return newCollisionResult;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
	//TODO: integrate this method
	public static CollisionHandler collisionEngineFromParams(CollisionResult baseHandler, UserDefinedCollisionParams paramType, int param) {
		//return new CollisionHandler() {
			//TODO: Implement
		//};
		return null;
	}
    
    //TODO: Determine if this method from goal characteristics is applicable...
    private String reformatTypeString(String s) {
        String[] words = s.split("_");
        String reformattedString = "";
        for(String word : words) {
            reformattedString += word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        }
        return reformattedString;
    }
    
}