import java.sql.SQLException;

public class QuizApp {
    public static DatabaseConnection con = new DatabaseConnection();
    public static void main(String[] args) throws SQLException {
        boolean start = con.connect();
        String choice;
        User currentUser;
        if(start) {
            currentUser = new User(AppInteraction.startPage(con));//Will return the user's username
            choice = AppInteraction.homePage(currentUser.getUsername());//user decides to play or create
            if(choice.equals("play")){
                //call play class
           }
            else{
                CreateView.displayQuizzes();//will display all the quizzes the user has made
                AppInteraction.createView();
            }
            con.disconnect();
        }
    }
}