package uni.mosey.bankatm.Model;

public class DataSingleton {

    // Creating the initial data handler object and username variable
    // In this project I use it to pass login data between scenes
    private static final DataSingleton instance = new DataSingleton();
    private String username;

    /***
     * Private constructor used to initialise the DataSingleton instance, to allow the transfer
     * of login data between scenes.
     */
    private DataSingleton(){
        // Default constructor
    }

    /***
     * Provides access to the instance of the class.
     * @return Returns the private instance of the 'DataSingleton' class.
     */
    public static DataSingleton getInstance(){
        return instance;
    }

    /***
     * Retrieves the value of the 'username' variable.
     * @return Returns the username.
     */
    public String getUsername(){
        return username;
    }

    /***
     * Sets the value of the username variable depending on what account is signed in,
     * so it displays the correct name.
     * @param username String set to the logged-in user's name.
     */
    public void setUsername(String username){
        this.username = username;
    }
}
