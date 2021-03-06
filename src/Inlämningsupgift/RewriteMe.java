package Inlämningsupgift;

import java.util.*;
import java.util.stream.Collectors;

/*
Inlämningsuppgit i kursen Funktionell Programmering för JAVA-programmet

För samtliga funktioner i denna fil, byt ut "throw UnSupportedException"-raden
och skriv ett pipeline-uttryck som returnerar det som ska returneras.

Streams MÅSTE användas i samtliga funktioner som lämnas in
För att testa om era funktioner funkar, kör testerna som hör till denna fil

För att bli godkänd på denna uppgift måste minst 7 av funktionerna vara implementerade.

Sigruns bedömning av denna uppgift kommer att gå till så att hon klipper in er version av denna fil
i sitt projekt och kör testerna.
Hennes kontroll om ni har klarat uppgifterna eller inte görs genom att
hon kollar att tillräckeligt många av tester går gröna. Pga detta ska ni inte ändra i någon fil
medföljande detta projekt, och inte heller metodsignaturerna i denna fil eller era tester, eftersom
ni då riskerar att påverka rättningen i negativ riktning.
 */

public class RewriteMe {

    public Database database = new Database();
    public List<Question> questions = database.getQuestions();

    public static void main(String[] args) {
        RewriteMe uppg4 = new RewriteMe();

    }

    //Skriv en funktioner som returnerar hur många frågor det finns i databasen?
    public int getAmountOfQuestionsInDatabase() {
        return questions.size(); //returns how many questions there is in the questions list
    }

    //Hur många frågor finns i databasen för en viss, given kategori (som ges som inparameter)
    public int getAmountOfQuestionsForACertainCategory(Category category) {
        return (int) questions.stream()
                .filter(question -> question.getCategory().equals(category)) //takes out the questions that have the category
                .count(); //returns how many (Returns a long)
    }

    //Skapa en lista innehållandes samtliga frågesträngar i databasen
    public List<String> getListOfAllQuestions() {
        return questions.stream()
                .map(Question::getQuestionString) //Gets string versions of the questions
                .collect(Collectors.toList()); //collects them and makes a list
    }

    //Skapa en lista innehållandes samtliga frågesträngar där frågan tillhör en viss kategori
    //Kategorin ges som inparameter
    public List<String> getAllQuestionStringsBelongingACategory(Category category) {
        return questions.stream()
                .filter(question -> question.getCategory().equals(category)) //takes out the questions that have the category
                .map(Question::getQuestionString) //Gets string versions of the questions
                .collect(Collectors.toList()); //collects them and makes a list
    }

    //Skapa en lista av alla svarsalternativ, där varje svarsalternativ får förekomma
    // en och endast en gång i den lista som du ska returnera
    public List<String> getAllAnswerOptionsDistinct() {
        return questions.stream()
                //gets all the strings in the getAllAnswers array and makes a stream that Collect can read
                .flatMap(question -> question.getAllAnswers().stream())  //flatMap because its a list in a list.
                .distinct() //filters out duplicates
                .collect(Collectors.toList()); //collects them and makes a list
    }

    //Finns en viss sträng, given som inparameter, som svarsalternativ till någon fråga i vår databas?
    public boolean isThisAnAnswerOption(String answerCandidate) {
        return questions.stream()
                //finds any string that matches with answerCandidate
                .anyMatch(question -> question.getAllAnswers().stream().anyMatch(answer -> answer.equals(answerCandidate)));
    }

    //Hur ofta förekommer ett visst svarsalternativ, givet som inparameter, i databasen
    public int getAnswerCandidateFrequncy(String answerCandidate) {
        return (int) questions.stream()
                //finds any string that matches with answerCandidate.
                .flatMap(question -> question.getAllAnswers().stream().filter(answer->answer.equals(answerCandidate)))  //flatMap because its a list in a list.
                .count(); //returns how many (Returns a long)
    }

    //Skapa en Map där kategorierna är nycklar och värdena är en lista
    //av de frågesträngar som tillhör varje kategori
    public Map<Category, List<String>> getQuestionGroupedByCategory() {
        return questions.stream()
                .collect(Collectors.toMap(Question::getCategory, question -> getListOfAllQuestions()));

    }

    //Skapa en funktion som hittar det svarsalternativ som har flest bokstäver, i en kategori, given som inparameter
    // OBS: Du måste använda Reduce!
    public String getLongestLettercountAnwerInAGivenCategory(Category c) {

        return "test";

    }

}
