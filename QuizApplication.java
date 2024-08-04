import java.util.*;

class Question {
    String questionText;
    List<String> options;
    int correctAnswerIndex;

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

public class QuizApplication {
    private List<Question> questions;
    private int score;

    public QuizApplication() {
        this.questions = new ArrayList<>();
        this.score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", Arrays.asList("Paris", "London", "Berlin", "Madrid"), 0));
        questions.add(new Question("Which planet is known as the Red Planet?", Arrays.asList("Earth", "Mars", "Jupiter", "Venus"), 1));
        questions.add(new Question("What is the largest ocean on Earth?", Arrays.asList("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"), 3));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.questionText);
            for (int j = 0; j < question.options.size(); j++) {
                System.out.println((j + 1) + ". " + question.options.get(j));
            }

            long startTime = System.currentTimeMillis();
            boolean answered = false;

            while (!answered) {
                if ((System.currentTimeMillis() - startTime) / 1000 > 10) { // 10 seconds timer
                    System.out.println("Time's up!");
                    break;
                }

                if (scanner.hasNextInt()) {
                    int answer = scanner.nextInt();
                    if (answer > 0 && answer <= question.options.size()) {
                        if (answer - 1 == question.correctAnswerIndex) {
                            score++;
                            System.out.println("Correct!");
                        } else {
                            System.out.println("Incorrect!");
                        }
                        answered = true;
                    } else {
                        System.out.println("Invalid option. Please try again.");
                        scanner.next(); // Clear the invalid input
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }
            System.out.println();
        }

        displayResults();
        scanner.close();
    }

    private void displayResults() {
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
        System.out.println();

        for (Question question : questions) {
            System.out.println(question.questionText);
            System.out.println("Correct answer: " + question.options.get(question.correctAnswerIndex));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QuizApplication quizApp = new QuizApplication();
        quizApp.startQuiz();
    }
}
