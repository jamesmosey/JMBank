package uni.mosey.bankatm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    /***
     * Initialises the JavaFX application, loads the user interface layout from an FXML file,
     * applies CSS styling, configures the primary stage, and displays the stage with the
     * initial scene.
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws IOException Notifies the caller of an input/output exception, if
     * there should be one. The only possible error thrown would be with the FXMLLoader,
     * therefore a try/catch block would not suffice.
     */
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

    /***
     * Launches the JavaFX application, which triggers the executing of the 'start' method.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}