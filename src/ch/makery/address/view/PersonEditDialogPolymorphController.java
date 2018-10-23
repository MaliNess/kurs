package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import ch.makery.address.model.Person;

/**
 * Dialog to edit details of a person.
 * 
 * @author Marco Jakob
 */
public class PersonEditDialogPolymorphController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField typeField;

    @FXML
    private GridPane rectanGrid;
    @FXML
    private TextField rectangleCoordx1;
    @FXML
    private TextField rectangleCoordx2;
    @FXML
    private TextField rectangleCoordx3;
    @FXML
    private TextField rectangleCoordx4;
    @FXML
    private TextField rectangleCoordy1;
    @FXML
    private TextField rectangleCoordy2;
    @FXML
    private TextField rectangleCoordy3;    
    @FXML
    private TextField rectangleCoordy4;
    
    @FXML
    private GridPane trapezGrid;
    @FXML
    private TextField trapeziumCoordx1;
    @FXML
    private TextField trapeziumCoordx2;
    @FXML
    private TextField trapeziumCoordx3;
    @FXML
    private TextField trapeziumCoordx4;
    @FXML
    private TextField trapeziumCoordy1;
    @FXML
    private TextField trapeziumCoordy2;
    @FXML
    private TextField trapeziumCoordy3;
    @FXML
    private TextField trapeziumCoordy4;
    
    @FXML
    private GridPane circGrid;
    @FXML
    private TextField circleCoordx1;
    @FXML
    private TextField circleCoordy1;
    @FXML
    private TextField circleRadius1;
        
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
        typeField.setText(person.getType());
        switch (person.getTypeCode()) {
		case 1:
			typeField.setText("Rectangle");
	    	rectanGrid.setVisible(true);
	    	trapezGrid.setVisible(false);
	    	circGrid.setVisible(false);
	    	rectangleCoordx1.setText(Double.toString(person.getCoordX(person.getPoint(0))));
	    	rectangleCoordy1.setText(Double.toString(person.getCoordY(person.getPoint(0))));
	    	rectangleCoordx2.setText(Double.toString(person.getCoordX(person.getPoint(1))));
	    	rectangleCoordy2.setText(Double.toString(person.getCoordY(person.getPoint(1))));
	    	rectangleCoordx3.setText(Double.toString(person.getCoordX(person.getPoint(2))));
	    	rectangleCoordy3.setText(Double.toString(person.getCoordY(person.getPoint(2))));
	    	rectangleCoordx4.setText(Double.toString(person.getCoordX(person.getPoint(3))));
	    	rectangleCoordy4.setText(Double.toString(person.getCoordY(person.getPoint(3))));
			break;
		case 2:
			typeField.setText("Trapezium");
	    	trapezGrid.setVisible(true);
	    	rectanGrid.setVisible(false);
	    	circGrid.setVisible(false);
	    	trapeziumCoordx1.setText(Double.toString(person.getCoordX(person.getPoint(0))));
	    	trapeziumCoordy1.setText(Double.toString(person.getCoordY(person.getPoint(0))));
	    	trapeziumCoordx2.setText(Double.toString(person.getCoordX(person.getPoint(1))));
	    	trapeziumCoordy2.setText(Double.toString(person.getCoordY(person.getPoint(1))));
	    	trapeziumCoordx3.setText(Double.toString(person.getCoordX(person.getPoint(2))));
	    	trapeziumCoordy3.setText(Double.toString(person.getCoordY(person.getPoint(2))));
	    	trapeziumCoordx4.setText(Double.toString(person.getCoordX(person.getPoint(3))));
	    	trapeziumCoordy4.setText(Double.toString(person.getCoordY(person.getPoint(3))));
			break;
		case 3:
			typeField.setText("Circle");
	    	circGrid.setVisible(true);
	    	rectanGrid.setVisible(false);
	    	trapezGrid.setVisible(false);
	    	circleCoordx1.setText(Double.toString(person.getCoordX(person.getPoint(0))));
	    	circleCoordy1.setText(Double.toString(person.getCoordY(person.getPoint(0))));
	    	circleRadius1.setText(Double.toString(person.getRadius()));
			break;
		default:
			break;
		}
    }
    
    int selectedType;
    
    public void selectedRectangle() {
    	typeField.setText("Rectangle");
    	rectanGrid.setVisible(true);
    	trapezGrid.setVisible(false);
    	circGrid.setVisible(false);
    	selectedType = 1;
    }
    
    public void selectedTrapezium() {
    	typeField.setText("Trapezium");
    	trapezGrid.setVisible(true);
    	rectanGrid.setVisible(false);
    	circGrid.setVisible(false);
    	selectedType = 2;
    }
    
    public void selectedCircle() {
    	typeField.setText("Circle");
    	circGrid.setVisible(true);
    	rectanGrid.setVisible(false);
    	trapezGrid.setVisible(false);
    	selectedType = 3;
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
			person.clearPoints();
            person.setName(nameField.getText());
            person.setType(typeField.getText());
                        
            /*
             * Point создаётся только с Int координатами, а возвращает Double!!!??? Возможно есть перегузка для Double
             */
            switch (selectedType) {
			case 1:
				person.addPoint(Integer.parseInt(rectangleCoordx1.getText()), Integer.parseInt(rectangleCoordy1.getText()));
				person.addPoint(Integer.parseInt(rectangleCoordx2.getText()), Integer.parseInt(rectangleCoordy2.getText()));
				person.setTypeCode(selectedType);
				break;
			case 2:
				person.addPoint(Integer.parseInt(trapeziumCoordx1.getText()), Integer.parseInt(trapeziumCoordy1.getText()));
				person.addPoint(Integer.parseInt(trapeziumCoordx2.getText()), Integer.parseInt(trapeziumCoordy2.getText()));
				person.addPoint(Integer.parseInt(trapeziumCoordx3.getText()), Integer.parseInt(trapeziumCoordy3.getText()));
				person.addPoint(Integer.parseInt(trapeziumCoordx4.getText()), Integer.parseInt(trapeziumCoordy4.getText()));
				person.setTypeCode(selectedType);
				break;
			case 3:
				person.addPoint(Integer.parseInt(circleCoordx1.getText()), Integer.parseInt(circleCoordy1.getText()));
				person.setRadius(Double.parseDouble(circleRadius1.getText()));
				person.setTypeCode(selectedType);
				break;
			default:
				break;
			}
            
            /* Ожидаем методы Насти (Координаты зранятся в ArrayList Points, дёргать оттуда), возвращать Double
            person.setArea(area);
            person.setCenter(center_of_gravity);
            person.setPerimeter(perimeter);
			*/
            
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