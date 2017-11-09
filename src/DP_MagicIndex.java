
public class DP_MagicIndex {
	int magicFast(int [] array){ 
		return magicFast(array, 0, array.length - 1);
	}
	
//case where the numbers in the array are distinct to each other	
	int magicFast(int [] array, int start, int end){
		if(start > end){
			return -1;
		}
		
		int mid = (start + end) / 2;
		
		if(array[mid] > mid)
			return magicFast(array, mid + 1, end);
		else if (array[mid] < mid) {
			return magicFast(array, start, mid - 1);
		}
		else {
			return mid;
		}
		
	}
	
	int magicFastDP(int [] array, int start, int end){
		if (end < start) return -1;
		
		int midIndex = (end + start) / 2;
		
		int midValue = array[midIndex];
		if(midValue == midIndex)
			return midIndex;
		
		//Left
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFastDP(array, start, leftIndex);
		if(left >= 0)
			return left;
		
		//right
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFastDP(array, rightIndex, end);
		
		return right;
		
	}
	
//case where the numbers in the array are not distinct
	
}