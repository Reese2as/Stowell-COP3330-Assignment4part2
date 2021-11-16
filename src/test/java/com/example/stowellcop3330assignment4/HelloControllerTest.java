/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Reese Stowell
 */
package com.example.stowellcop3330assignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    //Task 4 Adding Items
    @Test
    void addPress() {
        HelloController Controller = new HelloController();

        Items Item;
        Item = new Items(0, "Take out the trash", LocalDate.of(2020, Month.JANUARY, 8), "Incomplete");

        int id = 0;
        String Status = "Incomplete";
        String Description = "Take out the trash";
        LocalDate Date = LocalDate.of(2020, Month.JANUARY, 8);

        Controller.AddPress(id, Description, Date, Status);
        Items AddedItem = Controller.list.get(0);
        assertEquals(Item.id, AddedItem.id);
        assertEquals(Item.Status, AddedItem.Status);
        assertEquals(Item.Description, AddedItem.Description);
        assertEquals(Item.Duedate, AddedItem.Duedate);
    }

    //Task 5 Deleting Items
    @Test
    void deletePress() {
        HelloController Controller = new HelloController();

        Items Item;
        Item = new Items(0, "Take out the trash", LocalDate.of(2020, Month.JANUARY, 8), "Incomplete");

        Controller.list.add(Item);

        Controller.DeletePress(Item);
        assertEquals(Controller.list.size(), 0);
    }

    //Task 6 Clearing Whole List
    @Test
    void clearListPress() {
        HelloController Controller = new HelloController();

        Items Item, Item2, Item3;
        Item = new Items(0, "Take out the trash", LocalDate.of(2020, Month.JANUARY, 8), "Incomplete");
        Item2 = new Items(1, "Finish Your Programming :(", LocalDate.of(2023, Month.APRIL, 20), "Complete");
        Item3 = new Items(2, "GET LOST", LocalDate.of(2011, Month.JANUARY, 8), "Complete");

        Controller.list.add(Item);
        Controller.list.add(Item2);
        Controller.list.add(Item3);
        Controller.ClearListPress();
        assertEquals(Controller.list.size(), 0);
    }

    //Task 7, 8, 9 Editing Items
    @Test
    void editPress() {
        HelloController Controller = new HelloController();

        Items Item;
        Item = new Items(0, "Take out the trash", LocalDate.of(2020, Month.JANUARY, 8), "Incomplete");

        Controller.list.add(Item);

        String Status = "Complete";
        String Description = "Finish Your Programming :(";
        LocalDate Date = LocalDate.of(2023, Month.APRIL, 20);

        Controller.SaveEditPress(Item, Description, Date, Status);

        assertEquals(Item.Status, "Complete");
        assertEquals(Item.Description, "Finish Your Programming :(");
        assertEquals(Item.Duedate, LocalDate.of(2023, Month.APRIL, 20));
    }
    //Task 10 Showing All Items
    @Test
    void showAllPress() {
        HelloController Controller = new HelloController();

        Items Item, Item2, Item3;
        Item = new Items(0, "Take out the trash", LocalDate.of(2020, Month.JANUARY, 8), "Incomplete");
        Item2 = new Items(1, "Finish Your Programming :(", LocalDate.of(2023, Month.APRIL, 20), "Complete");
        Item3 = new Items(2, "GET LOST", LocalDate.of(2011, Month.JANUARY, 8), "Complete");

        Controller.list.add(Item);
        Controller.list.add(Item2);
        Controller.list.add(Item3);
        ObservableList<Items> listAll = FXCollections.observableArrayList();
        ObservableList<Items> listAll2 = Controller.ShowAllPress(listAll);

        for (int i = 0; i < listAll2.size(); i++) {
            if (listAll2.get(i).Status == "Complete"){
                assertEquals(Controller.list.get(i).Status, "Complete");
            }
            if (listAll2.get(i).Status == "Incomplete"){
                assertEquals(listAll2.get(i).Status, "Incomplete");
            }
        }
    }
    //Task 11 Showing Incomplete Items
    @Test
    void showIncompletePress() {
        HelloController Controller = new HelloController();

        Items Item, Item2, Item3;
        Item = new Items(0, "Take out the trash", LocalDate.of(2020, Month.JANUARY, 8), "Incomplete");
        Item2 = new Items(1, "Finish Your Programming :(", LocalDate.of(2023, Month.APRIL, 20), "Complete");
        Item3 = new Items(2, "GET LOST", LocalDate.of(2011, Month.JANUARY, 8), "Complete");

        Controller.list.add(Item);
        Controller.list.add(Item2);
        Controller.list.add(Item3);

        ObservableList<Items> listIncomplete = FXCollections.observableArrayList();
        ObservableList<Items> listIncompleted = Controller.ShowIncompletePress(listIncomplete);

        for (int i = 0; i < listIncompleted.size(); i++) {
            assertEquals(listIncompleted.get(i).Status, "Incomplete");
        }
    }

    //Task 12 Showing Completed Items
    @Test
    void showCompletePress() {
        HelloController Controller = new HelloController();

        Items Item, Item2, Item3;
        Item = new Items(0, "Take out the trash", LocalDate.of(2020, Month.JANUARY, 8), "Incomplete");
        Item2 = new Items(1, "Finish Your Programming :(", LocalDate.of(2023, Month.APRIL, 20), "Complete");
        Item3 = new Items(2, "GET LOST", LocalDate.of(2011, Month.JANUARY, 8), "Complete");

        Controller.list.add(Item);
        Controller.list.add(Item2);
        Controller.list.add(Item3);

        ObservableList<Items> listComplete = FXCollections.observableArrayList();
        ObservableList<Items> listCompleted = Controller.ShowCompletePress(listComplete);

        for (int i = 0; i < listCompleted.size(); i++) {
            assertEquals(listCompleted.get(i).Status, "Complete");
        }
    }

    //Task 13 Saving Items
    @Test
    void savePress() throws FileNotFoundException {
        HelloController Controller = new HelloController();

        Items Item;
        Item = new Items(0, "Take out the trash", LocalDate.of(2020, Month.JANUARY, 8), "Incomplete");

        Controller.list.add(Item);

        File file = new File("src/test/java/com/example/stowellcop3330assignment4/test13.txt");
        Controller.SavePress(file);
        Scanner scan = new Scanner(file);
        assertEquals(scan.nextLine(),"Take out the trash;2020-01-08;Incomplete");
    }

    //Task 14 Load Items
    @Test
    void loadPress() {
        HelloController Controller = new HelloController();

        File file = new File("src/test/java/com/example/stowellcop3330assignment4/test14.txt");
        Controller.LoadPress(file);

        assertEquals(Controller.list.get(0).Description, "Take out the trash");
        assertEquals(Controller.list.get(0).Duedate, LocalDate.of(2020, Month.JANUARY, 8));
        assertEquals(Controller.list.get(0).Status,"Incomplete");
    }
}

































































































