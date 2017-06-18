package org.duangsuse.passtest;

import android.database.DatabaseUtils;
import android.widget.*;
import android.content.*;

public class tests
{
    public int id;//题目编号
    private String test;//试题
    private String Sa;//A
    private String Sb;
    private String Sc;
    private String Sd;
    private int answer;//正确答案，从1开始abcd,为0就是填空
    
    public tests(int id,String test,String sa,
                 String sb,String sc,String sd,int a)
    {
        this.id = id;
        this.test = test;
        Sa = sa; Sb = sb; Sc = sc; Sd = sd;
        answer = a;
    }
    //填空题架构器
    public tests(int id,String t,String a){
        this.id = id;
        this.Sa = a;
        this.answer = 0;
    }
    public tests(int id) {
        this.id = id;
    }
    
    public boolean isBlankFilling() {
        return this.answer == 0;
    }
    public String getText() {
        return test;
    }
    public void setText(String t) {
        this.test = t;
    }
    public int getID() {
        return this.id;
    }
    public String getAnswerString() throws parseErrorException {
        if (this.isBlankFilling()) {
            return Sa;
        }
        else {
            switch (this.answer) {
                case 0:
                    return Sa;
                case 1:
                    return Sa;
                case 2:
                    return Sb;
                case 3:
                    return Sc;
                case 4:
                    return Sd;
                default:
                    throw new parseErrorException();
            }
        }
    }
    public int getAnswer() {
        return this.answer;
    }
    public void setAnswer(int a) {
        this.answer = a;
    }
    public boolean isCorrect(String ya) throws parseErrorException {
        String ret;
        try {
            ret=this.getAnswerString();
            } catch (parseErrorException e) {
                throw e;
            }
        return ret.equals(ya);
    }
    public String createSQLStatment() {
        if (this.isBlankFilling()) {
        return String.format(
               "INSERT INTO tests (id,test,a,b,c,d,answer) VALUES (%1$s,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s)",
               id,test,Sa,Sb,Sc,Sd,answer);
        } else {
            return String.format(
            "INSERT INTO tests (id,test,a,answer) VALUES (%1$s,%2$s,%3$s,%4$s)"
            ,id,test,Sa,answer);
        }
    }
}

class parseErrorException extends Exception {
    public parseErrorException() {}
}
