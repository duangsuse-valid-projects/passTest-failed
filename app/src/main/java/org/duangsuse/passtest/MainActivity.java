package org.duangsuse.passtest;

import android.content.*;
import android.content.res.*;
import android.database.*;
import android.os.*;
import android.support.v7.app.*;
import java.io.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toast.makeText(this,"",2);
        dbUtils u = new dbUtils(getApplicationContext());
        u.init_db();
     }

    
}
