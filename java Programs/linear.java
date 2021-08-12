import java.util.Scanner;
class linear
{
	public static void main(String args[]){
	int num,counter,array[],item;
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the number of elements in an array :");
	num =input.nextInt();
	array = new int[num];
	System.out.println("Enter " + num +" elements");
	for(counter=0;counter<num;counter++)
		array[counter]=input.nextInt();
		
	System.out.println("Enter search element:");
	item = input.nextInt();
	for(counter=0;counter<num;counter++)
	{
	    if(array[counter]==item)
		{
			System.out.println(item+"is placed at "+(counter+1));
			break;
		}	 
	}
	if(counter==num)
	{
		System.out.println(item+"not there in the array");
	}	
}
}