import java.util.Scanner;
class Addtwonumbers2{
    public static void main(String[] args){
    int n1,n2,sum;
    Scanner sc = new Scanner(System.in);
    System.out.println("enter 1 no.");
    n1 =sc.nextInt();
    System.out.println("Enter 2 no.");
    n2 =sc.nextInt();
     
    sc.close();
    sum =n1+n2;
    System.out.println("sum is :"+sum);
}
}