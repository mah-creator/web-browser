import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Browser extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // parent node from an fxml file
        Scene scene = new Scene(loadFXML("parent"), 640, 480);

        stage.setScene(scene);
        stage.setTitle("Web browser");
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.show();
    }

    // for the purpos of macking the code look clean
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Browser.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}