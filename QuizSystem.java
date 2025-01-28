import java.sql.*;
import java.util.*;

public class QuizSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Welcome message and prompt for name
        System.out.println("Welcome to the Online Quiz System!");
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        int score = 0;
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Fetch questions from the database
            String query = "SELECT * FROM questions";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int questionId = rs.getInt("question_id");
                String question = rs.getString("question");
                String optionA = rs.getString("option_a");
                String optionB = rs.getString("option_b");
                String optionC = rs.getString("option_c");
                String optionD = rs.getString("option_d");
                String correctOption = rs.getString("correct_option");

                // Display the question and options
                System.out.println("\nQuestion: " + question);
                System.out.println("A. " + optionA);
                System.out.println("B. " + optionB);
                System.out.println("C. " + optionC);
                System.out.println("D. " + optionD);

                // Get user input
                System.out.print("Your answer (A/B/C/D): ");
                String userAnswer = scanner.nextLine().toUpperCase();

                // Check if the answer is correct
                if (userAnswer.equals(correctOption)) {
                    score++;
                }
            }

            // Save score in the database
            String insertScoreQuery = "INSERT INTO user_scores (user_name, score) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(insertScoreQuery);
            ps.setString(1, userName);
            ps.setInt(2, score);
            ps.executeUpdate();

            // Display the result
            System.out.println("\nQuiz finished! Your score is: " + score);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
