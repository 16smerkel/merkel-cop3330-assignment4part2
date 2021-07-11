/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sean Merkel
 */
package ucf.assignments;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TodoListHelp {
    @FXML
    private TextArea helpText;

    @FXML
    private void needHelp(Event e) {
        String helpString =  ("      Todo List Help Screen Developed by Sean Merkel on Intellj \n " +
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
                "    If you did not learn anything, please read through the help page again.");

        this.helpText.setText(helpString);
    }



}
