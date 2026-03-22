import java.util.Arrays;

public class Solution {
    
    public static boolean findRotation(int[][] matrix, int[][] target) {
        // Step 1: Original check
        if (Arrays.deepEquals(matrix, target)) return true;
        
        // Step 2: 90° rotation
        int[][] rot90 = rotate90(matrix);
        if (Arrays.deepEquals(rot90, target)) return true;
        
        // Step 3: 180° = 90° ko dobara rotate karo
        int[][] rot180 = rotate90(rot90);
        if (Arrays.deepEquals(rot180, target)) return true;
        
        // Step 4: 270° = 180° ko rotate karo
        int[][] rot270 = rotate90(rot180);
        if (Arrays.deepEquals(rot270, target)) return true;
        
        return false;
    }
    
    // Helper function - 90° right rotation
    private static int[][] rotate90(int[][] mat) {
        int n = mat.length;
        int[][] rotated = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                rotated[i][j] = mat[n-1-j][i];
            }
        }
        return rotated;
    }
    
    // Test karne ke liye main method
    public static void main(String[] args) {
        int[][] matrix = {{0,1},{1,0}};
        int[][] target = {{1,0},{0,1}};
        
        System.out.println("Answer: " + findRotation(matrix, target));
    }
}
