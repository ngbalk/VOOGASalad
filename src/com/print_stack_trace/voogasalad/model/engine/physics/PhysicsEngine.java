/**
 * @author Zachary Podbela
 * @author Pranava Raparla
 * Date Created: 11/11/14
 * Date Modified: 11/23/14
 */
package com.print_stack_trace.voogasalad.model.engine.physics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class PhysicsEngine {

    private static final int MATRIX_SIZE = SpriteType.values().length;

    /**
     * The decision Matrix is the basis for determining HOW to handle a given collision.
     * 
     *	 								SpriteType
     *			 			|	A	|	B	|	C	|	D	|
     *				 	A	|Explode|		|		|		|
     *  SpriteType	 	B	|		|Allow	|Disp2	|		|
     *					C	|		|Disp1	|		|		|
     *					D	|		|		|		|		|
     *
     * Given two objects that have collided, we can lookup their types in the table
     * and get back a CollisionResult describing how the collision should play out.
     * For example, if a sprite of type A collides with another sprite of type A,
     * we know we must apply an "explode" type collision to them both.
     */
    public CollisionResult[][] decisionMatrix;

    private Map<CollisionResult , CollisionHandler> handlerMap = new HashMap<CollisionResult , CollisionHandler>();
    private SoloPhysicsHandler soloHandler;

    public PhysicsEngine() {
        decisionMatrix = new CollisionResult[MATRIX_SIZE][MATRIX_SIZE];
        //Defaults
        for(int i = 0; i < MATRIX_SIZE; i++) {
            for(int j = 0; j < MATRIX_SIZE; j++) {
                decisionMatrix[i][j] = CollisionResult.ObjectBothNoDisplacement;
            }
        }
        soloHandler = SoloPhysicsGenerator.getProgramPhysicEngine(ProgramPhysicEngine.EarthPhysicsEngine);
    }

    /**
     * Public method for animating the level.
     * The lifecycle is as follows:
     * 		1. Objects are animated within their own scope according to "world" 
     * 		(or global) physics. This includes gravity, drag/wind, and intensity
     * 		2. All objects are checked for collisions using the CollisionDetector.
     * 		Once it has been confirmed that two RuntimeSpriteCharacteristics are
     * 		colliding, we call on the private helper method collisionHandler();
     * 		3. Delete objects from the level that have been flagged for removal.
     * @param 	allObjects
     * 		a Collection of RuntimeSpriteCharacteristics that contains all of the
     * 		objects in a level.
     * @param 	framesPerSecond
     * 		an int representing the current frames per second the front end is
     * 		calling update at. Important for physics related calculations (such
     * 		as how gravity translates to position).
     * @see	CollisionDetector, RuntimeSpriteCharacteristics
     */
    public void animateAll(RuntimeModel currentRuntime, int framesPerSecond) {
    	
        Collection<RuntimeSpriteCharacteristics> allObjects = currentRuntime.getRuntimeSpriteMap().values();
        for(RuntimeSpriteCharacteristics obj : allObjects) {
            obj.setDecelerationConstant(0.0f);
            obj.isColliding = obj.isCollidingHorizontally = obj.isCollidingVertically = false;
            if(obj.interactive) soloHandler.applyPhysics(obj, framesPerSecond);
        }
        


        Object[] array = allObjects.toArray();
        for(int i = 0; i < array.length; i++) {
            RuntimeSpriteCharacteristics s1 = (RuntimeSpriteCharacteristics) array[i];
            for(int j = i+1; j < array.length; j++) {
                RuntimeSpriteCharacteristics s2 = (RuntimeSpriteCharacteristics) array[j];


                RuntimeSpriteCharacteristics copys1 = new RuntimeSpriteCharacteristics(s1);
                RuntimeSpriteCharacteristics copys2 = new RuntimeSpriteCharacteristics(s2);
                copys1.setX(s1.getX());
                copys1.v_x = s1.v_x;
                copys1.setY(s1.getY());
                copys1.v_y = s1.v_y;

                copys2.setX(s2.getX());
                copys2.v_x = s2.v_x;
                copys2.setY(s2.getY());
                copys2.v_y = s2.v_y;
                this.moveSpritesForward(copys1, copys2, framesPerSecond);
                if(CollisionDetector.haveCollided(copys1, copys2)) {
                    stickSpriteToSide(s1,s2);
                    collisionHandler(s1, s2, currentRuntime);

                }	
            }
        }
        performEnemyAI(allObjects.toArray());

        Collection<RuntimeSpriteCharacteristics> toRemove = new ArrayList<RuntimeSpriteCharacteristics>();
        for(RuntimeSpriteCharacteristics obj : allObjects) {
            if (obj.shouldBeRemoved()) toRemove.add(obj);
        }
        allObjects.removeAll(toRemove);

    }

    private void performEnemyAI(Object[] array) {

        for(int i = 0; i < array.length; i ++){
            RuntimeSpriteCharacteristics sprite = (RuntimeSpriteCharacteristics) array[i];
            if(sprite.objectType.equals(SpriteType.ENEMY) && sprite.enemyPatrols){
                patrolEnemy(sprite);
            }
        }
    }

    private void patrolEnemy(RuntimeSpriteCharacteristics enemy){
        if(enemy.isCollidingHorizontally) enemy.isPatrollingLeft = !enemy.isPatrollingLeft;
        if(enemy.isPatrollingLeft){
            enemy.setX(enemy.getX() + enemy.startingSpeed);
        }
        else{
            enemy.setX(enemy.getX() + -enemy.startingSpeed);
        }
    }

    private void stickSpriteToSide(RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2){

        //		ugly fixes!!!
        if((s2.objectType.equals(SpriteType.HERO) || s2.objectType.equals(SpriteType.ENEMY))
                && s1.objectType.equals(SpriteType.PLATFORM)){
            RuntimeSpriteCharacteristics copys1 = s1;
            s1 = s2;
            s2 = copys1;
        }
        if(s1.objectType.equals(s2.objectType)) return;


        if(CollisionDetector.haveCollidedFromTop(s1, s2)){
            s1.setY(s2.getY() - s1.getHeight()+1);
            return;
        }

        if(CollisionDetector.haveCollidedFromBottom(s1, s2)){
            s1.setY(s2.getY() + s2.getHeight()+5);
            return;
        }


        if(CollisionDetector.haveCollidedFromLeft(s1, s2)){
            s1.setX(s2.getX() - s1.getWidth());
            return;
        }
        if(CollisionDetector.haveCollidedFromRight(s1, s2)){
            s1.setX(s2.getX() + s2.getWidth());
            return;
        }
    }

    public void moveSpritesForward(RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2, int framesPerSecond){
        s1.setX(s1.getX()+((double)s1.v_x/(double)framesPerSecond));
        s1.setY(s1.getY()+((double)s1.v_y/(double)framesPerSecond));
        s2.setX(s2.getX()+((double)s2.v_x/(double)framesPerSecond));
        s2.setY(s2.getY()+((double)s2.v_y/(double)framesPerSecond));

    }

    /**
     * Private method to assist in the proper collision handling lifecycle.
     * Once it has been confirmed that two SpriteCharacteristics are colliding, 
     * we must determine what collision should occur given the types of colliding
     * objects and then apply the collision to the objects.
     * the following events happen:
     * 		1. The decisionMatrix is used to get the proper CollisionResult for 
     * 		the colliding types of SpriteCharacteristics.
     * 		2. The handlerMap is used to get the proper CollisionHandler subclass
     * 		for applying the CollisionResult received in step 1.
     * 		3. Call the .applyResult method on the CollisionResult subclass
     * 		received in step 2 to animate, transform, or change the states of the
     * 		colliding objects.
     * @param 	s1
     * 		a SpriteCharacteristics instance representing one of the colliding objects
     * @param 	s2	
     * 		a SpriteCharacteristics instance representing the other colliding object
     * @see	CollisionHandler, SpriteCharacteristics
     */
    private void collisionHandler(RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2, RuntimeModel currentRuntime) {
        s1.isColliding = s2.isColliding = true;
        CollisionResult result = getResultOfCollision(s1, s2);
        CollisionHandler handler = getHandlerForResult(result);
        handler.applyCollisionEffects(s1, s2, currentRuntime);
    }

    private CollisionResult getResultOfCollision(RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2) {
        return decisionMatrix[s1.objectType.ordinal()][s2.objectType.ordinal()];
    }

    public void setResultOfCollision(CollisionResult result, SpriteType s1, SpriteType s2) {
        decisionMatrix[s1.ordinal()][s2.ordinal()] = result;
    }

    private CollisionHandler getHandlerForResult(CollisionResult result) {
        CollisionHandler ret = handlerMap.get(result);
        if(ret == null) {
            ret = CollisionFactory.buildCollisionHandler(result);
            setHandlerForResult(result, ret);
        }
        return ret;
    }

    public void setHandlerForResult(CollisionResult result, CollisionHandler handler) {
        handlerMap.put(result, handler);
    }

    public SoloPhysicsHandler getSoloHandler() {
        return soloHandler;
    }

    public void setSoloHandler(SoloPhysicsHandler soloHandler) {
        this.soloHandler = soloHandler;
    }
}
