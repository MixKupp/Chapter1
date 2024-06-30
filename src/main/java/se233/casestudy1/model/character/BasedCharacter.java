package se233.casestudy1.model.character;

import se233.casestudy1.model.Damagetype;
import se233.casestudy1.model.item.Armor;
import se233.casestudy1.model.item.Weapon;

public class BasedCharacter {
    protected String name,imgpath;

    public void setType(Damagetype type) {
        this.type = type;
    }

    protected Damagetype type;
    protected Integer fullHp,basedPow,basedDef,basedRes;
    protected Integer hp,power,defense,resistance;
    protected Weapon weapon;
    protected Armor armor;

    public String getName() {
        return name;
    }
    public String getImgpath(){
        return imgpath;
    }
    public Integer getHp() {
        return hp;
    }
    public Integer getFullHp() {
        return fullHp;
    }
    public Integer getPower() {
        return power;
    }
    public Integer getDefense() {
        return defense;
    }
    public Integer getResistance() {
        return resistance;
    }
    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
        this.power = this.basedPow+weapon.getPower();
    }
    public void equipArmor(Armor armor){
        this.armor = armor;
        this.defense = this.basedDef+ armor.getDefense();
        this.resistance = this.basedRes+ armor.getResistance();
    }
    public void unEquipWeapon(){
        this.weapon = null;
        this.power = this.basedPow;
    }
    public void unEquipArmor(){
        this.armor = null;
        this.defense = this.basedDef;
        this.resistance = this.basedRes;
    }
    @Override
    public String toString(){
        return name;
    }
    public Damagetype getType(){
        return type;
    }
}
