package kata4.eric;

import kata4.eric.View.DataProvider;
import kata4.eric.View.DatabaseManager;
import kata4.eric.View.MainFrame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.histogramDisplay().show(new DataProvider() {

            @Override
            public ArrayList<Integer> getAltura() {
                ArrayList<Integer> alturas = new ArrayList<>();
                try(Connection connection = DatabaseManager.getConnection()) {
                    String query = "SELECT * FROM plantas";
                    try(PreparedStatement statement = connection.prepareStatement(query);
                        ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            alturas.add(resultSet.getInt("Altura"));
                        }
                        System.out.println(alturas);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return alturas;

            }
        });
        mainFrame.setVisible(true);
    }
}