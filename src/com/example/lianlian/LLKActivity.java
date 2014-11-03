package com.example.lianlian;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LLKActivity extends Activity {
	private CrtlView cv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_llk);
		cv=(CrtlView)findViewById(R.id.cv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.llk, menu);
		return true;
	}

}
