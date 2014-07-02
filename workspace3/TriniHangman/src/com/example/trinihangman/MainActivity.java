package com.example.trinihangman;


import com.example.trinihangman.R;

import android.app.Activity;
//import android.app.ActionBar;
//import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;



public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
		//listen for clicks on the play button
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View view) {
			//check if play button was clicked
			if(view.getId()==R.id.button1){
				Intent playIntent = new Intent(MainActivity.this, GameActivity.class);
				startActivity(playIntent);
			}
	}
});//end onClickListener
}//end on create 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}