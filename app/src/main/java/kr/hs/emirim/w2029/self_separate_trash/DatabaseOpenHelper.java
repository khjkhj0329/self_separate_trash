package kr.hs.emirim.w2029.self_separate_trash;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    public static final String tableName = "insertTB";

    public DatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("tag", "db 생성_db가 없을 때만 최초로 실행");
        createTable(db);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("drop table if exists insertTB");
        onCreate(db);

    }

    public void createTable(SQLiteDatabase db){
        String sql = "create table insertTB(Name char(20) primary key, Info char(20))";
        try {
            db.execSQL(sql);
        }catch (SQLException e){

        }
    }
    public void insertInfo(SQLiteDatabase db, String Name, String Info){
        Log.i("tag","정보를 입력했을 때 실행");
        db.beginTransaction();
        try{
            String sql = "INSERT INTO " + tableName + "(Name, Info)" + "values('"+ Name +"','"+ Info +"')";
            db.execSQL(sql);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
    }
}
