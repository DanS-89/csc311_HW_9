package com.example.csc_311_hww9;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for success screen displayed after successful registration completion
 */
public class SuccessController {

    @FXML
    Button resetButton;

    /**
     * handles reset button, navigates back to blank registration form
     */
    @FXML
    private void resetHandle(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Registration.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) resetButton.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
