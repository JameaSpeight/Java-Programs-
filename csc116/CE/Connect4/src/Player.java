/**
 * Class for Player object
 *
 * @author Jay Vandeveld
 * @author Jamea Speight 
 * @author Johnathan Rhyne
 * @author Tess Colavecchio
 */
 
public class Player {
     
    /** Name of the player*/
    private String name;
    
    /** Type of piece*/
    private String piece;
    
    
    /**
     * Creates a Player object
     * 
     * @param name name of player
     * @param piece type of piece
     */ 
    public Player(String name, String piece) {
        this.name = name;
        this.piece = piece;
    }
    
    /**
     * Returns the type of the pjece
     *
     *@return string for the type of the piece
     */
    public String getPiece() {
        return piece;
    }
        
    /**
     * Sets piece equal to input
     * 
     * @param piece1 type of piece
     */
    public void setPiece(String piece1) {
        piece = piece1;
    } 
}