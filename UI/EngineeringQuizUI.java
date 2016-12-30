package UI;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class wraps the quiz logic in a JavaFX UI.
 *
 * @author Kelvin Lin
 */
public class EngineeringQuizUI extends Application {

    //Symbolic Parameters
    private final int WIDTH = 675;
    private final int HEIGHT = 450;
    private final String TITLE = "McMaster Engineering Quiz";
    private final int NUMBER_OF_ENGINEERING_DISCIPLINES = 9;
    private final int NUMBER_OF_QUESTIONS = 8;
    private final String[] DISCIPLINES = {"Chemical Engineering",
                                          "Material Science and Engineering",
                                          "Mechanical Engineering",
                                          "Mechatronics Engineering",
                                          "Civil Engineering",
                                          "Computer Engineering or Electrical Engineering",
                                          "Electrical and Biomedical Engineering",
                                          "Software Engineering",
                                          "Engineering Physics"};
    private final String[] DISCIPLINE_DESCRIPTIONS = {"Chemical engineers design and manage the processes used to manufacture materials used in everyday life. They help develop an almost infinite number of products and materials, using basic scientific principles, mathematics and economics. Chemical engineers work in a variety of jobs, including food production, fuel production, pharmaceutical industry, and manufacturing.",
                                                      "Materials engineers focus on developing new materials and characterizing their various properties such as mechanical, physical and chemical properties. They also improve existing materials already used to build items on a daily basis. Materials engineers work in all kinds of industries with all kinds of materials and are also involved in groundbreaking research. Some streams include metals, polymers and nanotechnology.",
                                                      "Mechanical engineers apply the principles of physics to design, construct, analyze and maintain nearly all physical devices and systems. They also focus on the operation of machinery and power production. Mechanical engineers work in almost every type of industry, including automotive, metal, power plants, heavy equipment, and manufacturing.",
                                                      "Mechatronics deals with the design, control and production of electro-mechanical devices, integrating the production of physical devices with electronics. It integrates electrical engineering and mechanical engineering. Mechatronics engineers are needed in all industries, including manufacturing, telecommunications, and power generation.",
                                                      "Civil engineers plan, construct and maintain a sustainable infrastructure. Civil engineering is a broad discipline which includes structural engineering which deals with designing structures, construction engineering which manages construction projects, transportation engineering which deals with transportation systems and facilities, geotechnical engineering which deals with the behaviour of soil and rock, and environmental engineering which deals with improving the quality of our air, water and soil.",
                                                      "Electrical engineers and computer engineers use their knowledge of digital circuit technology to create devices benefiting the public, which include computer hardware, electronics, robotics and other related technologies. Electrical engineers focus on employing the flow of electrons and photons in circuits, while computer engineers focus on computer hardware and software interaction to make integrated computer systems.",
                                                      "Electrical and biomedical engineering focuses on integrating electrical circuit technology with their medical knowledge to design electronic devices to solve problems in medicine and biology. Technologies designed by these engineers include medical imaging devices, implants, medical instruments, and biological modelling.",
                                                      "Software engineers design, build, test and troubleshoot the software in computer systems, which include systems controlling electrical devices, systems that design products, financial systems, and information systems. Software is used everywhere and now used to design every device so career opportunities are unlimited.",
                                                      "Engineering physics is an interdisciplinary field of study where advanced devices, systems and materials are developed based on the principles of physics. Many new technologies are developed by engineering physicists, such as photonics, semiconductors, nuclear systems and electrical systems."};
    private final Question[] QUESTIONS = new Question[NUMBER_OF_QUESTIONS];

    private int[] studentPreferences = new int[NUMBER_OF_ENGINEERING_DISCIPLINES]; //The student preference array used to determine the end results

    /**
     * This method starts the GUI application.
     *
     * It populates the QUESTIONS array, and then it generates and loads the
     * first page of the application.
     *
     * @param primaryStage The stage to show the application
     */
    @Override
    public void start(Stage primaryStage) {

        //Populate the QUESTIONS array
        populateQuestions();

        //Show the welcome page
        Scene scene = generateWelcomePage(primaryStage);
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * This method generates the welcome page, and it handles the button
     * event to transition to the first question page.
     *
     * @param primaryStage  The stage to show the application
     * @return  The welcome page scene
     */
    private Scene generateWelcomePage(Stage primaryStage){
        GridPane grid = configureGridPane();

        Text bigTitle = new Text("Hello, future engineers!");
        bigTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(bigTitle, 0, 0, 1, 1);

        Text description = new Text("Are you interested in engineering at McMaster University? Then you have come to the right place! This is a quiz designed to help you find out what type of engineering to choose at McMaster university.");
        description.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        description.setWrappingWidth(WIDTH-50);
        grid.add(description, 0, 1, 2, 1);

        Text instructions = new Text("How the quiz works: Read the question and the answers. After you decide on your answer, click the on the corresponding button. Repeat with the next question until the end where your result will come up.");
        instructions.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        instructions.setWrappingWidth(WIDTH-50);
        grid.add(instructions, 0, 2, 2, 1);

        Text nextText = new Text("Press next to continue.");
        nextText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        nextText.setWrappingWidth(WIDTH-50);
        grid.add(nextText, 0, 3, 2, 1);

        Button nextButton = new Button();
        nextButton.setText("Next");
        nextButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        nextButton.setMinWidth(WIDTH-50);
        nextButton.setMinHeight(150);
        nextButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent e){
               Scene newScene = generateQuestionPage(primaryStage, 0);
               primaryStage.setScene(newScene);
               primaryStage.show();
           }
        });
        grid.add(nextButton, 0, 6, 1, 1);

        Scene scene = new Scene(grid, WIDTH, HEIGHT);
        return scene;
    }

    /**
     * This method generates the page for each question, and it handles the
     * button events needed to transition to the next/last page.
     *
     * @param primaryStage The stage to show the application
     * @param questionNumber The question that the user is on
     * @return The generated question page scene
     */
    private Scene generateQuestionPage(Stage primaryStage, int questionNumber){
        final Answer[] ANSWERS = QUESTIONS[questionNumber].getAnswers();
        GridPane grid = configureGridPane();
        String question = QUESTIONS[questionNumber].getQuestion();
        int numberOfAnswers = ANSWERS.length;
        Button[] answerButtons = new Button[numberOfAnswers];

        Text questionTitle = new Text(question);
        questionTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(questionTitle, 0, 0, 1, 1);

        for (int i = 0; i < numberOfAnswers; i++) {
            final int SELECTION = i;
            answerButtons[i] = new Button();
            answerButtons[i].setText(ANSWERS[i].getAnswer());
            answerButtons[i].setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
            answerButtons[i].setMinWidth(WIDTH - 50);
            answerButtons[i].setMinHeight(325 / numberOfAnswers);
            answerButtons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    answerButtonActionPerformed(e, primaryStage, questionNumber, ANSWERS, SELECTION);
                }
            });
            grid.add(answerButtons[i], 0, i + 1, 2, 1);
        }

        Scene scene = new Scene(grid, WIDTH, HEIGHT);
        return scene;
    }

    /**
     * This method generates the results page.
     *
     * It terminates the program once the user presses the "Finished" button.
     *
     * @param discipline1   The first suggested Engineering discipline
     * @param discipline2   The second suggested Engineering discipline
     * @return The generated results page scene
     */
    private Scene generateResultsPage(int discipline1, int discipline2){
        GridPane grid = configureGridPane();

        Text title = new Text("Your Recommendations: ");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 1, 1);

        Text discipline1Title = new Text(DISCIPLINES[discipline1]);
        discipline1Title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(discipline1Title, 0, 1, 1, 1);

        Text discipline1Description = new Text(DISCIPLINE_DESCRIPTIONS[discipline1]);
        discipline1Description.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        discipline1Description.setWrappingWidth(WIDTH-50);
        grid.add(discipline1Description, 0, 2, 1, 1);

        Text discipline2Title = new Text(DISCIPLINES[discipline2]);
        discipline2Title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(discipline2Title, 0, 3, 1, 1);

        Text discipline2Description = new Text(DISCIPLINE_DESCRIPTIONS[discipline2]);
        discipline2Description.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        discipline2Description.setWrappingWidth(WIDTH-50);
        grid.add(discipline2Description, 0, 4, 1, 1);

        Button finishedButton = new Button();
        finishedButton.setText("Finished");
        finishedButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        finishedButton.setMinWidth(WIDTH-50);
        finishedButton.setMinHeight(35);
        finishedButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent e){
               System.exit(0);
           }
        });
        grid.add(finishedButton, 0, 6, 1, 1);

        Scene scene = new Scene(grid, WIDTH, HEIGHT);
        return scene;
    }

    /**
     * This method configures the GridPane
     * @return The configured GridPane
     */
    private GridPane configureGridPane(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return grid;
    }

    /**
     * This method populates the QUESTION array.
     *
     * TODO: Encapsulate the questions using a persistent storage method like
     *       JSON, XML, or a database.
     */
    private void populateQuestions(){
        String question1 = "The environment I want to work in is: ";
        Answer answer11 = new Answer("1. a lab setting", new int[]{0,1,5,6,8}, new int[]{2,3,2,2,3});
        Answer answer12 = new Answer("2. outside the field", new int[]{4}, new int[]{3});
        Answer answer13 = new Answer("3. an office setting", new int[]{5,7}, new int[]{2,3});
        Answer answer14 = new Answer("4. a factory setting", new int[]{2,3,5}, new int[]{3,3,1});
        QUESTIONS[0] = new Question(question1, new Answer[]{answer11, answer12, answer13, answer14});

        String question2 = "In physics, I am most interested in: ";
        Answer answer21 = new Answer("1. none of the subtopics", new int[]{0,7}, new int[]{3,3});
        Answer answer22 = new Answer("2. thermodynamics", new int[]{1,3,8}, new int[]{3,1,2});
        Answer answer23 = new Answer("3. waves and oscillations", new int[]{6,3,8}, new int[]{3,1,2});
        Answer answer24 = new Answer("4. Electromagnetics", new int[]{5,6,3,8}, new int[]{3,3,1,2});
        Answer answer25 = new Answer("5. Mechanics", new int[]{3,8}, new int[]{3,3});
        Answer answer26 = new Answer("6. all of the above", new int[]{}, new int[]{});
        QUESTIONS[1] = new Question(question2, new Answer[]{answer21, answer22, answer23, answer24, answer25, answer26});

        String question3 = "The person I admire the most is: ";
        Answer answer31 = new Answer("1. Steve Jobs", new int[]{7,5}, new int[]{3,3});
        Answer answer32 = new Answer("2. Elon Musk", new int[]{2,3,4}, new int[]{3,3,3});
        Answer answer33 = new Answer("3. David Suzuki", new int[]{0,2,4}, new int[]{3,3,3});
        Answer answer34 = new Answer("4. Nikola Tesla", new int[]{2,5,8}, new int[]{3,3,3});
        Answer answer35 = new Answer("5. Frederick Banting", new int[]{3,2,6}, new int[]{1,3,3});
        Answer answer36 = new Answer("6. all of the above", new int[]{3,2}, new int[]{1,3});
        QUESTIONS[2] = new Question(question3, new Answer[]{answer31, answer32, answer33, answer34, answer35, answer36});

        String question4 = "A company I would like to work for is: ";
        Answer answer41 = new Answer("1. Nintendo, Google", new int[]{3,7}, new int[]{2,2});
        Answer answer42 = new Answer("2. Ministry of Transportation of Ontario (MTO)", new int[]{2,3,4}, new int[]{2,2,2});
        Answer answer43 = new Answer("3. Greenpeace", new int[]{0,1,4}, new int[]{5,5,5});
        Answer answer44 = new Answer("4. pharmaceutical industries", new int[]{2,1,4}, new int[]{1,5,2});
        Answer answer45 = new Answer("5. Ontario Power", new int[]{2,5,8}, new int[]{3,3,3});
        Answer answer46 = new Answer("6. a construction company", new int[]{2,1,4}, new int[]{3,5,3});
        QUESTIONS[3] = new Question(question4, new Answer[]{answer41, answer42, answer43, answer44, answer45, answer46});

        String question5 = "The invention people are taking for granted the most is: ";
        Answer answer51 = new Answer("1. computers", new int[]{3,7}, new int[]{2,2});
        Answer answer52 = new Answer("2. medicines", new int[]{2,1,4}, new int[]{1,5,2});
        Answer answer53 = new Answer("3. recycling", new int[]{0,1,4}, new int[]{5,5,5});
        Answer answer54 = new Answer("4. batteries", new int[]{2,5,8}, new int[]{3,3,3});
        Answer answer55 = new Answer("5. paved roads", new int[]{2,3,4}, new int[]{2,2,2});
        Answer answer56 = new Answer("6. concrete", new int[]{2,1,4}, new int[]{3,5,3});
        QUESTIONS[4] = new Question(question5, new Answer[]{answer51, answer52, answer53, answer54, answer55, answer56});

        String question6 = "I prefer to do homework/research: ";
        Answer answer61 = new Answer("1. with friends/in a team", new int[]{8,0,2}, new int[]{3,3,3});
        Answer answer62 = new Answer("2. by myself", new int[]{1,3,4,5,6,7}, new int[]{3,3,3,3,3,3});
        QUESTIONS[5] = new Question(question6, new Answer[]{answer61, answer62});

        String question7 = "Would you like to work in: ";
        Answer answer71 = new Answer("1. an industrial building", new int[]{0,2,5,8}, new int[]{1,3,3,3});
        Answer answer72 = new Answer("2. offfice building", new int[]{3,5,7}, new int[]{1,3,3});
        Answer answer73 = new Answer("3. hospital", new int[]{2,1,6}, new int[]{3,3,3});
        Answer answer74 = new Answer("4. outside in the wilderness", new int[]{0,1,4,8}, new int[]{3,3,3,1});
        Answer answer75 = new Answer("5. airports/roadways", new int[]{2,5,8}, new int[]{3,3,3});
        Answer answer76 = new Answer("6. construction site", new int[]{2,1,4}, new int[]{3,3,3});
        QUESTIONS[6] = new Question(question7, new Answer[]{answer71, answer72, answer73, answer74, answer75, answer76});

        String question8 = "A birthday present I want the most is (they are of the same price): ";
        Answer answer81 = new Answer("1. a new iphone", new int[]{7,5}, new int[]{3,3});
        Answer answer82 = new Answer("2. a cosmetic product", new int[]{1,0}, new int[]{3,3});
        Answer answer83 = new Answer("3. video game console", new int[]{2,5}, new int[]{3,3});
        Answer answer84 = new Answer("4. puzzles", new int[]{8,1}, new int[]{3,3});
        Answer answer85 = new Answer("5. a fitness tracker", new int[]{6,1}, new int[]{3,2});
        Answer answer86 = new Answer("6. jenga", new int[]{4}, new int[]{3});
        Answer answer87 = new Answer("7. a model car", new int[]{2,3}, new int[]{3,3});
        QUESTIONS[7] = new Question(question8, new Answer[]{answer81, answer82, answer83, answer84, answer85, answer86, answer87});
    }

    /**
     * This method handles the event of a button press on a question page.
     *
     * @param evt The Action Event
     * @param primaryStage The stage to show the application
     * @param questionNumber The question that the user is answering
     * @param answers   The array of possible answers
     * @param selection The index of the user's selected answer
     */
    private void answerButtonActionPerformed(ActionEvent evt, Stage primaryStage, int questionNumber, Answer[] answers, int selection){
        ArrayList<Integer> indices = answers[selection].getApplicablePreferences();
        ArrayList<Integer> scores = answers[selection].getApplicableScores();
        for(int i = 0; i < indices.size(); i++){
            this.studentPreferences[indices.get(i)] += scores.get(i);
        }

        //Switch to next page
        Scene newScene;
        if (questionNumber < NUMBER_OF_QUESTIONS - 1) {
            newScene = generateQuestionPage(primaryStage, questionNumber + 1);
        } else {
            int[] topDisciplines = findTopDisciplines();
            newScene = generateResultsPage(topDisciplines[0], topDisciplines[1]);
        }
        primaryStage.setScene(newScene);
        primaryStage.show();
    }

    /**
     * This method finds the user's top 2 recommended disciplines.
     *
     * @return The index of the top 2 recommended disciplines
     */
    private int[] findTopDisciplines(){

        int[] sortedStudentPreferences = new int[this.studentPreferences.length];
        System.arraycopy(this.studentPreferences, 0, sortedStudentPreferences, 0, this.studentPreferences.length);
        Arrays.sort(sortedStudentPreferences);

        int index1 = -1;
        int index2 = -1;
        for(int i = 0; i < this.studentPreferences.length; i++){
            if(this.studentPreferences[i] == sortedStudentPreferences[sortedStudentPreferences.length-1] && index1 == -1){
                index1 = i;
            } else if(this.studentPreferences[i] == sortedStudentPreferences[sortedStudentPreferences.length-2]){
                index2 = i;
            }

        }

        return new int[]{index1, index2};
    }

    /**
     * This is the main method which is the entry point to the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
