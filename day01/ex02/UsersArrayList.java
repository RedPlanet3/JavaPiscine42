
public class UsersArrayList implements UsersList{

    private User[] usersArray;
    private int nomberUsr;

    UsersArrayList()
    {
        this.usersArray = new User[10];
        this.nomberUsr = -1;
    }

    private void increaseUsersArray()
    {
        int lenUsersArray = this.usersArray.length;
        User[] tmpUsersArray = new User[lenUsersArray * 2];
        for(int i = 0; i < lenUsersArray; i++)
            tmpUsersArray[i] = this.usersArray[i];
        this.usersArray = tmpUsersArray;
    }

    @Override
    public void addUser(User user)
    {
        if (this.usersArray.length == this.nomberUsr + 1)
            increaseUsersArray();
        this.nomberUsr++;
        this.usersArray[nomberUsr] = user;
    };

    @Override
    public User RetrieveUserByID(int id) throws UserNotFoundException
    {
        for(int i = 0; i < this.nomberUsr; i++)
        {
            if (this.usersArray[i].getIdentifier() == id)
                return this.usersArray[i];
        }
        throw new UserNotFoundException();
    };

    @Override
    public User RetrieveUserByIndex(int ind)
    {
        if (ind > this.nomberUsr)
            throw new UserNotFoundException();
        return this.usersArray[ind];
    };

    @Override
    public int RetrieveNumberOfUsers()
    {
        return this.nomberUsr;
    };
}
