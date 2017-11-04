package com.example.attendance;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cseyear extends Activity{
	Button b1,b2,b3,b4,bout;
	UserSessionManager session;

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cseyear);
        
        b1=(Button)findViewById(R.id.button3);
        bout=(Button)findViewById(R.id.button5);
        
        session = new UserSessionManager(getApplicationContext());
        
	        
	       //Toast.makeText(getApplicationContext(),"User Login Status: " + session.isUserLoggedIn(), Toast.LENGTH_SHORT).show();
	       if(session.checkLogin())
	           finish();
	        
	       // get user data from session
	       HashMap<String, String> user = session.getUserDetails();
	        
	       // get name
	       String name = user.get(UserSessionManager.KEY_NAME);
	       // get email
	       String email = user.get(UserSessionManager.KEY_EMAIL);
	    
	       // Show user data on activity
	        
	       bout.setOnClickListener(new View.OnClickListener() {
	            
	           @Override
	           public void onClick(View arg0) {
	               session.logoutUser();
	               finish();
	           }
	       });

	}
	public void cse3(View v) {
		Intent i=new Intent(this,Csehome.class);
		startActivity(i);
	}
	
}
