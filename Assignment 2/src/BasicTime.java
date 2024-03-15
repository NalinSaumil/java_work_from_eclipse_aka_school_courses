//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Sep 26, 2022
//This class takes a basic time input in the 12hr format "HH:MMXX" and then performs addition and subtraction with those time inputs and also gives out the time in the same format.
public class BasicTime {
	
	//Datafields
	int hh;
	int mm;
	String xx;
	
	//no-args constructor
	public BasicTime() {
		this(12,0,true);
	}
	
	//takes the 12hr-format time input and creates a BasicTime object.
	public BasicTime(String time) {
		this(Integer.parseInt(time.substring(0, 2)), Integer.parseInt(time.substring(3, 5)), (time.charAt(5) == 'A' || time.charAt(5) == 'a'));
	}
	
	//takes 2 int's and 1 boolean to create a BasicTime object
	public BasicTime(int hour, int minute, boolean morning) {
		hh = hour;
		mm = minute;
		
		if(morning) {
			xx = "AM";
		} else {
			xx = "PM";
		}
	}
	
	//takes a BasicTime input and adds it to your BasicTime object and returns the result as your current object changed.
	public BasicTime add(BasicTime time) {
		int thisMin;
		int timeMin;
		int newTime;
		
		//changes current object values into a minutes only
		if(this.xx.charAt(0) == 'A' && this.hh != 12) {
			thisMin = (this.hh * 60) + this.mm;
		} else if(this.xx.charAt(0) == 'A' && this.hh == 12) {
			thisMin = ((this.hh) * 0) + this.mm;
		} else if(this.xx.charAt(0) == 'P' && this.hh == 12) {
			thisMin = (this.hh * 60) + this.mm;
		} else {
			thisMin = ((this.hh + 12) * 60) + this.mm;
		}
		
		//takes the input values and changes it to minutes only
		if(time.xx.charAt(0) == 'A' && time.hh != 12) {
			timeMin = (time.hh * 60) + time.mm;
		} else if(time.xx.charAt(0) == 'A' && time.hh == 12) {
			timeMin = ((time.hh) * 0) + time.mm;
		} else if(time.xx.charAt(0) == 'P' && time.hh == 12) {
			timeMin = (time.hh * 60) + time.mm;
		} else {
			timeMin = ((time.hh + 12) * 60) + time.mm;
		}
		
		//performs addition
		newTime = thisMin + timeMin;
		
		//changes the new added minutes back into object values
		if((newTime / 60 == 0) || (newTime / 60 == 24)) {
			this.hh = 12;
			this.xx = "AM";
		} else if((newTime / 60 < 12) && (newTime / 60 >= 1)) {
			this.hh = newTime / 60;
			this.xx = "AM";
		} else if(newTime / 60 == 12) {
			this.hh = 12;
			this.xx = "PM";
		} else if((newTime / 60 > 24) && (newTime / 60 < 36)) {
			this.hh = (newTime / 60) - 24;
			this.xx = "AM";
		} else if(newTime / 60 == 36) {
			this.hh = 12;
			this.xx = "PM";
		} else if(newTime / 60 > 36) {
			this.hh = (newTime / 60) - 36;
			this.xx = "PM";
		} else {
			this.hh = (newTime / 60) - 12;
			this.xx = "PM";
		}

		this.mm = newTime % 60;
		
		//return object
		return this;
	}
	
	//takes 2 BasicTime inputs and adds them together and returns the result.
	public static BasicTime addTo(BasicTime time1, BasicTime time2) {
		int time1Min;
		int time2Min;
		int newTime;
		
		//changes first input values into a minutes only
		if(time1.xx.charAt(0) == 'A' && time1.hh != 12) {
			time1Min = (time1.hh * 60) + time1.mm;
		} else if(time1.xx.charAt(0) == 'A' && time1.hh == 12) {
			time1Min = ((time1.hh) * 0) + time1.mm;
		} else if(time1.xx.charAt(0) == 'P' && time1.hh == 12) {
			time1Min = (time1.hh * 60) + time1.mm;
		} else {
			time1Min = ((time1.hh + 12) * 60) + time1.mm;
		}
		
		//takes the second input values and changes it to minutes only
		if(time2.xx.charAt(0) == 'A' && time2.hh != 12) {
			time2Min = (time2.hh * 60) + time2.mm;
		} else if(time2.xx.charAt(0) == 'A' && time2.hh == 12) {
			time2Min = ((time2.hh) * 0) + time2.mm;
		} else if(time2.xx.charAt(0) == 'P' && time2.hh == 12) {
			time2Min = (time2.hh * 60) + time2.mm;
		} else {
			time2Min = ((time2.hh + 12) * 60) + time2.mm;
		}
		
		//performs addition
		newTime = time1Min + time2Min;
		
		//creates object to return the added result
		BasicTime sumTime = new BasicTime();
		
		//takes the added minutes and converts it back to an object
		if((newTime / 60 == 0) || (newTime / 60 == 24)) {
			sumTime.hh = 12;
			sumTime.xx = "AM";
		} else if((newTime / 60 < 12) && (newTime / 60 >= 1)) {
			sumTime.hh = newTime / 60;
			sumTime.xx = "AM";
		} else if(newTime / 60 == 12) {
			sumTime.hh = 12;
			sumTime.xx = "PM";
		} else if((newTime / 60 > 24) && (newTime / 60 < 36)) {
			sumTime.hh = (newTime / 60) - 24;
			sumTime.xx = "AM";
		} else if(newTime / 60 == 36) {
			sumTime.hh = 12;
			sumTime.xx = "PM";
		} else if(newTime / 60 > 36) {
			sumTime.hh = (newTime / 60) - 36;
			sumTime.xx = "PM";
		} else {
			sumTime.hh = (newTime / 60) - 12;
			sumTime.xx = "PM";
		}

		sumTime.mm = newTime % 60;
		
		//return object
		return sumTime;
	}
	
	//takes a BasicTime input and subtracts it from the current object
	public BasicTime subtract(BasicTime time) {
		int thisMin;
		int timeMin;
		int newTime;
		
		//changes current object values into a minutes only
		if(this.xx.charAt(0) == 'A' && this.hh != 12) {
			thisMin = (this.hh * 60) + this.mm;
		} else if(this.xx.charAt(0) == 'A' && this.hh == 12) {
			thisMin = ((this.hh) * 0) + this.mm;
		} else if(this.xx.charAt(0) == 'P' && this.hh == 12) {
			thisMin = (this.hh * 60) + this.mm;
		} else {
			thisMin = ((this.hh + 12) * 60) + this.mm;
		}
		
		//takes the input values and changes it to minutes only
		if(time.xx.charAt(0) == 'A' && time.hh != 12) {
			timeMin = (time.hh * 60) + time.mm;
		} else if(time.xx.charAt(0) == 'A' && time.hh == 12) {
			timeMin = ((time.hh) * 0) + time.mm;
		} else if(time.xx.charAt(0) == 'P' && time.hh == 12) {
			timeMin = (time.hh * 60) + time.mm;
		} else {
			timeMin = ((time.hh + 12) * 60) + time.mm;
		}
		
		//performs subtraction
		if(thisMin >= timeMin) {
			newTime = thisMin - timeMin;
		} else {
			newTime = 1440 + (thisMin - timeMin);
		}
		
		//changes the new subtracted minutes back into object values
		if((newTime / 60 == 0) || (newTime / 60 == 24)) {
			this.hh = 12;
			this.xx = "AM";
		} else if((newTime / 60 < 12) && (newTime / 60 >= 1)) {
			this.hh = newTime / 60;
			this.xx = "AM";
		} else if(newTime / 60 == 12) {
			this.hh = 12;
			this.xx = "PM";
		} else if((newTime / 60 > 24) && (newTime / 60 < 36)) {
			this.hh = (newTime / 60) - 24;
			this.xx = "AM";
		} else if(newTime / 60 == 36) {
			this.hh = 12;
			this.xx = "PM";
		} else if(newTime / 60 > 36) {
			this.hh = (newTime / 60) - 36;
			this.xx = "PM";
		} else {
			this.hh = (newTime / 60) - 12;
			this.xx = "PM";
		}

		this.mm = newTime % 60;
		
		//return object
		return this;
	}
	
	//takes 2 BasicTime inputs and subtracts the second input from the first input.
	public static BasicTime subtractFrom(BasicTime time1, BasicTime time2) {
		int time1Min;
		int time2Min;
		int newTime;
		
		//changes first input into minutes only
		if(time1.xx.charAt(0) == 'A' && time1.hh != 12) {
			time1Min = (time1.hh * 60) + time1.mm;
		} else if(time1.xx.charAt(0) == 'A' && time1.hh == 12) {
			time1Min = ((time1.hh) * 0) + time1.mm;
		} else if(time1.xx.charAt(0) == 'P' && time1.hh == 12) {
			time1Min = (time1.hh * 60) + time1.mm;
		} else {
			time1Min = ((time1.hh + 12) * 60) + time1.mm;
		}
		
		//changes second input to minutes only
		if(time2.xx.charAt(0) == 'A' && time2.hh != 12) {
			time2Min = (time2.hh * 60) + time2.mm;
		} else if(time2.xx.charAt(0) == 'A' && time2.hh == 12) {
			time2Min = ((time2.hh) * 0) + time2.mm;
		} else if(time2.xx.charAt(0) == 'P' && time2.hh == 12) {
			time2Min = (time2.hh * 60) + time2.mm;
		} else {
			time2Min = ((time2.hh + 12) * 60) + time2.mm;
		}
		
		//perform subtraction
		if(time1Min >= time2Min) {
			newTime = time1Min - time2Min;
		} else {
			newTime = 1440 + (time1Min - time2Min);
		}
		
		//creates object to return the result
		BasicTime subTime = new BasicTime();
		
		//changes the new minutes back into object
		if((newTime / 60 == 0) || (newTime / 60 == 24)) {
			subTime.hh = 12;
			subTime.xx = "AM";
		} else if((newTime / 60 < 12) && (newTime / 60 >= 1)) {
			subTime.hh = newTime / 60;
			subTime.xx = "AM";
		} else if(newTime / 60 == 12) {
			subTime.hh = 12;
			subTime.xx = "PM";
		} else if((newTime / 60 > 24) && (newTime / 60 < 36)) {
			subTime.hh = (newTime / 60) - 24;
			subTime.xx = "AM";
		} else if(newTime / 60 == 36) {
			subTime.hh = 12;
			subTime.xx = "PM";
		} else if(newTime / 60 > 36) {
			subTime.hh = (newTime / 60) - 36;
			subTime.xx = "PM";
		} else {
			subTime.hh = (newTime / 60) - 12;
			subTime.xx = "PM";
		}

		subTime.mm = newTime % 60;
		
		//return object
		return subTime;
	}
	
	//prints out the BasicTime input in the 12hr-format
	public static void toString(BasicTime time) {
		System.out.println(String.format("%02d", time.hh) + ":" + String.format("%02d", time.mm) + time.xx);
	}
}