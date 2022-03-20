package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Chatty");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

//закончил в 1:42:28
    public static void main(String[] args) {
        launch(args);
    }
}
