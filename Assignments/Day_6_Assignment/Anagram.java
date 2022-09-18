
public class Anagram {
	private String string1,string2;
	
	public Anagram(String string1, String string2) {
		this.string1 = string1;
		this.string2 = string2;
	}
	
	public boolean getAnagram() {
		
		int i,j=0;
		int mp1[] = new int[26];
		int mp2[] = new int[26];
		
		for(char c: string1.toCharArray())
			++mp1[c - 'a'];
		
		for(char c: string2.toCharArray())
			++mp2[c - 'a'];
		
		for(i=0;i<26;++i) {
			if(mp1[i] != mp2[j++])
				return false;	
		}
		
		return true;
	}
	
}
