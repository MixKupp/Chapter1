package se233.casestudy1.model.character;

import se233.casestudy1.model.Damagetype;

public class PhysicalCharacter extends BasedCharacter{
    public PhysicalCharacter(String name,String imgpath,int basedDef,int basedRes){
        this.name = name;
        this.type = Damagetype.physical;
        this.imgpath = imgpath;
        this.fullHp = 50;
        this.basedPow = 30;
        this.basedRes = basedRes;
        this.basedDef = basedDef;
        this.hp =this.fullHp;
        this.power = basedPow;
        this.defense = basedDef;
        this.resistance = basedRes;
    }
}
