//Time Complexity: O(log(m)); where m is the length of the smaller array
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n2 < n1)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = n1; // partition is one more than index
        
        while(low <= high){
            
            int partX = low + (high - low)/2;
            int partY = (n1+n2)/2 - partX;
            
            double l1 = partX ==0? Integer.MIN_VALUE : nums1[partX -1];
            double l2 = partY ==0? Integer.MIN_VALUE: nums2[partY - 1];
            
            double r1 = partX == n1? Integer.MAX_VALUE: nums1[partX];
            double r2 = partY == n2? Integer.MAX_VALUE: nums2[partY];
            
            if(l1 <=r2 && l2 <= r1){
                
                if((n1 + n2)%2 == 0){
                    
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                    
                }
                else
                {
                    return Math.min(r1,r2);
                }
            }
            
            else if( l1 > r2)
                high = partX -1;
            else
                low = partX +1;
        }
        
        return 0.0;
    }
}
