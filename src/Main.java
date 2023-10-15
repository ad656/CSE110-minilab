import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

class Task extends HBox {

    private Label index;
    private TextField taskName;
    private Button doneButton;

    private boolean markedDone;

    Task() {
        this.setPrefSize(200, 20); // sets size of task
        this.setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0; -fx-font-weight: bold;"); // sets background color of task
        markedDone = false;

        index = new Label();
        index.setText(""); // create index label
        index.setPrefSize(40, 20); // set size of Index label
        index.setTextAlignment(TextAlignment.CENTER); // Set alignment of index label
        index.setPadding(new Insets(10, 0, 10, 0)); // adds some padding to the task
        this.getChildren().add(index); // add index label to task

        taskName = new TextField(); // create task name text field
        taskName.setPrefSize(210, 20); // set size of text field
        taskName.setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0;"); // set background color of texfield
        index.setTextAlignment(TextAlignment.LEFT); // set alignment of text field
        taskName.setPadding(new Insets(10, 0, 10, 0)); // adds some padding to the text field
        this.getChildren().add(taskName); // add textlabel to task

        doneButton = new Button("Done"); // creates a button for marking the task as done
        doneButton.setPrefSize(100, 20);
        doneButton.setPrefHeight(Double.MAX_VALUE);
        doneButton.setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0;"); // sets style of button

        this.getChildren().add(doneButton);
    }

    public void setTaskIndex(int num) {
        this.index.setText(num + ""); // num to String
        this.taskName.setPromptText("Task " + num);
    }

    public TextField getTaskName() {
        return this.taskName;
    }

    public Button getDoneButton() {
        return this.doneButton;
    }

    public boolean isMarkedDone() {
        return this.markedDone;
    }

    public void toggleDone() {
        
        markedDone = true;
        this.setStyle("-fx-border-color: #000000; -fx-border-width: 0; -fx-font-weight: bold;"); // remove border of task
        for (int i = 0; i < this.getChildren().size(); i++) {
            this.getChildren().get(i).setStyle("-fx-background-color: #BCE29E; -fx-border-width: 0;"); // change color of task to green
        }
    }
}

public class Main extends Application {

    @FXML
    private Button updateBtn;

    @FXML
    private VBox contactList;

    @FXML
    private void updateBtnClicked() {
        System.out.println("updateButton clicked");
        Task n = new Task();
        contactList.getChildren().add(n);
    }



    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/ui/Contact.fxml"));
            FXMLLoader loader = new FXMLLoader();
            loader.setController(new Main());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}