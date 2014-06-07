/** (c) Erik Malmstrom-Partridge 2014
This code is provided as-is without any warranty
This source code or its compiled program may not be redistributed in any way
**/
package com.erikpartridge;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class Zbw extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group g = new Group();
        StackPane root = new StackPane();
        
        root.getChildren().add(g);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
