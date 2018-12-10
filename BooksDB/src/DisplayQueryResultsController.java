import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DisplayQueryResultsController {
  @FXML
  private Label firstName;

  @FXML
  private Label lastName;

  @FXML
  void onDisplayPressed(ActionEvent event) {
    final String Database_Url =
            "jdbc:derby:C:\\BooksDB\\lib\\books";
    final String Select_Query =
            "SELECT authorID, firstName, lastName FROM authors";

    try (
            Connection connection = DriverManager.getConnection(
                    Database_Url, "deitel", "deitel");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Select_Query)) {
      resultSet.next();
      firstName.setText(resultSet.getString(2));
      lastName.setText(resultSet.getString(3));
      // AutoCloseable objects' close methods are called now
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }
}



/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/