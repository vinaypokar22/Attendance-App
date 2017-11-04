package com.example.attendance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Csealist extends Activity{
	
	CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
	Button b;
	ArrayList<String> list;
	static Context cx;

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.csealist);

        list = new ArrayList<String>();


        c1=(CheckBox)findViewById(R.id.checkBox1);  
        c2=(CheckBox)findViewById(R.id.checkBox2);  
        c3=(CheckBox)findViewById(R.id.checkBox3);  
        c4=(CheckBox)findViewById(R.id.checkBox4);  
        c5=(CheckBox)findViewById(R.id.checkBox5);  
        c6=(CheckBox)findViewById(R.id.checkBox6);  
        c7=(CheckBox)findViewById(R.id.checkBox7);  
        c8=(CheckBox)findViewById(R.id.checkBox8);  
        c9=(CheckBox)findViewById(R.id.checkBox9);  
        c10=(CheckBox)findViewById(R.id.checkBox10);  
        b =(Button)findViewById(R.id.button1);  
        addListenerOnButton();
    }

    public void addListenerOnButton() {


        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

            		if(list.size()==0){
            			Toast.makeText(getBaseContext(), "All students present today", Toast.LENGTH_SHORT).show();
            		}
            		else{
            			Iterator iterator = list.iterator();
                     	while (iterator.hasNext()) {
                    	 String x= iterator.next().toString();
                    	 	//Toast.makeText(getBaseContext(), "Arraylist values :"+x, Toast.LENGTH_SHORT).show();
                    	 	new AsyncLogin().execute(x);
                     	}
            		}
                 	
            }

        });

    }
	public void onCheckboxClicked(View v){
				
		boolean checked = ((CheckBox) v).isChecked();
		
        switch(v.getId()) {
        
        case R.id.checkBox1:
            if(checked)
            	 list.add(c1.getText().toString());
            else
            	list.remove(list.indexOf(c1.getText().toString()));
             break;
        
        case R.id.checkBox2:
        	if(checked)
           	 list.add(c2.getText().toString());
           else
           	list.remove(list.indexOf(c2.getText().toString()));
        	break;

        case R.id.checkBox3:
        	if(checked)
           	 list.add(c3.getText().toString());
           else
           	list.remove(list.indexOf(c3.getText().toString()));
        	break;
            
        case R.id.checkBox4:
        	if(checked)
           	 list.add(c4.getText().toString());
           else
           	list.remove(list.indexOf(c4.getText().toString()));
        	break;
            
        case R.id.checkBox5:
        	if(checked)
           	 list.add(c5.getText().toString());
           else
           	list.remove(list.indexOf(c5.getText().toString()));
        	break;
            
        case R.id.checkBox6:
        	if(checked)
           	 list.add(c6.getText().toString());
           else
           	list.remove(list.indexOf(c6.getText().toString()));
        	break;
            
        case R.id.checkBox7:
        	if(checked)
           	 list.add(c7.getText().toString());
           else
           	list.remove(list.indexOf(c7.getText().toString()));
        	break;
            
        case R.id.checkBox8:
        	if(checked)
           	 list.add(c8.getText().toString());
           else
           	list.remove(list.indexOf(c8.getText().toString()));
        	break;
            
        case R.id.checkBox9:
        	if(checked)
           	 list.add(c9.getText().toString());
           else
           	list.remove(list.indexOf(c9.getText().toString()));
        	break;
        case R.id.checkBox10:
        	if(checked)
           	 list.add(c10.getText().toString());
           else
           	list.remove(list.indexOf(c10.getText().toString()));
        	break;
        default :
			Toast.makeText(getBaseContext(), "select alteast one checkbox", Toast.LENGTH_SHORT).show();
		}
        
	}
	
	
	private class AsyncLogin extends AsyncTask<String, String, String>
	{
		 ProgressDialog pdLoading = new ProgressDialog(Csealist.this);
		  HttpURLConnection conn;
		  URL url = null;
		  
		  @Override
	      protected void onPreExecute() {
	          super.onPreExecute();

	          //this method will be running on UI thread
	          pdLoading.setMessage("\tLoading...");
	          pdLoading.setCancelable(false);
	          pdLoading.show();

	      }
		  
		  @Override
	     protected String doInBackground(String... params) {
	         try {
	             // Enter URL address where your php file resides
	         		url = new URL("http://192.168.1.107/attendance/insert.php");	
	         	
	         	
	         } catch (MalformedURLException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	             return "exception";
	         }
	         try {
	             // Setup HttpURLConnection class to send and receive data from php and mysql
	             conn = (HttpURLConnection)url.openConnection();
	             conn.setReadTimeout(MainActivity.READ_TIMEOUT);
	             conn.setConnectTimeout(MainActivity.CONNECTION_TIMEOUT);
	             conn.setRequestMethod("POST");

	             // setDoInput and setDoOutput method depict handling of both send and receive
	             conn.setDoInput(true);
	             conn.setDoOutput(true);
	             // Append parameters to URL
	             Uri.Builder builder = new Uri.Builder()
	                     .appendQueryParameter("id", params[0]);
	             String query = builder.build().getEncodedQuery();

	             // Open connection for sending data
	             OutputStream os = conn.getOutputStream();
	             BufferedWriter writer = new BufferedWriter(
	                     new OutputStreamWriter(os, "UTF-8"));
	             writer.write(query);
	             writer.flush();
	             writer.close();
	             os.close();
	             conn.connect();

	         } catch (IOException e1) {
	             // TODO Auto-generated catch block
	             e1.printStackTrace();
	             return "exception";
	         }
	         try {

	             int response_code = conn.getResponseCode();
	             
	             // Check if successful connection made
	             if (response_code == HttpURLConnection.HTTP_OK) {

	                 // Read data sent from server
	                 InputStream input = conn.getInputStream();
	                 BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	                 StringBuilder result = new StringBuilder();
	                 String line;

	                 while ((line = reader.readLine()) != null) {
	                     result.append(line);
	                 }
	                 
	                 // Pass data to onPostExecute method
	                 return(result.toString());

	             }else{

	                 return("unsuccessful");
	             }

	         } catch (IOException e) {
	             e.printStackTrace();
	             return "exception";
	         } finally {
	             conn.disconnect();
	         }

	     }
		  protected void onPostExecute(String result) {
		      pdLoading.dismiss();
		
			  //Toast.makeText(ctx.getApplicationContext(), result, Toast.LENGTH_SHORT).show();
	         //this method will be running on UI thread
	         if(result.equalsIgnoreCase("true")){
	         		Toast.makeText(getBaseContext(), "attendance posted successfully", Toast.LENGTH_SHORT).show();
	         }
	         else{
	         	Toast.makeText(getBaseContext(), "try again", Toast.LENGTH_SHORT).show();
	         }
		  }
	}

}
