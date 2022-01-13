package p2021.game4inarow;

/**
 *
 * @author Bruno Borges
 */
import java.util.Random;

public final class GameGrid { // Declaring static vars

    //initialising
    private static String type;
    private final char grid[][];
    private static Boolean init;

    /**
     * Constructor
     *
     * @param size
     */
    public GameGrid(String size) { // constructor
        GameGrid.type = size;

        //boolean to break the loop of body game
        init = true;

        // create grid of chars for game
        grid = new char[Integer.valueOf(size)][Integer.valueOf(size)];

        //Starting the game
        //creating and populating the game board
        newGame();
        showGrid();
    }

    // New game method for populating the game board with spaces
    public void newGame() {
        for (char[] grid1 : grid) {
            for (int column = 0; column < grid[0].length; column++) {
                grid1[column] = ' ';
            }
        }
    }

    // Showing Grids method to print the grid in the console
    public void showGrid() {
        //first row printing the Numbers of each row
        for (int row = 1; row < grid.length + 1; row++) {
            System.out.print("   " + row + "  ");
        }
        System.out.println(""); // jumping a line

        //creating the columns and row separated by "|"
        for (char[] grid1 : grid) {
            for (int column = 0; column < grid[1].length; column++) {
                System.out.print("|  " + grid1[column] + "  ");
                if (column > 8) {
                    System.out.print(" ");
                }
            }
            System.out.print("|"); // last '|'
            System.out.println("");//Jumping line
        }
    }

    //Method isFull to check if all columns of the first row[0] is full and if it is full return a draw (false)
    public Boolean isFull() {
        for (int i = 0; i < Integer.valueOf(type); i++) {
            if (grid[0][i] == ' ') {
                return false;
            }
        }
        return true;
    }

    //Horizontal Check method for check if there are 4 of same Letter in a row
    public Boolean horizontalCheck(char checker) { //Checker is the Letter related to Player or Computer 'P' or 'C'
        //Multidimensional array checking from row[0] and column[0] until the last row and last column
        for (int row = Integer.valueOf(type) - 1; row >= 0; row--) {
            int check = 0; // check reset if change the row (horizontal)
            for (int column = 0; column < Integer.valueOf(type); column++) {
                if (grid[row][column] != checker) { //checking
                    check = 0;
                } else {
                    check++;
                    if (check == 4) { // return true if there are 4 in a row
                        return true;
                    }

                }
            }
        }
        return false;
    }

    //Vertical Check method for check if there are 4 of same Letter in a row
    public Boolean verticalCheck(char checker) {
        for (int column = 0; column < Integer.valueOf(type); column++) {
            int check = 0;
            for (int row = Integer.valueOf(type) - 1; row >= 0; row--) {
                if (grid[row][column] != checker) {
                    check = 0;
                } else {
                    check++;
                    if (check == 4) { // return true if there are 4 in a row
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Diagonal right to the left Check method to check if there are 4 of same Letter in a row
    public Boolean rightLeftDiagonalCheck(char checker) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        //First half of the square in diagonal
        for (int r = 0; r < rowCount; r++) {
            int check = 0; // reset
            for (int row = r, col = columnCount - 1; row >= 0 && col < columnCount; row--, col--) {
                if (grid[row][col] != checker) {
                    check = 0;// reset
                } else {
                    check++;
                    if (check == 4) { // return true if there are 4 in a row
                        return true;
                    }
                }
            }
        }

        //Second half of the square in diagonal
        for (int c = columnCount - 1; c >= 0; c--) {
            int check = 0;// reset
            for (int row = rowCount - 1, col = c - 1; row >= 0 && col >= 0; row--, col--) {
                if (grid[row][col] != checker) {
                    check = 0;// reset
                } else {
                    check++;
                    if (check == 4) { // return true if there are 4 in a row
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Diagonal left to the right Check method to check if there are 4 of same Letter in a row
    public Boolean leftRightDiagonalCheck(char checker) {

        int rowCount = grid.length;
        int columnCount = grid[0].length;

        //First half of the square in diagonal
        for (int r = 0; r < rowCount; r++) {
            int check = 0;// reset
            for (int row = r, column = 0; row >= 0 && column < columnCount; row--, column++) {
                if (grid[row][column] != checker) {
                    check = 0;// reset
                } else {
                    check++;
                    if (check == 4) { // return true if there are 4 in a row
                        return true;
                    }
                }
            }
        }

        //Second half of the square in diagonal
        for (int c = 1; c < columnCount; c++) {
            int check = 0;// reset
            for (int row = rowCount - 1, column = c; row >= 0 && column < columnCount; row--, column++) {
                if (grid[row][column] != checker) {
                    check = 0;// reset
                } else {
                    check++;
                    if (check == 4) { // return true if there are 4 in a row
                        return true;
                    }
                }
            }
        }
        return false; // return false if there is no 4 in a row sequence
    }

    //Game Check all the columns and rows horizontally vertically and diagonally
    // and if it is full
    public int gameCheck() {
        //Character array for check the winner (P = 0, C = 1, Draw=2)
        char[] charArr = new char[4];
        charArr[0] = 'P'; // P = 0
        charArr[1] = 'C'; // C = 1

        /*
         * Checking Vertical 4 in a row (Player and Computer)
         */
        for (int i = 0; i < 2; i++) {

            if (true == verticalCheck(charArr[i])) {
                return i;
            }
        }


        /*
         * Checking Horizontal 4 in a row
         */
        for (int i = 0; i < 2; i++) {

            if (true == horizontalCheck(charArr[i])) {
                return i;
            }
        }

        /*
         * Checking left to Right Diagonal 4 in a row
         */
        for (int i = 0; i < 2; i++) {

            if (true == leftRightDiagonalCheck(charArr[i])) {
                return i;
            }
        }

        /*
         * Checking right to left Diagonal 4 in a row
         */
        for (int i = 0; i < 2; i++) {

            if (true == rightLeftDiagonalCheck(charArr[i])) {
                return i;
            }
        }

        /*
         * Checking if all columns and row[0] are full
         */
        if (isFull()) {
            return 2;
        }
        return -1;
    }

    //Computer turn checking the right spot
    public void Computer(int number) {
        Boolean computer = true; // boolean to detect if computer has moved

        // loop to guarantee the computer moves
        while (computer && !isFull()) {
            for (int row = grid.length - 1; row >= 0; row--) {
                if (grid[row][number] == ' ') { // if available swap for 'C'
                    grid[row][number] = 'C';
                    computer = false; // boolean false for break the loop
                    System.out.println("Computer has picked column: " + (number + 1));
                    break; // break
                }
            }
            number = randomNum(); // if there is a invalid spot generates other randomly number
        }
    }

    //Player turn
    public void Player(int number) {
        for (int row = grid.length - 1; row >= 0; row--) {
            if (grid[row][number] == ' ') { //if available swap for 'P'
                grid[row][number] = 'P';
                break;
            }
        }
    }

    // Setters and Getters
    public static void setType(String type) {
        GameGrid.type = type;
    }

    public static String getType() {
        return type;
    }

    public static Boolean getInit() {
        return init;
    }

    public static void setInit(Boolean init) {
        GameGrid.init = init;
    }

    //isValid method to check if the spot chosen is valid
    public boolean isValid(int number) {

//        System.out.println(Integer.valueOf(type).equals("5"));
        if (number < 0) {
            System.out.println("Invalid number"); // invalid number
            return false;
        }
            
        if (Integer.valueOf(type) == 5 && number >= 5) {    
            System.out.println("Invalid number"); // invalid number is out of lentgh of the matrix
            return false;
        } else if (Integer.valueOf(type) == 10 && number >= 10){
            System.out.println("Invalid number"); // invalid number is out of lentgh of the matrix
            return false;
        } 

        if (grid[0][number] != ' ') {
            System.out.println("This column is full"); // invalid column which is full
            return false;
        }
        return true; // return true to continue playing
    }

    //method to generate random number
    public int randomNum() {
        Random random = new Random();
        //generate a random number in the type size
        return random.nextInt(Integer.valueOf(type));
    }

    //Game body
    public void gamePlay(int number) {
        //Number is the column which the user has picked
        if (number != 0) {
            number = number - 1; //-1 because it is not 0-9 but 1-10 (numbers of the columns, just for the console viewing)
        }

        //random number
        int randomNum = randomNum();

        //isValid method to check if the spot is available
        if (!isValid(number)) {
        } else {
            //Player Turn (number is the column)
            Player(number);

            //Computer turn
            Computer(randomNum);

            //Show grid every each turn
            showGrid();

            //game check method to check if there is a winner for the game or draw
            if (-1 != gameCheck()) {
                init = false;
                Score.checkScore(gameCheck());
                newGame();
            }
        }
    }
} //end
