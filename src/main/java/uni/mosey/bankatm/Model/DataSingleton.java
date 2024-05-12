package uni.mosey.bankatm.Model;

public class DataSingleton {

    // Creating the initial data handler object and username variable
    // In this project I use it to pass login data between scenes
    private static final DataSingleton instance = new DataSingleton();
    private String username;

    private DataSingleton(){
        // Default constructor
    }

    // Gets the private instance
    public static DataSingleton getInstance(){
        return instance;
    }

    // Gets the username
    public String getUsername(){
        return username;
    }

    // Sets the username
    public void setUsername(String username){
        this.username = username;
    }
}
