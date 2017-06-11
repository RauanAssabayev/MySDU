package com.ce.sdu.mysdu.DB;

/**
 * Created by rauan on 11.06.2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ce.sdu.mysdu.model.Courses;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;



public class DbCourse {
    public static final String DATABASE_NAME = "mysdu";
    public static final String DATABASE_TABLE = "courses";
    public static final String ID = "_id";
    public static final String DERSTITLE = "ders_title";
    public static final String TYPE = "type";
    public static final String NEMPTITLE = "nemptitle";
    public static final String PEMPTITLE = "pemptitle";
    public static final String LEMPTITLE = "lemptitle";
    public static final String DAY = "day";
    public static final String TIMEFROM = "timefrom";
    public static final String TIMETO = "timeto";
    private final Context mycontext;
    private DBHelper myhelper;
    private SQLiteDatabase mydatabase;


    public DbCourse(Context mycontext) {
        this.mycontext = mycontext;
    }

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null ,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(
                    "CREATE TABLE "+DATABASE_TABLE+" (" +
                            ""+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                            +DERSTITLE + " TEXT NOT NULL, " +
                            ""+TYPE+" TEXT NOT NULL," +
                            ""+NEMPTITLE+" TEXT NOT NULL," +
                            ""+PEMPTITLE+" TEXT NOT NULL," +
                            ""+LEMPTITLE+" TEXT NOT NULL," +
                            ""+DAY+" TEXT NOT NULL," +
                            ""+TIMEFROM+" TEXT NOT NULL," +
                            " "+TIMETO+" TEXT NOT NULL);"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    public DbCourse connect(){
        myhelper = new DBHelper(mycontext);
        mydatabase = myhelper.getWritableDatabase();
        return this;
    }

    public void insertData(String[] course){
        ContentValues cv = new ContentValues();
        cv.put(DERSTITLE,course[0]);
        cv.put(TYPE,course[1]);
        cv.put(NEMPTITLE,course[2]);
        cv.put(PEMPTITLE,course[3]);
        cv.put(LEMPTITLE,course[4]);
        cv.put(DAY,course[5]);
        cv.put(TIMEFROM,course[6]);
        cv.put(TIMETO,course[7]);
        mydatabase.insert(DATABASE_TABLE,null,cv);
    }

    public  void updateData(String []course, String ids){
        ContentValues cv = new ContentValues();
        cv.put(DERSTITLE,course[0]);
        cv.put(TYPE,course[1]);
        cv.put(NEMPTITLE,course[2]);
        cv.put(PEMPTITLE,course[3]);
        cv.put(LEMPTITLE,course[4]);
        cv.put(DAY,course[5]);
        cv.put(TIMEFROM,course[6]);
        cv.put(TIMETO,course[7]);
        Log.d("upData",ids);
        mydatabase.update(DATABASE_TABLE,cv,ID+" = "+ids,null);
    }

    public void deleteNote(String ids){
        mydatabase.delete(DATABASE_TABLE,"_id = "+ids,null);
    }


    public ArrayList<String []> getData(){
        String []columns = new String[]{ID,DERSTITLE,TYPE,NEMPTITLE,PEMPTITLE,LEMPTITLE,DAY,TIMEFROM,TIMETO};
        Cursor c = mydatabase.query(DATABASE_TABLE,columns,null,null,null,null,null);
        ArrayList<String []> arrayList=new ArrayList();
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            String []str=new String[4];
            str[0]=c.getString(c.getColumnIndex(ID));
            str[1]=c.getString(c.getColumnIndex(DERSTITLE));
            str[2]=c.getString(c.getColumnIndex(TYPE));
            str[3]=c.getString(c.getColumnIndex(NEMPTITLE));
            str[4]=c.getString(c.getColumnIndex(PEMPTITLE));
            str[5]=c.getString(c.getColumnIndex(LEMPTITLE));
            str[6]=c.getString(c.getColumnIndex(DAY));
            str[7]=c.getString(c.getColumnIndex(TIMEFROM));
            str[8]=c.getString(c.getColumnIndex(TIMETO));
            arrayList.add(str);
        }
        c.close();
        Collections.reverse(arrayList);
        return arrayList;
    }

    public void disconnect(){
        myhelper.close();
    }
}