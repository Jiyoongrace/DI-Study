package step3;

import java.sql.Connection;
import java.sql.DriverManager;

public class NaverUserDAO extends UserDAO {
    @Override
    public Connection getConnection() throws Exception {
        // 해당 구매자가 사용하는 DBMS를 이용해서 데이터베이스 Connection을 얻는 코드를 넣는다.
        Class.forName("com.mysql.cj.jdbc.Driver");
        String id = "root";
        String pw = "jiyun9163!";
        String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        Connection con = DriverManager.getConnection(JDBC_URL, id, pw);

        return con;
    }
}
