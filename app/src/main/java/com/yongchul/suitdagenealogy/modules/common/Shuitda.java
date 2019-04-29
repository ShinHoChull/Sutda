package com.yongchul.suitdagenealogy.modules.common;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by shinyongchul on 16. 4. 8..
 */
public class Shuitda {

    private int cardSum = 0;
    public String cardSub(ArrayList cardList){

        if(cardList.size() < 1) return "카드를 선택해주세요";

        return "";
    }

    public String mix1(boolean card1State , int card2 , boolean card2State){

        String temp = "none";

        if( card2 == 1 ) {
            temp = "삥땡";
        }else if( (card2 == 3) && (card1State == true) && (card2State == true) ){
            temp = "일삼광땡";
        }else if( card2 == 8 && (card1State == true) &&  ( card2State == true ) ){
            temp = "일팔광땡";
        }else if( card2 == 8 && (card1State == true) &&  ( card2State == false ) ){
            temp = "갑오";
        }else if( card2 == 2 ) {
            temp = "알리";
        }else if( card2 == 4 ) {
            temp = "독사";
        }else if( card2 == 9 ) {
            temp = "구삥";
        }else if( card2 == 10 ) {
            temp = "장삥";
        }else{
            //끗 계산
            Log.e("card2 Num",""+card2);

            this.cardSum = 1+card2;
            if(this.cardSum > 10){
                temp = ""+(this.cardSum-10)+"끗";
            }else if(this.cardSum == 10){
                temp = "망통";
            }else {
                temp = this.cardSum+"끗";
            }
        }

        return temp;
    }

    public String mix2(boolean card1State , int card2 , boolean card2State){

        String temp = "none";
        if(card2 == 2){
            temp = "이땡";
        }else if( card2 == 1){
            temp ="알리";
        }else if( card2 == 7 && card2State == true && card1State == true){
            temp ="갑오";
        }else{
            //끗 계산
            Log.e("card2 Num",""+card2);

            this.cardSum = 2+card2;
            if(this.cardSum > 10){
                temp = ""+(this.cardSum-10)+"끗";
            }else if(this.cardSum == 10){
                temp = "망통";
            }else {
                temp = this.cardSum+"끗";
            }
        }

        return temp;
    }

    public String mix3(boolean card1State , int card2 , boolean card2State){

        String temp = "none";
        if( card2 == 3){
            temp = "삼땡";
        }else if( card2 == 7 && card2State == true){
            temp = "땡잡이";
        }else if( card1State == true && card2 == 8 && card2State == true){
            temp = "삼팔광땡";
        }else if(card1State == true && card2 == 1 && card2State == true){
            temp = "일삼광땡";
        }else if(card1State == true && card2 == 6 && card2State == true){
            temp ="갑오";
        }else{
            //끗 계산
            Log.e("card2 Num",""+card2);

            this.cardSum = 3+card2;
            if(this.cardSum > 10){
                temp = ""+(this.cardSum-10)+"끗";
            }else if(this.cardSum == 10){
                temp = "망통";
            }else {
                temp = this.cardSum+"끗";
            }
        }
        return temp;
    }

    public String mix4(boolean card1State , int card2 , boolean card2State){

        String temp = "none";
        if( card2 == 4 ){
            temp = "사땡";
        }else if(card2 == 1){
            temp = "독사";
        }else if(card2 == 10){
            temp = "장사";
        }else if(card2 == 6){
            temp = "세륙";
        }else if(card2 == 5 && card2State == true){
            temp = "갑오";
        }else if(card2 == 9 && card2State != true){
            temp = "구사";
        }else if(card2 == 9 && card1State == true && card2State == true){
            temp = "멍텅구리 구사";
        }else if(card1State == true && card2 == 7 && card2State == true){
            temp = "암행어사";
        }else{
            //끗 계산
            Log.e("card2 Num",""+card2);

            this.cardSum = 4+card2;
            if(this.cardSum > 10){
                temp = ""+(this.cardSum-10)+"끗";
            }else if(this.cardSum == 10){
                temp = "망통";
            }else {
                temp = this.cardSum+"끗";
            }
        }
        return temp;
    }

    public String mix5(boolean card1State , int card2 , boolean card2State){

        String temp = "none";
        if(card2 == 5){
            temp = "오땡";
        }else if(card1State == true && card2 == 4 && card2State == true){
            temp = "갑오";
        }else{
            //끗 계산
            Log.e("card2 Num",""+card2);

            this.cardSum = 5+card2;
            if(this.cardSum > 10){
                temp = ""+(this.cardSum-10)+"끗";
            }else if(this.cardSum == 10){
                temp = "망통";
            }else {
                temp = this.cardSum+"끗";
            }
        }
        return temp;
    }

    public String mix6(boolean card1State , int card2 , boolean card2State){

        String temp = "none";
        if(card2 == 6){
            temp ="육땡";
        }else if(card2 == 4){
            temp = "세륙";
        }else if(card1State == true&& card2 == 3 && card2State == true){
            temp = "갑오";
        }else{
            //끗 계산
            Log.e("card2 Num",""+card2);

            this.cardSum = 6+card2;
            if(this.cardSum > 10){
                temp = ""+(this.cardSum-10)+"끗";
            }else if(this.cardSum == 10){
                temp = "망통";
            }else {
                temp = this.cardSum+"끗";
            }
        }

        return temp;
    }

    public String mix7(boolean card1State , int card2 , boolean card2State){

        String temp = "none";
        if(card2 == 7){
            temp ="칠땡";
        }else if( card2 == 3){
            temp = "땡잡이";
        }else if( card1State == true && card2 == 2 && card2State == true){
            temp ="갑오";
        }else{
            //끗 계산
            Log.e("card2 Num",""+card2);

            this.cardSum = 7+card2;
            if(this.cardSum > 10){
                temp = ""+(this.cardSum-10)+"끗";
            }else if(this.cardSum == 10){
                temp = "망통";
            }else {
                temp = this.cardSum+"끗";
            }
        }

        return temp;
    }

    public String mix8(boolean card1State , int card2 , boolean card2State){

        String temp = "none";
        if (card2 == 8){
            temp = "팔땡";
        }else if(card1State == true && card2 == 3 && card2State == true){
            temp ="삼팔광땡";
        }else if(card1State == true && card2 == 1 && card2State == true){
            temp ="일팔광땡";
        }else if(card1State == false && card2 == 1 && card2State == true){
            temp ="갑오";
        }else{
            //끗 계산
            Log.e("card2 Num",""+card2);

            this.cardSum = 8+card2;
            if(this.cardSum > 10){
                temp = ""+(this.cardSum-10)+"끗";
            }else if(this.cardSum == 10){
                temp = "망통";
            }else {
                temp = this.cardSum+"끗";
            }
        }
        return temp;
    }

    public String mix9(boolean card1State , int card2 , boolean card2State){

        String temp = "none";
        if(card2 == 9){
            temp = "구땡";
        }else if(card2 == 1){
            temp = "구삥";
        }else if(card2 == 4 && card2State == true && card1State == true) {
            temp = "멍텅구리 구사";
        }else if(card2 == 4 && card2State != true){
            temp = "구사";
        }else{
            //끗 계산
            Log.e("card2 Num",""+card2);

            this.cardSum = 9+card2;
            if(this.cardSum > 10){
                temp = ""+(this.cardSum-10)+"끗";
            }else if(this.cardSum == 10){
                temp = "망통";
            }else {
                temp = this.cardSum+"끗";
            }
        }
        return temp;
    }

    public String mix10(boolean card1State , int card2 , boolean card2State){

        String temp = "none";
        if(card2 == 10){
            temp ="장땡";
        }else if(card2 == 1){
            temp ="장삥";
        }else if(card2 == 4){
            temp ="장사";
        }else{
            //끗 계산
            Log.e("card2 Num",""+card2);

            this.cardSum = 10+card2;
            if(this.cardSum > 10){
                temp = ""+(this.cardSum-10)+"끗";
            }else if(this.cardSum == 10){
                temp = "망통";
            }else {
                temp = this.cardSum+"끗";
            }
        }
        return temp;
    }


}
