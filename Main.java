import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Insets; 
import javafx.scene.text.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

//import ImageViewer
// Add necessary imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

import javax.swing.DefaultButtonModel;

import java.io.FileWriter;

class Contact extends HBox {

    private Label index;
    private TextField contactName;
    private TextField email;
    private TextField phoneNumber;
    private Button editButton;
    private Button uploadButton;

    // upload Image 
    

    private boolean editing;
    private String imgpath;


    

    Contact() {
        this.setPrefSize(900, 60); // sets size of tcontact
        this.setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0; -fx-font-weight: bold;"); // sets background color of contact
        editing = false;

        index = new Label();
        index.setText(""); // create index label
        index.setPrefSize(40, 20); // set size of Index label
        index.setTextAlignment(TextAlignment.CENTER); // Set alignment of index label
        index.setPadding(new Insets(10, 0, 10, 0)); // adds some padding to the contact
        index.setPrefHeight(Double.MAX_VALUE);
        this.getChildren().add(index); // add index label to contact

        contactName = new TextField(); // create contact name text field
        contactName.setPrefSize(150, 40); // set size of text field
        contactName.setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0;"); // set background color of texfield
        index.setTextAlignment(TextAlignment.LEFT); // set alignment of text field
        contactName.setPadding(new Insets(10, 0, 10, 0)); // adds some padding to the text field
        contactName.setPrefHeight(Double.MAX_VALUE);
        this.getChildren().add(contactName); // add textlabel to contact

        email = new TextField(); // create email text field
        email.setPrefSize(150, 40); // set size of text field
        email.setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0;"); // set background color of texfield
        index.setTextAlignment(TextAlignment.LEFT); // set alignment of text field
        email.setPadding(new Insets(10, 0, 10, 0)); // adds some padding to the text field
        email.setPrefHeight(Double.MAX_VALUE);
        this.getChildren().add(email); // add textlabel to contact
        
        phoneNumber = new TextField(); // create phoneNumber text field
        phoneNumber.setPrefSize(150, 40); // set size of text field
        phoneNumber.setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0;"); // set background color of texfield
        index.setTextAlignment(TextAlignment.LEFT); // set alignment of text field
        phoneNumber.setPadding(new Insets(10, 0, 10, 0)); // adds some padding to the text field
        phoneNumber.setPrefHeight(Double.MAX_VALUE);
        this.getChildren().add(phoneNumber); // add textlabel to contact

        editButton = new Button("Select"); 
        editButton.setPrefSize(100, 20);
        editButton.setPrefHeight(Double.MAX_VALUE);
        editButton.setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0;"); // sets style of button
        this.getChildren().add(editButton);

        uploadButton = new Button("Upload Image");
        uploadButton.setPrefSize(180, 60);
        uploadButton.setPrefHeight(Double.MAX_VALUE);
        uploadButton.setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0;"); // sets style of button
        this.getChildren().add(uploadButton);

    }

    public void setContactIndex(int num) {
        this.index.setText(num + ""); // num to String
        this.contactName.setPromptText("Name");
        this.email.setPromptText("Email");
        this.phoneNumber.setPromptText("Phone Number");
    }
    
    public TextField getContactName() {
        return this.contactName;
    }

    public TextField getEmail() {
        return this.email;
    }

    public TextField getPhoneNumber() {
        return this.phoneNumber;
    }

    public Button getEditButton() {
        return this.editButton;
    }

    public Button getUploadButton(){
        return this.uploadButton;
    }

    public boolean isMarkedEdit() {
        return this.editing;
    }
    public String getimgpath(){
        return this.imgpath;
    }
    
    public void setimgpath(String s){
        this.imgpath = s;
    }

    public void toggleEdit() {
        
        editing = true;
        this.setStyle("-fx-border-color: #000000; -fx-border-width: 0; -fx-font-weight: bold;"); // remove border of contact
        for (int i = 0; i < this.getChildren().size(); i++) {
            this.getChildren().get(i).setStyle("-fx-background-color: #87CEEB; -fx-border-width: 0;"); // change color of task to sky blue
        } 
    }
    public void unEdit(){
        editing = false;
        //this.setStyle();
        for (int i = 0; i < this.getChildren().size(); i++) {
            this.getChildren().get(i).setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0; -fx-font-weight: bold;");// change color of task back
        }
    } 
    public void addpic(Stage contactStage){
        // Select which extensions are allowed
        ImageView imageView = new ImageView();
        FileChooser fileChooser = new FileChooser();
    
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(contactStage);
        
        
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
            imgpath = selectedFile.toString();
            
            
            // * TODO6: Set the selected image in imageView i.e. display the image.
            // * Hint: To implement this, you can use the setImage() method of ImageView and pass the selected image as an argument.
            uploadButton.setGraphic(imageView);
            //imageView.setImage(image);
            // new
            imageView.setFitWidth(180);
            imageView.setFitHeight(60);
        
        }
        
    
    }
}

class ContactList extends VBox {
    private Stage stage;
    public Stage getStage(){
        return stage;
    }

    ContactList() {
        this.setSpacing(5); // sets spacing between tasks
        this.setPrefSize(500, 560);
        this.setStyle("-fx-background-color: #DEDFE0;");
    }

    public void updateTaskIndices() {
        int index = 1;
        for (int i = 0; i < this.getChildren().size(); i++) {
            if (this.getChildren().get(i) instanceof Contact) {
                ((Contact) this.getChildren().get(i)).setContactIndex(index);
                index++;
            }
        }
    }

    public void removeSelectedContact() {
        this.getChildren().removeIf(contact -> contact instanceof Contact && ((Contact) contact).isMarkedEdit());
        this.updateTaskIndices();
    }

    // TODO: Complete this method
    /*
     * Save tasks to a file called "tasks.txt"
     */
    public void saveContacts() {
    
        try{
            FileWriter contactwrite = new FileWriter("contacts.csv");
            
            for(int i = 0; i < this.getChildren().size(); i++){
                contactwrite.write(((Contact) this.getChildren().get(i)).getContactName().getText()+
                ','+ ((Contact) this.getChildren().get(i)).getEmail().getText().toString()+','+
                ((Contact) this.getChildren().get(i)).getPhoneNumber().getText().toString()+','+ 
                ((Contact) this.getChildren().get(i)).getimgpath() + "\n");

            }
      
            contactwrite.close();
        
        }catch(Exception e){
            e.printStackTrace();
           
        }
        
    }
    // TODO: Complete this method
    /*
     * Sort the tasks lexicographically
     */
    public void sortContacts() {
        // hint 1: this.getChildren() gets the list of tasks
        // hint 2: Collections.sort() can be used to sort the tasks
        // hint 3: task.getTaskName().setText() sets the text of the task
        List<Pair<String[], Boolean>> listChildren = new ArrayList<Pair<String[], Boolean>>();

        for(int i = 0; i < this.getChildren().size(); i++){
            String[] arrContacts = {((Contact) this.getChildren().get(i)).getContactName().getText().toString(),
                            ((Contact) this.getChildren().get(i)).getEmail().getText().toString(),
                                ((Contact) this.getChildren().get(i)).getPhoneNumber().getText().toString(),
                                    ((Contact) this.getChildren().get(i)).getimgpath().toString() };

            listChildren.add(new Pair<>(arrContacts, ((Contact) this.getChildren().get(i)).isMarkedEdit()));
        }

        Collections.sort(listChildren, new Comparator<Pair<String[], Boolean>>() {
            @Override
            public int compare(final Pair<String[], Boolean> o1, final Pair<String[], Boolean> o2){
                String s = o1.getKey()[0];
                String s2 = o2.getKey()[0];
                if(s == ""){
                    return 1;
                }
                return s.compareTo(s2);
            }
        }
        );

        this.getChildren().clear();
        for(int i = 0; i < listChildren.size(); i++){
            Contact contact = new Contact();
            contact.getContactName().setText(listChildren.get(i).getKey()[0]);
            contact.getEmail().setText(listChildren.get(i).getKey()[1]);
            contact.getPhoneNumber().setText(listChildren.get(i).getKey()[2]);

            if(listChildren.get(i).getKey()[3] == null){
                contact.setimgpath("");
            }else{
            contact.setimgpath(listChildren.get(i).getKey()[3]);
            }
            System.out.println(listChildren.get(i).getKey()[3]);
            File selectedFile = new File(listChildren.get(i).getKey()[3]);
            if(selectedFile != null){
                Image image = new Image(selectedFile.toURI().toString());
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setFitWidth(180);
                imageView.setFitHeight(60);

                contact.getUploadButton().setGraphic(imageView);
            }

            if(listChildren.get(i).getValue()){
                contact.toggleEdit();
            }

            Button editButton = contact.getEditButton();
                editButton.setOnAction(e1 -> {
                // Call toggleDone on click
                if (contact.isMarkedEdit()==false){
                    contact.toggleEdit();
                    }
                    else{
                        contact.unEdit();
                    }
            });
            Button uploadButton = contact.getUploadButton();
                uploadButton.setOnAction(e1 -> {
                    contact.addpic(getStage());
                });

            this.getChildren().add(contact);
            updateTaskIndices();
        }
 //       System.out.println("sorttasks() not implemented!");
    }
}

class Footer extends HBox {

    private Button addButton;
    private Button clearButton;
    // TODO: Add a button called "loadButton" to load tasks from file
    // TODO: Add a button called "saveButton" to save tasks to a file
    // TODO: Add a button called "sortButton" to sort the tasks lexicographically
    //private Button loadButton;
    private Button saveButton;
    private Button sortButton;

    Footer() {
        this.setPrefSize(500, 60);
        this.setStyle("-fx-background-color: #F0F8FF;");
        this.setSpacing(15);

        // set a default style for buttons - background color, font size, italics
        String defaultButtonStyle = "-fx-font-style: italic; -fx-background-color: #FFFFFF;  -fx-font-weight: bold; -fx-font: 11 arial;";

        addButton = new Button("Add Contact"); // text displayed on add button
        addButton.setStyle(defaultButtonStyle); // styling the button
        clearButton = new Button("Remove Selected"); // text displayed on clear tasks button
        clearButton.setStyle(defaultButtonStyle);

        //loadButton = new Button("Load Contacts");
        //loadButton.setStyle(defaultButtonStyle);
        saveButton = new Button("Save Contacts");
        saveButton.setStyle(defaultButtonStyle);
        sortButton = new Button("Sort Contacts");
        sortButton.setStyle(defaultButtonStyle);

        this.getChildren().addAll(addButton, clearButton, saveButton, sortButton); // adding buttons to footer
        this.setAlignment(Pos.CENTER); // aligning the buttons to center

        // TODO: Create loadButton, saveButton and sortButton to the footer
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getClearButton() {
        return clearButton;
    }

   /*  public Button getLoadButton(){
        return loadButton;
    }*/

    public Button getSortButton(){
        return sortButton;
    }

    public Button getSaveButton(){
        return saveButton;
    }
    // TODO: Add getters for loadButton, saveButton and sortButton
}

class Header extends HBox {

    Header() {
        this.setPrefSize(500, 60); // Size of the header
        this.setStyle("-fx-background-color: #F0F8FF;");

        Text titleText = new Text("Contact List"); // Text of the Header
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER); // Align the text to the Center
    }
}

class AppFrame extends BorderPane{

    private Header header;
    private Footer footer;
    private ContactList contactList;

    private Button addButton;
    private Button clearButton;

    //private Button loadButton;
    private Button saveButton;
    private Button sortButton;
    private Stage stage;

    public Stage getStage(){
        return stage;
    }

    AppFrame()
    {
        // Initialise the header Object
        header = new Header();
        // Create a tasklist Object to hold the tasks
        contactList = new ContactList();
        
        // Initialise the Footer Object
        footer = new Footer();

        

        // TODO: Add a Scroller to the Task List
        // hint 1: ScrollPane() is the Pane Layout used to add a scroller - it will take the tasklist as a parameter
        // hint 2: setFitToWidth, and setFitToHeight attributes are used for setting width and height
        // hint 3: The center of the AppFrame layout should be the scroller window instead  of tasklist
        ScrollPane s = new ScrollPane(contactList);
        s.setFitToWidth(true);
        s.setFitToHeight(true); 

        // Add header to the top of the BorderPane
        this.setTop(header);
        // Add scroller to the centre of the BorderPane
        this.setCenter(s);
        // Add footer to the bottom of the BorderPane
        this.setBottom(footer);

        // Initialise Button Variables through the getters in Footer
        addButton = footer.getAddButton();
        clearButton = footer.getClearButton();
        //loadButton = footer.getLoadButton();
        saveButton = footer.getSaveButton();
        sortButton = footer.getSortButton();

        // Call Event Listeners for the Buttons
        addListeners();
    }

    public void addListeners()
    {

        // Add button functionality
        addButton.setOnAction(e -> {
            // Create a new task
            Contact contact = new Contact();
            Stage mainStage = getStage();
            // Add task to contactlist
            contactList.getChildren().add(contact);
            // Add editButtonToggle to the Edit button
            Button editButton = contact.getEditButton();
            Button uploadButton = contact.getUploadButton();

            //Scene scene = new Scene(uploadButton, 180,60);
            
            uploadButton.setOnAction(e1->{
                contact.addpic(stage);
            });
            editButton.setOnAction(e1 -> {
                // Call toggleedit on click
                if (contact.isMarkedEdit()==false){
                        contact.toggleEdit();
                    }
                    else{
                        contact.unEdit();
                    }
            });
            // Update task indices
            contactList.updateTaskIndices();
        });
        
        // Clear finished tasks
        clearButton.setOnAction(e -> {
            contactList.removeSelectedContact();
        });
/*
        loadButton.setOnAction(e -> {
            contactList.loadContacts();
        });
*/
        saveButton.setOnAction(e -> {
            contactList.saveContacts();
        });

        sortButton.setOnAction(e -> {
            contactList.sortContacts();
        });
    }
}

public class Main extends Application {

    /* new code */
    private Stage stage;

    public Stage getStage(){
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Setting the Layout of the Window- Should contain a Header, Footer and the TaskList
        AppFrame root = new AppFrame();

        // Set the title of the app
        primaryStage.setTitle("Contact List");
        // Create scene of mentioned size with the border pane
        primaryStage.setScene(new Scene(root, 900, 1000));
        // Make window non-resizable
        primaryStage.setResizable(false);

        /* new code */
        this.stage = primaryStage;

        // Show the app
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}