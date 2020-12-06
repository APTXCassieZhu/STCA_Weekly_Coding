/*
Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s.

Write a function that takes in the image and returns one of the following representations of the rectangle of 0's: top-left coordinate and bottom-right coordinate OR top-left coordinate, width, and height.

image1 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

Sample output variations (only one is necessary):

findRectangle(image1) =>
  x: 3, y: 2, width: 3, height: 2
  2,3 3,5 -- row,column of the top-left and bottom-right corners

Other test cases:

image2 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

findRectangle(image2) =>
  x: 6, y: 4, width: 1, height: 1
  4,6 4,6

image3 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 0, 0],
  [1, 1, 1, 1, 1, 0, 0],
]

findRectangle(image3) =>
  x: 5, y: 3, width: 2, height: 2
  3,5 4,6
  
image4 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

findRectangle(image4) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0

image5 = [
  [0],
]

findRectangle(image5) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0

n: number of rows in the input image
m: number of columns in the input image


*/
import java.util.*;

public class FindRectangle{
    public static void main(String[] argv) {
        int[][] image1 = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] image2 = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0}
        };

        int[][] image3 = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 0, 0}
        };

        int[][] image4 = {
            {0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] image5 = {
            {0}
        };
        forTest(findRect(image1));   // 2,3,3,5
        forTest(findRect(image2));   // 4,6,4,6
        forTest(findRect(image3));   // 3,5,4,6
        forTest(findRect(image4));   // 0,0,0,0
        forTest(findRect(image5));   // 0,0,0,0
    }
    public static void forTest(int[] ans){
        for(int i : ans){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    private static int[] findRect(int[][] image){
        int[] ans = new int[4];
        boolean findLeftTop = false;
        int r = 0, c = 0;
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                if(!findLeftTop && image[i][j] == 0){
                    ans[0] = i;
                    ans[1] = j;
                    findLeftTop = true;
                    System.out.println(i+" "+j);
                }
                if(findLeftTop){
                    while(j < image[0].length && image[i][j] == 0 && ){
                        j++;
                    }
                    if(j == image[0].length || image[i][j] == 1){
                        j--;
                    }
                    c = j;
                    while(i < image.length && image[i][c] == 0){
                        i++;
                    }
                    if(i == image.length || image[i][j] == 1){
                        i--;
                    }
                    r = i;
                    ans[2] = r;
                    ans[3] = c;
                    return ans;
                }
            }
        }
        return ans;
    }
}