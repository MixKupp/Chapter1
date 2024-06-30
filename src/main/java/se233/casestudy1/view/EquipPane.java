package se233.casestudy1.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import se233.casestudy1.Launcher;
import se233.casestudy1.controller.AllCustomHandler;
import se233.casestudy1.model.item.Armor;
import se233.casestudy1.model.item.Weapon;

public class EquipPane extends ScrollPane {
    private Weapon equiepedWeapon;
    private Armor equiepedArmor;
    public EquipPane(){}
    private Pane getDetailsPane() {
        Pane equipmentInfoPane = new VBox(10);
        equipmentInfoPane.setBorder(null);
        ((VBox) equipmentInfoPane).setAlignment((Pos.CENTER));
        equipmentInfoPane.setPadding(new Insets(25, 25, 25, 25));
        Label weaponLbl, armorLbl;
        StackPane weaponImgGroup = new StackPane();
        StackPane armorImgGroup = new StackPane();
        ImageView bg1 = new ImageView();
        ImageView bg2 = new ImageView();
        ImageView weaponImg = new ImageView();
        ImageView armorImg = new ImageView();
        bg1.setImage(new Image(Launcher.class.getResource("assets/blank.png").toString()));
        bg2.setImage(new Image(Launcher.class.getResource("assets/blank.png").toString()));
        weaponImgGroup.getChildren().add(bg1);
        armorImgGroup.getChildren().add(bg2);
        if (equiepedWeapon != null) {
            weaponLbl = new Label("Weapon:\n" + equiepedWeapon.getName());
            weaponImg.setImage(new Image(Launcher.class.getResource(
                    equiepedWeapon.getImgpath()).toString())
            );
            weaponImgGroup.getChildren().add(weaponImg);
        } else {
            weaponLbl = new Label("Weapon:");
            weaponImg.setImage(new Image(Launcher.class.getResource(
                    "assets/blank.png").toString())
            );
        }
        if (equiepedArmor != null) {
            armorLbl = new Label("Armor:\n" + equiepedArmor.getName());
            armorImg.setImage(new Image(Launcher.class.getResource(
                    equiepedArmor.getImgpath()).toString())
            );
            armorImgGroup.getChildren().add(armorImg);
        } else {
            armorLbl = new Label("Armor:");
            armorImg.setImage(new Image(Launcher.class.getResource(
                    "assets/blank.png").toString())
            );
        }
        weaponImgGroup.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent e) {
                AllCustomHandler.GenCharacterHandler.onDragOver(e, "Weapon");
            }
        });
        armorImgGroup.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent e) {
                AllCustomHandler.GenCharacterHandler.onDragOver(e, "Armor");
            }
        });
        weaponImgGroup.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent e) {
                AllCustomHandler.GenCharacterHandler.onDragDropped(e, weaponLbl, weaponImgGroup);
            }
        });
        armorImgGroup.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent e) {
                AllCustomHandler.GenCharacterHandler.onDragDropped(e, armorLbl, armorImgGroup);
            }
        });

        Button unEquipButton = new Button();
        unEquipButton.setText("Unequip all");
        unEquipButton.setOnAction(event -> Launcher.unEquip());
        equipmentInfoPane.getChildren().addAll(weaponLbl, weaponImgGroup, armorLbl, armorImgGroup, unEquipButton);
        return equipmentInfoPane;
    }
    public void drawPane(Weapon equiepedWeapon,Armor equiepedArmor){
        this.equiepedWeapon = equiepedWeapon;
        this.equiepedArmor = equiepedArmor;
        Pane equipmentInfo = getDetailsPane();
        this.setStyle("-fx-background-color: Red;");
        this.setContent(equipmentInfo);
    }
}
