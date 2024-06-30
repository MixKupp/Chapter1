package se233.casestudy1.controller;

import se233.casestudy1.model.character.BasedCharacter;
import se233.casestudy1.model.character.BattleMageCharacter;
import se233.casestudy1.model.character.MagicalCharacter;
import se233.casestudy1.model.character.PhysicalCharacter;
import java.util.Random;

public class GenCharacter {
    public static BasedCharacter setUpCharacter(){
        BasedCharacter character;
        Random rand = new Random();
        int type = rand.nextInt(3)+1;
        int baseDef = rand.nextInt(50)+1;
        int baseRes = rand.nextInt(50)+1;
        if(type ==1){
            character = new MagicalCharacter("MagicChar1","assets/wizard.png",baseDef,baseRes);
        }
        else if (type ==2){
            character = new PhysicalCharacter("PhysicalChar1","assets/knight.png",baseDef,baseRes);
        }
        else {
            character = new BattleMageCharacter("BattleMageChar1","assets/battleM.png",baseDef,baseRes);
        }
        return character;
    }
}
