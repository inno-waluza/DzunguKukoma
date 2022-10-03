
//import utilities
import java.util.* ;
import java.io.* ;
import java.time.LocalDate ;
import java.time.format.DateTimeFormatter ;

public class DzunguKukoma {

    //static objects and arrays
    static Scanner sc = new Scanner(System.in) ;
    static Scanner i = new Scanner(System.in) ;
    static ArrayList<String> eat = new ArrayList<>() ;
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> Gymnumbers = new ArrayList<>() ;
    static LocalDate date = LocalDate.now() ;
    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy") ;
    static String formattedDate = date.format(myFormatObj) ;

    //create files
    static File inno = new File("gym_members.csv") ;
    static File salome = new File("authorised_users.csv") ;
    static File jonathan = new File("Report_template.csv") ;
    
    //Data fields
    private static String mobnum ;
    private String name  ;
    private static String gymnum ;

    //check if num starts with 265
    public boolean verMobile() {
        if(mobnum.charAt(0) == '2' && mobnum.charAt(1) == '6' && mobnum.charAt(2) == '5' && mobnum.length() == 12 ) {
         return true ;
        }
        return false ; 
    }
    //check if mob contains numbers
    public boolean
    onlyDigitsMob(String mobnum)
    {
   
        for (int i = 0; i <= mobnum.length();) {
  
   
            if (mobnum.charAt(i) >= '0'
                && mobnum.charAt(i) <= '9') {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    public String choice() {
        return """
        *
        Welcome to Dzungu Kukoma Cafeteria!
        What do you want to do?
        1. Add new gym members
        2. Delete gym member
        3. Issue meal cards
        4. Print report
        5. Logout """ ;
    }
    public boolean onlyDigitsGym(String gymnum) {
        for (int i = 0; i < gymnum.length();) {
  
   
            if (gymnum.charAt(i) >= '0'
                && gymnum.charAt(i) <= '9') {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    public static void welcome() {
        System.out.println("Dzungu Kukoma Cafeteria") ;
        System.out.println("________________________________________________________________________") ;
    }
    
    //choice 1
    public void addGymMembers() {
        
        System.out.print("enter name: ") ;
        name = i.nextLine();
        System.out.print("enter gym number: ") ;
        gymnum = sc.next();
    
        if (gymnum.length()== 6) {

        }
    }
    //choice 2
    public void deleteGymMember() {

    }
    //append a file


    //choice 3
    public void issueMealCard() {
        System.out.print("enter gym number: ") ;
        gymnum = sc.next() ;
        int indx = Gymnumbers.indexOf(gymnum);
        int ind = Collections.binarySearch(Gymnumbers, gymnum) ;
        if (ind > -1) {
            if (eat.contains(gymnum)) {
                System.out.println("denied " + names.get(indx) + " has already been issued a free meal card") ;
            } 
            else {
                System.out.println("Take out the meal card on the printer") ;
                eat.add(gymnum) ;
            }
        }
        else {
            System.out.println("invalid Gym number") ;
        }
    }
    //choice 4
    public  void reportFile() {
        System.out.println("The report has been exported to csv.") ;
    }
    //login
    public static void enterNumber() {
        System.out.print("enter mobile number starting with 265: ") ;
    }
    public static void logOut() {
        System.out.println("bye! bye!") ;
        return;
    }


    public boolean verGymNumber(String gymnum) {
        if(gymnum.length() == 6 ) {
            return true;
        }
        return false ;
    }
   
    public static void main(String[] args) throws IOException  {
        //create obj scanner
        Scanner in = new Scanner(System.in) ;
        //create dzungucafe obj
        DzunguKukoma app = new DzunguKukoma()  ;
    
        //write to gym mumbers
        BufferedWriter wrt = new BufferedWriter(new FileWriter("gym_members.csv"));
        
        
        //write to authorised users
        FileWriter xrt = new FileWriter("authorised_users.csv") ;
        
    

        //write to report temperate
        FileWriter rrt = new FileWriter("Report_template.csv") ;
        
        //welcome
        welcome();

        //enter mobile number
        enterNumber();
        mobnum = sc.next() ;
        while (app.verMobile() == false) {
            System.out.println("invalid number") ;
            enterNumber();
            mobnum = sc.next() ;
        }    
        int i=-1;
            while(i!=0){
                System.out.println(app.choice()) ;
                System.out.print("choice: ") ;
                int choice = in.nextInt() ; 
            
                if (choice == 1) {
                    app.addGymMembers();
                    if(app.verGymNumber(gymnum) == true && app.onlyDigitsGym(gymnum) == true) {
                        System.out.println("you have successfully added " + app.name + " with gym number " + gymnum) ;
                         names.add(app.name);
                         Gymnumbers.add(gymnum) ;
                    }
    
                    else {
                        System.out.println("invalid gym number") ;
                    }
                }
                if( choice == 2) {
                    System.out.println("example  not provided") ;

                }
                if (choice ==3 ) {
                    app.issueMealCard() ;
                   
                    
                   
                }

                //choice 4
                if (choice == 4 ) {
                    app.reportFile();
                    rrt.write("\non " + formattedDate) ;
                    rrt.write("\nlogin by " + mobnum) ;
                    rrt.write("\nThese Gym members were added") ;
                    for (int s = 0 ; s < names.size(); s++) {
                        rrt.write("\n" + names.get(s)) ;
                    }
                    rrt.write("\nThese gym numbers were added") ;
                    for(int n = 0 ; n < Gymnumbers.size() ; n++) {
                        rrt.write("\n" + Gymnumbers.get(n)) ;
                    }
                    rrt.write("\nThese Gym numbers were isuued meal cards") ;
                    for(int e = 0 ; e < eat.size() ; e++) {
                        rrt.write("\n" + eat.get(e)) ;
                    }
                    rrt.close();
                    xrt.write("\nLog in by " + mobnum ) ;
                    xrt.close();
                }

            
                //choice 5
                if (choice == 5) {
                    logOut();
                    for ( int j = 0; j < names.size(); j ++) {
                        wrt.write("\nname") ;
                        wrt.write("  " + names.get(j)) ;
                        wrt.write("\ngymnumber ") ;
                        wrt.write("  " + Gymnumbers.get(j)) ;
                    }
                    wrt.close();
                    i+=1;
                    return ;
                }

            }
            
        } 
    }

