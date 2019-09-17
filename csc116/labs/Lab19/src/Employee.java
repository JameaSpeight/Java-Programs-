/**
  * The Employee class performs various behaviors on the objects
  * firstName, middleInitial, and lastName.
  *
  * @author Grace Barnhill
  * @author Jamea Speight
  */
public class Employee {
    
    /** Declaring firstName String object */
    String firstName;
    /** Declaring middleInitial char object */
    char middleInitial;
    /** Declaring lastName String object */
    String lastName;
    
    /** Declaring and initializing final int for indexing last name for getUnityID behavior */
    public static final int UNITY_ID_INDEX = 6;

    /**
      * Sets the firstName variable
      *
      * @param f - a string containing the first name
      */
    public void setFirstName(String f) {
        firstName = f;
    }

    /**
      * Returns the firstName variable
      *
      * @return the firstName variable
      */
    public String getFirstName() {
        return firstName;
    }

    /**
      * Sets the middleInitial variable
      *
      * @param m - a char containing the middle initial
      */
    public void setMiddle(char m) {
        middleInitial = m;
    }

    /**
      * Returns the middleInitial variable
      *
      * @return the middleInitial variable
      */
    public char getMiddleInitial() {
        return middleInitial;
    }

    /**
      * Sets the lastName variable
      *
      * @param l - a string containing the last name
      */
    public void setLastName(String l) {
        lastName = l;
    }

    /**
      * Returns the lastName variable
      *
      * @return the lastName variable
      */
    public String getLastName() {
        return lastName;
    }

    /**
      * Lists the name in "normal order" 
      * (first, middle initial, last)
      *
      * @return a string with the full name in "normal order"
      */
    public String getNormalOrder() {
        String normalOrder = firstName + " " + middleInitial + ". " + lastName;
        return normalOrder;
    }

    /**
      * Lists the name in "reverse order" 
      * (last, first, middle initial)
      *
      * @return a string with the full name in "reverse order"
      */
    public String getReverseOrder() {
        String reverseOrder = lastName + ", " + firstName + " " + middleInitial + ".";
        return reverseOrder;
    }

    /**
      * Lists the name in unityID form 
      * (first initial, middle initial, first 6 letters of last name, all lowercase)
      *
      * @return a string with the name in unityID form
      */
    public String getUnityID() {
        String firstInitial = firstName.substring(0,1);
        String middleInitialString = Character.toString(middleInitial);
        String lastNameShort = lastName.substring(0,UNITY_ID_INDEX);
        String unityID = firstInitial.toLowerCase() + middleInitialString.toLowerCase() 
                                                          + lastNameShort.toLowerCase();
        return unityID;
    }

    /**
      * Lists the initials
      * (first initial, middle initial, last initial, all uppercase)
      *
      * @return a string with the initials
      */
    public String getInitials() {
        String firstInitial = firstName.substring(0,1);
        String middleInitialString = Character.toString(middleInitial);
        String lastInitial = lastName.substring(0,1);
        String initials = firstInitial.toUpperCase() + middleInitialString.toUpperCase() 
                                                             + lastInitial.toUpperCase();
        return initials;
    }

    /**
      * Returns the length of the full name
      * (first name length + middle initial length + last name length)
      *
      * @return the integer value of the length of the full name
      */
    public int length() {
        int firstNameLength = firstName.length();
        String middleInitialString = Character.toString(middleInitial);
        int middleInitialLength = middleInitialString.length();
        int lastNameLength = lastName.length();
        int fullNameLength = firstNameLength + middleInitialLength + lastNameLength;
        return fullNameLength;
        
    }

    /**
      * Creates a string with the full name
      * (first name, middle initial, last name)
      *
      * @return string with full name
      */
    @Override
    public String toString() {
        String nameString = firstName + " " + middleInitial + ". " + lastName;
        return nameString;
    }

    /**
      * Tests if the first name, middle inital, and last name are all the same
      *
      * @return boolean (true or false if the first name, middle initial, 
      * and last name are all the same)
      */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Employee) {
            Employee e = (Employee) o;
            return firstName.equals(e.getFirstName()) && (middleInitial == e.getMiddleInitial()) 
                                                             && lastName.equals(e.getLastName());
        } else {
            return false;
        }
    }

}
