package enity;

import java.text.DecimalFormat;

/**
 * @Author:wzh
 * @Description:Controler
 * @Date:Createed in 2019/8/13 8:49
 **/
public class Calculate {
    /*
     * @param: [value]
     * @return: boolean
     * @description:判断字符是否为汉字，数字或是字母，对标点符号不考虑
     */
    public static boolean isChar(char value){
        return ((value >= 0x4E00 && value <= 0X9FA5) || (value >='a' && value <= 'z') ||
                (value >= '0' && value <='9' )||(value >='A'&& value <='Z'));
    }

    /*
     * @param: [str]
     * @return: java.lang.String
     * @description:去掉原字符串中的标点
     */
    public static String removeSign(String str){
        StringBuffer buffer = new StringBuffer();
        //遍历字符串，若是汉字数字或字母，则加到buffer后面
        for(char item : str.toCharArray()){
            if(isChar(item)){
                buffer.append(item);
            }
        }
        return buffer.toString();
    }


    /*
     * @param: [text1, text2]
     * @return: double
     * @description:计算相似度
     */
    public static double Similarity(String text1,String text2){
        String strA = removeSign(text1);
        String strB = removeSign(text2);
        int temp = Math.max(strA.length(),strB.length());
        int temp1 =  longestCommonSubstring(strA,strB).length();
        return temp1 * 1.0 / temp;
    }

    /*
     * @param: [strA, strB]
     * @return: java.lang.String
     * @description:求公共子串，使用动态规划算法
     */
    public static String longestCommonSubstring(String strA, String strB) {
        char[] chars_strA = strA.toCharArray();
        char[] chars_strB = strB.toCharArray();
        int m = chars_strA.length;
        int n = chars_strB.length;
        /*
         * 初始化矩阵数据,matrix[0][0]的值为0，
         * 如果字符数组chars_strA和chars_strB的对应位相同，则matrix[i][j]的值为左上角的值加1，
         * 否则，matrix[i][j]的值等于左上方最近两个位置的较大值，
         * 矩阵中其余各点的值为0.
         */
        int[][] matrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chars_strA[i - 1] == chars_strB[j - 1])
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
            }
        }
        /*
         * 矩阵中，如果matrix[m][n]的值不等于matrix[m-1][n]的值也不等于matrix[m][n-1]的值，
         * 则matrix[m][n]对应的字符为相似字符元，并将其存入result数组中。
         *
         */
        char[] result = new char[matrix[m][n]];
        int currentIndex = result.length - 1;
        while (matrix[m][n] != 0) {
            if (matrix[m][n] == matrix[m][n - 1])
                n--;
            else if (matrix[m][n] == matrix[m - 1][n])
                m--;
            else {
                result[currentIndex] = chars_strA[m - 1];
                currentIndex--;
                n--;
                m--;
            }
        }
        return new String(result);
    }
    /*
    * @param: [result]
    * @return: void
    * @description:转化为百分比的形式
    */
    public static String paraseToDigit(double result){
        return Integer.parseInt(new DecimalFormat("0").format(result*100))+"%";
    }
}
