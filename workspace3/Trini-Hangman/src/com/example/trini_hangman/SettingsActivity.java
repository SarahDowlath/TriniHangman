package com.example.trini_hangman;


import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;


public class SettingsActivity extends PreferenceActivity{


	private static final String OPT_MUSIC = "music";
	private static final boolean OPT_MUSIC_DEF = true;

	
	
	protected void onCreate(Bundle savedInstanceState)
	{
	
		super.onCreate(savedInstanceState);
		getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
		//addPreferencesFromResource(R.layout.settings);
		
	}
	


	public static class MyPreferenceFragment extends PreferenceFragment
	{
	    @Override
	    public void onCreate(final Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        addPreferencesFromResource(R.layout.settings);
	    }
	}

	
	
	public static boolean getMusic(Context context){
	
		return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(OPT_MUSIC, OPT_MUSIC_DEF);
		}
	
}




