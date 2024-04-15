package step4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    private SimpleConnectionMaker simpleConnectionMaker; // field

    public UserDAO() {
        simpleConnectionMaker = new SimpleConnectionMaker();
    }

    // 사용자 입력(추가)
    public int insert(User user) throws Exception {
        // 데이터 베이스 6단계 처리
        Connection con = simpleConnectionMaker.getConnection();
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
        Connection con = simpleConnectionMaker.getConnection();
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
