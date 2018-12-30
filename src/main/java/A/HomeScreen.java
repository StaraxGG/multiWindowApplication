package A;

import A.screensFramework.ControlledScreen;
import A.screensFramework.ScreensController;
import A.screensFramework.ScreensFramework;
import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXTextField searchField;
    @FXML
    private JFXButton searchButton;

    ScreensController topController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image image = new Image("logo.png",400,60,false,true,true);
        logo.setImage(image);

        MovieList movieList = new MovieList();
        LinkedList<MovieItem> movieItems = movieList.popularMovies(0,true);

        tilePane = new TilePane();
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

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/hamburgerMenu.fxml"));
            VBox box = loader.load();
            drawer.setSidePane(box);
            drawer.close();
        } catch (IOException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            if (drawer.isOpened()) {
                drawer.close();
            } else {
                drawer.open();
            }
        });

        searchButton.setOnMouseClicked(mouseEvent -> {
            String query = searchField.getText();
            LinkedList<MovieItem> movieItems12 = movieList.search(query,0,true);
            setScreenContent(movieItems12,0);
        });

        //TODO change colours of logo
        //TODO refactor this class
        //TODO SearchBox enter to search
        logo.setOnMouseClicked(mouseEvent -> {
            String query = searchField.getText();
            LinkedList<MovieItem> movieItems1 = movieList.popularMovies(0,true);
            setScreenContent(movieItems1,0);
        });

    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        topController = screenParent;
    }

    @Override
    public void setScreenContent(LinkedList<MovieItem> movieItems, int index) {
        tilePane.getChildren().clear();
        for(int i = index; i< movieItems.size() ; i++){
            tilePane.getChildren().add(movieItems.get(i));

            final int p = i;
            tilePane.getChildren().get(i).setOnMouseClicked(e -> {
                ControlledScreen controller = topController.getController(ScreensFramework.screen2ID);
                controller.setScreenContent(movieItems,p);

                topController.setScreen(ScreensFramework.screen2ID);
            });
        }
    }
}
