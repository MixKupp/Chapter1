package se233.casestudy1.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import se233.casestudy1.Launcher;
import se233.casestudy1.model.character.BasedCharacter;
import se233.casestudy1.model.item.Armor;
import se233.casestudy1.model.item.BasedEquipment;
import se233.casestudy1.model.item.Weapon;

import java.awt.font.ImageGraphicAttribute;
import java.util.ArrayList;

public class AllCustomHandler {
    public static class GenCharacterHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            Launcher.setMainCharacter(GenCharacter.setUpCharacter());
            Launcher.refreshPane();
        }
    }
    public static void onDragDetected(MouseEvent event, BasedEquipment equipment, ImageView imgView){
        Dragboard db = imgView.startDragAndDrop(TransferMode.ANY);
        db.setDragView(imgView.getImage());
        ClipboardContent content = new ClipboardContent();
        content.put(BasedEquipment.DATA_FORMAT,equipment);
        db.setContent(content);
        event.consume();
    }
    public static void onDragOver(DragEvent event,String type){
        Dragboard dragboard = event.getDragboard();
        BasedEquipment retrievedEquipment = (BasedEquipment) dragboard.getContent(BasedEquipment.DATA_FORMAT);
        if (dragboard.hasContent(BasedEquipment.DATA_FORMAT)&& retrievedEquipment.getClass().getSimpleName().equals(type))event.acceptTransferModes(TransferMode.MOVE);
    }
    public static void onDragDropped(DragEvent event, Label lbl, StackPane imgGroup){
        boolean dragCompleted = false;
        Dragboard dragboard = event.getDragboard();
        ArrayList<BasedEquipment>allEquipments = Launcher.getAllEquipment();
        if(dragboard.hasContent(BasedEquipment.DATA_FORMAT)){
            BasedEquipment retrivedEquipment = (BasedEquipment) dragboard.getContent(BasedEquipment.DATA_FORMAT);
            BasedCharacter character = Launcher.getMainCharacter();
            if (retrivedEquipment.getClass().getSimpleName().equals("Weapon")){
                if(Launcher.getEquippedWeapon() != null){
                    allEquipments.add(Launcher.getEquippedWeapon());
                }
                Launcher.setEquippedWeapon((Weapon)retrivedEquipment);
                character.equipWeapon((Weapon) retrivedEquipment);
            }
            else {
                if(Launcher.getEquippedArmor() !=null){
                    allEquipments.add(Launcher.getEquippedArmor());
                }
                Launcher.setEquippedArmor((Armor)retrivedEquipment);
                character.equipArmor((Armor) retrivedEquipment);
            }
            Launcher.setMainCharacter(character);
            Launcher.setAllEquipment(allEquipments);
            Launcher.refreshPane();

            ImageView imageView = new ImageView();
            if (imgGroup.getChildren().size()!= 1){
                imgGroup.getChildren().remove(1);
                Launcher.refreshPane();
            }
            lbl.setText(retrivedEquipment.getClass().getSimpleName()+":\n"+retrivedEquipment.getName());
            imageView.setImage(new Image(Launcher.class.getResource(retrivedEquipment.getImgpath()).toString()));
            imgGroup.getChildren().add(imageView);
            dragCompleted = true;
        }
        event.setDropCompleted(dragCompleted);
    }
    public static void  onEquipDone(DragEvent event){
        Dragboard dragboard = event.getDragboard();
        ArrayList<BasedEquipment> allEquipments = Launcher.getAllEquipment();
        BasedEquipment retrievedEquipment = (BasedEquipment) dragboard.getContent(BasedEquipment.DATA_FORMAT);
        int pos = -1;
        for (int i = 0; i < allEquipments.size(); i++) {
            if (allEquipments.get(i).getName().equals(retrievedEquipment.getName())){
                pos = i;
            }
        }
        if(pos!=-1){
            allEquipments.remove(pos);
        }
        Launcher.setAllEquipment(allEquipments);
        Launcher.refreshPane();
    }
}
