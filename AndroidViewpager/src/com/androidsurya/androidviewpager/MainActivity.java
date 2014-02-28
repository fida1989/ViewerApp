package com.androidsurya.androidviewpager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	int noofsize = 6;
	ViewPager myPager;
	int value;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewPagerAdapter adapter = new ViewPagerAdapter(MainActivity.this,
				noofsize);
		myPager = (ViewPager) findViewById(R.id.reviewpager);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.go_to:
			AlertDialog.Builder alert = new AlertDialog.Builder(this);

			alert.setTitle("Select Quote Number:");
			// alert.setMessage("Message");

			// Set an EditText view to get user input
			final EditText input = new EditText(this);
			input.setInputType(InputType.TYPE_CLASS_NUMBER);
			alert.setView(input);

			alert.setPositiveButton("Ok",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							value = Integer.parseInt(input.getText()
									.toString());
							// Do something with value!

							if (value < noofsize && value > 0) {
								Toast.makeText(MainActivity.this, value+"", Toast.LENGTH_SHORT).show();
								new Handler().postDelayed(new Runnable() {
								    @Override
								    public void run() {
								    	try{
								    		
								    		myPager.setCurrentItem(value-1,true);
								    		//myPager.getAdapter().notifyDataSetChanged();
								    	}catch(Exception e){
								    		e.printStackTrace();
								    	}
											
											
								    }
								}, 100);
								
							} else {
								Toast.makeText(getApplicationContext(),
										"Wrong Quote Number!",
										Toast.LENGTH_SHORT).show();
							}
						}
					});

			alert.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// Canceled.
						}
					});

			alert.show();
			break;
		}
			return false;
		
	}

}
