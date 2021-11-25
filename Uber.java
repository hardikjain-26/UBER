//import whatever u need 
import java.util.*;
import java.awt.*;
import javax.swing.*;


class GUI {
GUI(int x,int y,String a,Float ETA){

   
JFrame frame = new JFrame();
JTextField arr[][] = new JTextField[25][25];
for(int i=0;i<25;i++){
for(int j=0;j<25;j++){
arr[i][j] = new JTextField();
arr[i][j].setFont(new Font("Serif",Font.CENTER_BASELINE,20));
arr[i][j].setHorizontalAlignment(JTextField.CENTER);
frame.add(arr[i][j]);
}
}
arr[0][0].setText("ETA =");
arr[0][1].setText(ETA+"");
x--; y--;
arr[y][x].setText(a);
JLabel l = new JLabel();
frame.setLayout(new GridLayout(25,25));
frame.setSize(1200,800);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}




}





class Location extends Thread{
    int x_cordinate;
    int y_cordinate;

    int distance(Location x,Location y){
        // to calculate distance
    int diff_x =x.x_cordinate-y.x_cordinate;
    int diff_y =x.y_cordinate-y.y_cordinate;
    return Math.abs(diff_x)+Math.abs(diff_y);

    }

    int distance(int x1,int y1){
    int diff_x =this.x_cordinate-x1;
    int diff_y =this.y_cordinate-y1;
    return Math.abs(diff_x)+Math.abs(diff_y);
    }


    void setNewLocation(int x,int y){
        //sets new loaction
        this.x_cordinate=x;
        this.y_cordinate=y;
    }
}



class Landmark extends Location{
  //  int [][] landmark_info=new int[10 ]/*n landmarks here 10*/[2]
     private int id;
      private String name;  
      int [][] l_arr=new int[5][2]; 
   
      

      Landmark(String name,int id,int x,int y){
         
          this(id);
          this.x_cordinate=x;
          this.y_cordinate=y;
          this.id=id;
          this.name=name;


      }

      Landmark(){
          this(0);
      }

      Landmark(int a){
           
        l_arr[0][0]=25;
        l_arr[0][1]=25;

        l_arr[1][0]=20;
        l_arr[1][1]=15;

        l_arr[2][0]=8;
        l_arr[2][1]=3;

        l_arr[3][0]=20;
        l_arr[3][1]=5;

        l_arr[4][0]=10;
        l_arr[4][1]=20;

        
      }

      int get_x(int id){
          return l_arr[id][0];
      }

      int get_y(int id){
        return l_arr[id][1];
    }
     
      
      // getter for landmark info 
      void display(){
          System.out.println(this.id+" - "+this.name+" - ("+this.x_cordinate+","+this.y_cordinate+")");
      }


      float ETA(int x1,int y1 ,int x2,int y2){
      
        int d=Math.abs(x1-x2+y1-y2);
        float t=d/1;
            System.out.println("ETA = "+t+" mins"); 
            return t;
    
      }




}






class Cab extends Location{
    private int cab_id;
    private int unique_reg;
    
    Booking b;
    

    private String[][] cab_info;

    //defining elements of cab 
    Cab(){
       
           cab_info=new String[2][5];
      
        
        cab_info[0][0]="0";
        cab_info[0][1]="1";
        cab_info[0][2]="2";
        cab_info[0][3]="3";
        cab_info[0][4]="4";
        
        cab_info[1][0]="true"; 
        cab_info[1][1]="false";
        cab_info[1][2]="true";
        cab_info[1][3]="false";
        cab_info[1][4]="true";
    
      
    }

    void change_state(int id){
        cab_info[1][id]="false";
      //  System.out.println("cahnged");
    }

       
    String getState(int id){   
      return cab_info[1][id];
    }

    String getID(int id){   
        return cab_info[0][id];
      }

}


class Booking {
  Driver driver_b  ;
  //Customer customer;
  private static int drop_location;
  private static int pickup_location;
  private int cab_id;
   Cab cab;
   private ArrayList<String> ava_cabs;
  
  

  void available_cabs(){
      //show total available cabs
       ava_cabs=new ArrayList<>();
     
      for(int i=0;i<5;i++){
          String s;
        Cab c=new Cab();
        String a=c.getState(i);
          if(a.equals("true")){
              s=c.getID(i);
              ava_cabs.add(s); 
            }
      }
      System.out.println("Available Cabs ID are -"+ava_cabs+"\n Input the Cab You want to ride :-)");
      ava_cabs.removeAll(ava_cabs);
  }

  void set_pickup(){
      System.out.println("Input PickUp Landmark Id");     
      Scanner p=new Scanner(System.in);
       pickup_location=p.nextInt();
      System.out.println(pickup_location);
  }

  void set_drop(){
    System.out.println("Input Drop Landmark Id");     
    Scanner p=new Scanner(System.in);  
    drop_location=p.nextInt();
    System.out.println(drop_location);
   
  }

  void choose_cab(){
    System.out.println("Choose Cab id");     
    Scanner p=new Scanner(System.in);  
    cab_id=p.nextInt();
    
    //change the state of choosen cab
    cab=new Cab();
    cab.change_state(cab_id);
    System.out.println("Your Cab Has Been Booked , Now Login as a Driver to Proceed"); // still need to improve to specific driver only 
    System.out.println("Press 2 to Login as a Driver");

  }

  void startJourney(Driver dri1){
  
    dri1.x_cordinate=10;
    dri1.y_cordinate=10;

   
  
    
    dri1.pathCalculator(pickup_location);
    System.out.println("Press start Journey(anykey) to start");
    System.out.println("this code os line 267");
   
    dri1.pathCalculator(pickup_location, drop_location);

    System.out.println("Rate your Cab Experience From 1-5");
    Scanner sc=new Scanner(System.in);
    int r=sc.nextInt();
    dri1.rate(r);
}

  int fareGenerator(int p,int d){
      //write the formula 
      Date date=java.util.Calendar.getInstance().getTime();
      System.out.println(date);
      int fare =10*(x.distance(y))*(date)*(Total-available_cabs())  
  }


 
}

class Customer extends Location{
    private int cust_id;
    private String cust_name;
   
    Booking b;

 


    void book_cab(){
     b=new Booking();

        b.set_pickup();
        b.set_drop();
        b.available_cabs();
        b.choose_cab();


    }

    



  
}

class Driver extends Location{
    private int dri_id;
    private int avg_rating;
    private ArrayList<Integer> rating=new ArrayList<>();
    private Location driv_loc;
    private Booking b;

    void confirm_booking(){
       System.out.println("Your Cab Have Been Booked \n Press Arriving(any key) to start journey"); //on drivers interface

      
       }

    void face(){
        System.out.println("You are in drivers interface");

    }

    
  



    void rate(int r){
        this.rating.add(r);
        int sum=0;
        int n=this.rating.size();
        for(int i=0;i<n;i++){
            sum=sum+this.rating.get(i);

        }
        this.avg_rating=sum/n;

        System.out.println("Average rating of the driver is "+this.avg_rating);
        System.out.println("Hooray *----*  You Have Reached Your Destionation ");

 }

    // display cab in path function 

    //path calculator
  
   
    void pathCalculator(int p,int d){
        //move from p to d
        //change x coordinate ....
      
        Landmark b1=new Landmark();
        GUI g;
       
     
       int px=b1.get_x(p);
       int py=b1.get_y(p);
       int dx=b1.get_x(d);
       int dy=b1.get_y(d);

         
        if(px<dx){
         for (int x=px;x<=dx;x++){
             this.setNewLocation(x,py);

             System.out.println("x="+this.x_cordinate +" y= "+this.y_cordinate);
             Float e= b1.ETA(x, py, dx, dy);
             b1.ETA(x, py, dx, dy);
             g=new GUI(x, py,"D,C",e);
            // System.out.println("x="+x+" y= "+py);

        }}
        else{
            for (int x=px;x>=dx;--x){
                this.setNewLocation(x,py);
                System.out.println("x="+this.x_cordinate +" y= "+this.y_cordinate);
              //  System.out.println("x="+x+" y= "+py);
             Float e= b1.ETA(x, py, dx, dy);
             b1.ETA(x, py, dx, dy);
              g=new GUI(x, py,"D,C",e);
   
        }}

        // chcange y cordinate...

        if(py<dy){
            for (int y=py;y<=dy;y++){
                this.setNewLocation(dy,y);
               // System.out.println("x="+this.x_cordinate +" y= "+this.y_cordinate);
                System.out.println("x="+dx +" y= "+y);
                float e= b1.ETA(dx, y, dx, dy);
                b1.ETA(dx, y, dx, dy);
                g=new GUI(dx, y,"D,C",e);

   
           }}
        else{
               for (int y=py;y>=dy;y--){
                   this.setNewLocation(dy,y);
                   System.out.println("x="+dx +" y= "+y);
                   float e=b1.ETA(dx, y, dx, dy);
                   b1.ETA(dx, y, dx, dy);
                   g=new GUI(dx, y,"D,C",e);
           }  }


        
        }
  

        // for driver to customer
        void pathCalculator(int p){
          
            //change x coordinate ....
          
            Landmark b1=new Landmark();
          
         
           int px=b1.get_x(p);
           int py=b1.get_y(p);
           int dx=this.x_cordinate;   //drivers cordinate
           int dy=this.y_cordinate; 
           GUI g;
           
           System.out.println(dx+" cordinates"+dy);//drivers cordinate 
    
             
           //change x cordinate
           if(dx<px){
               for(int x=dx;x<=px;x++){
                   this.setNewLocation(x, dy);
                   System.out.println("x= "+x+"y="+dy);
                   
                Float e = b1.ETA(x, dy, px, py);
                b1.ETA(x, dy, px, py);
                   g=new GUI(x, dy,"D",e);
                   for(int i=0;i<=50000;i++){System.out.print("");}
                  

               }
           }

           else{
            for(int x=dx;x>=px;x--){
                this.setNewLocation(x, dy);
                System.out.println("x= "+x+"y="+dy);
               Float e= b1.ETA(x, dy, px, py);
               b1.ETA(x, dy, px, py);

                g=new GUI(x, dy,"D",e);
                for(int i=0;i<=50000;i++){System.out.print("");}
               

            }
               
           }


    
            // chcange y cordinate...
    
            if(dy<py){
                for (int y=dy;y<=py;y++){
                    this.setNewLocation(px,y);
                   
                    System.out.println("x="+px +" y= "+y);

                   Float e= b1.ETA(px, y, px, py);
                   b1.ETA(px, y, px, py);
                    g=new GUI(px, y,"D",e);
                   
                    for(int i=0;i<=50000;i++){System.out.print("");}
                   
    
       
               }}
            else{
                   for (int y=dy;y>=py;--y){
                       this.setNewLocation(px,y);
                       System.out.println("x="+px +" y= "+y);
                      Float e= b1.ETA(px, y, px, py);
                       b1.ETA(px, y, px, py);

                       g=new GUI(px, y,"D",e);
                     
                       for(int i=0;i<=50000;i++){System.out.print("");}
                       

                      
    
               }  }
            }

        

        
}




 class Uber{
 
    public static void main(String[] args) {
      // HashMap<Integer,Landmark> l_map=new HashMap<>();
      
       Landmark l0=new Landmark("Main Gate",0,5,5);
       Landmark l1=new Landmark("Clock Tower",1,2,3);
       Landmark l2=new Landmark("Akshay",2,8,3);
       Landmark l3=new Landmark("C'Not",3,2,5);
       Landmark l4=new Landmark("Ram",4,1,2);
       
       
        Booking b=new Booking();
        Customer c=new Customer();
        Driver d=new Driver();
      
        Scanner sc=new Scanner(System.in);
         
        System.out.println("Choose an Interface \n Customer:1 \n Driver:2");

        int opt=sc.nextInt();

        if (opt==1){
          
          System.out.println("Press 1 to Book a Cab");
          int a = sc.nextInt();
          if(a==1){
             System.out.println("LANDMARK LIST -->\nID - NAME - CORDINATES");
              l0.display();
              l1.display();
              l2.display();
              l3.display();
              l4.display();

              c.book_cab();
          }
        }

        else if (opt==2){
            d.face();
            System.out.println("You are in Driver's Interface");
           
        }

        else{
            System.out.println("Restart and enter 1 or 2 only :-()-:");
        }



        // for driver 
     
        int opt2=sc.nextInt();
        if(opt2==2){
          
            d.face();
            d.confirm_booking();
            sc.next();
            b.startJourney(d);

        }

        else{
           System.out.println( "Press Correct Key"); 
        }    


        System.out.println("Thanks !!! Ride Back Sooooooooooooooon...........");
      
        
        

    }   
 }
