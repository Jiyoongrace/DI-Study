package step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    // User table에 대한 데이터베이스 처리를 담당하는 class(DAO)
    // method extraction(메소드 추출 - refactoring 기법 중 하나)
    protected Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String id = "root";
        String pw = "jiyun9163!";
        String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        Connection con = DriverManager.getConnection(JDBC_URL, id, pw);

        return con;

    }

    // 사용자 입력(추가)
    public int insert(User user) throws Exception {
        // 데이터 베이스 6단계 처리
        Connection con = getConnection();
        String sql = "insert into user values(?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());

        int result = pstmt.executeUpdate(); // 리턴 값이 정수이다.
        // 이 정수의 의미는 영향을 받은 행의 개수

        pstmt.close();
        con.close();

        return result;
    }
    // 사용자 검색
    public User select(String userId) throws Exception {
        // 데이터 베이스 6단계 처리
        Connection con = getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, userId);

        ResultSet rs = pstmt.executeQuery(); // 리턴 값이 ResultSet
        // 이 정수의 의미는 영향을 받은 행의 개수
        User user = null;
        if(rs.next()) {
            user = new User(rs.getString("id"),
                            rs.getString("name"),
                            rs.getString("password"));
        }

        pstmt.close();
        con.close();

        return user;
    }
}
