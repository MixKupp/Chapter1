package se233.casestudy1.model.item;

import javafx.scene.input.DataFormat;
import se233.casestudy1.model.Damagetype;

import java.io.Serializable;

public class BasedEquipment implements Serializable {
    protected String name;
    protected String imgpath;
    protected Damagetype dmtype;

    public Damagetype getDmtype() {
        return dmtype;
    }

    public String getName(){
        return name;
    }
    public String getImgpath(){
        return imgpath;
    }

    public static final DataFormat DATA_FORMAT = new DataFormat("src.main.java.se333.casestudy1.model.item.BasedEquipment");
}
