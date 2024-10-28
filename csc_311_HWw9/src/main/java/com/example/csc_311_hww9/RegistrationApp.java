package com.example.csc_311_hww9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main app class for registration application
 * Initializes the application and loads the registration form
 */
public class RegistrationApp extends Application {
    /**
     * starts the application
     * @param stage primary stag for the application
     * @throws IOException if an error occurs  during the FXML file load
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Registration.fxml"));
        Parent root = loader.load();
        stage.setTitle("Registration Form");
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Main entry for application launch
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}