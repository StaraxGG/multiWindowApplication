package A;

import A.screensFramework.ControlledScreen;
import A.screensFramework.ScreensController;
import A.screensFramework.ScreensFramework;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

/**
 * An implementation of HomeScreen
 * in multiWindowApplication
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-21
 */
public class HomeScreen implements Initializable, ControlledScreen {

    @FXML
    ImageView logo;
    @FXML
    TilePane tilePane;
    @FXML
    ScrollPane scrollPane;
    @FXML
    JFXButton switchButton;

    ScreensController topController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image image = new Image("logo.png",400,60,false,true,true);
        logo.setImage(image);

        MovieList movieList = new MovieList();
        LinkedList<MovieItem> movieItems = movieList.popularMovies(0,true);

        TilePane tilePane = new TilePane();
        tilePane.setStyle("-fx-background-color:  #c62828;");
        scrollPane.setStyle("-fx-background-color:  #c62828;");
        for(int i=0; i<movieItems.size() ; i++){
            tilePane.getChildren().add(movieItems.get(i));

            final int p = i;
            tilePane.getChildren().get(i).setOnMouseClicked(e -> {
                    ControlledScreen controller = topController.getController(ScreensFramework.screen2ID);
                    controller.setScreenContent(movieItems,p);

                    topController.setScreen(ScreensFramework.screen2ID);
            });
        }

        scrollPane.setContent(tilePane);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(Double.MAX_VALUE);
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        topController = screenParent;
    }

    @Override
    public void setScreenContent(LinkedList<MovieItem> movieItems, int index) {
        //null
    }

    @FXML
    private void goToMovie(ActionEvent event){
        MovieList movieList = new MovieList();
        LinkedList<MovieItem> movieItem = movieList.search("harry potter", 0, true);

        ControlledScreen controller = topController.getController(ScreensFramework.screen2ID);
        controller.setScreenContent(movieItem,0);

        topController.setScreen(ScreensFramework.screen2ID);
    }
}
