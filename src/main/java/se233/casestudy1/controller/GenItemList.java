package se233.casestudy1.controller;

import se233.casestudy1.model.Damagetype;
import se233.casestudy1.model.item.Armor;
import se233.casestudy1.model.item.BasedEquipment;
import se233.casestudy1.model.item.Weapon;
import java.util.ArrayList;

public class GenItemList {
    public static ArrayList<BasedEquipment> setUpItemList(){
        ArrayList<BasedEquipment> itemLists = new ArrayList<BasedEquipment>(6);
        itemLists.add(new Weapon("Sword",10, Damagetype.physical,"assets/sword.png"));
        itemLists.add(new Weapon("Gun",20,Damagetype.physical,"assets/gun.png"));
        itemLists.add(new Weapon("Staff",30,Damagetype.magical,"assets/staff.png"));
        itemLists.add(new Weapon("Murasaki",999999999,Damagetype.magical,"assets/murasaki.png"));
        itemLists.add(new Armor("Shirt",0,50,"assets/shirt.png"));
        itemLists.add(new Armor("Armor",50,0,"assets/armor.png"));
        return itemLists;
    }
}
