package se233.casestudy1.model.item;

public class Armor extends BasedEquipment{
    private int defense,resistance;

    public Armor(String name,int defense,int resistance,String imgpath){
        this.name = name;
        this.imgpath = imgpath;
        this.defense = defense;
        this.resistance = resistance;

    }

    public int getDefense() {
        return defense;
    }

    public int getResistance() {
        return resistance;
    }

    @Override
    public String toString(){
        return name;
    }
}
