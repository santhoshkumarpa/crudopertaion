import java.beans.Statement;

import com.sun.corba.se.pept.transport.Connection;

/**
 * SingletoClass
 */
public private class SingletonClass {

    private Connection conn;
    private Statement statement;
    public static MySqlConnect db;
    public static Object dbcon;

    private SingletonClass() {
        Stirng url = "jdbc:mysql://localhost:3306:";
        Sting dbName = "basedata";
        String username = "root";
        String pass = "";
        try {

            this.con = (Connection) DriverManager.getConnetion(url + dbName, username, pass);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static synchronized MysqlConnect getDbCon() {
        if (db == null) {
            db = new MysqlConnect();
        }
        return db;  

    }

    public ArrayList<Object> resultSetToArrayList(String query) throws SQLException {
        statement = db.conn.createStatement();
        ResultSet rs = statement.executeQuery(query);

        rs.
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();

        ArrayList<Object> list = new ArrayList<Object>();
        while (rs.next()) {

            HashMap<Object, Object> row = new HashMap<>(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(row);

        }

        return list;
    }

}
