package se233.casestudy1.model.item;

import javafx.scene.input.DataFormat;

import java.io.Serializable;

public class BasedEquipment implements Serializable {
    protected String name;
    protected String imgpath;

    public String getName(){
        return name;
    }
    public String getImgpath(){
        return imgpath;
    }
    public void setImgpath(String imgpath){
        this.imgpath = imgpath;
    }

    public static final DataFormat DATA_FORMAT = new DataFormat("src.main.java.se333.casestudy1.model.item.BasedEquipment");
}
