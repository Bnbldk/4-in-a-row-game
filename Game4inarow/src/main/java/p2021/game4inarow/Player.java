package p2021.game4inarow;

/**
 *
 * @author Bruno Borges
 */

public class Player { 
    
        //Player private attributes values 
        
        //Strings
    	private String name;
	private String age;
	private String email;

        
        Player(String name, String age, String email) { //Constructor 
            //initializing
            	super();
		this.name = name;
		this.age = age;
		this.email = email;          
        }       
        
        //getters and setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    //to String to pring the values of the Player
    @Override
    public String toString() {
        return "Player {" + "name=" + name + ", age=" + age + ", email=" + email + '}';
    }
    
}
    

