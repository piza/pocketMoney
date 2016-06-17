package com.piza.search;

import java.util.*;

/**
 * Created by Peter on 16/6/16.
 */
public class PhraseProcess {

    private final Queue<PhraseTerm> phraseTermQueue=new LinkedList<PhraseTerm>();

    private final Map<String,Integer> resultData=new TreeMap<>();


    public Map<String, Integer> getResultData() {
        return resultData;
    }

    public void addTerm(String content,int start,int end){
        PhraseTerm phraseTerm=new PhraseTerm();
        phraseTerm.setContent(content);
        phraseTerm.setStart(start);
        phraseTerm.setEnd(end);
        phraseTermQueue.add(phraseTerm);
    }


    /**
     * 1. 把大写的名字合并一个短语
     * 2. 把长度小于3的删除
     * 3. 去掉重复的
     */
    public void process(){
        while (phraseTermQueue.size()>0){
            PhraseTerm term=phraseTermQueue.poll();
            String current=term.getContent();
            if(term.upperCase){
                current=checkNext(current,term);
            }
            if(!resultData.containsKey(current) && current.length()>2){
                resultData.put(current,term.start);
            }
        }
        for(String key:resultData.keySet()){
            System.out.println(key);
        }
    }
    public String checkNext(String current,PhraseTerm term){
        PhraseTerm next=phraseTermQueue.peek();
        if(next==null){
            return current;
        }
        if(next.upperCase && next.start-term.end<2){
            current=current+" "+next.getContent();
            phraseTermQueue.poll();
            return checkNext(current,next);
        }else{
            return current;
        }
    }


    public class PhraseTerm{

        private String content;
        private int start;
        private int end;
        private boolean upperCase;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
            if(content!=null && content.charAt(0)<97){
                upperCase=true;
            }
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public boolean isUpperCase() {
            return upperCase;
        }

        public void setUpperCase(boolean upperCase) {
            this.upperCase = upperCase;
        }
    }
}
