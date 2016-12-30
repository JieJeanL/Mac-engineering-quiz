package UI;

/**
 * This class encapsulates a question asked in the McMaster Engineering Quiz.
 *
 * @author Kelvin Lin
 */
public class Question {
   private String question;     //The question text
   private Answer[] answers;    //The possible answers

   /**
    * The Question constructor
    *
    * @param question The question text
    * @param answers  The possible answers
    */
   public Question(String question, Answer[] answers){
       this.question = question;
       this.answers = answers;
   }

   /**
    * This method returns the question text
    *
    * @return The question text
    */
   public String getQuestion(){
       return this.question;
   }

   /**
    * This method returns the array of possible answers
    *
    * @return The array of possible answers
    */
   public Answer[] getAnswers(){
       return this.answers;
   }

}
