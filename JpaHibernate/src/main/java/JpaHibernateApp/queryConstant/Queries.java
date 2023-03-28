package JpaHibernateApp.queryConstant;

public class Queries {
    public static final String ALL_PILOTS = "SELECT * FROM users";
    public static final String FIND_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
}
