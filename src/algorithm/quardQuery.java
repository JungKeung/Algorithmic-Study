package algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class quardQuery {
    public static int arr[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i <N; i++){
            String str = br.readLine();
            for(int j = 0; j <N; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        // 구현층
        //재귀함수로 구현 : 분할 정복
        solve(0,0,N);


    }

    private static void solve(int start, int end, int size) {
        if(isPossible(start,end,size)){
            System.out.print(arr[start][end]);
            return;
        }
        System.out.print("(");
        int mid = (size)/2;
        solve(start,end,mid);
        solve(start,end+mid,mid);
        solve(start+mid,end,mid);
        solve(start+mid,end+mid,mid);
        System.out.print(")");

    }

    private static boolean isPossible(int start, int end, int size) {
        int val = arr[start][end];
        for(int i = start; i <start+size; i++){
            for(int j = end; j <end+size; j++){
                if(val != arr[i][j]){
                    return false;
                }
            }
        }

        return true;

    }

}
