public class Program {
    public static void main(String[] args) {
        UsersArrayList listOfUsers = new UsersArrayList();
        listOfUsers.addUser(new User("usr1", 100));
        listOfUsers.addUser(new User("usr2", 100));
        listOfUsers.addUser(new User("usr3", 100));
        listOfUsers.addUser(new User("usr4", 100));
        listOfUsers.addUser(new User("usr5", 100));
        listOfUsers.addUser(new User("usr6", 100));
        listOfUsers.addUser(new User("usr7", 100));
        listOfUsers.addUser(new User("usr8", 100));
        listOfUsers.addUser(new User("usr9", 100));
        listOfUsers.addUser(new User("usr10", 100));
        listOfUsers.addUser(new User("usr11", 100));
        listOfUsers.addUser(new User("usr12", 100));
        System.out.println("Number users: " + listOfUsers.RetrieveNumberOfUsers());
        System.out.println("User index 5: " + listOfUsers.RetrieveUserByIndex(5).getName());
        System.out.println("User id 3: " + listOfUsers.RetrieveUserByID(3).getName());
        System.out.println("User index 15: " + listOfUsers.RetrieveUserByIndex(15).getName());
    }
}
