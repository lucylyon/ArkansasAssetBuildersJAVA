package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import SQLite.DB;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Client Database Access Object class. <br/>
 * Methods that facilitate the interactions between the database
 * and objects of the Client class.
 */
public class ClientDAO {
    /**
     * Searches for a Client by ID.
     * @param ID String, ID of the Client.
     * @return Client with corresponding ID.
     * @throws SQLException Unable to retrieve data, loss of connection, or other errors.
     * @throws ClassNotFoundException Client class unable to be found.
     */
    public static Client searchClient(String ID) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * From Client WHERE ID = " + ID;

        try{
            ResultSet rs = DB.executeQuery(selectStmt);
            return getClientFromResultSet(rs);
        }catch(Exception e){
            System.out.println("Error while searching for " + ID + " : " + e);
            throw e;
        }
    }

    /**
     * Get Client from result set after search query.
     * @param rs ResultSet, contains results from a search query.
     * @return Client object.
     * @throws SQLException Unable to retrieve data, loss of connection, or other errors.
     */
    private static Client getClientFromResultSet(ResultSet rs) throws SQLException{
        Client client = null;
        if(rs.next()){
            client = new Client();
            client.setID(rs.getInt("ID"));
            client.setFirstName(rs.getString("FirstName"));
            client.setLastName(rs.getString("LastName"));
            client.setDoB(rs.getString("DoB"));
            client.setLast4SS(rs.getInt("Last4SS"));
        }
        return client;
    }

    /**
     * Gets the list of clients from a ResultSet.
     * @param rs ResultSet containing Clients from a search query.
     * @return ObservableList of Clients.
     * @throws SQLException Unable to retrieve data, loss of connection, or other errors.
     */
    private static ObservableList<Client> getClientList(ResultSet rs) throws SQLException{
        ObservableList<Client> clientList = FXCollections.observableArrayList();

        while(rs.next()){
            Client client = new Client();
            client.setID(rs.getInt("ID"));
            client.setFirstName(rs.getString("FirstName"));
            client.setLastName(rs.getString("LastName"));
            client.setDoB(rs.getString("DoB"));
            client.setLast4SS(rs.getInt("Last4SS"));
            clientList.add(client);
        }
        return clientList;
    }

    /**
     * Update first name of a Client.
     * @param clientID String, the ID of the Client.
     * @param FirstName String, name that the first name will be changed to.
     * @throws SQLException Unable to retrieve data, loss of connection, or other errors.
     */
    private static void updateFirstName(String clientID, String FirstName) throws SQLException{
        String updateStmt =
                "Begin\n" +
                        "   UPDATE Client\n" +
                        "       SET FirstName = '" + FirstName + "'\n" +
                        "    WHERE ID = " + clientID + ";\n" +
                        "END;";
        try{
            DB.update(updateStmt);
        }catch(Exception e){
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
}
