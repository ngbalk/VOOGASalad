package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.runtime.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.environment.Goal;
import com.print_stack_trace.voogasalad.model.sprites.Sprite;
import com.print_stack_trace.voogasalad.model.sprites.SpriteFactory;

public class LevelModel {
    
    private Map<Integer, Sprite> spriteMap;
    private Integer currentID;
    private boolean isLocked;
    private PhysicsEngine physicsEngine;
    private SpriteFactory mySpriteFactory;
    private Map<SpriteType, List<Sprite>> spriteTypeMap; 
    
    public LevelModel() {
        mySpriteFactory = new SpriteFactory();
        spriteMap = new HashMap<>();
        spriteTypeMap = new HashMap<>();
    }
    
    public PhysicsEngine getPhysicsEngine() {
        return physicsEngine;
    }

    public void setPhysicsEngine(PhysicsEngine physicsEngine) {
        if (isLocked);
        this.physicsEngine = physicsEngine;
    }

    private Integer incrementID() {
        while(spriteMap.keySet().contains(currentID)) {
            currentID++;
        }
        return currentID;
    }
    
    public void setLocked() {
        isLocked = true;
    }
    
    public void setUnlocked() {
        isLocked = false;
    }
    
    public Integer addObject (SpriteCharacteristics characteristics) {
        if (isLocked) return null;
        Integer id = null;
        if (isAddable(characteristics)) {
            Sprite sp = mySpriteFactory.buildSprite(characteristics);
            id = incrementID();
            spriteMap.put(id, sp);
            addToSpriteTypeCollection(sp, characteristics);
        }
        
        return id;
    }
    
    private void addToSpriteTypeCollection(Sprite sp, SpriteCharacteristics characteristics) {
        SpriteType type = characteristics.objectType;
        if(!spriteTypeMap.containsKey(type)) {
            spriteTypeMap.put(type, new ArrayList<>());
        }
        spriteTypeMap.get(type).add(sp);
    }
    
    public boolean deleteObject (Integer modelID) {
        if (isLocked) return false;
        Sprite sp = spriteMap.get(modelID);
        List<Sprite> sprites = spriteTypeMap.get(sp.getMySpriteType());
        sprites.remove(sp);
        spriteMap.remove(modelID);

        return true;
    }
    
    public boolean updateObject (Integer ModelID, SpriteCharacteristics chars) {
        if (isLocked) return false;
        //if it passes other logic tests including: no collisions
        Sprite sp = spriteMap.get(ModelID);
        sp.updateSpriteProperties(chars);
        return true;
    }
    
    
    //TODO: Talk to authoring about how goals are implemented 
    //      this is needed to implement this method.
    public boolean setGoal(Goal goal) {
        return false;
    }
    
    
    
    /*public HashMap<Integer, SpriteCharacteristics> getSpriteTypes(ObjectType obj) {
        HashMap<Integer, SpriteCharacteristics> sprites = new HashMap<Integer, SpriteCharacteristics >();
        for (Integer i: spriteMap.keySet()) {
            if (spriteMap.get(i).objectType == obj) {
                sprites.put(i, spriteMap.get(i));
            }
        }
        return sprites;
    }*/
    
    
    private boolean isAddable(SpriteCharacteristics spriteCharacteristics) {
        //TODO IMPLEMENT THIS LATER
        return true;
    }

}