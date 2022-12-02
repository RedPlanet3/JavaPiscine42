public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private int id;

    private UserIdsGenerator(){
        this.id = 0;
    }
    public static UserIdsGenerator getInstance()
    {
        if (instance == null)
            instance = new UserIdsGenerator();
        return instance;
    }
    public static int generateId()
    {
        instance.id++;
        return instance.id;
    }
}
