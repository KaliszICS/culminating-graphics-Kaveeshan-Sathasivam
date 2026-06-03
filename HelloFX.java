/*File: ICS3U Culminating - Connections
Author: Kaveeshan Sathasivam
Date Created: June 2nd, 2026
Date Last Modified: June 3rd, 2026*/


/* first do menu screen, then instructions, then start game input the gameboard
words then figure out how to do the correct button stuff for those words then
do the grouping of the words and like how to display a right answer
and wrong answer and then mistake and scoring system and then yea - order of things will
probably change*/ 


import javafx.application.Application;
import javafx.geometry.Pos; //added
import javafx.scene.Scene;
import javafx.scene.control.Button; //added
import javafx.scene.control.Label;
import javafx.scene.layout.VBox; //added
import javafx.scene.layout.StackPane;  
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;



public class HelloFX extends Application {

    @Override
    public void start(Stage stage) {
        
        // TITLE
        
        Label title = new Label("CONNECTIONS");

        title.setStyle(
                "-fx-font-size: 32;" +
                "-fx-font-weight: bold;"
        );

       
        // BUTTONS
       
        Button startButton = new Button("Start Game");
        Button instructionsButton = new Button("Instructions");
        Button exitButton = new Button("Exit");

        
        // LAYOUT (MENU SCREEN)
       
        VBox menuLayout = new VBox(20);
        menuLayout.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));

        menuLayout.getChildren().addAll(
                title,
                startButton,
                instructionsButton,
                exitButton
        );

        menuLayout.setAlignment(Pos.CENTER);

        
        // SCENE
       
        Scene menuScene = new Scene(menuLayout, 800, 600);

        stage.setTitle("Connections");
        stage.setScene(menuScene);
        stage.show();

        
        // BUTTON ACTIONS
        

        // Exit game   - this works
        exitButton.setOnAction(e ->   // e means event - if the event happens, then the code is executed 
        {
            stage.close();
        });

        // Start game (placeholder for rn)   the visuals dont change but button works
        startButton.setOnAction(e ->
        {
            System.out.println("Start Game clicked - placeholder rn");
        });

        // Instructions (placeholder for now) the visual dont change but button works
        instructionsButton.setOnAction(e ->
        {
            System.out.println("Instructions clicked - placeholder rn");
        });
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    }

   

