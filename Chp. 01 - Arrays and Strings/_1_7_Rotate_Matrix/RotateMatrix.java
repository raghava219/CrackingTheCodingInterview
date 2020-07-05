// github.com/RodneyShag

package _1_7_Rotate_Matrix;

public class RotateMatrix {
    private static int n;

    public static void rotate90clockwise(int[][] image) {
        if (image == null || image.length != image[0].length) {
            return;
        }
        n = image.length;
        transpose(image);//intermediate ->[[1, 3], [2, 4]]
        flipHorizontally(image);
    }
    
    private static void transpose(int[][] image) {
    	
    	// https://www.codeproject.com/Articles/792036/Ranges-and-Looping-with-IntStream
    	
		/*
		 * IntStream.range(0, n) .forEach(row -> IntStream.range(row+1,n) .forEach(col
		 * -> RotateMatrix :: swap(image, row, col, col, row)); 1 2   1 3
		 *                                                      3 4   2 4
		 */
    	
        for (int row = 0; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                swap(image, row, col, col, row); //swamp([[1,2],[3,4]], 0, 1, 1, 0) --> [[1, 3], [2, 4]]
            }                                    
        }
    }
    
    private static void flipHorizontally(int[][] image) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n / 2; col++) {
                swap(image, row, col, row, n - 1 - col); // swap([[1,3],[2,4]],0,0,0,1) -->[[3,1],[2,4]] 
            }                                            // swap([[3,1],[2,4]],1,0,1,1) -->[[3,1],[4,2]]  
        }
    }

    // Swaps 2 elements in a 2-D array
    private static void swap(int[][] image, int r1, int c1, int r2, int c2) {
        int temp      = image[r1][c1];
        image[r1][c1] = image[r2][c2];
        image[r2][c2] = temp;
    }

    // For fun: I tried rotating image by 180 degrees
    public static int[][] rotate180(int[][] image) {
        int n = image.length;
        for (int row = 0; row < n/2; row++) {
            for (int col = 0; col < n; col++) {
                swap(image, row, col, n-1-row, n-1-col); // 5-argument version of swap
            }
        }
        /* If n is odd, rotate middle row */
        if (n % 2 == 1) {
            int middleRow = n/2;
            for (int col = 0; col < n/2; col++) {
                swap(image, middleRow, col, middleRow, n-1-col);
            }
        }
        return image;
    }
}

//  Time Complexity: O(n^2). Impossible to do better since must touch all n^2 elements.
// Space Complexity: O(1)
// Time/Space complexities are the same for both the 90-degree rotation and 180-degree rotation.
