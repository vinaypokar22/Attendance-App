package com.example.attendance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Csehome extends Activity{
	
	Button csea,cseb,csec,csed;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.csehome);
	        csea=(Button)findViewById(R.id.button1);
	        cseb=(Button)findViewById(R.id.button2);
	        csec=(Button)findViewById(R.id.button3);
	        csed=(Button)findViewById(R.id.button4);
	    }
	 public void csea(View v){
		 Intent i=new Intent(Csehome.this,Csealist.class);
		 startActivity(i);
	 }
	 public void cseb(View k){
		 
	 }
	 
	 public void csec(View l){
		 
	 }
	 public void csed(View m){
		 
	 }
}
