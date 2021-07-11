/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sean Merkel
 */
package ucf.assignments;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoListManagerControllerTest {

    @Test
    void addItemSet() {
        TodoListManagerController detector = new TodoListManagerController();
        String actual = detector.addItemTest("Your Todo List\nNot Completed: 2021 - 07 - 10 take trash\nCompleted: 2021 - 07 - 10 laundry\nNot Completed: 2021 - 07 - 10 feed the dishes\n", "Walk the dogs", "2021-07-10", true);
        String expected = "Your Todo List\nNot Completed: 2021 - 07 - 10 take trash\nCompleted: 2021 - 07 - 10 laundry\nNot Completed: 2021 - 07 - 10 feed the dishes\nNot Completed: 2021-07-10 Walk the dogs.";
        assertEquals(expected, actual);
    }

    @Test
    void deleteItemSet() {
        TodoListManagerController detector = new TodoListManagerController();
        String actual = detector.deleteItemTest("Your Todo List\nNot Completed: 2021 - 07 - 10 take trash\nCompleted: 2021 - 07 - 10 laundry\nNot Completed: 2021 - 07 - 10 feed the dishes\nNot Completed: 2021-07-10 Walk the dogs.", "Walk the dogs", "2021-07-10", true);
        String expected = "Your Todo List\nNot Completed: 2021 - 07 - 10 take trash\nCompleted: 2021 - 07 - 10 laundry\nNot Completed: 2021 - 07 - 10 feed the dishes\n";
        assertEquals(expected, actual);
    }

    @Test
    void editItemSet() {
        TodoListManagerController detector = new TodoListManagerController();
        String actual = detector.editItemTest("Your Todo List\nNot Completed: 2021 - 07 - 10 take trash\nCompleted: 2021 - 07 - 10 laundry\nNot Completed: 2021 - 07 - 10 feed the dishes\nNot Completed: 2021-07-10 Walk the dogs.", "Walk the dogs", "2021-07-10", true,"Feed the plates", "2021-06-10", false);
        String expected = "Your Todo List\nNot Completed: 2021 - 07 - 10 take trash\nCompleted: 2021 - 07 - 10 laundry\nNot Completed: 2021 - 07 - 10 feed the dishes\nNot Completed: 2021-06-10 Feed the plates.";
        assertEquals(expected, actual);
    }

    @Test
    void clearAllSet() {
        TodoListManagerController detector = new TodoListManagerController();
        String actual = detector.clearAllTest("Your Todo List\nNot Completed: 2021 - 07 - 10 take trash\nCompleted: 2021 - 07 - 10 laundry\nNot Completed: 2021 - 07 - 10 feed the dishes\nNot Completed: 2021-07-10 Walk the dogs.");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void isItemCompleteSet() {
        TodoListManagerController detector = new TodoListManagerController();
        int actual = detector.isItemComplete("Walk the dogs", "2021-07-10", true);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void isItemIncompleteSet() {
        TodoListManagerController detector = new TodoListManagerController();
        int actual = detector.isItemComplete("Feed the plates", "2021-06-10", false);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void extractNotComplete() {
        TodoListManagerController detector = new TodoListManagerController();
        int actual = detector.extractCompletion("Not Completed: 2021-07-10 feed the dishes");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void extractComplete() {
        TodoListManagerController detector = new TodoListManagerController();
        int actual = detector.extractCompletion("Completed: 2021-07-10 feed the dishes");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void extractNeitherComplete() {
        TodoListManagerController detector = new TodoListManagerController();
        int actual = detector.extractCompletion("Your Todo List");
        int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    void extractDueDate() {
        TodoListManagerController detector = new TodoListManagerController();
        String actual = detector.extractDueDate("Not Completed: 2021-07-10 feed the dishes");
        String expected = "2021-07-10";
        assertEquals(expected, actual);
    }

    @Test
    void extractNoDueDate() {
        TodoListManagerController detector = new TodoListManagerController();
        String actual = detector.extractDueDate("Your Todo List");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void extractTitle() {
        TodoListManagerController detector = new TodoListManagerController();
        String actual = detector.extractTitle("Not Completed: 2021-07-10 feed the dishes");
        String expected = "feed the dishes";
        assertEquals(expected, actual);
    }

    @Test
    void extractNoTitle() {
        TodoListManagerController detector = new TodoListManagerController();
        String actual = detector.extractTitle("Your Todo List");
        String expected = "";
        assertEquals(expected, actual);
    }
}