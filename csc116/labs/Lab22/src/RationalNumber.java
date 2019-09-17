/**
 * This class can be used to store rational numbers: numbers that can be
 * expressed as a/b where a and b are integers and b is not 0.
 * 
 * @author Jessica Young Schmidt
 * @author Johnathan Rhyne
 * @author Grace Barnhill
 * @author Jamea Speight
 */
public class RationalNumber {
    
    /** Create private int for numerator */
    private int numerator;
    /** Create private int for denominator */
    private int denominator;

    /**
      * Default constructor creating a rational number representing 0
      */
    public RationalNumber() {
        setNumerator(0);
        setDenominator(1);
    }

    /**
      * Custom constructor creating a RationalNumber and then reducing it
      *
      * @param numerator - the numerator of the rational number
      * @param denominator - the denominator of the rational number
      * @throws IllegalArgumentException if the denominator is 0
      */
    public RationalNumber(int numerator, int denominator) {
        // Throw IllegalArgumentException if the Denominator is 0
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator is 0");
        }
        // Set numerator and denominator
        setNumerator(numerator);
        setDenominator(denominator);
        // Reduce the rational number
        reduce();
    }


    /**
      * Set the numerator
      *
      * @param n - the integer value of the numerator
      */ 
    private void setNumerator(int n) {
        numerator = n;
    }

    /**
      * Return the numerator
      *
      * @return the numerator value
      */
    public int getNumerator() {
        return numerator;
    }
    
    /**
      * Set the denominator
      *
      * @param d - the integer value of the denominator
      */ 
    private void setDenominator(int d) {
        denominator = d;
    }

    /**
      * Return the denominator
      *
      * @return the denominator value
      */
    public int getDenominator() {
        return denominator;
    }
    
    /**
      * Returns a string in "a/b" format
      * If the denominator is 1, only the numerator is returned
      *
      * @return a string in "a/b" format
      */
    @Override
    public String toString () {
        String rationalNumber = "";
        if (denominator == 1) {
            rationalNumber += numerator;
            return rationalNumber;
        } else if (denominator < 0) {
            rationalNumber += "-" + numerator + "/" + Math.abs(denominator);
            return rationalNumber;
        } else {
            rationalNumber += numerator + "/" + denominator;
            return rationalNumber;
        }
    }

    /**
      * Compares this RationalNumber object to another RationalNumber
      *
      * @return boolean (true if both the numerators and denominators are equal, false otherwise)
      */
    @Override
    public boolean equals(Object o) {
        if (o instanceof RationalNumber) {
            RationalNumber r = (RationalNumber) o;
            return numerator == (r.getNumerator()) && denominator == (r.getDenominator());
        } else {
            return false;
        }
    }

    /**
     * Adds this RationalNumber and the other RationalNumber
     * 
     * @param other rational number to add to this
     * @return the sum of this and other
     */
    public RationalNumber add(RationalNumber other) {

        int methodNumThis = 0;
        int methodNumOther = 0;
        int methodNumAns = 0;
        int methodDenom = 0;
        
        if (this.denominator == other.denominator) {
            methodNumAns = this.numerator + other.numerator;
            methodDenom = this.denominator;
        } else {
            int tempDenom = this.denominator * other.denominator;
            methodNumThis = this.numerator * other.denominator;
            methodNumOther = other.numerator * this.denominator;
            methodDenom = tempDenom;
            methodNumAns = methodNumThis + methodNumOther;
        }
        RationalNumber ans = new RationalNumber(methodNumAns, methodDenom);
        ans.reduce();
        return ans;
    }

    /**
     * Subtracts other from this
     * 
     * @param other rational number to subtract from this
     * @return the difference of this and other
     */
    public RationalNumber subtract(RationalNumber other) {
        
        int tempNum = other.numerator * -1;
        RationalNumber temp = new RationalNumber(tempNum, other.denominator);
        return temp.add(this);
    } 
    /**
     * Multiples this and other
     * 
     * @param other rational number to multiply by this
     * @return the product of this and other
     */
    public RationalNumber multiply(RationalNumber other) {
        this.reduce();
        other.reduce();
        int methodNum = this.numerator * other.numerator;
        int methodDenom = this.denominator * other.denominator;
        RationalNumber ans = new RationalNumber(methodNum, methodDenom);
        ans.reduce();
        return ans;
    }

    /**
     * Divided this by other
     * 
     * @param other rational number to divide this by
     * @return the quotient of this and other
     */
    public RationalNumber divide(RationalNumber other) {
        RationalNumber ans = new RationalNumber(other.denominator,other.numerator);
        return ans.multiply(this);
    }

    /**
     * eliminates any common factors and ensures that denominator > 0
     */
    private void reduce() {
        int divisor = gcd(this.numerator, this.denominator);
        while (divisor != 1) {
            setNumerator(this.numerator / divisor);
            setDenominator(this.denominator / divisor);
            divisor = gcd(this.numerator, this.denominator);
        }
    }

    /**
     * Finds the greatest common divisor for x and y.
     * This method is static because it belongs to the class, itself:
     * in other words, every instance of RationalNumber will compute the gcd
     * the exact same way, so it does not need to be an instance method
     * 
     * @param x first int
     * @param y second int
     * @return the greatest common divisor of x and y
     */
    private static int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}