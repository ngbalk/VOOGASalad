package com.print_stack_trace.voogasalad.model.engine.physics;

/**
 * @author Pranava Raparla
 * Date Created: 11/22/14
 * Date Modified: 11/22/14
 */
import java.lang.reflect.Constructor;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

import com.print_stack_trace.voogasalad.model.engine.physics.collisions.*;

public class CollisionFactory {
	//TODO: verify that this path takes us to the right package
	public static final String collisionResultPath = "com.print_stack_trace.voogasalad.model.engine.physics.collisions.";
	
	public enum CollisionResult {
		ObjectOneFullDisplacement,
		ObjectTwoFullDisplacement,
		ObjectBothFullDisplacement,
		ObjectBothNoDisplacement,
		NoAction,
		ObjectOneDisappear,
		ObjectTwoDisappear,
		ObjectBothDisappear,
		HeroDamageCollision,
		ObjectOnePassThroughBottom,
	};
	
	public enum UserDefinedCollisionParams {
		PointsAwarded,
		DamageDealt
	}
	
	//TODO: make sure its collision result vs. collision handler and vice-versa
    public static CollisionHandler buildCollisionHandler(CollisionResult myCollisionResult) {
        Constructor<?> con = null;
        CollisionHandler newCollisionResult = null;

        try {
            String objectType = myCollisionResult.toString(); //TODO: explore using toString() instead of name()
            Class<?> newCollisionResultClass = Class.forName(collisionResultPath + objectType);
            try {
                con = newCollisionResultClass.getConstructor();
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
    
    /**
     * Public method to generate standard collision handler but with additional 
     * key-value specification from the UserDefinedCollisionParams (such as 
     * awarding points, causing damage); 
     */
	public static CollisionHandler collisionEngineFromParams(CollisionResult baseHandler, UserDefinedCollisionParams paramType, int param) {
		return new CollisionHandler() {
			private final CollisionHandler base = buildCollisionHandler(baseHandler);
			private final UserDefinedCollisionParams fParamType = paramType;
			@Override
			public void applyCollisionEffects(RuntimeSpriteCharacteristics s1,
					RuntimeSpriteCharacteristics s2, RuntimeModel currentRuntime) {
				base.applyCollisionEffects(s1, s2, currentRuntime);
				switch (fParamType) {
				case DamageDealt:
					s2.health -= param;
					break;
				case PointsAwarded:
					currentRuntime.currentPoints += param;
					break;
				default:
					break;
				}
			}
            @Override
            public boolean shouldStick (RuntimeSpriteCharacteristics s1,
                                        RuntimeSpriteCharacteristics s2) {
                // TODO Auto-generated method stub
                return true;
            }
		};
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