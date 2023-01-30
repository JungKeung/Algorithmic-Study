package algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class solved1992종이갯수문제 {
    public static int arr[][];
    public static Map<Integer,Integer> map = new TreeMap<Integer,Integer>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return o1-o2;
		}
	
    
    });

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        // N×N크기의 행렬
        for(int i = 0 ; i < N; i++){
            String str[] = br.readLine().split(" ");
            int num = str.length;
            for(int j = 0; j < num; j++){
                arr[i][j] = Integer.valueOf(str[j]);
            }
        }
        // 구현
        solve(0,0,N);
        // 종이는 3의 제곱수로 주어진다.
        // 9크기로 나눈다는 것이 가능하다.
        // 9 * 9 = 81/9 = 9

        

        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
            int key = it.next();
            System.out.println(map.get(key));
        }


    }
    private static void solve(int start,int end,int size){
        if(isPossible(start,end,size)){
           int value = arr[start][end];
            map.put(value,map.getOrDefault(value,0)+1);
            return;
        }

        int mid = size/3;
    
        
        // 문제 핵심
        // 분할 정복에서 범위를 줄여서 탐색할때 범위 기준값을 만든다. 여기선 왼쪽 맨위의 값 그리고 범위를 줄여가며 체크한다. 체크할때 기준값의 좌표가 변하는 것을 신경쓴다고 생각했지만
        // 출발지점을 [size]범위의 값을 더해서 조정한다.(이게 핵심)
       
        
       
        // 처음에는 2*mid 이부분은 하드 코딩이라고 생각했다. 하지만 이해해보니 아니였다
        // 예를 들어 size가 81이라고 해더 2 *mid까지 밖에 되지 않는다. 3등분이니깐
        // 243이라고 해도 2*mid까지 빡에 되지 않는다. 3등분이니깐
        // 9가지 구역으로 나누기
       
        /*solve(start,end,mid);
        solve(start,end+mid,mid);
        solve(start,end+(2*mid),mid);
        
        solve(start + mid,end,mid);
        solve(start + mid,end+mid,mid);
        solve(start + mid,end + (2*mid),mid);
        
        solve(start + (2*mid),end,mid);
        solve(start + (2*mid),end + mid,mid);
        solve(start + (2*mid),end + (2*mid),mid);
        */
        
        // 쿼드 쿼리문제와 달리 분할해야되는 영역이 많다면 반복문을 사용한다.
        // 이때 문제에서는 3개의 영역이므로 하드 코딩한다.
        // (6,0)에서 9가지 영역으로 분할하는데에 mid 값은 변한다.
        // 영역분할에 있어 분할 갯수가 정해져 있다면 하드코딩을 한다.
        // 아니면 위에처럼 직접 영역을 분할하는 방법도 있다.
        
        // 모르는 부분 9가지 재귀부분을 돌리기
        	for(int i = 0; i < 3; i++){
        		for(int j = 0; j <3; j++){
        			solve(start + (mid* i),end + (size*j),size );
        		}

        	}
    }

    private static boolean isPossible(int start, int end, int size) {
        int val = arr[start][end];
        for(int i = start; i < start+size; i++){
            for(int j = end; j < end + size; j++){
                if(val != arr[i][j]){
                    return false;
                }
            }
        }

        return true;

    }
}

