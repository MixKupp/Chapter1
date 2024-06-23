package se233.casestudy1.model.item;

import se233.casestudy1.model.Damagetype;

public class Weapon extends BasedEquipment{
    private int power;
    private Damagetype damagetype;

    public Weapon(String name,int power,Damagetype damagetype,String imgpath){
        this.name = name;
        this.imgpath = imgpath;
        this.power = power;
        this.damagetype = damagetype;

    }

    public int getPower(){
        return power;
    }
    public void setPower(int power){
        this.power = power;
    }
    public void setDamagetype(Damagetype damagetype) {
        this.damagetype = damagetype;
    }
    public Damagetype getDamagetype(){
        return damagetype;
    }
    @Override
    public String toString(){
        return name;
    }
}