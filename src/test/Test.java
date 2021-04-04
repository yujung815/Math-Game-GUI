package test;

public class Test {

	
	public  void  sortRSave(String[] scores,String[] names){
		for(int j=0;j<4;j++) {
		for(int i=0;i<4-j;i++) {
			if(Integer.parseInt(scores[i])<Integer.parseInt(scores[i+1])) {
				System.out.println("비교가능");
				String tmp="";
				tmp=scores[i];
				scores[i]=scores[i+1];
				scores[i+1]=tmp;
				
				tmp=names[i];
				names[i]=names[i+1];
				names[i+1]=tmp;				
				
				

			}//if-end
			
		}//for-end
		}
		for(int i=0;i<5;i++) {
			System.out.println((i+1)+"번째: "+scores[i]+names[i]);
			
		}
	

	
	}
}
