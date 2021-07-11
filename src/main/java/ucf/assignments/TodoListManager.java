/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sean Merkel
 */
package ucf.assignments;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class TodoListManager extends Application {
    @FXML
    private TableView<TodoListItem> table;

    TextField nameInput;
    CheckBox completeInput;
    DatePicker dateInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            AnchorPane root = FXMLLoader.load(getClass().getResource("TodoListManager.fxml"));

            Button getHelp = new Button("Help");
            Button theDelete = new Button("My List");
            root.getChildren().add(getHelp);
            root.getChildren().add(theDelete);
            root.setRightAnchor(theDelete, 220.0);
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Todo List");
            primaryStage.show();
            TableColumn<TodoListItem, String> completeColumn = new TableColumn<>("Completed");
            TableColumn<TodoListItem, String> nameColumn = new TableColumn<>("Task Description");
            TableColumn<TodoListItem, LocalDate> dateColumn = new TableColumn<>("Due Date");
            dateColumn.setMinWidth(100);
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
            nameColumn.setMinWidth(100);
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            completeColumn.setMinWidth(100);
            completeColumn.setCellValueFactory(new PropertyValueFactory<>("completionCheck"));
            nameInput = new TextField();
            nameInput.setPromptText("title");
            dateInput = new DatePicker();
            dateInput.setPromptText("dueDate");
            completeInput = new CheckBox();
            Button addButton = new Button("Add");
            addButton.setOnAction(e-> addItem());
            addButton.setMinWidth(50);
            Button deleteButton = new Button("Delete");
            deleteButton.setOnAction(e-> deleteItem());
            deleteButton.setMinWidth(50);
            Button editButton = new Button("Edit");
            editButton.setOnAction(e-> editItem());
            editButton.setMinWidth(50);
            Button clearButton = new Button("Clear");
            clearButton.setOnAction(e-> clearAll());
            clearButton.setMinWidth(50);

            HBox hBox = new HBox();
            hBox.setPadding(new Insets(10,10,10,10));
            hBox.setSpacing(10);
            hBox.getChildren().addAll(nameInput, dateInput, completeInput, addButton, deleteButton, editButton, clearButton);
            table = new TableView<>();
            table.setItems(getProduct());
            table.getColumns().addAll(completeColumn, dateColumn, nameColumn);

            theDelete.setOnAction(event-> {
                        refresh();
                        Button getDelete = new Button(("back"));
                        VBox vbo = new Vbox();
                        vbo.getChildren().add(getDelete);
                        vbo.getChildren().addAll(table, hBox);
                        Scene so = new Scene(vbo, 500, 300);
                        primaryStage.setScene(so);
                        getDelete.setOnAction(f -> {
                            primaryStage.setScene(scene);
                        });
                    });

            getHelp.setOnAction(e -> {
                Button getHelp1 = new Button((
                        "      Todo List Help Screen Developed by Sean Merkel on Intellj \n " +
                                "   In case you feel that you do not need any help, please do not \n" +
                                "    hesitate to click the screen again to return to the todo list.\n" +
                                "    Press 'My List' in the top right corner to find edit and delete.\n" +
                        "    To add an item, fill out the due date and task description and then \n" +
                                "    press 'Add'.\n" +
                                "    To mark the item as completed, press the checkbox next to 'Add' and \n" +
                                "    then press 'Add' after filling out the due date and description.\n" +
                                "    A checkbox that is not tapped will mark the item down as incomplete.\n" +
                                "    To remove an item, click the item you wish to have removed and then click\n" +
                                "    'delete'. To delete everything, click the 'clear' button.\n" +
                        "    To edit an item, click the item you wish to have edited and then fill\n" +
                        "    in the spots you want change. You don't need to fill in everything just\n" +
                        "    to change the due date or description. Once you filled out at least one \n" +
                        "    field, click the 'edit' button. \n" +
                "    To save a list, press file and then save and choose the location \n    of where to save your list.\n" +
                        "    To load a list, press file and then load and click a file \n    that you have previously saved.\n" +
                        "    This help screen is dedicated in memory of \"Rey\".\n" +
                        "    If you wish to contact the developer, please reach out to (555)555-5555.\n" +
                        "    If you did not learn anything, please read through the help page again.\""));
                VBox vb = new Vbox();
                vb.getChildren().add(getHelp1);
                Scene s = new Scene(vb, 500, 400);
                primaryStage.setScene(s);
                getHelp1.setOnAction(f -> {
                    primaryStage.setScene(scene);
                });
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ObservableList<TodoListItem> getProduct() {
        ObservableList<TodoListItem> thisList = TodoListManagerController.list;
        return thisList;
    }

    private void addItem(){
        // gets information from textfield, datepicker, and checkbox and creates new item
        // adds item to the list
        TodoListItem theItem = new TodoListItem();
        theItem.setTitle(nameInput.getText());
        theItem.setDueDate(dateInput.getValue());
        if(completeInput.isSelected() == true)
        {
            theItem.setCompletionCheck("Completed");
            theItem.isComplete = true;
        }
        else
        {
            theItem.setCompletionCheck("Not completed");
        }
        table.getItems().add(theItem);
        refresh();
    }

    private void deleteItem(){
        // removes the selected item from list
        ObservableList<TodoListItem> TodoListItemSelected, allTodoListItems;
        allTodoListItems = table.getItems();
        TodoListItemSelected = table.getSelectionModel().getSelectedItems();
        for(TodoListItem p : TodoListItemSelected)
        {
            allTodoListItems.remove(p);
        }
    }

    private void editItem(){
        // gets information from textfield, datepicker, and checkbox (whichever ones were filled out) and edits chosen item
        ObservableList<TodoListItem> allTodoListItems;
        allTodoListItems = table.getItems();
        TodoListItem Selected = table.getSelectionModel().getSelectedItem();
        allTodoListItems.remove(Selected);
        TodoListItem theItem = new TodoListItem();
        if(nameInput.getText() == "")
        {
            theItem.setTitle(Selected.title);
        }
        else
        {
            theItem.setTitle(nameInput.getText());
        }
        if(dateInput.getValue().equals(""))
        {
            theItem.setDueDate(Selected.dueDate);
        }
        else
        {
            theItem.setDueDate(dateInput.getValue());
        }
        if(completeInput.isSelected() == true)
        {
            theItem.setCompletionCheck("Completed");
            theItem.isComplete = true;
        }
        else
        {
            theItem.setCompletionCheck("Not completed");
        }
        table.getItems().add(theItem);
        refresh();
    }

    private void clearAll(){
        // removes everything from the list
        ObservableList<TodoListItem> allTodoListItems;
        allTodoListItems = table.getItems();
        allTodoListItems.clear();
    }

    private void refresh()
    // sets all the variables to a beginning form
    {
        nameInput.clear();
        dateInput.setValue(LocalDate.now());
    }
}