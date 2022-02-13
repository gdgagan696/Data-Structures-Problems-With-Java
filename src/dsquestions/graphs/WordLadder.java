package dsquestions.graphs;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String>wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord))return 0;

        Queue<String>queue=new LinkedList<>();
        int minLength=0;
        queue.add(beginWord);
        while (queue.size()>0){
            minLength++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                String temp=queue.poll();
                for(int j=0;j<temp.length();j++){
                    char[]tempArray=temp.toCharArray();
                    for(char ch='a';ch<='z';ch++){
                        tempArray[j]=ch;
                        String newWord=new String(tempArray);
                        if(newWord.equals(endWord))return minLength+1;
                        else if(!newWord.equals(temp) && wordSet.contains(newWord)){
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        List<String>words=Arrays.asList( "hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength("hit","cog",words));
    }
}
