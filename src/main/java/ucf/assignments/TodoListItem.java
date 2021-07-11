/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sean Merkel
 */
package ucf.assignments;

import java.time.LocalDate;

public class TodoListItem {
    public String title;
    public LocalDate dueDate;
    public boolean isComplete;
    public String completionCheck;

    public TodoListItem(){
        this.title = "";
        this.dueDate = LocalDate.ofEpochDay(2007-12-03);
        this.isComplete = false;
        this.completionCheck = "Not Completed";
    }

    public TodoListItem(String title, LocalDate dueDate, boolean isComplete, String completionCheck){
        this.title = title;
        this.dueDate = dueDate;
        this.isComplete = isComplete;
        this.completionCheck = completionCheck;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }

    public String getCompletionCheck(){
        return completionCheck;
    }

    public void setCompletionCheck(String completionCheck){
        this.completionCheck = completionCheck;
    }

    @Override
    public String toString(){
        if(this.isComplete == true)
        {
            return "Completed: " + this.getDueDate() + " " + this.getTitle() + ".";
        }
        else
        {

            return "Not Completed: " + this.getDueDate() + " " + this.getTitle() + ".";
        }
    }
}
    /*
    declare private String description
    declare private int dueDate
    make a public TodoListItem made up of a string and int using this.
        create get and set methods for the string and int
    create a function that can update an item's description
    create a function that can update an item's due date
    create a function that can take all of an item's information and make it into one string
     */

