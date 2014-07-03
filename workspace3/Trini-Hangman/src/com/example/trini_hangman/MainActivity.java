package com.example.trini_hangman;

import com.example.trini_hangman.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
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
	
	
	
	/** Called when the activity is first created. */
	
	
	public void onCreate(Bundle savedInstanceState) {  
		 
		 super.onCreate(savedInstanceState);   // set content view to main layout 
		 
		 setContentView(R.layout.activity_main);   
		 
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
		  // continue old game    
			//startGame(Game.CATEGORY_CONTINUE);    
			break;   
		  
		  //case R.id.newgameBtn:    
		  // open a new game dialog box    
			//to do:
			  //OpenNewGameDialog();    
		//	break;
			
		  case R.id.aboutBtn:    
		  // start about activity    
			Intent i = new Intent(MainActivity.this, About.class);    
			startActivity(i);    
			break;  
			
		  case R.id.exitgameBtn:    
		  // exit game    
			finish();    
			break;   
			}  
		}
	
	
	
	
	
	
	
	/*
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}*/

}
