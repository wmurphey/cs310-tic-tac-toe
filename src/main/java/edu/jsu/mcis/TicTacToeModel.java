package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    private int counter = 0;
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        for (int row = 0; row < width; ++row) {

			for (int col = 0; col < width; ++col) {

				board[row][col] = Mark.EMPTY;

			}
		}
        // INSERT YOUR CODE HERE
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE

        if (isValidSquare(row, col) == true){
            if(isSquareMarked(row, col) == false){
                if (xTurn == true){
                    board[row][col] = Mark.X;
                    xTurn = false;
                    return true;
                }
                else {
                    board[row][col] = Mark.O;
                    xTurn = true;
                    return true;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false; 
        }
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        if((row < width) && (row >=0) && (col>=0) && (col< width)) {
            return true;
        }
        else {
            return false;
        }
        // INSERT YOUR CODE HERE

        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        if(this.board[row][col] == Mark.EMPTY){
            return false;
        }
        else{
            return true;
        }
        // INSERT YOUR CODE HERE
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE
        Mark returnMark = board[row][col];
        return returnMark;
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
        if(isMarkWin(Mark.X) == true) {
            return Result.X;
        } 
        else if(isMarkWin(Mark.O) == true) {
            return Result.O;
        }
        else if(isTie()) {
            return Result.TIE;
        }
        else{
            return Result.NONE;
        }
        
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE
            for(int row = 0; row<this.width;row++){
                counter = 0;
                for(int col = 0;col<this.width;col++){
                    if(this.board[row][col] == mark){
                        counter++;
                    }
                }
              
                if(counter == this.width){
                    return true;
                    
                }
            }


            
            for(int col = 0; col<this.width;col++){
                counter = 0;
                for(int row = 0; row<this.width;row++){
                    if(this.board[row][col] == mark){
                        counter++;
                    }
                }
            
                if(counter == this.width){
                    return true;
                    
                }
            }

            counter = 0;
            for(int i = 0; i<this.width;i++){
                
                if(this.board[i][i] == mark){
                    counter++;
                }
            
                if(counter == this.width){
                    return true;
                    
                }
            }
            counter = 0;
            for(int i = 0; i<this.width;i++){
                
                int j = (this.width -1)-i;
                if(this.board[i][j] == mark){
                    counter++;
                }

                if(counter == this.width){
                    return true;
                    
                }
            }

        return false; // remove this line later!

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        int numSquares = width * width;
        int numSquaresMarked = 0;
        for(int col = 0; col<this.width;col++){
            for(int row = 0; row<this.width;++row){
                if(this.board[row][col] != Mark.EMPTY){
                    numSquaresMarked++;
                }
            }
        }
        if (numSquaresMarked == numSquares){
            return true;
        }
        else{
            return false;
        }
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE
        for (int i = 0; i<this.width; i++){
            output.append(i);
        }
        output.append("\n");
        for (int j = 0; j<this.width; j++){
            output.append(j);
            output.append(" ");
            for (int h = 0;h<this.width; h++){
              
                output.append(board[j][h]);

            }
            output.append("\n");
        }
        return output.toString();
        
    }
    
}
