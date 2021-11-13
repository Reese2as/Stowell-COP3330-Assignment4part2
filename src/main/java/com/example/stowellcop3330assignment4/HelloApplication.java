/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Reese Stowell
 */
package com.example.stowellcop3330assignment4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//Will be renamed to App
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("List Viewer.fxml"));
        HelloController controller = new HelloController();
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), 686, 777);
        stage.setTitle("To-Do List Viewer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}