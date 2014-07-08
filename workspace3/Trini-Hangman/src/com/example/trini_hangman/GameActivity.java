package com.example.trini_hangman;

	import com.example.trini_hangman.R;

import java.util.Random;

import android.app.Activity; 
import android.app.AlertDialog; 
import android.app.Dialog;
import android.content.DialogInterface; 
import android.content.Intent; 
import android.content.res.Resources;
import android.os.Bundle; 
import android.util.Log; 
import android.view.KeyEvent; 
import android.view.View; 
import android.view.View.OnClickListener;
import android.widget.Button; 
import android.widget.ImageView; 
import android.widget.LinearLayout;
import android.widget.TextView; 
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
	
	
	
	public class GameActivity extends Activity {
	
	
	private String wordsFoodArray[],wordsMusicArray[],wordsSportsArray [],categoryArray[];
	private Random rand;
	private String currWord,secretWord, wordsFood,wordsMusic,wordsSports, newWord;
	private TextView [] charViews;
	
	private TextView secWord,wrongLetters;
	private LinearLayout layout1,layout2, layout3, layout4;
	
	//body part images
	private ImageView[] bodyParts;
	
	//number of body parts
	private int numParts=6;
	
	//current part - will increment when wrong answers are chosen
	private int currPart;
	
	//number of characters in current word
	private int numChars;
	
	//number correctly guessed
	private int numCorr;
	
	private int numWrongGuesses;
	
	private int catValue;
	
	public static final String KEY_CATEGORY = "com.example.trini_hangman.category";
	public static final int CATEGORY_FOOD =0;
	public static final int CATEGORY_MUSIC = 1;
	public static final int CATEGORY_SPORTS = 2; 
	

	public void onCreate(Bundle savedInstanceState){
	
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.game);
		
			 Resources res1=getResources();
			 categoryArray = res1.getStringArray(R.array.category);
			 
			 Resources res2=getResources();
			 wordsFoodArray= res2.getStringArray(R.array.food);
			 
			 Resources res3=getResources();
			 wordsMusicArray = res3.getStringArray(R.array.music);
			 
			 Resources res4=getResources();
			 wordsSportsArray = res4.getStringArray(R.array.sports);
			 
			rand=new Random();
			currWord="";
			
			catValue=getIntent().getIntExtra(KEY_CATEGORY, CATEGORY_FOOD);
			secretWord=generateWordByCategory(catValue);
			
			playGame(secretWord);
			 
			 
			bodyParts = new ImageView[numParts];
			bodyParts[0] = (ImageView)findViewById(R.id.head);
			bodyParts[1] = (ImageView)findViewById(R.id.body);
			bodyParts[2] = (ImageView)findViewById(R.id.arm1);
			bodyParts[3] = (ImageView)findViewById(R.id.arm2);
			bodyParts[4] = (ImageView)findViewById(R.id.leg1);
			bodyParts[5] = (ImageView)findViewById(R.id.leg2);
							 
			 
		}


		
		
	private void bindViews()
	{
		wrongLetters = (TextView) this.findViewById(R.id.wrongLetters);
		secWord= (TextView) this.findViewById(R.id.secretTextView);
		layout1 = (LinearLayout) this.findViewById(R.id.letterLayout1);
		layout2 = (LinearLayout) this.findViewById(R.id.letterLayout2);
		layout3 = (LinearLayout) this.findViewById(R.id.letterLayout3);
		layout4 = (LinearLayout) this.findViewById(R.id.FinalLayout);	
	}

	private void playGame(String word)
	{
		
		currPart = 0;
		numChars=currWord.length();
		numCorr=0;
		
		for(int p = 0; p < numParts; p++) {
		bodyParts[p].setVisibility(View.INVISIBLE);
		}
		
		initSecretWord();
		initWrongGuesses();
		
		
	
	}
	

		
		
		
	private void initSecretWord(){
	
		String underScore = underscore();
		secWord.setText(underScore);
	
	}
		
		
	/*** sets the number of wrong guesses to zero wrongGuesses string to empty   */  
	private void initWrongGuesses() 
	{   
	numWrongGuesses = 0;   
	wrongLetters.setText("");  
	}  
	
	
	
 /**   * updates the View of wrong guesses with the recent wrong guess   */  
	private void updateWrongGuesses(char ch) 
	{   
	wrongLetters.setText(wrongLetters.getText() + Character.toString(ch));  
	}
	
	
	 private String underscore() 
	 {   
		 StringBuffer result = new StringBuffer();   
		 for (int i = 0; i < secretWord.length(); i++) 
		 { 
			 result.append("_ "); 
			 
		 }
	return result.toString(); 
		 
	}
	
	
	
	private String generateWordByCategory(int cat){
	
	
		switch(cat)
	{
		
		case 0: //category food - choose a word from the food array 
			String temp1 = wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
			while (temp1.equals(currWord)) temp1= wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
			currWord=wordsFood;
			newWord=temp1;
		break;
		
		case 1: //category music - choose a word from the music array
			String temp2 = wordsMusicArray[rand.nextInt(wordsMusicArray.length)];
			while (temp2.equals(currWord)) temp2= wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
			currWord=wordsMusic;
			newWord=temp2;
		break;
		
		case 2://category sports - choose a word from the sports array 
			String temp3 = wordsSportsArray[rand.nextInt(wordsSportsArray.length)];
			while (temp3.equals(currWord)) temp3= wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
			currWord=wordsSports;
			newWord=temp3;
		break;
	}
		
	return newWord;
}	
	
	
	
	
	
	
	}//end class 	