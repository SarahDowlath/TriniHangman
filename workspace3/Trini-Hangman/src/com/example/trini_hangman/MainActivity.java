package com.example.trini_hangman;

import com.example.trini_hangman.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.app.ActionBar;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.os.Build;

public class MainActivity extends Activity implements OnClickListener {

	
	private static final String TAG = "Hangman";
	
	String [] categoryArray;
	
	
	/** Called when the activity is first created. */
	
	
	public void onCreate(Bundle savedInstanceState) {  
		 
		 super.onCreate(savedInstanceState);   // set content view to main layout 
		 
		 setContentView(R.layout.activity_main);   
		 
		 Resources res=getResources();
		
		 categoryArray = res.getStringArray(R.array.category);
		 
		 
		 
		 // set OnClick Listeners for each button in the view  
		 Button continueButton = (Button) this.findViewById(R.id.continueBtn);   
		 
		 // continue button  
		 continueButton.setOnClickListener(this);   
		 
		 Button newgameButton = (Button) this.findViewById(R.id.newgameBtn);   
		 // new game button   
		 newgameButton.setOnClickListener(this);   
		 
		 Button aboutButton = (Button) this.findViewById(R.id.aboutBtn);   
		 // about button   
		 aboutButton.setOnClickListener(this);   
		 
		 Button exitButton = (Button) this.findViewById(R.id.exitgameBtn);   
		 // exit button   
		 exitButton.setOnClickListener(this);  
		 }  
		 
	
	
	
	//insert code for music Pause and Resume
	
	//insert code for onCreate
	
	//insert code for options menu
	

	 public void onClick(View v) {  
		  
		 switch (v.getId()) {   
		  
		  case R.id.continueBtn:    
			  //continue old game    
			  //startGame(Game.CATEGORY_CONTINUE);    
			break;   
		  
		   case R.id.newgameBtn:    
		   //open a new game dialog box    
			 openNewGameDialog();
			   
	      
			break;
			
		   case R.id.aboutBtn:    
		   // start about activity    
			Intent j = new Intent(MainActivity.this, About.class);    
			startActivity(j);    
			break;  
			
		  case R.id.exitgameBtn:    
		  // exit game    
			finish();    
			break;   
			}  
		}
	
	 

	
	//creating a category option
	 
	 private void openNewGameDialog(){
		 
		 AlertDialog.Builder dBuilder=new AlertDialog.Builder(this);
		 dBuilder.setTitle("Select a category");
		 dBuilder.setItems(R.array.category,new DialogInterface.OnClickListener(){
			 
			 public void onClick(DialogInterface dialogInt, int item){
				 
				 Toast.makeText(getApplicationContext(), categoryArray[item], Toast.LENGTH_SHORT).show(); 
				 startGame(item);

			 }
		}
		 
		);
			 
		 
		AlertDialog alert = dBuilder.create();
		//display Dialog box
		
		alert.show();
		 
		 
	 }//end openNewGameDialog 
		 
		 
				 


	 private void startGame(int i){
		 
		// Log.d(TAG,"clicked on" + i );
		
		Intent intent = new Intent(MainActivity.this, GameActivity.class);
		intent.putExtra(GameActivity.KEY_CATEGORY,i);
		startActivity(intent);
	 }







}//end MainActivity class


