/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Reese Stowell
 */
package com.example.stowellcop3330assignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

//Will be renamed to Controller
public class HelloController implements Initializable {
    FileChooser fileChooser = new FileChooser();

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

    @FXML
    private Button Add;

    @FXML
    private Button Delete;

    @FXML
    private Button SaveEdit;

    @FXML
    private Button ShowComplete;

    @FXML
    private Button ShowIncomplete;

    @FXML
    private Button ClearList;

    @FXML
    private Button ShowAll;

    @FXML
    private Button Save;

    @FXML
    private Button Load;

    @FXML
    private javafx.scene.control.TextArea TextArea;

    @FXML
    private DatePicker DateBox;

    @FXML
    private CheckBox CheckBox;


    public ObservableList<Items> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Items,Integer>("id"));
        Description.setCellValueFactory(new PropertyValueFactory<Items,String>("Description"));
        DueDate.setCellValueFactory(new PropertyValueFactory<Items,LocalDate>("DueDate"));
        Status.setCellValueFactory(new PropertyValueFactory<Items,Boolean>("Status"));

        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));

        table.setItems(list);
    }

    public void AddPressJunit(ActionEvent actionEvent){
        int id = list.size();
        String Description = TextArea.getText();
        LocalDate Date = DateBox.getValue();
        Boolean StatusBool = CheckBox.isSelected();
        String Status;
        if(StatusBool == true){
            Status = "Complete";
        }
        else{
            Status = "Incomplete";
        }
        AddPress(id, Description, Date, Status);
        table.refresh();
    }

    public void AddPress(int id, String Description, LocalDate Date, String Status){
        Items Item1 = new Items(id, Description, Date, Status);
        list.add(Item1);
    }

    public void DeletePressJunit(ActionEvent actionEvent){
        Items Item = table.getSelectionModel().getSelectedItem();
        DeletePress(Item);
        table.refresh();
    }
    public void DeletePress(Items Item){
        list.remove(Item);
        for(int i = 0; i<list.size(); i++){
            list.get(i).id = i;
        }
    }
    public void SaveEditPressJunit(ActionEvent actionEvent){
        Items Item = table.getSelectionModel().getSelectedItem();
        String Description = TextArea.getText();
        LocalDate Date = DateBox.getValue();
        Boolean StatusBool = CheckBox.isSelected();
        String Status;
        if(StatusBool == true){
            Status = "Complete";
        }
        else{
            Status = "Incomplete";
        }
        SaveEditPress(Item, Description, Date, Status);
        table.refresh();
    }
    public void SaveEditPress(Items Item, String Description, LocalDate Date, String Status){
        Item.setStatus(Status);
        Item.setDescription(Description);
        Item.setDuedate(Date);
    }

    public void ShowCompletePressJunit(ActionEvent actionEvent){
        ObservableList<Items> listComplete = FXCollections.observableArrayList();
        ObservableList<Items> listCompleted = ShowCompletePress(listComplete);
        table.setItems(listCompleted);
        table.refresh();
    }
    public ObservableList<Items> ShowCompletePress( ObservableList<Items> listComplete){

        for(int i = 0; i<list.size(); i++){
            if(list.get(i).Status == "Complete"){
                listComplete.add(list.get(i));
            }
        }
        return listComplete;
    }

    public void ShowIncompletePressJunit(ActionEvent actionEvent){
        ObservableList<Items> listIncomplete = FXCollections.observableArrayList();
        ObservableList<Items> listIncompleted = ShowIncompletePress(listIncomplete);
        table.setItems(listIncompleted);
        table.refresh();
    }

    public ObservableList<Items> ShowIncompletePress( ObservableList<Items> listIncomplete){
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).Status == "Incomplete") {
                listIncomplete.add(list.get(i));
            }
        }
        return listIncomplete;
    }

    public void ClearListPressJunit(ActionEvent actionEvent){
        table.setItems(list);
        ClearListPress();
        table.refresh();
    }

    public void ClearListPress(){
        list.clear();
    }

    public void ShowAllPressJunit(ActionEvent actionEvent){
        ObservableList<Items> listAll = FXCollections.observableArrayList();
        ObservableList<Items> listAll2 = ShowAllPress(listAll);
        table.setItems(listAll2);
        table.setItems(list);
        table.refresh();
    }
    public ObservableList<Items> ShowAllPress(ObservableList<Items> listAll){
        for(int i = 0; i<list.size(); i++){
            listAll.add(list.get(i));
        }
        return listAll;
    }
    public void SavePressJunit(ActionEvent actionEvent){
        final Stage primaryStage = new Stage();
        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("List1");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text File", "*.txt"));
        File file = fileChooser.showSaveDialog(primaryStage);
        SavePress(file);
    }
    public void SavePress(File file){
        String textFile = "";
        for(int i = 0; i<list.size(); i++){
            textFile += list.get(i).Description;
            textFile += ";";

            textFile += list.get(i).Duedate;
            textFile += ";";

            textFile += list.get(i).Status;
            if (i != list.size() - 1)
                textFile += "\n";
        }
        if (file != null) {
            try {
                PrintWriter writer;
                writer = new PrintWriter(file);
                writer.println(textFile);
                writer.close();
            } catch (IOException ex) {

            }
        }
    }

    public void LoadPressJunit(ActionEvent actionEvent){
        final Stage primaryStage = new Stage();
        fileChooser.setTitle("Load Dialog");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text File", "*.txt"));
        File file = fileChooser.showOpenDialog(primaryStage);
        LoadPress(file);
    }

    public void LoadPress(File file){
        List<String> lines;
        try
        {
            lines = Files.readAllLines(Paths.get(String.valueOf(file)), StandardCharsets.US_ASCII);
        }
        catch (Exception ex) {
            System.out.println("File not found.");
            return;
        }

        Items item;
        String line, description, status;
        LocalDate dueDate;
        for (int i = 0; i < lines.size(); i++)
        {
            line = lines.get(i);

            description = line.substring(0, line.indexOf(";"));
            line = line.substring(line.indexOf(";") + 1);

            dueDate = LocalDate.parse(line.substring(0, line.indexOf(";")));
            line = line.substring(line.indexOf(";") + 1);

            status = line;
            item = new Items(list.size(), description, dueDate, status);
            list.add(item);
        }
    }
}