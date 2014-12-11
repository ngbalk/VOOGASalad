/**
 * @author Pranava Raparla
 * Date Created: 11/22/14
 * Date Modified: 11/22/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;


import javafx.scene.input.KeyCode;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;

public class RuntimeSpriteCharacteristics extends SpriteCharacteristics {
	public float v_x;
	public float v_y;
	public boolean isColliding = false;
	public boolean isCollidingHorizontally = false;
	public boolean isCollidingVertically = false;
	public boolean enemyPatrols = true;
	public boolean isPatrollingLeft = true;
	private float decelerationConstant;
	public KeyResult currentSpriteAction;
	public ReadOnlyIntegerWrapper healthProperty=new ReadOnlyIntegerWrapper(this.startingHealth);
	public ReadOnlyIntegerWrapper pointsProperty=new ReadOnlyIntegerWrapper(0);
	
	public int health;
	private boolean remove = false;
	private float alpha = 1.0f;
	
	public RuntimeSpriteCharacteristics(SpriteType t) {
		super(t);
	}
	
//	public void setWritableHealthProperty(int newHealth){
//		healthProperty.setValue(newHealth);
//	}
	
	public ReadOnlyIntegerProperty getPropertyReadOnlyHealth(){
		return this.healthProperty.getReadOnlyProperty();
	}
	
//	public void setWritablePointsProperty(int newPoints){
//		pointsProperty.setValue(newPoints);
//	}
	
	public ReadOnlyIntegerProperty getPropertyReadOnlyPoints(){
		return this.pointsProperty.getReadOnlyProperty();
	}
	
	
	public void setHealthProperty(int newHealth){
		this.healthProperty.setValue(newHealth);
	}
	
	public void setPointsProperty(int newPoints){
		this.pointsProperty.setValue(newPoints);
	}
	
	public RuntimeSpriteCharacteristics(SpriteCharacteristics obj) {
		super(obj);
		health = startingHealth;
		healthProperty.setValue(health);
	}
	public void setStartingHealth(int health){
		healthProperty.setValue(health);
		this.setStartingHealth(health);
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		if(alpha < 0.0f) { this.alpha = 0.0f; }
		else if(alpha > 1.0f) { this.alpha = 1.0f; }
		else this.alpha = alpha;
	}
	
	public float getDecelerationConstant() {
		return decelerationConstant;
	}

	public void setDecelerationConstant(float decelerationConstant) {
		if(decelerationConstant < 0.0f) { this.decelerationConstant = 0.0f; }
		else if(decelerationConstant > 1.0f) { this.decelerationConstant = 1.0f; }
		else this.decelerationConstant = decelerationConstant;
	}

	public boolean shouldBeRemoved() {
		return remove;
	}

	public void flagForRemoval() {
		this.remove = true;
	}	
	
	public KeyResult getCurrentAnimation() {
		return currentSpriteAction;
	}
	

	public void setPossibleSpriteAction(KeyResult spriteAction) {
		currentSpriteAction = spriteAction;
		//TODO: implement this on back end.

	}

}