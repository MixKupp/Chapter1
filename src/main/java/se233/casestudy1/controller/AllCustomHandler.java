package se233.casestudy1.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import se233.casestudy1.Launcher;
import se233.casestudy1.model.Damagetype;
import se233.casestudy1.model.character.BasedCharacter;
import se233.casestudy1.model.item.Armor;
import se233.casestudy1.model.item.BasedEquipment;
import se233.casestudy1.model.item.Weapon;
import se233.casestudy1.view.EquipPane;

import java.util.ArrayList;

public class AllCustomHandler {
    public static class GenCharacterHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Launcher.setMainCharacter(GenCharacter.setUpCharacter());
            // Unequip all equipments when generate new character - START
            if (Launcher.getEquippedWeapon() != null || Launcher.getEquippedArmor() != null) {
                Launcher.unEquip();
            }
            // Unequip all equipments when generate new character - END
            Launcher.refreshPane();
        }

        public static void onDragDetected(MouseEvent event, BasedEquipment equipment, ImageView imgView) {
            Dragboard db = imgView.startDragAndDrop(TransferMode.ANY);
            db.setDragView(imgView.getImage());
            ClipboardContent content = new ClipboardContent();
            content.put(BasedEquipment.DATA_FORMAT, equipment);
            db.setContent(content);
            event.consume();
        }

        public static void onDragOver(DragEvent event, String type) {
            Dragboard dragboard = event.getDragboard();
            BasedEquipment retrievedEquipment = (BasedEquipment) dragboard.getContent(BasedEquipment.DATA_FORMAT);
            if (dragboard.hasContent(BasedEquipment.DATA_FORMAT) && retrievedEquipment.getClass().getSimpleName().equals(type)) {
                if (retrievedEquipment.getClass().getSimpleName().equals("Weapon") && (retrievedEquipment.getDmtype() == Launcher.getMainCharacter().getType())) {
                    event.acceptTransferModes(TransferMode.MOVE);
                } else if (retrievedEquipment.getClass().getSimpleName().equals("Weapon") && (Launcher.getMainCharacter().getType() == Damagetype.magi)) {
                    event.acceptTransferModes(TransferMode.MOVE);
                } else if (retrievedEquipment.getClass().getSimpleName().equals("Armor") && (Launcher.getMainCharacter().getType() != Damagetype.magi)) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }else{
                    event.acceptTransferModes(TransferMode.MOVE);
                }
            }
        }

        public static void onDragDropped(DragEvent event, Label lbl, StackPane imgGroup) {
            boolean dragComplete = false;
            Dragboard dragboard = event.getDragboard();
            ArrayList<BasedEquipment> allEquipments = Launcher.getAllEquipment();
            if (dragboard.hasContent(BasedEquipment.DATA_FORMAT)) {
                BasedEquipment retrievedEquipment = (BasedEquipment) dragboard.getContent(BasedEquipment.DATA_FORMAT);
                BasedCharacter character = Launcher.getMainCharacter();
                if (retrievedEquipment.getClass().getSimpleName().equals("Weapon")) {
                    if (Launcher.getEquippedWeapon() != null) {
                        allEquipments.add(Launcher.getEquippedWeapon());
                    }
                    Launcher.setEquippedWeapon((Weapon) retrievedEquipment);
                    character.equipWeapon((Weapon) retrievedEquipment);
                } else if (retrievedEquipment.getClass().getSimpleName().equals("Armor")) {
                    if (Launcher.getEquippedArmor() != null) {
                        allEquipments.add(Launcher.getEquippedArmor());
                    }
                    Launcher.setEquippedArmor((Armor) retrievedEquipment);
                    character.equipArmor((Armor) retrievedEquipment);
                }
                Launcher.setMainCharacter(character);
                Launcher.setAllEquipment(allEquipments);
                Launcher.refreshPane();
                ImageView imgView = new ImageView();
                if (imgGroup.getChildren().size() != 1) {
                    imgGroup.getChildren().remove(1);
                    Launcher.refreshPane();
                }
                lbl.setText(retrievedEquipment.getClass().getSimpleName() + ":\n" + retrievedEquipment.getName());
                imgView.setImage(new Image(Launcher.class.getResource(retrievedEquipment.getImgpath()).toString()));
                imgGroup.getChildren().add(imgView);
                dragComplete = true;
            }
            event.setDropCompleted(dragComplete);
        }

        public static void onEquipDone(DragEvent event) {
            Dragboard dragboard = event.getDragboard();
            ArrayList<BasedEquipment> allEquipments = Launcher.getAllEquipment();
            BasedEquipment retrievedEquipment = (BasedEquipment) dragboard.getContent(BasedEquipment.DATA_FORMAT);
            // Prevent item drop outside item slot - START
            if (event.getTransferMode() == TransferMode.MOVE) {
                int pos = -1;
                for (int i = 0; i < allEquipments.size(); i++) {
                    if (allEquipments.get(i).getName().equals(retrievedEquipment.getName())) {
                        pos = i;
                    }
                }
                if (pos != -1) {
                    allEquipments.remove(pos);
                }
            }
            // Prevent item drop outside item slot - END
            Launcher.setAllEquipment(allEquipments);
            Launcher.refreshPane();
        }
    }
}
