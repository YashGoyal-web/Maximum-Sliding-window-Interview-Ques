package slidingwindowmaximumoptimizedsolution;
import java.util.*;

public class SlidingWindowMaximumOptimizedSolution {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayDeque<Integer> window = new ArrayDeque<>(k);
        int []res = new int[nums.length-k+1];
         int i = 0;
        for(i = 0 ; i < nums.length ; i++){
            if(i<k){
                
                while(!window.isEmpty() && nums[window.peekFirst()] <= nums[i]){
                    window.removeLast();
                }
                window.addLast(i);
            
            }else{
                res[i-k] = nums[window.peekFirst()];
                while(!window.isEmpty() && window.peekFirst() <= i-k){
                    window.removeFirst();
                }
                while(!window.isEmpty() && nums[window.peekFirst()] <= nums[i]){
                    window.removeLast();
                }
                window.addLast(i);
            }
      } 
           res[i-k] = nums[window.peekFirst()];          
       return res;
    }
    
    public static void main(String[] args) {
    
		int a[] = { 4, 3, 1, 2, 5, 3, 4, 7, 1, 9 };
		int ans[] = maxSlidingWindow(a, 4);

		for (int x : ans) {
			System.out.print(x + " ");
		}
    }   
}
