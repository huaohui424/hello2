package autowire;

public class UserServiceImpl implements UserService {
   private UserDao dao;

   public UserDao getDao(){
       return dao;
   }

   public void setDao(UserDao dao){
       this.dao=dao;
   }


    @Override
    public void update() {
        dao.update();
    }
}
