package dao;

import bean.UserBean;
import com.sun.javafx.UnmodifiableArrayList;
import dto.UserDTO;
import dto.UserLoginDTO;

import java.sql.*;

public class UserDAO {

    public void add(UserDTO userDTO,UserLoginDTO userLoginDTO) throws DAOException
    {

        try
        {

            Connection connection = DAOConnection.getConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("Select partyid from userlogin where userloginid=?");
            preparedStatement.setString(1,userLoginDTO.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                resultSet.close();
                preparedStatement.close();
                throw new DAOException("User : "+userLoginDTO.getUsername()+" Exists.");
            }
            resultSet.close();
            preparedStatement = connection.prepareStatement("insert into party (firstname,lastname,address,city,zip,state,country,phone) values (?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,userDTO.getFirstName());
            preparedStatement.setString(2,userDTO.getLastName());
            preparedStatement.setString(3,userDTO.getAddress());
            preparedStatement.setString( 4,userDTO.getCity());
            preparedStatement.setInt(5,userDTO.getZip());
            preparedStatement.setString(6,userDTO.getState());
            preparedStatement.setString(7,userDTO.getCountry());
            preparedStatement.setString(8,userDTO.getPhone());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int partId = resultSet.getInt(1);
            preparedStatement = connection.prepareStatement("Select partyid from userlogin where userloginid=?");
            preparedStatement.setString(1,userLoginDTO.getUsername());
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                resultSet.close();
                preparedStatement.close();
                throw new DAOException("User : "+userLoginDTO.getUsername()+" Exists.");
            }

            resultSet.close();
            preparedStatement = connection.prepareStatement("insert into userlogin (userloginid,password,partyid) values (?,?,?)");
            preparedStatement.setString(1,userLoginDTO.getUsername());
            preparedStatement.setString(2,userLoginDTO.getPassword());
            preparedStatement.setInt(3,partId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        }catch(SQLException sqlException)
        {
            throw new DAOException(sqlException.getMessage());
        }

    }
}
