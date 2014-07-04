package com.example.trini_hangman;

	 import com.example.trini_hangman.R;

	 import java.util.Random;
	 import android.app.Activity; 
	 import android.app.AlertDialog; 
	 import android.app.Dialog;
	 import android.content.DialogInterface; 
	 import android.content.Intent; 
	 import android.os.Bundle; 
	 import android.util.Log; 
	 import android.view.KeyEvent; 
	 import android.view.View; 
	// import android.view.View.OnClickListener; 
	 import android.view.View.OnClickListener;
	 import android.widget.Button; 
	 import android.widget.ImageView; 
	 import android.widget.TextView; 
	 import android.widget.Toast;
	
	
	
	 public class Game extends Activity  {
		 
		 //private static final String TAG= 'Game';
		 
		 //The textview of the mystery word to be guessed
		 private TextView mystWord;
		 
		 //The textView of the string of letters guessed incorrectly
		 private TextView wrongletters;
		 
		 //the View of the the displayed Hangman image
		 private ImageView hangmanimg;
		 
		 private Button hintbutton;
		 
		 private Dialog dialog;
		 
		 
		 private int currentDialogId;
		 
		 private int numWrongGuesses;
		 private String mysteryWord;
		 private Boolean hintused = false;
		 private int cat; //category
		 
		 /**** do we need Dialog? ****/ 
	
		 static final String KEY_CATEGORY= "com.example.trini_hangman.category";
		 
		 public static final int CATEGORY_MUSIC =1;
		 public static final int CATEGORY_FOOD = 0;
		 public static final int CATEGORY_SPORTS = 2; 
		 
		 protected static final int CATEGORY_CONTINUE = -1; 
		 
		 private static final String PREF_MYSTWORD = "mystword";  
		 private static final String PREF_MYSTERYWORD = "mysterytword";  
		 private static final String PREF_WRONGLETTERS = "wrongletters";  
		 private static final String PREF_NUMWRONGGUESSES = "numWrongGuesses";  
		 private static final String PREF_HINTUSED = "hintused"; 
	
		 /** Called when the activity is first created. */  
		 @Override  
		 public void onCreate(Bundle savedInstanceState) {   
			 super.onCreate(savedInstanceState);   
			 // set content view to game layout   
			 setContentView(R.layout.game);  
			 
			 //bindViews();  // bind the resource views to textview and imageview holders   
			 
			 setWordByCategory();   // get selected category and assign mystery word  
			 
			// initMystWord();   // initialize the Mystery word view with underscores   
			 
			 //initWrongGuesses();  // initialize the number of wrong guesses and wrong guesses view string  
			 
			// initImg(); // initialize hangman imageview  
			 
			// setClickListeners();  // set OnClick Listeners for each button in the view   
			 
			  
			// loadGameIfSaved();  // load game if saved 
		}  //end onCreate
		 
		 
	
		 
		 
		/* private void bindViews() {
			 
			 mystWord = (TextView) this.findViewById(R.id.mysteryWord);
			 wrongletters = (TextView)this.findViewById(R.id.wrongletters);
			 this.findViewById(R.id.hangman_img);
			 
			 
		 }*/
		 
		 
		 
		 
		 private void setWordByCategory() 
		 {  
			 
			 cat = getIntent().getIntExtra(KEY_CATEGORY, CATEGORY_MUSIC);   //how do you know which category was selected? 
			// mysteryWord = getWord(cat);  
			 
		 }  
		 
		 
		 
		 /*private String getWord(int cat) {   
			 String temp;   
			 switch (cat) {   
			 case CATEGORY_CONTINUE:    
				 temp = getPreferences(MODE_PRIVATE).getString(PREF_MYSTERYWORD,getWord(CATEGORY_FOOD));    
				 break;   
				 case CATEGORY_MUSIC:    
					 //temp = "KNIGHTIA";    
					 //randomly generate words 
					 
					 break;   
					 
				 case CATEGORY_FOOD:    
					 //temp = "LEOPARD";    
					 break;   
					 
				case CATEGORY_SPORTS:    
					//temp = "PICKLEWORM";    
					break;   
					
				default:    temp = "DEFAULT";   
				}   
			 return temp;
		 }*/
		 
		 
		 
	 
		 private void openNewGameDiaglog(){
			 
			 new AlertDialog.Builder(this).setTitle("Select a category").setItems(
					 R.array.category, new DialogInterface.OnClickListener(){
				 			public void onClick(DialogInterface dialoginterface, int i)
				 				{
				 				
				 				//startGame(i);
				 				}
			 }).show();
			 
		 }
				 				
				 
				 
		public void onClick(View v)
		{
			
			
			switch(v.getId()){
			
			case R.id.buttonA:  inputLetter('a');
			break;
			
			case R.id.buttonB:  inputLetter('b');
			break;
			
			case R.id.buttonC:  inputLetter('c');
			 break;
			 
			case R.id.buttonD:  inputLetter('d');
			break;
			
			case R.id.buttonE:  inputLetter('e');
			break;
			
			case R.id.buttonF:  inputLetter('f');
			break;
			
			case R.id.buttonG:  inputLetter('g');
			break;
			
			case R.id.buttonH:  inputLetter('h');
			break;
			
			case R.id.buttonI:  inputLetter('i');
			break;
			
			case R.id.buttonJ:  inputLetter('j');
			break;
			
			case R.id.buttonK:  inputLetter('k');
			break;
			
			case R.id.buttonL:  inputLetter('l');
			break;
			
			case R.id.buttonM:  inputLetter('m');
			break;
			
			case R.id.buttonN:  inputLetter('n');
			 break;
			 
			case R.id.buttonO:  inputLetter('o');
			break;
			
			case R.id.buttonP:  inputLetter('p');
			break;
			
			case R.id.buttonQ:  inputLetter('q');
			break;
			
			case R.id.buttonR:  inputLetter('r');
			break;
			
			case R.id.buttonS:  inputLetter('s');
			break;
			
			case R.id.buttonT:  inputLetter('t');
			break;
			
			case R.id.buttonU:  inputLetter('u');
			break;
			
			case R.id.buttonV:  inputLetter('v');
			break;
			
			case R.id.buttonW:  inputLetter('w');
			break;
			
			case R.id.buttonX:  inputLetter('x');
			break;
			
			case R.id.buttonY:  inputLetter('y');
			break;
			
			case R.id.buttonZ:  inputLetter('z');
			break;
			
			
			}
			
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//end class Game 
