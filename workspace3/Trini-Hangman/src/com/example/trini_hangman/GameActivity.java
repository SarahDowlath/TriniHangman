package com.example.trini_hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener; 
import android.view.ViewGroup.LayoutParams;
import android.app.AlertDialog;
import android.content.DialogInterface;


	

public class GameActivity extends Activity implements OnClickListener {
	//implements onClickListener? 
	
	public static final String GAME_CATEGORY = "Hangman_Category";
	
	private String wordsFoodArray[],wordsMusicArray[],wordsSportsArray [],categoryArray[], wordsUsedArray[];
	private Random rand;
	private String currWord,secretWord,secretWord2, wordsFood,wordsMusic,wordsSports, newWord;
	private TextView [] charViews;//an array of the text views for the letters
	
	private TextView secWord,wrongLetters;
	private LinearLayout wordLayout, layout1,layout2, layout3, layout4;
	private LinearLayout [] layouts;
	
	private Dialog dialog;
	private int currentDialogId;
	
	//private ArrayList <Boolean> currAnswer;
	
	//body part images
	private ImageView[] bodyParts;
	private ImageView hangmanimg;
	
	//number of body parts
	private int numParts=6;
	
	//current part - will increment when wrong answers are chosen
	private int currPart;
	
	//number of characters in current word
	private int numChars;
	
	//number correctly guessed
	private int numCorr;
	      
	
	public int catValue;
	
	public static final String KEY_CATEGORY = "com.example.trini_hangma n.category";
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
		
		
		
		rand = new Random();		
		currWord = "";
		
		catValue = getIntent().getExtras().getInt(MainActivity.GAME_CATEGORY);
		Log.w(MainActivity.TAG, "Received "+ catValue);
				
		wordLayout = (LinearLayout)findViewById(R.id.secretWord);
		
		
		bindViews();
		
		
		bodyParts = new ImageView[numParts];
		bodyParts[0] = (ImageView)findViewById(R.id.head);
		bodyParts[1] = (ImageView)findViewById(R.id.body);
		bodyParts[2] = (ImageView)findViewById(R.id.arm1);
		bodyParts[3] = (ImageView)findViewById(R.id.arm2);
		bodyParts[4] = (ImageView)findViewById(R.id.leg1);
		bodyParts[5] = (ImageView)findViewById(R.id.leg2);

		playGame(catValue);
	}
	
	
	
	private void playGame(int category){

		int i=0;
		secretWord = generateWordByCategory(category);
		//Toast.makeText(getApplicationContext(), secretWord, Toast.LENGTH_SHORT).show();//shows secret word
		
		initGame(currWord);
  
		currWord = secretWord;
		currPart=0;  //
		numChars=currWord.length(); //setting numChars to length of the word 
		numCorr=0;  //number of correct characters 
	  
		charViews = new TextView[currWord.length()];
		wordLayout.removeAllViews(); //what is wordLayout? check xml file? 
	  
 
		for (int c = 0; c < currWord.length(); c++) {
		  charViews[c] = new TextView(this);
		  charViews[c].setText(""+currWord.charAt(c));
		  charViews[c].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		  charViews[c].setGravity(Gravity.CENTER);
		  charViews[c].setTextColor(Color.BLACK);
		  charViews[c].setTextSize(20);
		  charViews[c].setBackgroundResource(R.drawable.letter_bg); 
		  wordLayout.addView(charViews[c]);
		  wordLayout.setGravity(Gravity.CENTER);
		
		}

		
}
	
		
	private void bindViews()
	{
		
		wordLayout = (LinearLayout)this.findViewById(R.id.secretWord);
		
		secWord= (TextView) this.findViewById(R.id.secretTextView);
		
		layout1 = (LinearLayout) this.findViewById(R.id.letterLayout1);
		layout2 = (LinearLayout) this.findViewById(R.id.letterLayout2);
		layout3 = (LinearLayout) this.findViewById(R.id.letterLayout3);
		layout4 = (LinearLayout) this.findViewById(R.id.FinalLayout);	
	}
	

	
	
	public void clickLetter(View view) {
		  //user has pressed a letter to guess
		  
		  String ltr=((TextView)view).getText().toString();
		  char letterChar = ltr.charAt(0);
		 // Toast.makeText(getApplicationContext(), "letter:" +letterChar, Toast.LENGTH_SHORT).show();
		  view.setEnabled(false);
		 // view.setBackgroundResource(R.drawable.letter_down);
		  
		  boolean correct = false;
		  for(int k = 0; k < currWord.length(); k++) 
		  {
		  
			if(currWord.charAt(k)==letterChar){
		    correct = true;
		    numCorr++;
		    charViews[k].setTextColor(Color.WHITE);
		  }
		}

		if (correct)//then check if the user has won
	{
		 
		 if (numCorr == numChars) //user has won 
		 {
			//user has won
			disableBtns();
				
			openWinGameDialog();
			
		}
		 
	}
		
		else if (currPart<numParts)
			
		{
			bodyParts[currPart].setVisibility(View.VISIBLE);
			currPart++;
			
			if (currPart == numParts){
				disableBtns();
				openLoseGameDialog();
			}
			
		}
			
		else if
		
			 (currPart == numParts)
		{
				disableBtns();
				openLoseGameDialog();
		}
			
		
		else {
			GameActivity.this.finish();//set a dialog for this 
		}
		

}


	private void disableBtns()
	{
		
		for (int i=0;i<26;i++){
			
			char c = (char)('a' + i);
			disableLetter(c);
		}
	}
	
	
	 
	public void disableLetter(char c)
	{
		
		char C= Character.toUpperCase(c);
		String buttonID = "button" + C;
		int resID = getResources().getIdentifier(buttonID, "id", "com.example.trini_hangman");
		Button b = (Button) findViewById(resID);
		b.setEnabled(false);
		
	}

	private void enableBtns()
	{
		
		for (int i=0;i<26;i++){
			
			char c = (char)('a' + i);
			enableLetter(c);
		}
	}

	public void enableLetter(char c)
	{
		
		char C= Character.toUpperCase(c);
		String buttonID = "button" + C;
		int resID = getResources().getIdentifier(buttonID, "id", "com.example.trini_hangman");
		Button b = (Button) findViewById(resID);
		b.setEnabled(true);
		
	}
	
		
	//Returns the string for the button selected
	public char getLetter(int btnId)
	{
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
	}



	
	private void openWinGameDialog()
	{
		 AlertDialog.Builder winGameBuilder=new AlertDialog.Builder(GameActivity.this);
		 winGameBuilder.setTitle("Congratulations! ");
		 winGameBuilder.setIcon(R.drawable.smiley_face);
		 winGameBuilder.setMessage("You won! Your word was: " + secretWord);
		 
 
		 winGameBuilder.setPositiveButton("Next Word", new DialogInterface.OnClickListener(){ 
			 	
			 public void onClick(DialogInterface wDialog, int which){

				 enableBtns();
				 GameActivity.this.playGame(catValue);
			 
			 }
		 }
		 );
		 
		 
		 winGameBuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener(){
			 
			 public void onClick(DialogInterface wDialog, int which){
				 Intent k = new Intent(GameActivity.this, MainActivity.class);    
				 startActivity(k);   
				 
			 }
		 });
		 
		 AlertDialog dialogWin = winGameBuilder.create();
		 dialogWin.show();
		 
		 
		
	 }//end openWinGameDialog 
	
	
	private void openLoseGameDialog(){
		 AlertDialog.Builder loseGameBuilder=new AlertDialog.Builder(GameActivity.this);
		 loseGameBuilder.setTitle("Sorry ");
		 loseGameBuilder.setMessage("You lose! The correct word was: " + secretWord);
		 loseGameBuilder.setIcon(R.drawable.sad_face);
		 loseGameBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
			 	
			 public void onClick(DialogInterface lDialog, int which){
				 GameActivity.this.finish();
				 
			 }
		 });
		 
		 
		 loseGameBuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener(){
			 
			 public void onClick(DialogInterface lDialog, int which){
				 Intent k = new Intent(GameActivity.this, MainActivity.class);    
				 startActivity(k);   
				 
			 }
		 });
		 
		 AlertDialog dialogLose = loseGameBuilder.create();
		 dialogLose.show();
	}
	
	

	public void openNewGameDialog(){
		 AlertDialog.Builder dBuilder=new AlertDialog.Builder(this);
		 dBuilder.setTitle("Select a category");
		 dBuilder.setItems(R.array.category,new DialogInterface.OnClickListener(){
			 public void onClick(DialogInterface dialogInt, int item){
				 Toast.makeText(getApplicationContext(), categoryArray[item], Toast.LENGTH_SHORT).show(); 
				 startGame(item);
			 }
		 });
		AlertDialog alert = dBuilder.create(); //display Dialog box
		alert.show();
	 }//end openNewGameDialog 


	private void startGame(int i){
			Intent intent = new Intent(GameActivity.this, GameActivity.class);
			intent.putExtra(GAME_CATEGORY, i);
			startActivity(intent);
			finish();
		

	 }
		
	private void initGame(String word)
	{
	
		for(int p = 0; p < numParts; p++) 
			bodyParts[p].setVisibility(View.INVISIBLE);
		
	}
	
	
	 private String generateWordByCategory(int cat){
		 String temp = "";
		 switch(cat){
			case 0: //category food - choose a word from the food array 
				temp = wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
				while (temp.equals(currWord)) temp= wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
				currWord= wordsFood;
				newWord = temp;
				break;
			
			case 1: //category music - choose a word from the music array
				temp = wordsMusicArray[rand.nextInt(wordsMusicArray.length)];
				while (temp.equals(currWord)) temp = wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
				currWord= wordsMusic;
				newWord = temp;
				break;
			
			case 2://category sports - choose a word from the sports array 
				temp = wordsSportsArray[rand.nextInt(wordsSportsArray.length)];
				while (temp.equals(currWord)) temp= wordsFoodArray[rand.nextInt(wordsFoodArray.length)];
				currWord= wordsSports;
				newWord = temp;
				break;
		 }
		 return newWord;
	 }
	 
		 
	 
	public void goHome(View view) {   
	       Intent intentHome = new Intent(this, MainActivity.class);
	       startActivity(intentHome);
	}
	
	
	public void newGame(View view){
		enableBtns();
		openNewGameDialog();
		
		
		
	}


	@Override
	public void onBackPressed() {
		
		finish();
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	


	 
	 
}//end class 	