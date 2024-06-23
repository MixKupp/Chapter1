package se233.casestudy1.model.character;

import se233.casestudy1.model.Damagetype;

public class MagicalCharacter extends BasedCharacter{
    public MagicalCharacter(String name,String imgpath,int basedDef, int basedRes){
        this.name = name;
        this.type = Damagetype.magical;
        this.imgpath = imgpath;
        this.fullHp = 30;
        this.basedPow = 50;
        this.basedDef = basedDef;
        this.basedRes = basedRes;
        this.hp = this.fullHp;
        this.power = this.basedPow;
        this.defense = basedDef;
        this.resistance = basedRes;

    }
}
