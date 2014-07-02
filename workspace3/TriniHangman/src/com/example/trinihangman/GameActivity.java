package com.example.trinihangman;

import java.util.Random;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.GridView;

public class GameActivity extends Activity {
	
	private String [] words;
	private Random rand;
	private String currWord;
	private LinearLayout wordLayout; 
	private TextView[] charViews;
	
	//adding adapter
	private GridView letters;
	private LetterAdapter ltrAdapt;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_game);
	  Resources res = getResources();
	  words = res.getStringArray(R.array.food); //whatever category selected 
	  
	  rand= new Random(); //use a random generator to generate a word from the food array
	  currWord = "" ; //set currWord to null or space
		
	  wordLayout = (LinearLayout)findViewById(R.id.word); //get a reference to the layout area we created for the answer letters
	  
	  letters= (GridView)findViewById(R.id.letters);
	  playGame();
	
	
	}
	
	
	private void playGame(){
		//play a game
		
		
		ltrAdapt=new LetterAdapter(this);
		letters.setAdapter(ltrAdapt);
		
		String newWord = words[rand.nextInt(words.length)];
		//make sure that we don't pick the same word twice since the playGame method is invoked when the user chooses to play again after winning or loosing a game. 
		while (newWord.equals(currWord)) newWord = words[rand.nextInt(words.length)];
		currWord=newWord; 
		
		/* Create one text view for each letter of the target word*/
		charViews=new TextView[currWord.length()];
		wordLayout.removeAllViews();
		
		//for loop to iterate over each letter of the answer.. 
		//create a textview for each letter and set the textview to the current letter
		for(int c=0;c<currWord.length();c++)
		{
			
			charViews[c]=new TextView(this);
			charViews[c].setText("" + currWord.charAt(c));
			
			//setting the display properties on the text view and add it to the layout
			charViews[c].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			charViews[c].setGravity(Gravity.CENTER);
			charViews[c].setTextColor(Color.WHITE);
			charViews[c].setBackgroundResource(R.drawable.letter_bg);
			//add to layout
			wordLayout.addView(charViews[c]);
			
		}
			
		
		
		
		}//end method playGame
		
		
}//end class
	
	
		
	
	

