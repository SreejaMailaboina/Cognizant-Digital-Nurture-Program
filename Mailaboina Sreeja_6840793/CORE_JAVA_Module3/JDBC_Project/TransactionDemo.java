import java.sql.*;

public class TransactionDemo {

    private static final String URL =
            "jdbc:mysql://localhost:3306/college";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void transfer(int fromAcc,
                                int toAcc,
                                double amount) {

        Connection con = null;

        try {

            con = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            // Start transaction
            con.setAutoCommit(false);

            // Debit query
            String debitQuery =
                    "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

            PreparedStatement debitStmt =
                    con.prepareStatement(debitQuery);

            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAcc);

            int debitRows = debitStmt.executeUpdate();

            // Credit query
            String creditQuery =
                    "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

            PreparedStatement creditStmt =
                    con.prepareStatement(creditQuery);

            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAcc);

            int creditRows = creditStmt.executeUpdate();

            // If both succeed
            if (debitRows > 0 && creditRows > 0) {

                con.commit();

                System.out.println(
                        "Transaction Successful. Amount transferred.");

            } else {

                con.rollback();

                System.out.println(
                        "Transaction Failed. Rolled back.");
            }

        } catch (Exception e) {

            try {
                if (con != null) {
                    con.rollback();
                    System.out.println(
                            "Error occurred. Transaction rolled back.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        transfer(101, 102, 2000);
    }
}