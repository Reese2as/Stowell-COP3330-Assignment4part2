/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Reese Stowell
 */
package com.example.stowellcop3330assignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
//Will be renamed to Controller
public class HelloController {

    @FXML

    private ListView List1;

    @FXML
    protected void initialize()
    {
        ObservableList<String> content = FXCollections.observableArrayList("List 1");
        List1.setItems(content);
    }
}