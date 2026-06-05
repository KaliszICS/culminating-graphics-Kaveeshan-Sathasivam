/*File: ICS3U Culminating - Connections
Author: Kaveeshan Sathasivam 
Date Created: June 2nd, 2026
Date Last Modified: June 5th, 2026*/

/* first do menu screen, then instructions, then start game input the gameboard
words then figure out how to do the correct button stuff for those words then
do the grouping of the words and like how to display a right answer
and wrong answer and then mistake system and then yea - order of things will
probably change*/

//menu is done and gameboards with words and shuffle is done
//need to do selection - and submission, mistake system, correct category system 
// and reveal the words, and Win and Lose condition, and then be able to play the game multiple times
// also change words and comment

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Random;

public class HelloFX extends Application {

    ArrayList<Puzzle> puzzles = new ArrayList<>();
    Random rand = new Random();

    Button[] wordButtons = new Button[16];

    @Override
    public void start(Stage stage) {

        // PUZZLES 
     

        String[] w1 = {"STACK","HEAP","NODE","TREE","CLASS","OBJECT","POINTER","MEMORY","LOOP","FUNCTION","GRAPH","DATA","FLOW","SYSTEM","ROOT","BRANCH"};
        String[] c1 = {"Computing","Memory","Structure","Flow"};

        String[] w2 = {"PHOTON","LENS","WAVE","ENERGY","BRIGHT","DARK","MOOD","SAD","HAPPY","CLICK","PRESS","SCREEN","BUTTON","FEEL","LIGHT","PARTICLE"};
        String[] c2 = {"Physics","Light","Emotion","Interface"};

        String[] w3 = {"CLOCK","TIMER","SECOND","MINUTE","FAST","SLOW","QUEUE","LOAD","PROCESS","BANK","CASH","CREDIT","DELAY","CACHE","STORE","FLOW"};
        String[] c3 = {"Time","Speed","System","Finance"};

        String[] w4 = {"CODE","SYNTAX","LOGIC","IDEA","THOUGHT","DREAM","MIND","THINK","ALGORITHM","VARIABLE","FUNCTION","SYSTEM","REALITY","MATRIX","LOOP","MEMORY"};
        String[] c4 = {"Code","Mind","Logic","Dream"};

        String[] w5 = {"TREE","ROOT","LEAF","FOREST","STREAM","RIVER","NODE","EDGE","LINK","PATH","GRAPH","DATA","NETWORK","FLOW","CURRENT","BRANCH"};
        String[] c5 = {"Nature","Network","Structure","Data"};

        String[] w6 = {"CLASS","OBJECT","INSTANCE","RECORD","TYPE","LABEL","NAME","ID","ENTITY","STRUCT","FILE","DATA","POINTER","MEMORY","NODE","SYSTEM"};
        String[] c6 = {"OOP","Identity","Data","System"};

        String[] w7 = {"SIGNAL","NOISE","WAVE","ERROR","BEEP","TONE","FREQUENCY","CLICK","INPUT","OUTPUT","HAPPY","SAD","FEEL","SYSTEM","DISTORT","PROCESS"};
        String[] c7 = {"Signal","Emotion","System","Sound"};

        String[] w8 = {"SPACE","VOID","DIMENSION","UNIVERSE","REALITY","SIM","MATRIX","CODE","FUNCTION","OBJECT","CLASS","VARIABLE","TIME","FIELD","SYSTEM","LOOP"};
        String[] c8 = {"Space","Reality","Code","Structure"};

        String[] w9 = {"BRAIN","HEART","BODY","CPU","CHIP","RAM","MEMORY","PROCESS","ROOT","TREE","LEAF","FLOW","IDEA","CODE","SYSTEM","NODE"};
        String[] c9 = {"Human","Machine","Nature","System"};

        String[] w10 = {"FLOW","CONTROL","MOVE","PRESS","INPUT","OUTPUT","SAD","HAPPY","FEEL","SIGNAL","SYSTEM","PATH","QUEUE","ERROR","PROCESS","LOOP"};
        String[] c10 = {"Flow","Control","Emotion","System"};

        String[] w11 = {"CLICK","PRESS","BUTTON","SCREEN","LIGHT","ENERGY","FORCE","WAVE","IDEA","THOUGHT","FUNCTION","CLASS","OBJECT","VARIABLE","SYSTEM","LOGIC"};
        String[] c11 = {"Interface","Physics","Thought","Code"};

        String[] w12 = {"NODE","LINK","GRAPH","TREE","EDGE","PATH","WORD","LANGUAGE","LOGIC","IDEA","MIND","THOUGHT","FLOW","DATA","SYSTEM","THINK"};
        String[] c12 = {"Structure","Language","Mind","Network"};

        String[] w13 = {"CACHE","LOAD","SAVE","STORE","FILE","DATA","MEMORY","CLOCK","TIME","DELAY","PROCESS","FLOW","BANK","QUEUE","HISTORY","SYSTEM"};
        String[] c13 = {"Storage","Time","System","Flow"};

        String[] w14 = {"REALITY","SIM","DREAM","CODE","MATRIX","CLASS","OBJECT","FUNCTION","VARIABLE","SYSTEM","LOOP","THINK","IDEA","MEMORY","TIME","PROCESS"};
        String[] c14 = {"Reality","Simulation","Code","Mind"};

        String[] w15 = {"SIGNAL","INPUT","OUTPUT","CHOICE","DECISION","LOGIC","SAD","HAPPY","FEEL","PRESS","FLOW","SYSTEM","ERROR","PROCESS","CONTROL","THOUGHT"};
        String[] c15 = {"Decision","Signal","Emotion","System"};

        String[] w16 = {"THREAD","PROCESS","STACK","HEAP","POINTER","MEMORY","FUNCTION","VARIABLE","CLASS","OBJECT","LOOP","SYSTEM","DATA","GRAPH","NODE","ALGORITHM"};
        String[] c16 = {"Computing","Memory","Structure","Algorithm"};

        String[] w17 = {"TREE","ROOT","BRANCH","LEAF","CODE","IDEA","THINK","MIND","CLOCK","TIME","FLOW","SYSTEM","MEMORY","FUNCTION","PROCESS","DATA"};
        String[] c17 = {"Nature","Code","Mind","Time"};

        String[] w18 = {"SIGNAL","WAVE","ENERGY","LIGHT","CLICK","PRESS","BUTTON","SCREEN","HAPPY","SAD","FEEL","FORCE","SYSTEM","INPUT","OUTPUT","PROCESS"};
        String[] c18 = {"Signal","Energy","Interface","Emotion"};

        String[] w19 = {"VOID","MATRIX","REALITY","SIM","CODE","CLASS","OBJECT","FUNCTION","LOOP","SYSTEM","MEMORY","DATA","FLOW","TIME","THINK","PROCESS"};
        String[] c19 = {"Abstract","Code","Reality","System"};

        String[] w20 = {"IDEA","THINK","MIND","MEMORY","CODE","SYSTEM","FUNCTION","LOOP","CLASS","OBJECT","DATA","FLOW","TIME","PROCESS","REALITY","VARIABLE"};
        String[] c20 = {"Mind","Code","System","Reality"};

        puzzles.add(new Puzzle(w1,c1));
        puzzles.add(new Puzzle(w2,c2));
        puzzles.add(new Puzzle(w3,c3));
        puzzles.add(new Puzzle(w4,c4));
        puzzles.add(new Puzzle(w5,c5));
        puzzles.add(new Puzzle(w6,c6));
        puzzles.add(new Puzzle(w7,c7));
        puzzles.add(new Puzzle(w8,c8));
        puzzles.add(new Puzzle(w9,c9));
        puzzles.add(new Puzzle(w10,c10));
        puzzles.add(new Puzzle(w11,c11));
        puzzles.add(new Puzzle(w12,c12));
        puzzles.add(new Puzzle(w13,c13));
        puzzles.add(new Puzzle(w14,c14));
        puzzles.add(new Puzzle(w15,c15));
        puzzles.add(new Puzzle(w16,c16));
        puzzles.add(new Puzzle(w17,c17));
        puzzles.add(new Puzzle(w18,c18));
        puzzles.add(new Puzzle(w19,c19));
        puzzles.add(new Puzzle(w20,c20));

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

        
        // INSTRUCTIONS 
      

        Label instructionsTitle = new Label("How To Play");
        Text instructionsText = new Text(
                "Find 4 groups of 4 related words.\n\n" +
                "Select 4 words that belong together.\n\n" +
                "You only get 4 mistakes.\n\n" +
                "Solve all groups to win."
        );

        Button backButton = new Button("Back To Menu");

        VBox instructionsLayout = new VBox(20);
        instructionsLayout.setAlignment(Pos.CENTER);
        instructionsLayout.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        instructionsLayout.getChildren().addAll(instructionsTitle, instructionsText, backButton);

        Scene instructionsScene = new Scene(instructionsLayout, 800, 600);

        
        // SHUFFLE 
   

        ArrayList<String> words = new ArrayList<>();
        for (String w : currentPuzzle.getWords()) words.add(w);

        for (int i = 0; i < words.size(); i++) {
            int randIndex = (int)(Math.random() * words.size());
            String temp = words.get(i);
            words.set(i, words.get(randIndex));
            words.set(randIndex, temp);
        }

        
        // GAME SCREEN 
        

        VBox gameLayout = new VBox(20);
        gameLayout.setAlignment(Pos.CENTER);

        Label gameTitle = new Label("CONNECTIONS GAME");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        for (int i = 0; i < 16; i++) {
            wordButtons[i] = new Button(words.get(i));
            wordButtons[i].setPrefWidth(150);

            int index = i;

            wordButtons[i].setOnAction(e ->
                System.out.println("Clicked: " + wordButtons[index].getText())
            );

            grid.add(wordButtons[i], i % 4, i / 4);
        }

        gameLayout.getChildren().addAll(gameTitle, grid);

        Scene gameScene = new Scene(gameLayout, 800, 600);

       
        // STAGE 
       

        stage.setTitle("Connections");
        stage.setScene(menuScene);
        stage.show();

        exitButton.setOnAction(e -> stage.close());
        instructionsButton.setOnAction(e -> stage.setScene(instructionsScene));
        backButton.setOnAction(e -> stage.setScene(menuScene));
        startButton.setOnAction(e -> stage.setScene(gameScene));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//PUZZLE CLASS 

class Puzzle {
    private String[] words;
    private String[] categories;

    public Puzzle(String[] words, String[] categories) {
        this.words = words;
        this.categories = categories;
    }

    public String[] getWords() {
        return words;
    }

    public String[] getCategories() {
        return categories;
    }
}