package dao;

import bean.UserBean;
import com.sun.javafx.UnmodifiableArrayList;
import dto.UserDTO;
import dto.UserLoginDTO;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserDAO {

    public void add(UserDTO userDTO, UserLoginDTO userLoginDTO) throws DAOException {

        try {

            Connection connection = DAOConnection.getConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("Select partyid from userlogin where userloginid=?");
            preparedStatement.setString(1, userLoginDTO.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultSet.close();
                preparedStatement.close();
                throw new DAOException("User : " + userLoginDTO.getUsername() + " Exists.");
            }
            resultSet.close();
            preparedStatement = connection.prepareStatement("insert into party (firstname,lastname,address,city,zip,state,country,phone) values (?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, userDTO.getFirstName());
            preparedStatement.setString(2, userDTO.getLastName());
            preparedStatement.setString(3, userDTO.getAddress());
            preparedStatement.setString(4, userDTO.getCity());
            preparedStatement.setInt(5, userDTO.getZip());
            preparedStatement.setString(6, userDTO.getState());
            preparedStatement.setString(7, userDTO.getCountry());
            preparedStatement.setString(8, userDTO.getPhone());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int partId = resultSet.getInt(1);
            preparedStatement = connection.prepareStatement("Select partyid from userlogin where userloginid=?");
            preparedStatement.setString(1, userLoginDTO.getUsername());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultSet.close();
                preparedStatement.close();
                throw new DAOException("User : " + userLoginDTO.getUsername() + " Exists.");
            }

            resultSet.close();
            preparedStatement = connection.prepareStatement("insert into userlogin (userloginid,password,partyid) values (?,?,?)");
            preparedStatement.setString(1, userLoginDTO.getUsername());
            preparedStatement.setString(2, userLoginDTO.getPassword());
            preparedStatement.setInt(3, partId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException sqlException) {
            throw new DAOException(sqlException.getMessage());
        }

    }


    public Map<UserLoginDTO, UserDTO> getAll() throws DAOException {
        Map<UserLoginDTO, UserDTO> userDTOS = new HashMap<>();

        try {
            Connection connection = DAOConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select party.partyid,party.firstname,party.lastname,party.address,party.city,party.zip,party.state,party.country,party.phone,userlogin.userloginid  from party inner join userlogin on party.partyid=userlogin.partyid order by party.firstname");
            UserDTO userDTO;
            UserLoginDTO userLoginDTO;
            while (resultSet.next()) {
                userDTO = new UserDTO();
                userLoginDTO = new UserLoginDTO();
                userDTO.setPartyId(resultSet.getInt("partyid"));
                userDTO.setFirstName(resultSet.getString("firstname").trim());
                userDTO.setLastName(resultSet.getString("lastname").trim());
                userDTO.setAddress(resultSet.getString("address").trim());
                userDTO.setCity(resultSet.getString("city").trim());
                userDTO.setZip(resultSet.getInt("zip"));
                userDTO.setState(resultSet.getString("state").trim());
                userDTO.setCountry(resultSet.getString("country").trim());
                userDTO.setPhone(resultSet.getString("phone").trim());
                userLoginDTO.setUsername(resultSet.getString("userloginid").trim());
                userDTOS.put(userLoginDTO, userDTO);
            }
            connection.close();
            statement.close();
            resultSet.close();
            return userDTOS;

        } catch (Exception exception) {
            throw new DAOException(exception.getMessage());
        }
    }


    public UserLoginDTO getByUsername(String username) throws DAOException {
        try {
            Connection connection = DAOConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from userlogin where userloginid=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                preparedStatement.close();
                resultSet.close();
                connection.close();
                throw new DAOException("Invalid username/password");
            }
            UserLoginDTO userLoginDTO = new UserLoginDTO();
            userLoginDTO.setUsername(resultSet.getString("userloginid").trim());
            userLoginDTO.setPassword(resultSet.getString("password").trim());
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return userLoginDTO;
        } catch (SQLException sqlException) {
            throw new DAOException(sqlException.getMessage());
        }
    }


    public UserDTO getByPartyId(int partyId) throws DAOException {
        UserDTO userDTO;
        try {
            Connection connection = DAOConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from party where partyid=?");
            preparedStatement.setInt(1, partyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                connection.close();
                preparedStatement.close();
                resultSet.close();
                throw new DAOException("Invalid party id : " + partyId);
            }
            userDTO = new UserDTO();
            userDTO.setPartyId(resultSet.getInt("partyid"));
            userDTO.setFirstName(resultSet.getString("firstname"));
            userDTO.setLastName(resultSet.getString("lastname"));
            userDTO.setAddress(resultSet.getString("address"));
            userDTO.setCity(resultSet.getString("city"));
            userDTO.setZip(resultSet.getInt("zip"));
            userDTO.setState(resultSet.getString("state"));
            userDTO.setCountry(resultSet.getString("country"));
            userDTO.setPhone(resultSet.getString("phone"));
            connection.close();
            resultSet.close();
            preparedStatement.close();
        } catch (Exception exception) {
            throw new DAOException(exception.getMessage());
        }
        return userDTO;
    }

    public void update(UserDTO userDTO) throws DAOException {
        int partyId = userDTO.getPartyId();
        try {
            Connection connection = DAOConnection.getConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("select firstname from party where partyid=?");
            preparedStatement.setInt(1, partyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                connection.close();
                preparedStatement.close();
                resultSet.close();
                throw new DAOException("Invalid party id : " + partyId);
            }
            resultSet.close();
            preparedStatement.close();

            preparedStatement = connection.prepareStatement("update party set firstname=?,lastname=?,address=?,city=?,zip=?,state=?,country=?,phone=? where partyid=?");
            preparedStatement.setString(1, userDTO.getFirstName());
            preparedStatement.setString(2, userDTO.getLastName());
            preparedStatement.setString(3, userDTO.getAddress());
            preparedStatement.setString(4, userDTO.getCity());
            preparedStatement.setInt(5, userDTO.getZip());
            preparedStatement.setString(6, userDTO.getState());
            preparedStatement.setString(7, userDTO.getCountry());
            preparedStatement.setString(8, userDTO.getPhone());
            preparedStatement.setInt(9, partyId);
            preparedStatement.executeUpdate();
            resultSet.close();
            preparedStatement.close();
            connection.close();


        } catch (SQLException sqlException) {
            throw new DAOException(sqlException.getMessage());
        }

    }


    public void delete(int partyId) throws DAOException {

        try {
            Connection connection = DAOConnection.getConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("select userloginid from userlogin where partyid=?");
            preparedStatement.setInt(1, partyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                connection.close();
                preparedStatement.close();
                resultSet.close();
                throw new DAOException("Invalid party id : " + partyId);
            }
            preparedStatement.close();
            resultSet.close();
            preparedStatement = connection.prepareStatement("delete from userlogin where partyid=?");
            preparedStatement.setInt(1, partyId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement = connection.prepareStatement("delete from party where partyid=?");
            preparedStatement.setInt(1, partyId);
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();

        } catch (Exception exception) {
            throw new DAOException("Invalid party id " + partyId);
        }
    }


}
