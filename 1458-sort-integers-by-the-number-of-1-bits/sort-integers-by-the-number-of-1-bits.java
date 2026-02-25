class Solution {
    public int[] sortByBits(int[] arr) {
        for(int i=0; i<arr.length; i++){

            int count = 0;
            int n = arr[i];

            while(n > 0){
                 n = (n & (n-1));
                    count++;
            }
                
                arr[i] = count*10001+arr[i];
               
               
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] % 10001;
        }
      return arr;
    }
}