package se233.camelot.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import se233.camelot.Launcher;
import se233.camelot.view.Platform;

import java.io.IOException;

public class CharacterViewController {

    @FXML
    private Button playBtn;
    @FXML
    private Button backBtn;
    @FXML
    public void initialize() {
        playBtn.setOnAction( event -> {
            Platform platform = new Platform() ;
            Launcher.musicController.play("game");
            Launcher.stage.getScene().setOnKeyPressed(keyEvent -> platform.getKeys().add(keyEvent.getCode()));
            Launcher.stage.getScene().setOnKeyReleased( keyEvent -> {
                platform.getKeys().remove(keyEvent.getCode());
                System.out.println(keyEvent.getCode());
            });
            Launcher.stage.getScene().setRoot(platform);
        });

        backBtn.setOnAction(event -> {
            //back
        });
    }
}
