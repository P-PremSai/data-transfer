import java.util.Scanner;
class Player{
   private String id,name;
   private double scores[] = new double[10];
   private double totalsc=0.0;
   private int no_matches_played;
   private double avg=0.0;
   private  double avg1=0.0,avg2=0.0;

Player(){
   id ="123";
   name="sai";
   scores =new double[]{1,2,3,4,5,6,7,8,9,10};
   no_matches_played=10;
}   
Player(String eid,String ename,double escore[],int eno_matches_played){
   id =eid;
   name=ename;
   for(int i=0;i<10;i++){
       scores[i]=escore[i];
   }
   no_matches_played=eno_matches_played;   
}

void average(){
		    for(int i=0;i<10;i++)
        {
           totalsc=+scores[i];
        }
		    avg =totalsc/10;
}

double reavgs()
{
	return avg;
}


void printdetails(){
    System.out.println("ID : "+id+"   NAME : "+name+"   Average of score is : "+avg);
}

}
class Playermain{
	
   public static void main(String args[]){
	  
       Player p1 =new Player();
	   p1.average();
	   p1.printdetails();
	   Player p2 = new Player("456","prem",new double[]{0,1,2,3,4,5,6,7,8,9},10);
	   p2.average();
	   p2.printdetails();
	   
	   if(p1.reavgs()>p2.reavgs())
	{
		System.out.println("Average of Player1 is greater than Player2");
	}
	else if(p1.reavgs()<p2.reavgs())
	{
		System.out.println("Average of Player2 is greater than Player2");
	}
	else 
	{
		System.out.println("Average of Player1 is equal to Player2");
	}
	  
   }
}