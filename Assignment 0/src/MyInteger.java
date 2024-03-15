public class MyInteger {
	
	private int value;
	
	public MyInteger() {
		value = 0;
	}
	
	public MyInteger(int num) {
		value = num;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isEven() {
		if(value % 2 == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isOdd() {
		if(value % 2 == 1) {
			return true;
		}
		return false;
	}
	
	public boolean isPrime() {
		if(value <= 1)
        {
            return false;
        }
        for(int i = 2; i <= value / 2; i++)
        {
            if(value % i == 0) {
                return  false;
            }
        }
        return true;
	}
	
	public static boolean isEven(int num) {
		if(num % 2 == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isOdd(int num) {
		if(num % 2 == 1) {
			return true;
		}
		return false;
	}
	
	public static boolean isPrime(int num) {
		if(num <= 1)
        {
            return false;
        }
        for(int i = 2; i <= num / 2; i++)
        {
            if(num % i == 0) {
                return  false;
            }
        }
        return true;
	}
	
	public boolean equals(int num) {
		if(value == num) {
			return true;
		}
		return false;
	}
	
	public boolean equals(MyInteger integer) {
		if(integer.getValue() == this.value) {
			return true;
		}
		return false;
	}
	
	public static int parseInt(char[] arrayOfChars) {
		String num = "";
		for(int i = 0; i < arrayOfChars.length; i++) {
			num += String.valueOf(arrayOfChars[i]);
		}
		return Integer.parseInt(num);
	}
	
	public static int parseInt(String input) {
		return Integer.parseInt(input);
	}
}
