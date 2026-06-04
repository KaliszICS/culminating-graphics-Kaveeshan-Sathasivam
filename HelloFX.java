/*File: ICS3U Culminating - Connections
Author: Kaveeshan Sathasivam
Date Created: June 2nd, 2026
Date Last Modified: June 3rd, 2026*/

/* first do menu screen, then instructions, then start game input the gameboard
words then figure out how to do the correct button stuff for those words then
do the grouping of the words and like how to display a right answer
and wrong answer and then mistake system and then yea - order of things will
probably change*/

//menu and instructions are done, gameboard isn't, word sets haven't been imported in
// need to comment code after done

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) {

        // TITLE

        Label title = new Label("CONNECTIONS");

        title.setStyle(
                "-fx-font-size: 32;" +
                "-fx-font-weight: bold;"
        );

        // MENU BUTTONS

        Button startButton = new Button("Start Game");
        Button instructionsButton = new Button("Instructions");
        Button exitButton = new Button("Exit");

        // MENU LAYOUT

        VBox menuLayout = new VBox(20);

        menuLayout.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.BLUEVIOLET,
                                null,
                                null
                        )
                )
        );

        menuLayout.getChildren().addAll(
                title,
                startButton,
                instructionsButton,
                exitButton
        );

        menuLayout.setAlignment(Pos.CENTER);

        // MENU SCENE


        Scene menuScene = new Scene(menuLayout, 800, 600);


        // INSTRUCTIONS SCREEN

        Label instructionsTitle = new Label("How To Play");

        instructionsTitle.setStyle(
                "-fx-font-size: 24;" +
                "-fx-font-weight: bold;"
        );

        Text instructionsText = new Text(

                "Find four groups of four related words.\n\n" +

                "Select four words that belong together\n" +
                "and submit your answer.\n\n" +

                "If your group is correct, the category\n" +
                "will be solved.\n\n" +

                "If your group isn't correct, then you must try \n" +
                "again to match another set of 4 words.\n\n" +

                "You only get 4 mistakes.\n\n" +

                "Solve all four categories to win."
        );

        Button backButton = new Button("Back To Menu");

        VBox instructionsLayout = new VBox(20);

        instructionsLayout.getChildren().addAll(
                instructionsTitle,
                instructionsText,
                backButton
        );

        instructionsLayout.setAlignment(Pos.CENTER);

        instructionsLayout.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.LIGHTBLUE,
                                null,
                                null
                        )
                )
        );

        Scene instructionsScene =
                new Scene(instructionsLayout, 800, 600);

        // GAME SCREEN PLACEHOLDER

        Label gameTitle =
                new Label("Connections Game Board");

        gameTitle.setStyle(
                "-fx-font-size: 24;" +
                "-fx-font-weight: bold;"
        );

        Label gameMessage =
                new Label("Game board not done yet");  //game board needs to be done

        VBox gameLayout = new VBox(20);

        gameLayout.getChildren().addAll(
                gameTitle,
                gameMessage
        );

        gameLayout.setAlignment(Pos.CENTER);

        gameLayout.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.LIGHTGREEN,
                                null,
                                null
                        )
                )
        );

        Scene gameScene =
                new Scene(gameLayout, 800, 600);

        // STAGE

        stage.setTitle("Connections");
        stage.setScene(menuScene);
        stage.show();

        // BUTTON ACTIONS

        // Exit game
        exitButton.setOnAction(e ->
        {
            stage.close();
        });

        // Open instructions screen
        instructionsButton.setOnAction(e ->
        {
            stage.setScene(instructionsScene);
        });

        // Back to menu
        backButton.setOnAction(e ->
        {
            stage.setScene(menuScene);
        });

        // Open game screen
        startButton.setOnAction(e ->
        {
            stage.setScene(gameScene);
        });

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}