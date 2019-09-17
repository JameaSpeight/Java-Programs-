/**
 * This program prints the image of an Animal 
 * Art from the site http://www.asciiworld.com/-Animals-.html
 *
 * @author Jamea Speight
 */
public class AnimalArt {
    /**
    * The main method starts program execution
    *
    * @param args command line arguments
    */
    public static void main(String[] args) {
        moon();
        wolfOnGround();
        ground();
    }
    /**
    *
    * This method prints the moon top.
    */
    public static void moon() {
        System.out.println("                           oo");
        System.out.println("                         oOOOOo");
        for(int i = 1; i <= 2; i++) {
            System.out.println("                        oOOOOOOo");
        }
        System.out.println("                         oOOOOo");
        System.out.println("                           oo");
    }
    /**
    *
    * This method prints the whole wolf.
    */
    public static void wolfOnGround ()  { 
        wolfHead();
        wolfBody();
        wolfButt();
    }
    /**
    *
    * This method prints the head of the wolf.
    */
    public static void wolfHead ()  {
        System.out.println("              A");
        System.out.println("             AMa");
        System.out.println("             VMMML");
        System.out.println("           h  VMMHMA");
        System.out.println("            VAMMMMMMA;,.");
        System.out.println("             VHHHHHHV^^^^^");
    }
    /**
    *
    * This method prints the body of the wolf.
    */
    public static void wolfBody ()  {
        System.out.println("              AMMMMM");
        System.out.println("             AMMMMMHHha           A");
        System.out.println("             AMMMMMMMMMmma        VA");
        System.out.println("             MMMMMMMMMMMMMMMA      AV");
        System.out.println("             VMMMMMMMMMMMMMMMMMA   AV");
    }
    /**
    *
    * This method prints the butt of the wolf.
    */
    public static void wolfButt ()  {
        System.out.println("             MM  VMMMMMMMMMMMMMMMMMV");
        System.out.println("             MM     VMMMMMMMMMMMMMV");
        System.out.println("____________AMA__AMMMMMMMMMMMMMMMV_________");
    }
    /**
    *
    * This method prints the ground.
    */
    public static void ground()  { 
        System.out.println("\\\\ \\\\ \\\\ \\\\ \\\\\\\\\\\\\\\\\\    \\ \\   \\  \\  \\  \\ \\");
        System.out.println("\\\\\\/ \\ //\\\\ \\\\\\ ///  /\\ \\\\\\ \\/ \\\\/ \\\\ /\\ //");
        System.out.println(" \\\\\\/\\\\\\/\\\\/\\ /\\ /\\/\\/ \\\\/\\/ \\// \\ /\\ \\/ \\\\");
        System.out.println(" /\\\\ /\\\\/ \\/\\/\\ /\\ /\\/\\ / ///\\\\ \\\\\\/ /\\\\\\\\\\");
        System.out.println(" \\ \\\\\\ \\\\\\\\\\\\\\\\/     /\\\\\\     /\\\\ /\\\\/\\\\/ /");
        System.out.println("  \\\\\\//\\\\\\\\/\\/\\\\/\\/ \\/ /\\/\\/\\  /\\/\\\\\\\\/ // \\");
        System.out.println("   \\\\\\\\/ //// \\\\\\\\ / \\/\\ /\\/\\ \\/ /\\ \\\\\\ / /");
    }
}

