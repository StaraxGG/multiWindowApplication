package A;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.SnapshotParameters;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * An implementation of GuiToolBox
 * in multiWindowApplication
 *
 * Contains frequently used methods in GUI Development
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-21
 */
public class GuiToolBox {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */



    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */


    /**
     * Rounds the corners of the image with an Arc value of 20 (As specified in project guidelines)
     * and adds a drop shadow of 20 (As specified in project guidelines)
     * @param poster ImageView that shall contain the image
     * @param img   Image to be placed in ImageView
     * @param dropShadow    Should it contain drop shadow?
     */

    public static void getRoundCorners(ImageView poster, Image img, boolean dropShadow){
        poster.setImage(img);

        Rectangle clip = new Rectangle();
        clip.setWidth(300);clip.setHeight(450);
        clip.setArcHeight(30);clip.setArcWidth(30);
        clip.setStroke(Color.BLACK);poster.setClip(clip);
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = poster.snapshot(parameters,null);
        poster.setClip(null);
        if(dropShadow){
            poster.setEffect(new DropShadow(20, Color.BLACK));
        }
        poster.setImage(image);
    }

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
