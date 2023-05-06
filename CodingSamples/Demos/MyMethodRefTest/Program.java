interface INumberCheck{
	boolean isValid(int i);
}

class Compute{
	static int ComputeSum(int lower, int higher, INumberCheck chk){
		int total = 0;
		for(int i = lower; i <= higher; i++)
		{
		    if (chk.isValid(i))
				total = total + i;
		}
		return total;
	}
}

//Logic for Even
//Implement a class from interface INumberCheck
class EvenNumbers implements INumberCheck{
	public boolean isValid(int n){
		if (n%2 == 0)
			return true;
		return false;
	}

}

class Program{
    static boolean isOdd(int n){
		if (n% 2 != 0)
			return true;
		return false;
	}
	public static void main(String[] args){
	    int l = Integer.parseInt(args[0]);	
	    int h = Integer.parseInt(args[1]);	
		System.out.printf("Sum of even numbers is %d%n", Compute.ComputeSum(l, h, new EvenNumbers()));
		System.out.printf("Sum of odd numbers is %d%n", Compute.ComputeSum(l, h, Program::isOdd ));
		System.out.printf("Sum of odd numbers is %d%n", Compute.ComputeSum(l, h, y-> y%2!=0 ));
		System.out.printf("Sum of odd numbers is %d%n", Compute.ComputeSum(l, h,  new INumberCheck(){
			
    		public boolean isValid(int n){
			if (n% 2 != 0)
				return true;
			return false;
			}
		}
		));
	}

}
