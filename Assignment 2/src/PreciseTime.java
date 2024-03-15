//Saumil Nalin
//CS 2336.503
//Mohamed Amine Belkoura
//Sep 26, 2022
//This class takes a precise time input in the 12hr format "HH:MM:SSXX" and then performs addition and subtraction with those time inputs and also gives out the time in the same format. This class also is a subclass to the BasicTime class.
public class PreciseTime extends BasicTime {
	
	//datafields
	int ss;
	
	//no-args constructor
	public PreciseTime() {
		this(12,0,0,true);
	}
	
	//takes a string time input in the 12hr-format and creates Precise Time object
	public PreciseTime(String time) {
		this(Integer.parseInt(time.substring(0, 2)), Integer.parseInt(time.substring(3, 5)), Integer.parseInt(time.substring(6, 8)), (time.charAt(8) == 'A' || time.charAt(8) == 'a'));
	}
	
	//takes 3 int's and a boolean and creates a precise time object.
	public PreciseTime(int hour, int minute, int second, boolean morning) {
		super(hour, minute, morning);
		ss = second;
	}
	
	//takes a precisetime input, adds it to your object and returns the result as your object edited.
	public PreciseTime add(PreciseTime time) {
		int thisSec;
		int timeSec;
		int newTime;
		
		//takes your object and changes it to seconds only
		if(this.xx.charAt(0) == 'A' && this.hh != 12) {
			thisSec = (this.hh * 3600) + (this.mm * 60) + this.ss;
		} else if(this.xx.charAt(0) == 'A' && this.hh == 12) {
			thisSec = ((this.hh) * 0) + (this.mm * 60) + this.ss;
		} else if(this.xx.charAt(0) == 'P' && this.hh == 12) {
			thisSec = (this.hh * 3600) + (this.mm * 60) + this.ss;
		} else {
			thisSec = ((this.hh + 12) * 3600) + (this.mm * 60) + this.ss;
		}
		
		//takes input and changes it to seconds only
		if(time.xx.charAt(0) == 'A' && time.hh != 12) {
			timeSec = (time.hh * 3600) + (time.mm * 60) + time.ss;
		} else if(time.xx.charAt(0) == 'A' && time.hh == 12) {
			timeSec = ((time.hh) * 0) + (time.mm * 60) + time.ss;
		} else if(time.xx.charAt(0) == 'P' && time.hh == 12) {
			timeSec = (time.hh * 3600) + (time.mm * 60) + time.ss;
		} else {
			timeSec = ((time.hh + 12) * 3600) + (time.mm * 60) + time.ss;
		}
		
		//performs addition
		newTime = thisSec + timeSec;
		
		//changes the new added seconds back into a precisetime object
		if((newTime / 3600 == 0) || (newTime / 3600 == 24)) {
			this.hh = 12;
			this.xx = "AM";
		} else if((newTime / 3600 < 12) && (newTime / 3600 >= 1)) {
			this.hh = newTime / 3600;
			this.xx = "AM";
		} else if(newTime / 3600 == 12) {
			this.hh = 12;
			this.xx = "PM";
		} else if((newTime / 3600 > 24) && (newTime / 3600 < 36)) {
			this.hh = (newTime / 3600) - 24;
			this.xx = "AM";
		} else if(newTime / 3600 == 36) {
			this.hh = 12;
			this.xx = "PM";
		} else if(newTime / 3600 > 36) {
			this.hh = (newTime / 3600) - 36;
			this.xx = "PM";
		} else {
			this.hh = (newTime / 3600) - 12;
			this.xx = "PM";
		}
		
		this.mm = (newTime - ((newTime / 3600) * 3600)) / 60;
		this.ss = (newTime - ((newTime / 3600) * 3600)) % 60;
		
		//returns object
		return this;
	}	
	
	//takes 2 precisetime inputs and adds them together and returns result
	public static PreciseTime addTo(PreciseTime time1, PreciseTime time2) {
		int time1Sec;
		int time2Sec;
		int newTime;
		
		//changes input 1 into seconds only
		if(time1.xx.charAt(0) == 'A' && time1.hh != 12) {
			time1Sec = (time1.hh * 3600) + (time1.mm * 60) + time1.ss;
		} else if(time1.xx.charAt(0) == 'A' && time1.hh == 12) {
			time1Sec = ((time1.hh) * 0) + (time1.mm * 60) + time1.ss;
		} else if(time1.xx.charAt(0) == 'P' && time1.hh == 12) {
			time1Sec = (time1.hh * 3600) + (time1.mm * 60) + time1.ss;
		} else {
			time1Sec = ((time1.hh + 12) * 3600) + (time1.mm * 60) + time1.ss;
		}
		
		//changes input 2 into seconds only
		if(time2.xx.charAt(0) == 'A' && time2.hh != 12) {
			time2Sec = (time2.hh * 3600) + (time2.mm * 60) + time2.ss;
		} else if(time2.xx.charAt(0) == 'A' && time2.hh == 12) {
			time2Sec = ((time2.hh) * 0) + (time2.mm * 60) + time2.ss;
		} else if(time2.xx.charAt(0) == 'P' && time2.hh == 12) {
			time2Sec = (time2.hh * 3600) + (time2.mm * 60) + time2.ss;
		} else {
			time2Sec = ((time2.hh + 12) * 3600) + (time2.mm * 60) + time2.ss;
		}
		
		//performs addition
		newTime = time1Sec + time2Sec;
		
		//creates precisetime object to return the result
		PreciseTime sumTime = new PreciseTime();
		
		//changes added seconds back into a PreciseTime object
		if((newTime / 3600 == 0) || (newTime / 3600 == 24)) {
			sumTime.hh = 12;
			sumTime.xx = "AM";
		} else if((newTime / 3600 < 12) && (newTime / 3600 >= 1)) {
			sumTime.hh = newTime / 3600;
			sumTime.xx = "AM";
		} else if(newTime / 3600 == 12) {
			sumTime.hh = 12;
			sumTime.xx = "PM";
		} else if((newTime / 3600 > 24) && (newTime / 3600 < 36)) {
			sumTime.hh = (newTime / 3600) - 24;
			sumTime.xx = "AM";
		} else if(newTime / 3600 == 36) {
			sumTime.hh = 12;
			sumTime.xx = "PM";
		} else if(newTime / 3600 > 36) {
			sumTime.hh = (newTime / 3600) - 36;
			sumTime.xx = "PM";
		} else {
			sumTime.hh = (newTime / 3600) - 12;
			sumTime.xx = "PM";
		}

		sumTime.mm = (newTime - ((newTime / 3600) * 3600)) / 60;
		sumTime.ss = (newTime - ((newTime / 3600) * 3600)) % 60;
		
		//return object
		return sumTime;
	}
	
	//takes a precise time object and subtracts it from the current object
	public PreciseTime subtract(PreciseTime time) {
		int thisSec;
		int timeSec;
		int newTime;
		
		//changes object to seconds only
		if(this.xx.charAt(0) == 'A' && this.hh != 12) {
			thisSec = (this.hh * 3600) + (this.mm * 60) + this.ss;
		} else if(this.xx.charAt(0) == 'A' && this.hh == 12) {
			thisSec = ((this.hh) * 0) + (this.mm * 60) + this.ss;
		} else if(this.xx.charAt(0) == 'P' && this.hh == 12) {
			thisSec = (this.hh * 3600) + (this.mm * 60) + this.ss;
		} else {
			thisSec = ((this.hh + 12) * 3600) + (this.mm * 60) + this.ss;
		}
		
		//changes input to seconds only
		if(time.xx.charAt(0) == 'A' && time.hh != 12) {
			timeSec = (time.hh * 3600) + (time.mm * 60) + time.ss;
		} else if(time.xx.charAt(0) == 'A' && time.hh == 12) {
			timeSec = ((time.hh) * 0) + (time.mm * 60) + time.ss;
		} else if(time.xx.charAt(0) == 'P' && time.hh == 12) {
			timeSec = (time.hh * 3600) + (time.mm * 60) + time.ss;
		} else {
			timeSec = ((time.hh + 12) * 3600) + (time.mm * 60) + time.ss;
		}
		
		//performs subtraction
		if(thisSec >= timeSec) {
			newTime = thisSec - timeSec;
		} else {
			newTime = 86400 + (thisSec - timeSec);
		}
		
		//changes newly subtracted into edited object
		if((newTime / 3600 == 0) || (newTime / 3600 == 24)) {
			this.hh = 12;
			this.xx = "AM";
		} else if((newTime / 3600 < 12) && (newTime / 3600 >= 1)) {
			this.hh = newTime / 3600;
			this.xx = "AM";
		} else if(newTime / 3600 == 12) {
			this.hh = 12;
			this.xx = "PM";
		} else if((newTime / 3600 > 24) && (newTime / 3600 < 36)) {
			this.hh = (newTime / 3600) - 24;
			this.xx = "AM";
		} else if(newTime / 3600 == 36) {
			this.hh = 12;
			this.xx = "PM";
		} else if(newTime / 3600 > 36) {
			this.hh = (newTime / 3600) - 36;
			this.xx = "PM";
		} else {
			this.hh = (newTime / 3600) - 12;
			this.xx = "PM";
		}

		this.mm = (newTime - ((newTime / 3600) * 3600)) / 60;
		this.ss = (newTime - ((newTime / 3600) * 3600)) % 60;
		
		//returns object
		return this;
	}
	
	//takes 2 precise time input and subtracts the second from the first
	public static PreciseTime subtractFrom(PreciseTime time1, PreciseTime time2) {
		int time1Sec;
		int time2Sec;
		int newTime;
		
		//changes input 1 into seconds only
		if(time1.xx.charAt(0) == 'A' && time1.hh != 12) {
			time1Sec = (time1.hh * 3600) + (time1.mm * 60) + time1.ss;
		} else if(time1.xx.charAt(0) == 'A' && time1.hh == 12) {
			time1Sec = ((time1.hh) * 0) + (time1.mm * 60) + time1.ss;
		} else if(time1.xx.charAt(0) == 'P' && time1.hh == 12) {
			time1Sec = (time1.hh * 3600) + (time1.mm * 60) + time1.ss;
		} else {
			time1Sec = ((time1.hh + 12) * 3600) + (time1.mm * 60) + time1.ss;
		}
		
		//changes input 2 into seconds only
		if(time2.xx.charAt(0) == 'A' && time2.hh != 12) {
			time2Sec = (time2.hh * 3600) + (time2.mm * 60) + time2.ss;
		} else if(time2.xx.charAt(0) == 'A' && time2.hh == 12) {
			time2Sec = ((time2.hh) * 0) + (time2.mm * 60) + time2.ss;
		} else if(time2.xx.charAt(0) == 'P' && time2.hh == 12) {
			time2Sec = (time2.hh * 3600) + (time2.mm * 60) + time2.ss;
		} else {
			time2Sec = ((time2.hh + 12) * 3600) + (time2.mm * 60) + time2.ss;
		}
		
		//performs subtraction
		if(time1Sec >= time2Sec) {
			newTime = time1Sec - time2Sec;
		} else {
			newTime = 86400 + (time1Sec - time2Sec);
		}
		
		//creates new object to return result
		PreciseTime subTime = new PreciseTime();
		
		//changes newly subtracted seconds into object
		if((newTime / 3600 == 0) || (newTime / 3600 == 24)) {
			subTime.hh = 12;
			subTime.xx = "AM";
		} else if((newTime / 3600 < 12) && (newTime / 3600 >= 1)) {
			subTime.hh = newTime / 3600;
			subTime.xx = "AM";
		} else if(newTime / 3600 == 12) {
			subTime.hh = 12;
			subTime.xx = "PM";
		} else if((newTime / 3600 > 24) && (newTime / 3600 < 36)) {
			subTime.hh = (newTime / 3600) - 24;
			subTime.xx = "AM";
		} else if(newTime / 3600 == 36) {
			subTime.hh = 12;
			subTime.xx = "PM";
		} else if(newTime / 3600 > 36) {
			subTime.hh = (newTime / 3600) - 36;
			subTime.xx = "PM";
		} else {
			subTime.hh = (newTime / 3600) - 12;
			subTime.xx = "PM";
		}

		subTime.mm = (newTime - ((newTime / 3600) * 3600)) / 60;
		subTime.ss = (newTime - ((newTime / 3600) * 3600)) % 60;
		
		//return object
		return subTime;
	}
	
	//prints precise time object as a 12hr-format string
	public static void toString(PreciseTime time) {
		System.out.println(String.format("%02d", time.hh) + ":" + String.format("%02d", time.mm) + ":" + String.format("%02d", time.ss) + time.xx);
	}

}
