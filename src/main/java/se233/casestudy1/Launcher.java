package se233.casestudy1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import se233.casestudy1.controller.GenCharacter;
import se233.casestudy1.controller.GenItemList;
import se233.casestudy1.model.character.BasedCharacter;
import se233.casestudy1.model.item.Armor;
import se233.casestudy1.model.item.BasedEquipment;
import se233.casestudy1.model.item.Weapon;
import se233.casestudy1.view.CharacterPane;
import se233.casestudy1.view.EquipPane;
import se233.casestudy1.view.InventoryPane;
import java.util.ArrayList;

public class Launcher extends Application {

    private static Weapon equippedWeapon = null;
    private static Armor equippedArmor = null;
    private static Scene mainScene;
    private static ArrayList<BasedEquipment> allEquipment = null;
    private static CharacterPane characterPane = null;
    private static BasedCharacter mainCharacter = null;
    private static EquipPane equipPane = null;
    private static InventoryPane inventoryPane = null;

    public static Armor getEquippedArmor() {
        return equippedArmor;
    }

    public static void setEquippedArmor(Armor equippedArmon) {
        Launcher.equippedArmor = equippedArmon;
    }

    public static Scene getMainScene() {
        return mainScene;
    }

    public static void setMainScene(Scene mainScene) {
        Launcher.mainScene = mainScene;
    }

    public static ArrayList<BasedEquipment> getAllEquipment() {
        return allEquipment;
    }

    public static void setAllEquipment(ArrayList<BasedEquipment> allEquipment) {
        Launcher.allEquipment = allEquipment;
    }

    public static Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public static void setEquippedWeapon(Weapon equippedWeapon) {
        Launcher.equippedWeapon = equippedWeapon;
    }

    public static CharacterPane getCharacterPane() {
        return characterPane;
    }

    public static void setCharacterPane(CharacterPane characterPane) {
        Launcher.characterPane = characterPane;
    }

    public static EquipPane getEquipPane() {
        return equipPane;
    }

    public static void setEquipPane(EquipPane equipPane) {
        Launcher.equipPane = equipPane;
    }

    public static InventoryPane getInventoryPane() {
        return inventoryPane;
    }

    public static void setInventoryPane(InventoryPane inventoryPane) {
        Launcher.inventoryPane = inventoryPane;
    }

    public static void  unEquip(){
        BasedCharacter character = Launcher.getMainCharacter();
        Launcher.setEquippedWeapon(null);
        Launcher.setEquippedArmor(null);
        Launcher.getMainCharacter().unEquipWeapon();
        Launcher.getMainCharacter().unEquipArmor();
        Launcher.setAllEquipment(GenItemList.setUpItemList());
        Launcher.refreshPane();
    }

    public Pane getMainPane(){
        BorderPane mainPane = new BorderPane();
        characterPane = new CharacterPane();
        equipPane = new EquipPane();
        inventoryPane = new InventoryPane();
        refreshPane();
        mainPane.setCenter(characterPane);
        mainPane.setLeft(equipPane);
        mainPane.setBottom(inventoryPane);
        return mainPane;
    }

    public static void  refreshPane(){
        characterPane.drawPane(mainCharacter);
        equipPane.drawPane(equippedWeapon,equippedArmor);
        inventoryPane.drawPane(allEquipment);
    }

    public static BasedCharacter getMainCharacter(){
        return mainCharacter;
    }

    public static void setMainCharacter(BasedCharacter mainCharacter){
        Launcher.mainCharacter = mainCharacter;
    }

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Charpter1");
        primaryStage.setResizable(false);
        primaryStage.show();
        mainCharacter = GenCharacter.setUpCharacter();
        allEquipment = GenItemList.setUpItemList();
        Pane mainPane = getMainPane();
        mainScene = new Scene(mainPane);
        primaryStage.setScene(mainScene);
    }
}
