/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab03.quentinproulx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * GitHub Link: https://github.com/QuentinProulx/lab03
 * @author 6324569 - Quentin Proulx
 */
public class Lab03QuentinProulx extends Application {
        Label firstName = new Label("First Name:");
        Label lastName = new Label("Last Name:");
        Label email = new Label("Email:");
        Label password = new Label("Password:");
        Label message = new Label();
        
        TextField firstNameInput = new TextField();
        TextField lastNameInput = new TextField();
        TextField emailInput = new TextField();
        PasswordField passwordInput = new PasswordField();
        
        Button register = new Button("Register");
        Button clear = new Button("Clear");
    
        GridPane gridPane = new GridPane();
        BorderPane borderPane = new BorderPane(gridPane);
        Scene scene = new Scene(borderPane, 600, 500);
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    boolean firstNameFilled = false;
    boolean lastNameFilled = false;
    boolean emailFilled = false;
    boolean passwordFilled = false;
    
    @Override
    public void start(Stage stage) throws Exception {
        register.setDisable(true);
        
        firstNameInput.setOnKeyTyped(e -> {
            firstNameFilled = firstNameInput.getText().length() > 0;
            setRegister();
        });
        
        lastNameInput.setOnKeyTyped(e -> {
            lastNameFilled = lastNameInput.getText().length() > 0;
            setRegister();
        });
        
        emailInput.setOnKeyTyped(e -> {
            emailFilled = emailInput.getText().length() > 0;
            setRegister();
        });
        
        passwordInput.setOnKeyTyped(e -> {
            passwordFilled = passwordInput.getText().length() > 0;
            setRegister();
        });
        
        clear.setOnMouseClicked(e -> {
            firstNameInput.setText("");
            lastNameInput.setText("");
            emailInput.setText("");
            passwordInput.setText("");
            
            register.setDisable(true);
        });
        
        register.setOnMouseClicked(e -> {
            // Checking password
            boolean hasLetter = false;
            boolean hasNumber = false;
            
            for (Character c : passwordInput.getText().toCharArray()) {
                if (c > 47 && c < 58) {
                    hasNumber = true;
                }
                if ((c > 64 && c < 91) || (c > 96 && c < 123)) {
                    hasLetter = true;
                }
            }
            boolean password = hasLetter && hasNumber;
            
            // Checking email
            boolean hasAt = false;
            
            String address = emailInput.getText();
            if (address.split("@").length == 2) {
                hasAt = true;
                address = address.split("@")[1];
            }
            
            boolean validDom = false;
            if (address.split("\\.").length == 2 && hasAt) {
                validDom = true;
            }
            boolean email = hasAt && validDom;
            
            // Setting message
            if (password && email) {
                message.setText("WELCOME!");
            } else {
                message.setText("ERROR IN FIELD(S)");
            }
        });
        
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        gridPane.add(firstName, 0, 1);
        gridPane.add(lastName, 0, 2);
        gridPane.add(email, 0, 3);
        gridPane.add(password, 0, 4);
        gridPane.add(firstNameInput, 1, 1);
        gridPane.add(lastNameInput, 1, 2);
        gridPane.add(emailInput, 1, 3);
        gridPane.add(passwordInput, 1, 4);
        
        gridPane.add(register, 0, 5);
        gridPane.add(clear, 1, 5);
        
        gridPane.add(message, 1, 0);
        
        stage.setTitle("Lab03");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    private void setRegister() {
        if (firstNameFilled && lastNameFilled && emailFilled && passwordFilled) {
            register.setDisable(false);
        } else {
            register.setDisable(true);
        }
    }
    
}
