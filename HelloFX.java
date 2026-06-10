/*File: ICS3U Culminating - Connections
Author: Kaveeshan Sathasivam 
Date Created: June 2nd, 2026
Date Last Modified: June 10th, 2026*/

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

    // GAME VARIABLES
    // Holds all 10 puzzles 
    ArrayList<Puzzle> puzzles = new ArrayList<>();
    Random rand = new Random();

    // Array to keep track of the 16 buttons on the grid
    Button[] wordButtons = new Button[16];

    // Lists to track what the user currently has clicked
    ArrayList<Button> selectedButtons = new ArrayList<>();
    ArrayList<String> selectedWords = new ArrayList<>();

    // Game tracking variables
    int mistakes = 4;
    int solvedGroups = 0;
    boolean gameOver = false;

    // Text labels to show info on the screen
    Label mistakeLabel = new Label("Mistakes: 4");
    Label messageLabel = new Label("");
    Label endLabel = new Label("");

    @Override
    public void start(Stage stage) {

        // PUZZLES (10 FULL BOARDS)
        // Each puzzle has a 2D array for the 4x4 words, and a 1D array for the category names

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

        // Adding all the puzzles to main list
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

        // Pick one random puzzle out of the 10 to use for this game
        Puzzle currentPuzzle = puzzles.get(rand.nextInt(puzzles.size()));

        
        // MENU SCREEN
        Label title = new Label("CONNECTIONS");

        Button startButton = new Button("Start Game");
        Button instructionsButton = new Button("Instructions");
        Button exitButton = new Button("Exit");

        // Stacking menu items vertically and setting a background colour
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

  
        //  SHUFFLE WORDS 
        // takes the words from the current puzzle and turns them into a single list
        ArrayList<String> words = new ArrayList<>();
        for (String[] group : currentPuzzle.getGroups()) {
            for (String w : group) {
                words.add(w);
            }
        }

        //  random swapping to scramble the list of words
        for (int i = 0; i < words.size(); i++) {
            int r = (int)(Math.random() * words.size());
            String temp = words.get(i);
            words.set(i, words.get(r));
            words.set(r, temp);
        }


        //GAME SCREEN 
        VBox gameLayout = new VBox(10);
        gameLayout.setAlignment(Pos.CENTER);

        Label gameTitle = new Label("CONNECTIONS GAME");

        // Creating the 4x4 layout grid for the buttons
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // Loop to build the 16 buttons and set up what happens when you click them
        for (int i = 0; i < 16; i++) {

            wordButtons[i] = new Button(words.get(i));
            wordButtons[i].setPrefWidth(120);

            int index = i; 

            wordButtons[i].setOnAction(e -> {
                // If game is already over, don't let them click anything
                if (gameOver) return;

                Button b = wordButtons[index];

                // If they click an already selected button, unselect it and remove the yellow highlight
                if (selectedButtons.contains(b)) {
                    selectedButtons.remove(b);
                    selectedWords.remove(b.getText());
                    b.setStyle("");
                }
                // If it wasn't selected yet, and they have picked less than 4 words, select it
                else if (selectedButtons.size() < 4) {
                    selectedButtons.add(b);
                    selectedWords.add(b.getText());
                    b.setStyle("-fx-background-color: yellow;");
                }
            });

            // automatically place buttons into columns and rows 
            grid.add(wordButtons[i], i % 4, i / 4);
        }

        Button submitButton = new Button("Submit");
        Button menuButton = new Button("Return to Menu");
        menuButton.setVisible(false); // Hidden until the game ends


        // SUBMIT BUTTON LOGIC 
        submitButton.setOnAction(e -> {

            if (gameOver) return;

            // Stop them if they try to check less than 4 words
            if (selectedWords.size() != 4) {
                messageLabel.setText("Select 4 words!");
                return;
            }

            // Call check function to see if the 4 chosen words match any category
            boolean correct = checkGroup(selectedWords, currentPuzzle.getGroups());

            if (correct) {
                messageLabel.setText("Correct!");

                // Lock the correct buttons and turn them green
                for (Button b : selectedButtons) {
                    b.setDisable(true);
                    b.setStyle("-fx-background-color: lightgreen;");
                }

                solvedGroups++;

                // If they found all 4 groups, they win
                if (solvedGroups == 4) {
                    gameOver = true;
                    endLabel.setText("YOU WIN!");
                    submitButton.setDisable(true);
                    menuButton.setVisible(true); // Show the reset/menu button
                }

            } else {
                // Take away a life if they were wrong
                mistakes--;
                mistakeLabel.setText("Mistakes: " + mistakes);
                messageLabel.setText("Wrong!");

                // Remove yellow highlight from incorrect selection so they can try again
                for (Button b : selectedButtons) {
                    b.setStyle("");
                }

                // If they run out of lives, it's game over
                if (mistakes == 0) {
                    gameOver = true;
                    endLabel.setText("GAME OVER");

                    submitButton.setDisable(true);
                    menuButton.setVisible(true); // Show the reset/menu button

                    // Freeze all buttons so they can't keep playing
                    for (Button b : wordButtons) {
                        b.setDisable(true);
                    }
                }
            }

            // Clear the temporary selection lists for the next turn
            selectedButtons.clear();
            selectedWords.clear();
        });

        // Add everything to the game layout view
        gameLayout.getChildren().addAll(
                gameTitle,
                mistakeLabel,
                messageLabel,
                grid,
                submitButton,
                endLabel,
                menuButton
        );

        Scene gameScene = new Scene(gameLayout, 800, 600);

  
        // NAVIGATION & WINDOW SETUP 
        stage.setTitle("Connections");
        stage.setScene(menuScene); // Launch into the main menu first
        stage.show();

        // Screen switching 
        exitButton.setOnAction(e -> stage.close());
        instructionsButton.setOnAction(e -> stage.setScene(instructionsScene));
        backButton.setOnAction(e -> stage.setScene(menuScene));
        startButton.setOnAction(e -> stage.setScene(gameScene));
        
        // Return to menu button resets the game variables so it acts as a play again
        menuButton.setOnAction(e -> {
            // Reset game variables
            mistakes = 4;
            solvedGroups = 0;
            gameOver = false;
            
            // Reset text labels
            mistakeLabel.setText("Mistakes: 4");
            messageLabel.setText("");
            endLabel.setText("");
            
            // re-enable and clear button for a new game
            for (Button b : wordButtons) {
                b.setDisable(false);
                b.setStyle("");
            }
            
            submitButton.setDisable(false);
            menuButton.setVisible(false);
            
            // Go back to the main menu scene
            stage.setScene(menuScene);
        });
    }


    // CHECK FUNCTION 
    // Loops through the solution groups to see if the 4 chosen words fit perfectly into one
    public boolean checkGroup(ArrayList<String> selected, String[][] groups) {  
        for (String[] group : groups) {

            int count = 0;

            // Compare each selected word against each word in the current solution group
            for (String s : selected) { 
                for (String g : group) {
                    if (s.equals(g)) count++;
                }
            }

            // If all 4 selected words matched this specific group, it's a correct match
            if (count == 4) return true;
        }

        return false; // If the loop finishes and didn't find a group with 4 matches, it's incorrect
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//PUZZLE CLASS 
// to store a single game board's answers and categories easily
class Puzzle {
    
    String[][] groups;
    String[] categories;

    //  assign values when a new Puzzle is initialized
    public Puzzle(String[][] gInput, String[] cInput) {
        groups = gInput;       
        categories = cInput;  
    }

    // retrieve the words
    public String[][] getGroups() {
        return groups;         
    }

    //  retrieve the category names
    public String[] getCategories() {
        return categories;
    }
}