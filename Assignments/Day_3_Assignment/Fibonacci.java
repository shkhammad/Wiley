
public class Fibonacci {
	private int range;
	
	
	public Fibonacci(int range){
		this.range = range;
	}
	
	public int[] getSeries() {
		
		int i,series[] = new int[range];
		
		
		if(range == 0)
			return new int[] {};
		
		if(range == 1)
			return new int[] {0};
		
		series[0] = 0;
		series[1] = 1;
		
		if(range == 2)
			return series;
		
		
		for(i=2;i<range;++i) 
			series[i] = series[i-1] + series[i-2];
		
		
		return series;
	}
	
	public int getRange() {
		return this.range;
	}
}
