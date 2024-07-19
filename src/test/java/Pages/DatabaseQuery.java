package Pages;

import java.sql.SQLException;

public class DatabaseQuery extends DatabaseConnection{

    protected Autorization edo = new Autorization(driver, wait);
//    protected FillSvedenyaDdoSKO docFill = new FillSvedenyaDdoSKO(driver, wait);

    String docTypeDdoSKo = "63";
    String docInn;

    public String findInnOrganizationDdoSKoinDb() {

        connectDbEdoTestKf2024();

        try {
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select inn from users u\n" +
                    "join contrag c on u.contragid = c.id\n" +
                    "where u.login = '"+ edo.login +"'");

            while (resultSet.next()) {
                docInn = resultSet.getString("inn");
            }

            resultSet.close();
            statement.close();
            closeConnectionDbEdoTestKf2024();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docInn;
    }

    public boolean findDdoSKoinDb(String docMonth, String docYear) {

        findInnOrganizationDdoSKoinDb();

        connectDbEdoTestKf2024();

        boolean result = false;

        try {
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from bank_credits_info_document\n" +
                    "where doc_type = '"+docTypeDdoSKo+"' and\n" +
                    "parent_inn = '"+docInn+"' and\n" +
                    "month = '"+docMonth+"' and\n" +
                    "year = '"+docYear+"'");

//            resultSet = statement.executeQuery("select * from bank_credits_info_document\n" +
//                    "where doc_type = '63' and\n" +
//                    "parent_inn = '7830002078' and\n" +
//                    "month = '06' and\n" +
//                    "year = '2024'");

            if(!resultSet.isBeforeFirst()){
            System.out.println(docTypeDdoSKo + "\n" + docInn + "\n" + FillSvedenyaDdoSKO.docMonth + "\n" + FillSvedenyaDdoSKO.docYear);}else
                result = resultSet.isBeforeFirst();

            resultSet.close();
            statement.close();
            closeConnectionDbEdoTestKf2024();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
