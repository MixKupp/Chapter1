package se233.casestudy1.model.character;

import se233.casestudy1.model.Damagetype;

public class BattleMageCharacter extends BasedCharacter{
    public BattleMageCharacter(String name,String imgpath,int basedDef, int basedRes) {
        this.name = name;
        this.type = Damagetype.magi;
        this.imgpath = imgpath;
        this.fullHp = 40;
        this.basedPow = 40;
        this.basedDef = basedDef;
        this.basedRes = basedRes;
        this.hp = this.fullHp;
        this.power = this.basedPow;
        this.defense = this.basedDef;
        this.resistance = this.basedRes;
    }
}
