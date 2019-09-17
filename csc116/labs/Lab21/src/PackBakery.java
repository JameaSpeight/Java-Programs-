/**
  * This class describes the number of calories in a sandwich based on the type
  *
  * @author Grace Barnhill
  * @author Jamea Speight
  */
public class PackBakery {
    /** Creating private array for menu*/
    private Sandwich[] menu;
    /** Creating private in for menu size*/
    public int DEFAULT_MENU_SIZE = 3;
    
    public PackBakery (int size) {
        this.size = size;
    }
    
    public PackBakery() {
        DEFAULT_MENU_SIZE = size;
    }
    
    public boolean addSandwich(Sandwich s) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == null) {
                menu[i] = s;
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean removeSandwich(Sandwich s) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == s) {
                menu[i] = null;
                return true;
            } else {
                return false;
            }
        }
        
    }
    
    public Sandwich getSandwich(String name) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].getName() == name) {
                return menu[i];
            } else {
                return null;
            }
        }
        
    }
    
    public Sandwich[] getMenu() {
        return menu;
    }
}

/**
  * This class describes the number of calories in a sandwich based on the type
  *
  * @author Grace Barnhill
  * @author Jamea Speight
  */
public class Sandwich {
    /** Creating private string for name */
    private String name;
    /** Creating private bread */
    private Bread bread;
    /** Creating private filling */
    private SandwichFilling filling;
    /** 
      * Custom constructor (set type to t and set calories to c)
      *
      * @param n - name
      * @param b - bread
      * @param f - filling 
      */
    public Sandwich (String n, Bread b, SandwichFilling f) {
        setName(n);
        setBread(b);
        setSandwichFilling(f);
    }
    /**
      * Sets the sandwich name
      *
      * @param n - name
      */
    private void setName(String n){
        name = n;
    }
    /**
      * Gets the name
      *
      * @return the name
      */
    public String getName() {
        return name;
    } 
    /**
      * Sets the sandwich bread
      *
      * @param b - bread
      */
    private void setBread(Bread b) {
        bread = b;
    }
    /**
      * Gets the bread
      *
      * @return the bread
      */
    public Bread getBread() {
        return bread;
    }
     /**
      * Sets the sandwich filling
      *
      * @param f - filling
      */
    private void setSandwichFilling(SandwichFilling f) {
        filling = f;
    }
     /**
      * Gets the filling 
      *
      * @return the filling
      */
    public SandwichFilling getSandwichFilling(){
        return filling;
    }
    /**
      * Creates and returns a string describing the type and number of calories per serving
      *
      * @return a string describing the type and number of calories
      */
    public String toString() {
        String sandwich = "Total Calories (" + getCalories() + "): " + filling + " on " + bread;
        return sandwich;
    }
    /** 
      * Tests the type and calories are all the same
      *
      * @param o - object
      * @return boolean (true if the type and calories are all the same, false if not)
      */
    public boolean equals(Object o) {
        if (o instanceof Sandwich) {
            Sandwich s = (Sandwich) o;
            return bread.equals(s.getBread()) && filling.equals(s.getSandwichFilling());
        } else {
            return false; 
        }
    }
     /**
      * Gets the calories
      *
      * @return the calories
      */
    public int getCalories() {
        int totalCalories = filling.getCalories() + (2 * bread.getCalories());
        return totalCalories;
    }
    
}

/**
  * This class describes the number of calories in a sandwich based on the type
  *
  * @author Grace Barnhill
  * @author Jamea Speight
  */
class SandwichFilling {
    /** Creating private int for calories */
    private int calories;
    /** Creating private String for type */
    private String type;

    /** 
      * Custom constructor (set type to t and set calories to c)
      *
      * @param t - type
      * @param c - calories
      */
    public SandwichFilling (String t, int c) {
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
    private void setCalories(int c) {
        calories = c;
    }

    /**
      * Gets the calories
      *
      * @return the calories
      */
    public int getCalories() {
        return calories;
    }

    /**
      * Creates and returns a string describing the type and number of calories per serving
      *
      * @return a string describing the type and number of calories
      */
    public String toString() {
        String sandwich = type + " (" + calories + " calories per serving)";
        return sandwich;
    }

    /** 
      * Tests the type and calories are all the same
      *
      * @param o - object
      * @return boolean (true if the type and calories are all the same, false if not)
      */
    @Override
    public boolean equals(Object o) {
        if (o instanceof SandwichFilling) {
            SandwichFilling s = (SandwichFilling) o;
            return type.equals(s.getType()) && (calories == s.getCalories());
        } else {
            return false;
        }
    }
}

/**
  * This class describes the number of calories in a sandwich based on the type
  *
  * @author Grace Barnhill
  * @author Jamea Speight
  */
class Bread {
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


