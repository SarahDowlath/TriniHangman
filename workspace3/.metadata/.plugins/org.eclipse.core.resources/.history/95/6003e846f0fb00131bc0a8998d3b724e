package com.example.trinihangman;


import com.example.trinihangman.R;

import android.R;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
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
		Button playBtn = (Button)findViewById(R.id.playButton);
		playBtn.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		//check if play button was clicked
		if(view.getId()==R.id.playButton){
			Intent playIntent = new Intent(this, GameActivity.class);
			this.startActivity(playIntent);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}