/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Reese Stowell
 */
package com.example.stowellcop3330assignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

//Will be renamed to Controller
public class HelloController implements Initializable {

    @FXML
    private TableView<Items> table;

    @FXML
    private TableColumn<Items, Integer> id;

    @FXML
    private TableColumn<Items, String> Description;

    @FXML
    private TableColumn<Items, LocalDate> DueDate;

    @FXML
    private TableColumn<Items, Boolean> Status;

    ObservableList<Items> list = FXCollections.observableArrayList(
            new Items(1,"Swag", LocalDate.of(2020, 1, 8),true )
    );



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Items,Integer>("id"));
        Description.setCellValueFactory(new PropertyValueFactory<Items,String>("Description"));
        DueDate.setCellValueFactory(new PropertyValueFactory<Items,LocalDate>("DueDate"));
        Status.setCellValueFactory(new PropertyValueFactory<Items,Boolean>("Status"));

        table.setItems(list);
    }
}