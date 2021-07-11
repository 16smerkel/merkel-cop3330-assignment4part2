/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sean Merkel
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TodoListModel {
    /*
    declare private String title
    declare a collection (array/list thing) for all the todolist items
        do more research on javafx collection
    make a public TodoListModel made up of a string and collection using this.
        create get and set methods for the string and collection
    todolist section
        create a function that can add a new todolist
            ask for title, clear page, and make new empty list with new title
        create a function that can remove a todolist
            delete the list from the collection of todolist
        create a function that can edit the title of a todolist
            setter method for todolist title
    todolist item section
        create a function that can add a new item
            go through collections and create space for the new item
        create a function that can remove an item
            go through collections and edit out the item
        create a function that can edit the description of an item
            go through collections and find the item
            return the new string for the description
        create a function that can edit the due date of an item
            return the new int for the due date
        create a function that can display all items
            make a new screen shows prints every item
    todolist completion/display section
        create a function that can mark a task as complete
            maybe implement a boolean variable into the todolist item class that can be switched to true or false if completed
        create a function that can display only the incomplete task
            go item by item to check if boolean complete is marked false
        create a function that can display only the complete task
            go item by item to check if boolean complete is marked true
    todolist save section
        create a function that can save items in a single list
            research how to save file in javafx
            save the current list
        create a function that can save items in all list
            go list by list to save all the lists
    todolist load section
        create a function that can load items in a single list
            research how to load file in javafx
            load the current list
        create a function that can load multiple list
            go list by list and load the lists with the corresponding names
     */
}
