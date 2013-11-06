package com.example.homework1;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ImageView.ScaleType;

public class Activity2 extends Activity implements OnItemSelectedListener, OnClickListener {
	

	private List<ItemSpinner> ListSpinner;	
	private Spinner spScaleType;
	private ImageView ivMinion2;
	private Button butClose2;
	
	/**
	 * Пункт спинера
	 */
	public class ItemSpinner {
		public Object tag;
		public String name;

		public ItemSpinner(Object _tag, String _name)
		{
			this.tag = _tag;
			this.name = _name;
		}
		
		public String toString()
		{
			return this.name;
		}
	}
	
	private void setScaleType(){
		for (ScaleType stValue : ImageView.ScaleType.values()) {
			ItemSpinner item = new ItemSpinner(stValue, stValue.toString());
			this.ListSpinner.add(item);
		}

		ArrayAdapter adapterSelectDetail = new ArrayAdapter(this, android.R.layout.simple_spinner_item, this.ListSpinner);		
		adapterSelectDetail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spScaleType.setAdapter(adapterSelectDetail);		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity2);
		
		this.ListSpinner = new ArrayList<ItemSpinner>();
		this.ivMinion2 = (ImageView)findViewById(R.id.ivMinion2);
		this.spScaleType = (Spinner)findViewById(R.id.spScaleType);
		this.butClose2 = (Button)findViewById(R.id.butClose2);
		
		this.setScaleType();
		this.spScaleType.setOnItemSelectedListener(this);
		this.butClose2.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity2, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		if(parent.getId() == R.id.spScaleType){
			ItemSpinner item = (ItemSpinner)this.spScaleType.getSelectedItem();	
			ImageView.ScaleType st = (ImageView.ScaleType)item.tag;
			this.ivMinion2.setScaleType(st);			
		}		
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.butClose2)
			finish();		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
