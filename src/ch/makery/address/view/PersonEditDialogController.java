package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ch.makery.address.model.Person;

/**
 * Dialog to edit details of a person.
 * 
 * @author Marco Jakob
 */
public class PersonEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField areaField;
    @FXML
    private TextField centerField;
    @FXML
    private TextField perimeterField;
    @FXML
    private TextField typeField;    

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        
        // Set the dialog icon.
        this.dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        nameField.setText(person.getName());
        areaField.setText(Double.toString(person.getArea()));
        centerField.setText(Double.toString(person.getCenter()));
        perimeterField.setText(Double.toString(person.getPerimeter()));
        typeField.setText(person.getType());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setName(nameField.getText());
            person.setArea(Double.parseDouble(areaField.getText()));
            person.setCenter(Double.parseDouble(centerField.getText()));
            person.setPerimeter(Double.parseDouble(perimeterField.getText()));
            person.setType(typeField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid name!\n"; 
        }
        
        if (areaField.getText() == null || areaField.getText().length() == 0) {
            errorMessage += "No valid area!\n"; 
        } else {
        	// try to parse the areay into a double.
            try {
                Double.parseDouble(perimeterField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid area value (must be a double)!\n"; 
            }
        }
        
        if (centerField.getText() == null || centerField.getText().length() == 0) {
            errorMessage += "No center of gravity!\n"; 
        } else {
        	// try to parse the center of gravity into a double.
            try {
                Double.parseDouble(perimeterField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid center of gravity value (must be a double)!\n"; 
            }
        }

        if (perimeterField.getText() == null || perimeterField.getText().length() == 0) {
            errorMessage += "No valid perimeter!\n"; 
        } else {
            // try to parse the perimeter into a double.
            try {
                Double.parseDouble(perimeterField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid perimeter value (must be a double)!\n"; 
            }
        }
        
        if (typeField.getText() == null || typeField.getText().length() == 0) {
            errorMessage += "No valid type!\n"; 
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
}