package JungKeung.DfsBfs;

import java.util.*;

public class Words {
    public int solution(String begin, String target, String[] words) {
        Queue<WordProcess> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new WordProcess(begin, 0));

        while(!queue.isEmpty()){
            WordProcess wp = queue.poll();

            if(wp.getWord().equals(target)) return wp.getCnt();

            for(int i=0; i<words.length; i++){
                if(!visited[i] && getDiffCnt(wp.getWord(), words[i]) == 1){
                    visited[i] = true;
                    queue.offer(new WordProcess(words[i], wp.getCnt()+1));
                }
            }
        }
        return 0;
    }

    private int getDiffCnt(String word, String comp){
        int cnt = 0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) != comp.charAt(i)) cnt+=1;
        }
        return cnt;
    }
}

class WordProcess{
    String word;
    int cnt;

    public WordProcess(String word, int cnt){
        this.word = word;
        this.cnt = cnt;
    }

    public String getWord(){
        return word;
    }

    public int getCnt(){
        return cnt;
    }
}
