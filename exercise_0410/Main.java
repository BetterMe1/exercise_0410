package exercise.exercise_0410;

/*
字符串中找出连续最长的数字串
题目描述
读入一个字符串str，输出字符串str中的连续最长的数字串
输入描述:
个测试输入包含1个测试用例，一个字符串str，长度不超过255。
输出描述:
在一行内输出str中里连续最长的数字串。
示例1
输入
abcd12345ed125ss123456789
输出
123456789
 */
/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String maxtmp = "";
        int i=0;
        int len = s.length();
        while(i<len){
            if('0'<=s.charAt(i) && s.charAt(i)<='9'){
                int f = i;
                while(i<len && '0'<=s.charAt(i) && s.charAt(i)<='9'){
                    i++;
                }
                String tmp = s.substring(f,i);
                if(tmp.length() > maxtmp.length()){
                    maxtmp = tmp;
                }
            }else{
                i++;
            }
        }
        System.out.println(maxtmp);
    }
}*/

/*
编码
题目描述
假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下： a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。 编写一个函数，输入是任意一个编码，输出这个编码对应的Index.
输入描述:
输入一个待编码的字符串,字符串长度小于等于100.
输出描述:
输出这个编码的index
示例1
输入
baca
输出
16331
 */
/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println(solution());
    }
    public static int solution(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        int[] d = {16276,651,26,1};
        int result = 0;
        for(int i=0; i<len; i++){
            if(i == 0){
                result += (s.charAt(i)-'a')*d[0];
            }else{
                result += (s.charAt(i)-'a')*d[i] + 1;
            }
        }
        return result;
    }
}*/


/*
数字游戏
题目描述
小易邀请你玩一个数字游戏，小易给你一系列的整数。你们俩使用这些整数玩游戏。每次小易会任意说一个数字出来，然后你需要从这一系列数字中选取一部分出来让它们的和等于小易所说的数字。 例如： 如果{2,1,2,7}是你有的一系列数，小易说的数字是11.你可以得到方案2+2+7 = 11.如果顽皮的小易想坑你，他说的数字是6，那么你没有办法拼凑出和为6 现在小易给你n个数，让你找出无法从n个数中选取部分求和的数字中的最小数（从1开始）。
输入描述:
输入第一行为数字个数n (n ≤ 20)
第二行为n个数xi (1 ≤ xi ≤ 100000)
输出描述:
输出最小不能由n个数选取求和组成的数
示例1
输入
3
5 1 2
输出
4
 */
/*
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println(solution());
    }
    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        if(nums[0] > 1){
            return 1;
        }
        if(n == 1){
            return nums[0]+1;
        }
        // 1 2 5
        int sum = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i]-sum > 1){
                break;
            }
            sum += nums[i];
        }
        return sum+1;
    }
}
*/

/*
拼凑面额
题目描述
给你六种面额1、5、10、20、50、100元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0-10000的非负整数）的不同组合的个数。
输入描述:
输入为一个数字N，即需要拼凑的面额
输出描述:
输出也是一个数字，为组成N的组合个数。
示例1
输入
5
输出
2
 */
/*
A(n,1) = 1 (n>=0)
A(0,m) = 1 (m=1,5,10,20,50,100)
【状态转移方程】

A(n,m) = A(n-m,m) + A(n,m-) (n>=m, m-为小于m的面值)
A(n,m) = A(n,m-) (n<m)
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = {1,5,10,20,50,100};//面额
        //初始化
        long[] nums = new long[n+1];
        for(int i=0; i<=n; i++){
            nums[i] = 1;
        }
        for(int i=1; i<6; i++){//初始化时已将1放入
            for(int j=1; j<=n; j++){//保证边界条件等于1
                if(j>=m[i]){
                    nums[j] += nums[j-m[i]];
                }
            }
        }
        System.out.println(nums[n]);
    }
}
