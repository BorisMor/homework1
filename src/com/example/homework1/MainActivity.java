package com.example.homework1;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	
	Button butClose;
	Button butRadioGroup;
	Button butSpinner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.butClose = (Button)findViewById(R.id.butClose);
		this.butClose.setOnClickListener(this);
		
		this.butRadioGroup = (Button)findViewById(R.id.butRadioGroup);
		this.butRadioGroup.setOnClickListener(this);
		
		this.butSpinner = (Button)findViewById(R.id.butSpinner);
		this.butSpinner.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void click_butRadioGroup()
	{
		Intent intent = new Intent(getApplicationContext(), Activity1.class);
    	startActivity(intent);
	}
	
	public void click_butSpinner()
	{
		Intent intent = new Intent(getApplicationContext(), Activity2.class);
    	startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.butClose:
			finish();
			break;

		case R.id.butRadioGroup:
			this.click_butRadioGroup();
			break;
			
		case R.id.butSpinner:
			this.click_butSpinner();
			break;

		default:
			break;
		}
		
	}

}
