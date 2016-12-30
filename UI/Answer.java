package UI;

import java.util.ArrayList;

/**
 * This class models an answer to a question.
 *
 * It holds values denoting which student preference to add to.
 *
 * @author Kelvin Lin
 */
public class Answer {

    private String answer;                              //The answer text
    private ArrayList<Integer> applicablePreferences;   //The student preferences applicable to the answer
    private ArrayList<Integer> applicableScores;        //The weight of the student preference

    /**
     * The Answer constructor
     *
     * @param answer                    The answer text
     * @param applicablePreferences     The student preferences applicable to the answer
     * @param applicableScores          The weight of the student preference
     */
    public Answer(String answer, int[] applicablePreferences, int[] applicableScores){
        this.answer = answer;
        this.applicablePreferences = new ArrayList<Integer>();
        this.applicableScores = new ArrayList<Integer>();

        //Populate the ArrayList with values from the arrays
        for(int i = 0; i < applicablePreferences.length; i++){
            this.applicablePreferences.add(applicablePreferences[i]);
            this.applicableScores.add(applicableScores[i]);
        }
    }

    /**
     * This method returns the ArrayList of applicable preferences to the answer
     *
     * @return  An ArrayList of applicable preferences to the answer
     */
    public ArrayList<Integer> getApplicablePreferences(){
        return this.applicablePreferences;
    }

    /**
     * This method returns the ArrayList of applicable weights to the answer
     *
     * @return An ArrayList of applicable weights to the answer
     */
    public ArrayList<Integer> getApplicableScores(){
        return this.applicableScores;
    }

    /**
     * This method returns the answer text
     *
     * @return The answer text
     */
    public String getAnswer(){
        return this.answer;
    }

}
