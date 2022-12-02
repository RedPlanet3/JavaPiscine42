public interface UsersList {
    public void addUser(User user);
    public User RetrieveUserByID(int id);
    public User RetrieveUserByIndex(int ind);
    public int RetrieveNumberOfUsers();
}
