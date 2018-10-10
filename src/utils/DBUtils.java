package utils;

import beans.BeanOfURL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
    public static BeanOfURL findURLOfImage(Connection connection, String id) throws SQLException {
        String sql = "Select url, number from urlofimages "
                + " where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();


        if (resultSet.next()){
            String url = resultSet.getString("url");
            String number = resultSet.getString("number");
            BeanOfURL beenOfURL = new BeanOfURL();
            beenOfURL.setUrlOfImg(url);
            beenOfURL.setNumberOfImg(Integer.valueOf(number));
            beenOfURL.setId(Integer.valueOf(id));
            return beenOfURL;
        }
        return null;
    }
}
