/**
 * This program prints the planar and spherical distance from Raleigh, NC.
 *
 * @author Jamea Speight
 */
public class DistanceCalculator {
    /** 
    * sets radius in miles
    *
    */
    public static final double EARTH_RADIUS = 3959;
    /** 
    * sets raleigh latitude in degrees
    *
    */
    public static final double RALEIGH_LATITUDE = 35.78;
    /** 
    * sets raleigh longitude in degrees
    *
    */
    public static final double RALEIGH_LONGITUDE = -78.64;
    /**
    * sets minimum latitude in degrees
    *
    */
    public static final int MIN_LATITUDE = 30;
    /**
    * sets maximum latitude in degrees
    *
    */
    public static final int MAX_LATITUDE = 50;
    /**
    * sets minimum longitude in degrees
    *
    */
    public static final int MIN_LONGITUDE = -120;
    /** 
    * sets maximum longitude in degrees
    * 
    */
    public static final int MAX_LONGITUDE = -70;
    /**
    * set latitude increment in degrees
    * 
    */
    public static final int LATITUDE_INCREMENT = 10;
    /**
    * sets longitude increment in degrees
    * 
    */
    public static final int LONGITUDE_INCREMENT = 5;
    /**
    * The main method starts program execution
    *
    * @param args command line arguments
    */
    public static void main(String[] args) { 
        calculatorHeading ();
        for (int lng = MIN_LONGITUDE; lng <= MAX_LONGITUDE ; lng += LONGITUDE_INCREMENT) {
            System.out.printf("%5d",lng);
            for (int lat = MIN_LATITUDE; lat <= MAX_LATITUDE; lat += LATITUDE_INCREMENT) {
                System.out.printf("%9.0f",calculatePlanarDistance(RALEIGH_LATITUDE,
                                  RALEIGH_LONGITUDE , lat, lng) );
                System.out.printf("%9.0f",calculateSphericalDistance(RALEIGH_LATITUDE, 
                                  RALEIGH_LONGITUDE , lat, lng));
            }
            System.out.println();
        }
    }
    /**
    * This method prints the calculator heading.
    *
    */
    public static void calculatorHeading () {
        System.out.printf( "         " + "Distance (miles) from Raleigh (lat " + 
                          RALEIGH_LATITUDE + " long " + RALEIGH_LONGITUDE + ")" );
        System.out.println();
        for (int i = MIN_LATITUDE; i <= MAX_LATITUDE ; i += 10) {
            for (int j = 1; j <= 1; j++) {
                System.out.printf("              " + "lat " + (i) );
            }
        }
        System.out.println();
        System.out.printf("long" + "     ");
        for (int m = 1; m <= 3; m++) { 
            System.out.printf("Planar Spherical" + "    ");
        }
        System.out.println();
        System.out.printf("----" + "     ");
        for (int p = 1; p <= 3; p++) {
            System.out.printf("------ ---------" + "    ");
        }
        System.out.println();
    }
    /**
    * Calculates the distance between two points on the earth's surface assuming
    * the spherical earth has been projected to a plane
    * 
    * @param latitude1 latitude of first point in degrees
    * @param longitude1 longitude of first point in degrees
    * @param latitude2 latitude of second point in degrees
    * @param longitude2 longitude of second point in degrees
    * @return planar distance in miles between the two points
    */
    public static double calculatePlanarDistance(double latitude1, double longitude1, 
                                                 double latitude2, double longitude2) {
        double raleighLngRad = Math.toRadians (longitude1);
        double raleighLatRad = Math.toRadians (latitude1);
        double lngRadians = Math.toRadians(longitude2);
        double latRadians = Math.toRadians(latitude2);
        double diffLat = ( raleighLatRad - latRadians );
        double diffLng = ( raleighLngRad - lngRadians );
        double avgLat = ( raleighLatRad  + latRadians ) / 2 ;
        double diffLatSquared = Math.pow(diffLat, 2);
        double cosAvgLng = Math.cos(avgLat) ;
        double cosTimesDiffLng = cosAvgLng * diffLng ;
        double planerDistance = ( EARTH_RADIUS *  (Math.sqrt(diffLatSquared + 
                                 Math.pow(cosTimesDiffLng, 2))));
        return planerDistance;
    }
    /**
    * Calculates the spherical distance between two points on the earth's surface 
    * 
    * @param latitude1 latitude of first point in degrees
    * @param longitude1 longitude of first point in degrees
    * @param latitude2 latitude of second point in degrees
    * @param longitude2 longitude of second point in degrees
    * @return spherical distance in miles between the two points
    */ 
    public static double calculateSphericalDistance(double latitude1, double longitude1, 
                                                    double latitude2, double longitude2) {
        double raleighLngRad = Math.toRadians (longitude1);
        double raleighLatRad = Math.toRadians (latitude1);
        double lngRadians = Math.toRadians(longitude2);
        double latRadians = Math.toRadians(latitude2);
        double diffLng = (raleighLngRad - lngRadians);
        double sphericalDistance = EARTH_RADIUS * Math.acos( Math.sin(raleighLatRad) * 
                                   Math.sin(latRadians) + Math.cos(raleighLatRad) * 
                                   Math.cos(latRadians) * Math.cos(diffLng) );
        return sphericalDistance;
    }
}