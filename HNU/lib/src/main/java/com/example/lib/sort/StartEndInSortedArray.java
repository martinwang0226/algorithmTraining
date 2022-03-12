package com.example.lib.sort;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/11
 */
public class StartEndInSortedArray {

    public static void main(String[] args) {
        int[] testArrays = {1, 2, 3, 4, 4, 4, 4, 5, 6};
        int tagetNum = 4;
        int[] resultArrays = {-1, -1};
//        resultArrays[0] = getStartEndPosition(testArrays, tagetNum)[0];
//        resultArrays[1] = getStartEndPosition(testArrays, tagetNum)[1];
        resultArrays[0] = getStartEndPosition2(testArrays, tagetNum)[0];
        resultArrays[1] = getStartEndPosition2(testArrays, tagetNum)[1];
        System.out.println("测试得到Target数字的start位置为========" + resultArrays[0]);
        System.out.println("测试得到Target数字的end位置为========" + resultArrays[1]);
    }

    public static int[] getStartEndPosition(int[] sortedArrys, int targetNum) {
        int[] resultPosition = {-1, -1};
        if (sortedArrys == null || sortedArrys.length == 0) {
            return resultPosition;
        }
        boolean hasFindFirstPosition = false;
        for (int i = 0; i < sortedArrys.length; i++) {
            if (sortedArrys[i] == targetNum && !hasFindFirstPosition) {
                resultPosition[0] = i;
                hasFindFirstPosition = true;
            } else if (sortedArrys[i] != targetNum && hasFindFirstPosition) {
                resultPosition[1] = i - 1;
                break;
            } else {
                resultPosition[0] = -1;
                resultPosition[1] = -1;
            }

        }

        return resultPosition;
    }


    public static int[] getStartEndPosition2(int[] sortedArrys, int targetNum) {
        return getStartEndPosition22(sortedArrys, targetNum, 0, sortedArrys.length);
    }


    public static int[] getStartEndPosition22(int[] sortedArrys, int targetNum, int start, int end) {
        int[] resultPosition = {-1, -1};
        if (sortedArrys == null || sortedArrys.length == 0) {
            return resultPosition;
        }

        if (sortedArrys.length == 1) {
            resultPosition[0] = 0;
            resultPosition[1] = 0;
        }
        int endPosition = sortedArrys.length - 1;

//        int mid = sortedArrys.length / 2;
        int mid = start +(end -start)/2;

        if (sortedArrys[mid] == targetNum) {
            //find Start Position
            for (int i = mid; i > 0; i--) {
                if (sortedArrys[i] != targetNum) {
                    resultPosition[0] = i + 1;
                    break;
                }
            }

            //find end Position
            for (int i = mid; i < endPosition; i++) {
                if (sortedArrys[i] != targetNum) {
                    resultPosition[1] = i - 1;
                    break;
                }
            }


        } else if (sortedArrys[mid] < targetNum) {
            //递归
            getStartEndPosition22(sortedArrys, targetNum, mid + 1, endPosition);

        } else if (sortedArrys[mid] > targetNum) {
            //递归
            getStartEndPosition22(sortedArrys, targetNum, 0, mid - 1);
        }

        return resultPosition;
    }
}
