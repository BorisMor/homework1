package com.example.homework1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity1 extends Activity implements OnCheckedChangeListener, OnClickListener {

	RadioGroup rgScaleType;
	ImageView ivMinion;
	Button butCloseA1;
	
	private void setScaleType()
	{
		for (ScaleType stValue : ImageView.ScaleType.values()) {
			RadioButton rb = new RadioButton(this);
			rb.setText(stValue.toString());
			rb.setTag(stValue);
			rb.setOnCheckedChangeListener(this);
			this.rgScaleType.addView(rb);
		} 
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity1);
		
		this.rgScaleType = (RadioGroup)findViewById(R.id.rgScaleType);
		this.ivMinion = (ImageView)findViewById(R.id.ivMinion);
		this.butCloseA1 = (Button)findViewById(R.id.butCloseA1);
		
		this.setScaleType();
		this.butCloseA1.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity1, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		ImageView.ScaleType st = (ImageView.ScaleType)buttonView.getTag();
		this.ivMinion.setScaleType(st);
		
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.butCloseA1)
			finish();
		
	}

}
