/**
 * @author Pranava Raparla
 * Tests for Engine
 */

package com.print_stack_trace.voogasalad.tests;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameWorldModel;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;

public class GameEngineTests {

	public void debugGameWorld(GameWorldModel game) {
		for (LevelModel level : game.getLevelMap().values()) {
			debugLevel(level);
		}
	}

	public void debugLevel(LevelModel lvl) {
		System.out.println(lvl.getPhysicsEngine().decisionMatrix);
		for (int i = 0; i < lvl.getPhysicsEngine().decisionMatrix.length; i++) {
			for (int j = 0; j < lvl.getPhysicsEngine().decisionMatrix[0].length; j++) {
				CollisionResult c = lvl.getPhysicsEngine().decisionMatrix[i][j];
				if (!(c.name().toString().equals(CollisionResult.NoAction
						.toString()))) {
					System.out.println(c.name());
				}
			}
		}
		for (Integer i : lvl.getSpriteMap().keySet()) {
			SpriteCharacteristics s = lvl.getSpriteMap().get(i);
			System.out.println("type = " + s.objectType + "x,y = " + s.getX()
					+ "," + s.getY() + "orientation = " + s.getOrientation()
					+ "name = " + s.getName());
		}
		for (GoalCharacteristics g : lvl.getGoalMap().values()) {
			System.out.println(g.myGoalType);
		}
	}

	public Integer findHero(LevelModel lvl) {
		for (Integer id : lvl.getSpriteMap().keySet()) {
			if (lvl.getSpriteMap().get(id).getObjectType() == SpriteType.HERO) {
				return id;
			}
		}
		return 0;
	}
}
