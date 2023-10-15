import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML
    private Button updateBtn;

    @FXML
    private void updateBtnClicked() {
        System.out.println("updateButton clicked");
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
