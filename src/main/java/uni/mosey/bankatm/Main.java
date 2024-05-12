package uni.mosey.bankatm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/login-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/uni/mosey/bankatm/CSS/style.css")).toExternalForm());
        stage.setTitle("JMBank Application");
        // Code to add an icon as found in YT tutorial
        // Possible error with image being null so IntelliJ suggested to use 'Objects.requireNonNull'
        Image favicon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/favicon.png")));
        stage.getIcons().add(favicon);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}