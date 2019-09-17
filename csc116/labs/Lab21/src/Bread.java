/**
  * This class describes the number of calories in a sandwich based on the type
  *
  * @author Grace Barnhill
  * @author Jamea Speight
  */
public class Bread {
    /** Creating private int for calories */
    private String type;
    /** Creating private String for type */
    private int calories;
    /** 
      * Custom constructor (set type to t and set calories to c)
      *
      * @param t - type
      * @param c - calories
      */
    public Bread ( String t, int c){
        setType(t);
        setCalories(c);
    }
    /**
      * Sets the sandwich type
      *
      * @param t - type
      */
    private void setType(String t) {
        type = t;
    }
    /**
      * Gets the type
      *
      * @return the type
      */
    public String getType() {
        return type;
    }
    /**
      * Sets the calories
      *
      * @param c - calories
      */
    private void setCalories(int c){
        calories = c;
    } 
    /**
      * Gets the calories
      *
      * @return the calories
      */
    public int getCalories(){
        return calories;
    }
    /**
      * Creates and returns a string describing the type and number of calories per serving
      *
      * @return a string describing the type and number of calories
      */
    public String toString(){
        String bread = type + " (" + calories + " calories per slice)";
        return bread; 
    }
    /** 
      * Tests if the type and calories are all the same
      * @param o - object
      * @return boolean (true if the type and calories are all the same, false if not)
      */
    public boolean equals(Object o) {
        if (o instanceof Bread) {
            Bread b = (Bread) o;
            return type.equals(b.getType()) && calories == (b.getCalories());
        } else {
            return false; 
        }
    }
}


