/*File: ICS3U Culminating - Connections
Author: Kaveeshan Sathasivam 
Date Created: June 2nd, 2026
Date Last Modified: June 8th, 2026*/


// have to do commenting, and create play again button that returns user to menu



/*
Features:
- Menu, Instructions, Game screens
- 10 full puzzles (4 groups of 4 words)
- Random puzzle selection
- 4x4 word grid
- Word selection (max 4)
- Submit button
- Mistake system (4 lives)
- Win/Lose conditions
- Play again button (returns user to the menu)
*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Random;

public class HelloFX extends Application {

    
    // GAME 
    ArrayList<Puzzle> puzzles = new ArrayList<>();
    Random rand = new Random();

    Button[] wordButtons = new Button[16];

    ArrayList<Button> selectedButtons = new ArrayList<>();
    ArrayList<String> selectedWords = new ArrayList<>();

    int mistakes = 4;
    int solvedGroups = 0;
    boolean gameOver = false;

    Label mistakeLabel = new Label("Mistakes: 4");
    Label messageLabel = new Label("");
    Label endLabel = new Label("");

    @Override
    public void start(Stage stage) {

        
        // PUZZLES (10 FULL BOARDS)
        

        String[][] g1 = {
                {"APPLE","BANANA","ORANGE","PEAR"},
                {"DOG","CAT","RABBIT","HAMSTER"},
                {"SOCCER","HOCKEY","TENNIS","GOLF"},
                {"RED","BLUE","GREEN","YELLOW"}
        };
        String[] c1 = {"Fruits","Pets","Sports","Colours"};

        String[][] g2 = {
                {"JAVA","PYTHON","C++","JAVASCRIPT"},
                {"STACK","QUEUE","ARRAY","LIST"},
                {"CPU","GPU","RAM","SSD"},
                {"LOGIN","SIGNUP","SEARCH","UPLOAD"}
        };
        String[] c2 = {"Languages","Data Structures","Hardware","Web Actions"};

        String[][] g3 = {
                {"LION","TIGER","BEAR","WOLF"},
                {"EARTH","MARS","VENUS","JUPITER"},
                {"IRON","GOLD","SILVER","COPPER"},
                {"WINTER","SUMMER","SPRING","FALL"}
        };
        String[] c3 = {"Animals","Planets","Metals","Seasons"};

        String[][] g4 = {
                {"SHADOW","LIGHT","DARK","BRIGHT"},
                {"FAST","SLOW","QUICK","SPEED"},
                {"HAPPY","SAD","ANGRY","EXCITED"},
                {"HOT","COLD","WARM","COOL"}
        };
        String[] c4 = {"Light","Speed","Emotion","Temperature"};

        String[][] g5 = {
                {"TABLE","CHAIR","SOFA","DESK"},
                {"CAR","BUS","TRAIN","BIKE"},
                {"RIVER","OCEAN","LAKE","STREAM"},
                {"FIRE","WATER","EARTH","AIR"}
        };
        String[] c5 = {"Furniture","Transport","Water","Elements"};

        String[][] g6 = {
                {"ATOM","MOLECULE","CELL","TISSUE"},
                {"EYE","EAR","NOSE","MOUTH"},
                {"BRAIN","HEART","LUNG","LIVER"},
                {"NERVE","MUSCLE","BONE","SKIN"}
        };
        String[] c6 = {"Chemistry","Senses","Organs","Body Parts"};

        String[][] g7 = {
                {"LOGIN","PASSWORD","USERNAME","EMAIL"},
                {"GOOGLE","YOUTUBE","GMAIL","DRIVE"},
                {"CLICK","SCROLL","TYPE","DRAG"},
                {"UPLOAD","DOWNLOAD","DELETE","SAVE"}
        };
        String[] c7 = {"Security","Apps","Actions","File Ops"};

        String[][] g8 = {
                {"CLOCK","WATCH","TIMER","CALENDAR"},
                {"MORNING","NOON","EVENING","NIGHT"},
                {"PAST","PRESENT","FUTURE","TIME"},
                {"YEAR","MONTH","DAY","WEEK"}
        };
        String[] c8 = {"Time Tools","Day Cycle","Time Concepts","Units"};

        String[][] g9 = {
                {"MATH","SCIENCE","ENGLISH","HISTORY"},
                {"BOOK","PEN","PAPER","ERASER"},
                {"TEACHER","STUDENT","PRINCIPAL","COACH"},
                {"SCHOOL","HOME","CLASSROOM","LIBRARY"}
        };
        String[] c9 = {"Subjects","Supplies","People","Places"};

        String[][] g10 = {
                {"KING","QUEEN","ROOK","PAWN"},
                {"CHECK","MATE","STALEMATE","DRAW"},
                {"BLACK","WHITE","BOARD","GAME"},
                {"MOVE","STRATEGY","ATTACK","DEFEND"}
        };
        String[] c10 = {"Chess Pieces","Outcomes","Game Setup","Actions"};

        puzzles.add(new Puzzle(g1,c1));
        puzzles.add(new Puzzle(g2,c2));
        puzzles.add(new Puzzle(g3,c3));
        puzzles.add(new Puzzle(g4,c4));
        puzzles.add(new Puzzle(g5,c5));
        puzzles.add(new Puzzle(g6,c6));
        puzzles.add(new Puzzle(g7,c7));
        puzzles.add(new Puzzle(g8,c8));
        puzzles.add(new Puzzle(g9,c9));
        puzzles.add(new Puzzle(g10,c10));

        Puzzle currentPuzzle = puzzles.get(rand.nextInt(puzzles.size()));

        
        // MENU SCREEN


        Label title = new Label("CONNECTIONS");

        Button startButton = new Button("Start Game");
        Button instructionsButton = new Button("Instructions");
        Button exitButton = new Button("Exit");

        VBox menuLayout = new VBox(20);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
        menuLayout.getChildren().addAll(title, startButton, instructionsButton, exitButton);

        Scene menuScene = new Scene(menuLayout, 800, 600);

        // INSTRUCTIONS SCREEN

        Label instructionsTitle = new Label("How To Play");

        Text instructionsText = new Text(
                "Find 4 groups of 4 related words.\n\n" +
                "Select 4 words and press Submit.\n\n" +
                "You only get 4 mistakes.\n\n" +
                "Solve all groups to win."
        );

        Button backButton = new Button("Back To Menu");

        VBox instructionsLayout = new VBox(20);
        instructionsLayout.setAlignment(Pos.CENTER);
        instructionsLayout.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        instructionsLayout.getChildren().addAll(instructionsTitle, instructionsText, backButton);

        Scene instructionsScene = new Scene(instructionsLayout, 800, 600);

  
        // SHUFFLE WORDS

        ArrayList<String> words = new ArrayList<>();

        for (String[] group : currentPuzzle.getGroups()) {
            for (String w : group) {
                words.add(w);
            }
        }

        for (int i = 0; i < words.size(); i++) {
            int r = (int)(Math.random() * words.size());
            String temp = words.get(i);
            words.set(i, words.get(r));
            words.set(r, temp);
        }


        // GAME SCREEN

        VBox gameLayout = new VBox(10);
        gameLayout.setAlignment(Pos.CENTER);

        Label gameTitle = new Label("CONNECTIONS GAME");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        for (int i = 0; i < 16; i++) {

            wordButtons[i] = new Button(words.get(i));
            wordButtons[i].setPrefWidth(120);

            int index = i;

            wordButtons[i].setOnAction(e -> {

                if (gameOver) return;

                Button b = wordButtons[index];

                if (selectedButtons.contains(b)) {
                    selectedButtons.remove(b);
                    selectedWords.remove(b.getText());
                    b.setStyle("");
                }
                else if (selectedButtons.size() < 4) {
                    selectedButtons.add(b);
                    selectedWords.add(b.getText());
                    b.setStyle("-fx-background-color: yellow;");
                }
            });

            grid.add(wordButtons[i], i % 4, i / 4);
        }

        Button submitButton = new Button("Submit");

submitButton.setOnAction(e -> {

    if (gameOver) return;

    if (selectedWords.size() != 4) {
        messageLabel.setText("Select 4 words!");
        return;
    }

    boolean correct = checkGroup(selectedWords, currentPuzzle.getGroups());

    if (correct) {

        messageLabel.setText("Correct!");

        for (Button b : selectedButtons) {
            b.setDisable(true);
            b.setStyle("-fx-background-color: lightgreen;");
        }

        solvedGroups++;

        if (solvedGroups == 4) {
            gameOver = true;
            endLabel.setText("YOU WIN!");
            submitButton.setDisable(true);
        }

    } else {

        mistakes--;
        mistakeLabel.setText("Mistakes: " + mistakes);
        messageLabel.setText("Wrong!");

        // Remove yellow highlight from incorrect selection
        for (Button b : selectedButtons) {
            b.setStyle("");
        }

        if (mistakes == 0) {
            gameOver = true;
            endLabel.setText("GAME OVER");

            submitButton.setDisable(true);

            for (Button b : wordButtons) {
                b.setDisable(true);
            }
        }
    }

    selectedButtons.clear();
    selectedWords.clear();
});

        gameLayout.getChildren().addAll(
                gameTitle,
                mistakeLabel,
                messageLabel,
                grid,
                submitButton,
                endLabel
        );

        Scene gameScene = new Scene(gameLayout, 800, 600);

  
        // NAVIGATION

        stage.setTitle("Connections");
        stage.setScene(menuScene);
        stage.show();

        exitButton.setOnAction(e -> stage.close());
        instructionsButton.setOnAction(e -> stage.setScene(instructionsScene));
        backButton.setOnAction(e -> stage.setScene(menuScene));
        startButton.setOnAction(e -> stage.setScene(gameScene));
    }


    // CHECK FUNCTION

    public boolean checkGroup(ArrayList<String> selected, String[][] groups) {  
        for (String[] group : groups) {

            int count = 0;

            for (String s : selected) { 
                for (String g : group) {
                    if (s.equals(g)) count++;
                }
            }

            if (count == 4) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Puzzle {
    
    String[][] groups;
    String[] categories;

   
    public Puzzle(String[][] gInput, String[] cInput) {
        groups = gInput;       
        categories = cInput;  
    }


    public String[][] getGroups() {
        return groups;         
    }



    public String[] getCategories() {
        return categories;
    }
}