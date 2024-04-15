package step5;

public class Main {
    public static void main(String[] args) {
        // 사용자 등록
        UserDAO dao = new UserDAO();
        User user = new User("hwang", "황민현", "1234");
        try {
            int result = dao.insert(user);
            if(result != 1) {
                throw new Exception();
            }
            System.out.println("사용자 등록 완료");
        } catch (Exception e) {
            System.out.println("사용자 등록 실패");
        }

        // 사용자 검색하는 코드가 나온다.
        try {
            User user2 = dao.select("yoon");
            System.out.println(user2.getName());
        } catch (Exception e) {

        }

    }
}
