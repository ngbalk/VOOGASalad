package testpackage;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.sprites.Enemy;
import com.print_stack_trace.voogasalad.model.sprites.Sprite;
import com.print_stack_trace.voogasalad.model.sprites.SpriteFactory;

public class SpriteTests {
    private SpriteFactory mySpriteFactory = new SpriteFactory();
    
    @Test
    public void test () {
        SpriteCharacteristics spriteCharacteristics = new SpriteCharacteristics(SpriteType.ENEMY);
        Enemy mySprite = (Enemy)mySpriteFactory.buildSprite(spriteCharacteristics);
        assertEquals(10, mySprite.myHealth);
    }

    @Test
    public void TestLevelModel () {
        LevelModel levelModel = new LevelModel();
        List<Integer> iDList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            iDList.add(levelModel.addObject(new SpriteCharacteristics(SpriteType.ENEMY)));
        }
        levelModel.updateObject(iDList.get(4), new SpriteCharacteristics(SpriteType.HERO));
        Map<Integer, Sprite> spriteMap = levelModel.getSpriteMap();
        assertEquals(spriteMap.get(iDList.get(4)).getMySpriteType(), SpriteType.HERO);
    }
    

}
