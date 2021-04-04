package rank;

public class isRank {
	
	
	public boolean checkMin(int total,String[] score){
		
		int min=Integer.parseInt(score[4]);
		boolean result;
		if(min<total) {
			result=true;
		}else {
			result=false;
		}
		
		return result;
	}

}
