import java.time.LocalDate;

public class Date {
	private int dd,mm,yy;
	
	public Date(int dd, int mm, int yy) {
		this.dd = dd;
		this.mm = mm;
		this.yy = yy;
	}
	
	public boolean checkDate() {
		
		if(mm < 1 || mm > 12 || dd < 1 || dd > 31 || yy < 1)
			return false;
		
		if(mm == 2) {
			
			if(!isLeapYear(yy)) {
				if(dd > 28)
					return false;
			}
			
			else {
				if(dd > 29)
					return false;
			}
		}
		
		else if((mm <= 7 && (mm&1) != 1) || (mm > 7 && (mm&1) == 1)) {
			if(dd > 30)
				return false;
		}
		
		return true;
	}
	
	public String displayDate() {
		
		if(!checkDate())
		return "Invalid";
		
		LocalDate date = LocalDate.of(yy, mm, dd);	
		
		StringBuilder res = new StringBuilder("");
		
		if(dd < 10) {
			res.append('0');
			res.append(dd);
		}
		
		else res.append(dd);
		
		
		res.append(' ');
		res.append(date.getMonth());
		res.append(' ');
		
		if(yy < 10) {
			res.append('0');
			res.append(yy);
		}
		
		else res.append(yy);
		
		return res.toString();
	}
	
	private boolean isLeapYear(int year) {
		
		if(year%4 != 0)
		return false;
		
		else if(year%100 != 0)
		return true;
		
		else if(year%400 == 0)
		return true;
		
		return false;
	}
	
}
