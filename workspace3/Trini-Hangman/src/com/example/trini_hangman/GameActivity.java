package com.example.trini_hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;

//import org.apache.commons.lang.StringUtils;

	

public class GameActivity extends Activity {
	//implements onClickListener? 
	
	private String wordsFoodArray[],wordsMusicArray[],wordsSportsArray [],categoryArray[];
	private Random rand;
	private String currWord,secretWord, wordsFood,wordsMusic,wordsSports, newWord;
	private TextView [] charViews;//an array of the text views for the letters
	
	private TextView secWord,wrongLetters;
	private LinearLayout wordLayout, layout1,layout2, layout3, layout4;
	private LinearLayout [] layouts;
	
	private Dialog dialog;
	private int currentDialogId;
	
	//private ArrayList <Boolean> currAnswer;
	
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
	
	
	static final int DIALOG_WIN_ID = 1;
	
	static final int DIALOG_LOSE_ID = 2;
	

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		
		Resources res = getResources();
		categoryArray = res.getStringArray(R.array.category);
		wordsFoodArray= res.getStringArray(R.array.food);
		wordsMusicArray = res.getStringArray(R.array.music);
		wordsSportsArray = res.getStringArray(R.array.sports);
		
		bindViews();
		
		rand = new Random();		
		currWord = "";
		
		catValue = getIntent().getExtras().getInt(MainActivity.GAME_CATEGORY);
		Log.w(MainActivity.TAG, "Received "+ catValue);
		
		secretWord = generateWordByCategory(catValue);
		Toast.makeText(getApplicationContext(), secretWord, Toast.LENGTH_SHORT).show();//shows secret word
		
		bodyParts = new ImageView[numParts];
		bodyParts[0] = (ImageView)findViewById(R.id.head);
		bodyParts[1] = (ImageView)findViewById(R.id.body);
		bodyParts[2] = (ImageView)findViewById(R.id.arm1);
		bodyParts[3] = (ImageView)findViewById(R.id.arm2);
		bodyParts[4] = (ImageView)findViewById(R.id.leg1);
		bodyParts[5] = (ImageView)findViewById(R.id.leg2);
		
		initGame(secretWord);
	}
		
	private void bindViews()
	{
		wrongLetters = (TextView) this.findViewById(R.id.wrongLetters);
		
		wordLayout = (LinearLayout)this.findViewById(R.id.secretWord);
		
		secWord= (TextView) this.findViewById(R.id.secretTextView);
		
		layout1 = (LinearLayout) this.findViewById(R.id.letterLayout1);
		layout2 = (LinearLayout) this.findViewById(R.id.letterLayout2);
		layout3 = (LinearLayout) this.findViewById(R.id.letterLayout3);
		layout4 = (LinearLayout) this.findViewById(R.id.FinalLayout);	
	}
	
	public void clickLetter(View view) 
	
	{ //this is the clickLetter method from the XML Game file 
		
		char letter = this.getLetter(view.getId());
	
	
		//String letter=((TextView)view).getText().toString();
		
		//char letterChar = letter.charAt(0);
		
		//Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
		
		Toast.makeText(this, "LetterChosen:" +letter, Toast.LENGTH_SHORT).show();
	
		
		//view.setEnabled(false);
		processLetter(letter);
		disableLetter(letter);
		
		
		
		//check result;
		
		
	}
		

	private void processLetter(char c)
	{
		boolean correct = false;
		for(int i =0; i < secretWord.length();i++){
			char ans = secretWord.charAt(i);
			if(c == ans){
				correct = true;//Good guess
				numCorr++;
				 
				
			}
		}
		
	}
	
	 
	public void disableLetter(char c){
		
		char C= Character.toUpperCase(c);
		String buttonID = "button" + C;
		int resID = getResources().getIdentifier(buttonID, "id", "com.example.trini_hangman");
		Button b = (Button) findViewById(resID);
		b.setEnabled(false);
		
	}
	
	

		
		
	//Returns the string for the button selected
	public char getLetter(int btnId){
		char letter = ' ';
		switch(btnId){
			case R.id.buttonA:
				letter = 'A';
				break;
			case R.id.buttonB:
				letter = 'B';
				break;
			case R.id.buttonC:
				letter = 'C';
				break;
			case R.id.buttonD:
				letter = 'D';
				break;
			case R.id.buttonE:
				letter = 'E';
				break;
			case R.id.buttonF:
				letter = 'F';
				break;
			case R.id.buttonG:
				letter = 'G';
				break;
			case R.id.buttonH:
				letter = 'H';
				break;
			case R.id.buttonI:
				letter = 'I';
				break;
			case R.id.buttonJ:
				letter = 'J';
				break;
			case R.id.buttonK:
				letter = 'K';
				break;
			case R.id.buttonL:
				letter = 'L';
				break;
			case R.id.buttonM:
				letter = 'M';
				break;
			case R.id.buttonN:
				letter = 'N';
				break;
			case R.id.buttonO:
				letter = 'O';
				break;
			case R.id.buttonP:
				letter = 'P';
				break;
			case R.id.buttonQ:
				letter = 'Q';
				break;
			case R.id.buttonR:
				letter ='R';
				break;
			case R.id.buttonS:
				letter = 'S';
				break;
			case R.id.buttonT:
				letter = 'T';
				break;
			case R.id.buttonU:
				letter = 'U';
				break;
			case R.id.buttonV:
				letter = 'V';
				break;
			case R.id.buttonW:
				letter = 'W';
				break;
			case R.id.buttonX:
				letter = 'X';
 				break;
			case R.id.buttonY:
				letter = 'Y';
				break;
			case R.id.buttonZ:
				letter = 'Z';
				break;
		}
		return letter;
		//check result 
	}


		
	private void initGame(String word)
	{
		currPart = 0;
		numChars = currWord.length();
		numCorr  = 0;
		for(int p = 0; p < numParts; p++) 
			bodyParts[p].setVisibility(View.INVISIBLE);
		initSecretWord(word);
		initWrongGuesses();
		
	}
	
	
	
	 private String underscore(String temp) 
	 {   
		 //break up the word/phrase 
		
		 StringBuffer buff = new StringBuffer();   
		 for (int i = 0; i < temp.length(); i++) 
			 buff.append("_ "); 
		 return buff.toString(); 
	}
	
	
	
		
	private void initSecretWord(String word){
		
		String underScore = underscore(word);
		Log.w(MainActivity.TAG, underScore);
	
		if (secWord == null)
			secWord = (TextView)findViewById(R.id.secretTextView);
		
		secWord.setText(underScore);
		
		
			
}
	
		
	/*** sets the number of wrong guesses to zero wrongGuesses string to empty   */  
	private void initWrongGuesses() {   
		numWrongGuesses = 0;    
		if (wrongLetters == null)
			wrongLetters = (TextView)findViewById(R.id.wrongLetters);
		wrongLetters.setText("");  
	}  
	

 /**   * updates the View of wrong guesses with the recent wrong guess   */  
	private void updateWrongGuesses(char ch) 
	{   
		wrongLetters.setText(wrongLetters.getText() + Character.toString(ch));  
	}
	
	
	 private String generateWordByCategory(int cat){
		 String temp = "";
		 switch(cat){
			case 0: //category food - choose a word from the food array 
				temp = wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
//				while (temp.equals(currWord)) temp= wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
//				currWord= wordsFood;
				newWord = temp;
				break;
			
			case 1: //category music - choose a word from the music array
				temp = wordsMusicArray[rand.nextInt(wordsMusicArray.length)];
//				while (temp.equals(currWord)) temp = wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
//				currWord= wordsMusic;
				newWord = temp;
				break;
			
			case 2://category sports - choose a word from the sports array 
				temp = wordsSportsArray[rand.nextInt(wordsSportsArray.length)];
//				while (temp.equals(currWord)) temp= wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
//				currWord= wordsSports;
				newWord = temp;
				break;
		 }
		 return newWord;
	 }
	 
	 
	 
	 
	/* 
	 protected Dialog onCreateDialog(int id){
		 
		 Button keypad1, keypad2, keypad3;
		 
		 
		 TextView endmessage;
		 Button endgame1;
		 Button endgame2;
		 
		 
		 switch(id){
		 
		 
		 case DIALOG_WIN_ID:
			 
			 currentDialogId = id;
			 dialog = new Dialog(GameActivity.this);
			 dialog.setContentView(R.layout.endgame_dialog);
			 dialog.setTitle("Game Over");
			 
			 endmessage = (TextView) dialog.findViewById(R.id.endmessage);
			 
			 endgame1 = (Button) dialog.findViewById(R.id.endgame1);
		 
			 endgame2 = (Button) dialog.findViewById(R.id.endgame2);
			 			endmessage.setText("You Win!");
			 			endgame1.setText("Play Again");
			 			endgame2.setText("Back to Main");
		 
			keypad2.setOnClickListener(this);
			keypad3.setOnClickListener(this);
			
			 			
		 }
		 
	 }
	 */

	 
	 
	 
	 
	 
	 
	public void goHome(View view) {   
	       Intent intentHome = new Intent(this, MainActivity.class);
	       startActivity(intentHome);
	}
	


	@Override
	public void onBackPressed() {
		
		finish();
		
	}
	 
	 
	 
	 
	 
	 
}//end class 	