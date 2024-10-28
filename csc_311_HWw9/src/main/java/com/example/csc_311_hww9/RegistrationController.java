package com.example.csc_311_hww9;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;
import java.util.zip.InflaterOutputStream;

/**
 * Controller class for registration form functionality
 * provides input validation and handles transition to success screen
 */
public class RegistrationController {

    //Create TextFields
    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField zipCodeField;

    //Create button
    @FXML
    Button submitButton;

    //Create root container
    @FXML
    private VBox rootContainer;

    //Regex for validating input fields
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z]{2,25}$");

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@farmingdale\\.edu$");

    private static final Pattern DOB_PATTERN = Pattern.compile("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$");

    private static final Pattern ZIP_CODE_PATTERN = Pattern.compile("^\\d{5}$");

    /**
     * Initialize the controller with focus listeners to validate fields
     * Submit button enabled only if all fields are valid and contain data
     */
    @FXML
    public void initialize() {
    firstNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue)
            validateFirstName();
            updateSubmitButtonState();
    });

    lastNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue)
            validateLastName();
            updateSubmitButtonState();
    });

    emailField.focusedProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue)
        validateEmail();
        updateSubmitButtonState();
        });

    dobField.focusedProperty().addListener((observable, oldValue, newValue) -> {
        if(!newValue)
        validateDOB();
        updateSubmitButtonState();
    });

    zipCodeField.focusedProperty().addListener((observable, oldValue, newValue) -> {
        if(!newValue)
        validateZipCode();
        updateSubmitButtonState();
    });
    }

    /**
     * Validates the first name field, ensuring it has between 2-25 alphabetic characters
     */
    private void validateFirstName() {
        if(!NAME_PATTERN.matcher(firstNameField.getText()).matches()){
            showError(firstNameField, "First name must be 2-25 alphabetic characters");
        } else {
            clearError(firstNameField);
        }
    }

    /**
     * Validates the last name field, ensuring it has between 2-25 alphabetic characters
     */
    private void validateLastName() {
        if(!NAME_PATTERN.matcher(lastNameField.getText()).matches()){
            showError(lastNameField, "Last name must be 2-25 alphabetic characters");
        } else {
            clearError(lastNameField);
        }
    }

    /**
     *Validates the email field, ensuring it is a farmingdale.edu email address
     */
    private void validateEmail() {
        if(!EMAIL_PATTERN.matcher(emailField.getText()).matches()){
        showError(emailField, "Enter a valid @farmingdale.edu email");
        } else {
        clearError(emailField);
        }
    }

    /**
     * Validates the date of birth field, ensuring it is a valid 1-12 month and 1-31 day proper format(DD/MM/YYYY)
     */
    private void validateDOB() {
        if(!DOB_PATTERN.matcher(dobField.getText()).matches()){
        showError(dobField, "Date of Birth must be MM/DD/YYYY format");
        } else {
        clearError(dobField);
        }
    }

    /**
     * Validates the zip code field, ensuring it is a valid 5 digit number
     */
    private void validateZipCode() {
        if(!ZIP_CODE_PATTERN.matcher(zipCodeField.getText()).matches()){
            showError(zipCodeField, "Zip code must be 5 digits");
        } else {
            clearError(zipCodeField);
        }
    }

    /**
     * Enables the submit button's state, so it is only accessible if all fields contain valid data
     */
    private void updateSubmitButtonState() {
        boolean allValid = NAME_PATTERN.matcher(firstNameField.getText().trim()).matches() && NAME_PATTERN.matcher(lastNameField.getText().trim()).matches() && EMAIL_PATTERN.matcher(emailField.getText().trim()).matches() && DOB_PATTERN.matcher(dobField.getText().trim()).matches() && ZIP_CODE_PATTERN.matcher(zipCodeField.getText().trim()).matches();
        submitButton.setDisable(!allValid);
    }

    /**
     * Displays error on the field and highlights it
     * @param field the text field with the error
     */
    private void clearError(TextField field) {
        field.setTooltip(null);
        field.setStyle(null);
    }

    /**
     * Highlights specific text fields in red when an incorrect format has been entered
     * @param field the TextField which contains an error
     * @param message the error message to display
     * @throws NullPointerException if the field or message is null
     */
    private void showError(TextField field, String message) {
        field.setTooltip(new Tooltip(message));
        field.setStyle("-fx-background-color: red;");
    }

    /**
     * Handles the submit button click event, navigates to the success screen
     */
    @FXML
    private void submitHandle() {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Success.fxml"));
        Parent successRoot = loader.load();
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.setScene(new Scene(successRoot));
        } catch (IOException e){
        e.printStackTrace();
        }
    }
}