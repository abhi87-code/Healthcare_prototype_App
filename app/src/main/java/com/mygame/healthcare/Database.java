package com.mygame.healthcare;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1= "create table users(username text,email text,password text)";
        sqLiteDatabase.execSQL(qry1);

        String qry2 = "create table cart(username text, product_name text, price float, otype text)";
        sqLiteDatabase.execSQL(qry2);

        String qry3= "create table orderplac(username text, fullname text, address text, pincode int, contactno text, date text, time text, ammount String, otype text)";
        sqLiteDatabase.execSQL(qry3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void register(String username, String email, String  password ){
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }
    public int login(String username, String password){
        int result=0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c= db.rawQuery("select*from users where username=? and password=?",str);
        if (c.moveToFirst()){
            result=1;
        }
        return result;
    }

    public void addToCart(String username, String product, float price, String otype){
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("product_name", product);
        cv.put("price", price);
        cv.put("otype", otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("cart", null, cv);
        db.close();
    }


    public int checkCart(String username,String product){
        int  result=0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=product;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from cart where username=? and product_name=?",str);
        if (c.moveToFirst()){
            result=1;
        }
        db.close();
        return result;
    }

    public void deletCart(String username, String otype){
        String str[]= new String[2];
        str[0]= username;
        str[1]=otype;
        SQLiteDatabase db= getWritableDatabase();
        db.delete("cart", "username=? and otype=?",str);
        db.close();
    }

        public ArrayList getCartData(String username, String otype){
        ArrayList<String>arr=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String str[]=new String[2];
        str[0]=username;
        str[1]=otype;
        Cursor c=db.rawQuery("select * from cart where username=? and otype=?",str);
        if (c.moveToFirst()){
            do {
                String product=c.getString(1);
                String price=c.getString(2);
                arr.add(product+"$"+price);
            }while (c.moveToNext());
        }
        db.close();
        return arr;
        }

        public void addorder(String username, String fullname, String address, int pincode, String contactno, String date,String time,String ammount,String otype){
        ContentValues cv= new ContentValues();
            cv.put("username",username);
            cv.put("fullname",fullname);
            cv.put("address",address);
            cv.put("pincode",pincode);
            cv.put("contactno",contactno);
            cv.put("date",date);
            cv.put("time",time);
            cv.put("ammount",ammount);
            cv.put("otype",otype);
            SQLiteDatabase db=getWritableDatabase();
            db.insert("orderplac",null,cv);
            db.close();
        }

    public ArrayList getOrderData(String username) {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] str = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select * from orderplac where username=?", str); // Corrected table name
        if (c.moveToFirst()) {
            do {
                arr.add(c.getString(0) + "$" + c.getString(1) + "$" + c.getString(2) + "$" + c.getString(3) + "$"
                        + c.getString(4) + "$" + c.getString(5) + "$"
                        + c.getString(6) + "$" + c.getString(7) + "$" + c.getString(8));
            } while (c.moveToNext());
        }
        db.close();
        return arr;
    }


    public  int chechAppointmentExists(String username, String fullname, String address,String contact,String date, String time){

        int result=0;
        String str[]=new String[6];
        str[0]=username;
        str[1]=fullname;
        str[2]=address;
        str[3]=contact;
        str[4]=date;
        str[5]=time;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from orderplac where username = ? and fullname =? and address =? and contactno =? and date =? and time = ?",str);
        if (c.moveToFirst()){
            result=1;
        }
        db.close();
        return result;
    }


}
