package com.brainstormer.recycleview;

public class ContactModel {
       int img;
       String name, number;

       ///because we have designed our UI as a contact image, name and number
    //so we need 3 variables to work with that
    //that's why we craeted a default constructor because how many times we will call this class
    //we have to insert these 3 values and work with it properly

       public ContactModel(int img,String name,String number){
           this.img=img;
           this.name=name;
           this.number=number;

       }
    public ContactModel(String name,String number){
        this.name=name;
        this.number=number;
    }
}
