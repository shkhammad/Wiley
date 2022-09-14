import java.util.Comparator;

public class Sort implements Comparator <Pair>{
	
	@Override
	public int compare(Pair pair1, Pair pair2) {
		return (int)(pair1.getSalary() - pair2.getSalary());
	}
	
}
