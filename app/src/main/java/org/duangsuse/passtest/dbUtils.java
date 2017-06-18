package org.duangsuse.passtest;

import android.content.Context;
import android.database.*;
import android.database.DatabaseUtils;
import android.widget.*;
import java.lang.String;
import java.io.File;
import java.io.*;
import java.lang.reflect.*;
import android.content.res.*;
import android.support.v4.view.*;

public class dbUtils
{
    Context mContext;
    
    public dbUtils(Context context) {mContext=context;}
    
    //initialize a new tests 
    public void init_db() {
        AssetManager dbinit = mContext.getAssets();
        String init_stmt = new String();
       try{
          InputStream dbinitfile = dbinit.open("Dbinit.txt");
          byte[] rawfile = new byte[dbinitfile.available()];
          dbinitfile.read(rawfile);
          init_stmt = new String(rawfile,"utf8");
       } catch (IOException e) {
           e.printStackTrace();
       }
       DatabaseUtils.createDbFromSqlStatements(mContext,"tests_db",0,init_stmt);
    }
    
}
