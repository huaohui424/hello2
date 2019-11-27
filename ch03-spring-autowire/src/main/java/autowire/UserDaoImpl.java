package autowire;

public class UserDaoImpl implements UserDao{
    @Override
    public void update() {
        System.out.println("update in userdaoimpl");
    }
}
