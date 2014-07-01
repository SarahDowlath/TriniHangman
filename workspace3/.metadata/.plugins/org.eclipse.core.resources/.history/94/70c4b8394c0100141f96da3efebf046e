package com.example.trinihangman;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;



public class LetterAdapter extends BaseAdapter {

	
	private String[] letters;
	private LayoutInflater letterInf;
	
	
	//adding a constructor method for the adapter
	public LetterAdapter(Context c){
		//setup adapter
		//instantiate the alphabet array and assign letters A-Z to each position
		letters= new String[26];
		for( int alphabet=0; alphabet<letters.length;alphabet++){
			
			letters[alphabet]= "" + (char)(alphabet + 'A');  //each character is represented as a number so that we can set the letter A to Z in a loop 
															//starting at zero by adding the value of the character A to each array index	
			
		}
		
		letterInf = LayoutInflater.from(c);
		
	}
	
	@Override
	public int getCount() { 
		// TODO Auto-generated method stub
		return letters.length; //represents the number of views, one for each letter. 
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	//this method builds each view mapped to the user interface elememt through the adapter
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	  //create a button for the letter at this position in the alphabet
	  Button letterBtn;
	  if (convertView == null) {
	    //inflate the button layout
	    letterBtn = (Button)letterInf.inflate(R.layout.letter, parent, false);
	  } else {
	    letterBtn = (Button) convertView;
	  }
	  //set the text to this letter
	  letterBtn.setText(letters[position]);
	  return letterBtn;
	}

}
