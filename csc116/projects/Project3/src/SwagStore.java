import java.util.Scanner;
/**
 * A program that allows customers to place their orders at the SwagStore and outputs 
 * the price. 
 *
 * @author Jamea Speight
 *
 */
public class SwagStore {
    /**
     * The cost of stickers
     */
    public static final int STICKER_COST = 1;
    /**
     * The cost of bottles
     */
    public static final int BOTTLE_COST = 10;
    /**
     * The cost of hats
     */
    public static final int HAT_COST = 12;
    /**
     * The minmum number of acceptable months
     */
    public static final int MIN_MONHTHS = 3;
    /**
     * The maximum number of acceptable months
     */
    public static final int MAX_MONHTHS = 4;
    /**
     * The maximum number of acceptable days
     */
    public static final int MAX_DAYS = 30;
    /**
     * The minmum number of days in march
     */
    public static final int MIN_MARCH_DAYS = 15;
    /**
     * The one day shipping cost.
     */
    public static final int ONE_DAY_SHIPPING = 5;
    /**
     * The regular shipping cost.
     */
    public static final int REGULAR_SHIPPING = 3;
    /**
     * Minimum cost of items for Free shipping
     */
    public static final int MIN_FREE_SHIPPING = 25;
    /**
     * The current year
     */
    public static final int CURRENT_YEAR = 2019;
    /**
     * Total number of months
     */
    public static final int MONTHS = 12;
    /**
     * Number of time a leap occurs
     */
    public static final int LEAP_YEAR_FREQUENCY = 4;
    /**
     * Number of years in a century
     */
    public static final int CENTURY_YEARS = 100;
    /**
     * Max Number of days in a month
     */
    public static final int DAYS_IN_MONTH = 31;
    /**
     * Max Number of days in april
     */
    public static final int DAYS_IN_APRIL = 30;
    /**
     * Max Number of days in a week
     */
    public static final int DAYS_IN_WEEK = 7;
    /**
     * Starts the program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        storeHeader();
        customerOrder();
    }
    /**
     * Displays the Header with the information and instruction for the customer.
     */
    public static void storeHeader() {
        System.out.println("               Welcome to our club Swag Store!");
        System.out.println("All orders must be placed between March 15 and April 30, 2019. "
                    + "When prompted, please enter today's date and the number of each " 
                    + "item you would like to purchase. Please enter S to choose Standard "
                    + "(three-day) shipping or O to choose One-day shipping. Orders of"
                    + " $25.00 or more receive free Standard shipping. Entering the correct "
                    + "coupon code also entitles you to free Standard shipping! A receipt "
                    + "and the arrival date of your order will be displayed.");
    }
    /**
     * The interface that reads the customer order and outputs the cost. 
     */
    public static void customerOrder() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nMonth Day (e.g., 3 15): ");
        int month = in.nextInt();
        int day = in.nextInt();
        if (isValidDate(month, day) == false) {
            System.out.println("Invalid Date");
            System.exit(1);
        }
        System.out.print("Number of Laptop Stickers($1.00 each): ");
        int stickers = in.nextInt();
        if (stickers < 0) {
            System.out.println("Invalid number of items");
            System.exit(1);
        }
        int cost = getCostOfItems(stickers, 0, 0);
        System.out.print("Number of Water Bottles($10.00 each):  ");
        int bottles = in.nextInt();
        if (bottles < 0) {
            System.out.println("Invalid number of items");
            System.exit(1);
        }
        cost = getCostOfItems(stickers, bottles, 0);
        System.out.print("Number of Hats($12.00 each): ");
        int hats = in.nextInt();
        if (hats < 0) {
            System.out.println("Invalid number of items");
            System.exit(1);
        }
        cost = getCostOfItems(stickers, bottles, hats);
        System.out.print("Shipping (S-tandard, O-ne Day): ");
        String shippingInput = in.next();
        String shipping = shippingInput.toUpperCase();
        if (!shipping.equals("O") && !shipping.equals("S")) {
            System.out.println("Invalid shipping type");
            System.exit(1);
        }
        int shippingCost = typeOfShipping (in, shipping, cost);
        if (shippingCost == -1) {
            System.exit(1);
        }
        int shipDays = getShippingDays(shippingCost);
        if (shipDays == 0 ) {
            System.out.print("\nSubtotal: $:" + (double)cost + "0");
            System.out.print("\nShipping: $:" + (double)shippingCost + "0");
            System.out.println("\nTotal:    $:" + (double)(cost + shippingCost) + "0");
            System.exit(1);
        } else {
            String arrivalDate = getArrivalDate(month, day, shipDays);
            System.out.print("\nSubtotal: $:" + (double)cost + "0");
            System.out.print("\nShipping: $:" + (double)shippingCost + "0");
            System.out.print("\nTotal:    $:" + (double)(cost + shippingCost) + "0");
            System.out.println("\nArrival Date:" + arrivalDate);
        }
        
    }
    /**
     * Declares date as valid or not.
     * 
     * @param month entered month value
     * @param day entered day value
     * @return truth value of valid date
     *
     */
    public static boolean isValidDate (int month, int day) {
        if (month < MIN_MONHTHS || month > MAX_MONHTHS ) {
            return false;
        } else if (month == MIN_MONHTHS &&  day < MIN_MARCH_DAYS) {
            return false;
        } else  if (month == MAX_MONHTHS &&  day > MAX_DAYS) {
            return false;
        } 
        return true;
    }
    /**
     * Calculates and returns total cost of the items. 
     * 
     * @param numberOfStickers number of Stickers being bought
     * @param numberOfBottles number of Bottles being bought
     * @param numberOfHats number of Hats being bought
     * @return total cost of all items 
     *
     */
    public static int getCostOfItems(int numberOfStickers, int numberOfBottles, int numberOfHats) {
        int totalCost = 0;
        if (numberOfStickers < 0) { 
            throw new IllegalArgumentException ("Invalid number of items");
            
        } else if  (numberOfBottles < 0 ) {
            throw new IllegalArgumentException ("Invalid number of items");
        } else if (numberOfHats < 0 ) { 
            throw new IllegalArgumentException ("Invalid number of items"); 
        } else {
            int totalCostOfStickers = numberOfStickers * STICKER_COST;
            int totalCostOfBottles = numberOfBottles * BOTTLE_COST;
            int totalCostOfHats = numberOfHats * HAT_COST;
            totalCost += totalCostOfStickers +  totalCostOfBottles + totalCostOfHats;
        }
        return totalCost;
    }
     /**
     * Calculates and returns total cost of shipping
     * 
     * @param in the scanner to get the customer preference
     * @param shipping type of shipping selected
     * @param cost total cost of all the items 
     * @return total cost of the shipping 
     *
     */
    public static int typeOfShipping (Scanner in, String shipping, int cost) {
        if (!shipping.equals("O") && !shipping.equals("S")) {
            throw new IllegalArgumentException ("Invalid shipping type");
        }
        int shippingCost = 0;
        boolean oneDay;
        boolean coupon;
        if (shipping.equals("S")) {
            System.out.print("Coupon (y,n): ");
            String couponInput = in.next();
            String couponCode = couponInput.toUpperCase();
            if (couponCode.startsWith("Y")){
                oneDay = false ;
                System.out.print("Coupon Code: ");
                String code = in.next();
                if ( code.equals("THANKYOU19")) {
                    coupon = true ;
                } else {
                    coupon = false ;
                    oneDay = false ;
                    System.out.println("Invalid coupon code");
                }
                shippingCost += getShippingCost(cost, oneDay, coupon );
                return shippingCost;
            } else {
                oneDay = false ;
                coupon = false ;
                shippingCost += getShippingCost(cost, oneDay, coupon );
                return shippingCost;
            }     
        } else if (shipping.equals("O")) {
            coupon = false ;
            oneDay = true ;
            shippingCost += getShippingCost(cost, oneDay, coupon );
            return shippingCost;
        }
        return shippingCost;
    }
    /**
     * Calculates and returns shipping cost
     * 
     * @param costOfItems cost of all the items
     * @param oneDayShipping if the customer wants one day shipping 
     * @param hasValidCoupon if the customer has a valid coupon
     * @return the shipping cost
     * @throw IllegalArgumentException if the number of shipping days is invalid
     *
     */
    public static int getShippingCost(int costOfItems, boolean oneDayShipping, 
                                        boolean hasValidCoupon) {
        int shipCost = 0;
        if (costOfItems < 0) {
            throw new IllegalArgumentException ("Invalid cost of items");
        } else if (oneDayShipping == true) {
            if (costOfItems == 0) {
                return shipCost;
            } else {   
                shipCost += ONE_DAY_SHIPPING;
                return shipCost;
            }
        } else if (costOfItems < MIN_FREE_SHIPPING ){
            if (hasValidCoupon == false) {
                shipCost += REGULAR_SHIPPING;
                return shipCost;
            } else {
                return shipCost;
            }
        }
        return shipCost; 
    }
    /**
     * Calculates and returns the number of shipping days. 
     * 
     * @param costShipping the amount it cost to ship
     * @return the number of shipping days
     */
    public static int getShippingDays(int costShipping) {
        int shipDays = 0;
        if (costShipping == REGULAR_SHIPPING) {
            shipDays += REGULAR_SHIPPING;
        } else if (costShipping == ONE_DAY_SHIPPING) {
            shipDays += 1;
        } else if (costShipping == 0) {
            shipDays += 0;
        } else {
            shipDays += REGULAR_SHIPPING;
        }
        return shipDays;
    }
    /**
     * Calculates and returns the arrival date. 
     * 
     * @param orderMonth number of month of the purchase
     * @param orderDay number of day of the purchase
     * @param numberOfShippingDays number of shipping days
     * @return arrival date of order
     * @throw IllegalArgumentException if the date is invalid
     *
     */
    public static String getArrivalDate(int orderMonth, int orderDay, int numberOfShippingDays) {
        String arrivalDate = "";
        if (isValidDate(orderMonth, orderDay) == false) {
            throw new IllegalArgumentException ("Invalid date");
        } else if (numberOfShippingDays < 1) {
            throw new IllegalArgumentException ("Invalid number of shipping days");
        } else if (numberOfShippingDays > REGULAR_SHIPPING) {
            throw new IllegalArgumentException ("Invalid number of shipping days");
        } else
            if (numberOfShippingDays == 0) {
                arrivalDate += "";
            } else { 
                int x = CURRENT_YEAR - ((MONTHS + 2) - orderMonth) / MONTHS;
                int y = x + x / LEAP_YEAR_FREQUENCY - x / CENTURY_YEARS + x / (CENTURY_YEARS * 
                                                                    LEAP_YEAR_FREQUENCY);
                int z = orderMonth + MONTHS * (((MONTHS + 2) - orderMonth) / MONTHS) - 2;
                int dayOfTheWeekNumber = ((orderDay + y + ((DAYS_IN_MONTH * z) / MONTHS )) % 
                                                    DAYS_IN_WEEK);
                dayOfTheWeekNumber += numberOfShippingDays;
                String dayOfWeek = getDayOfWeek(dayOfTheWeekNumber);
                if (orderMonth == MIN_MONHTHS) {
                    if((orderDay + numberOfShippingDays) > DAYS_IN_MONTH) {
                        orderMonth += 1;
                        orderDay += (numberOfShippingDays) - DAYS_IN_MONTH;
                    } else {
                        orderDay += numberOfShippingDays;
                    }
                } else if (orderMonth == MAX_MONHTHS) {
                    if ((orderDay + numberOfShippingDays) > DAYS_IN_APRIL) {
                        orderMonth += 1;
                        orderDay += (numberOfShippingDays) - DAYS_IN_APRIL;
                    } else {
                        orderDay += numberOfShippingDays;
                    }
                }
                arrivalDate += dayOfWeek + ", " + orderMonth + " " + orderDay + " " + CURRENT_YEAR; 
            }                                                              
        return arrivalDate;
    } 
    /**
     * Calculates and returns the arrival date. 
     * 
     * @param dayOfTheWeekNumber number associated to the weekday
     * @return the corresponding day of the week
     */
    public static String getDayOfWeek(int dayOfTheWeekNumber) {
        String dayOfWeek = "";
        do {
            if (dayOfTheWeekNumber == 0 ) {
                dayOfWeek += "Sun";
                return dayOfWeek;
            } else if (dayOfTheWeekNumber == 1 ) {
                dayOfWeek += "Mon";
                return dayOfWeek;
            } else if (dayOfTheWeekNumber == 2 ) {
                dayOfWeek += "Tue";
                return dayOfWeek;
            } else if (dayOfTheWeekNumber == DAYS_IN_WEEK - (REGULAR_SHIPPING + 1) ) {
                dayOfWeek += "Wed";
                return dayOfWeek;
            } else if (dayOfTheWeekNumber == DAYS_IN_WEEK - REGULAR_SHIPPING ) {
                dayOfWeek += "Thu";
                return dayOfWeek;
            } else if (dayOfTheWeekNumber == DAYS_IN_WEEK - 2) {
                dayOfWeek += "Fri";
                return dayOfWeek;
            } else if (dayOfTheWeekNumber == DAYS_IN_WEEK - 1) {
                dayOfWeek += "Sat";
                return dayOfWeek;
            } else if  (dayOfTheWeekNumber == DAYS_IN_WEEK) {
                dayOfWeek += "Sun";
                return dayOfWeek;
            } else if (dayOfTheWeekNumber == DAYS_IN_WEEK + 1 ) {
                dayOfWeek += "Mon";
                return dayOfWeek;
            } else if (dayOfTheWeekNumber == DAYS_IN_WEEK + 2) {
                dayOfWeek += "Tue";
                return dayOfWeek;
            } 
        } while (dayOfTheWeekNumber < DAYS_IN_WEEK + 2);
        return dayOfWeek;
    }
}
 