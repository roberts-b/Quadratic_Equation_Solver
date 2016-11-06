package com.example.vienadojumusaknes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	private EditText etA , etB, etC;
	private Button bSkaitlot;
	private TextView tvInfo, tvX1, tvX2;
	private double a, b, c;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etA = (EditText) findViewById(R.id.etA);
		etB = (EditText) findViewById(R.id.etB);
		etC = (EditText) findViewById(R.id.etC);
		
		bSkaitlot = (Button) findViewById(R.id.bSkaitlot);
		
		tvInfo = (TextView) findViewById(R.id.tvInfo);
		tvX1 = (TextView) findViewById(R.id.tvX1);
		tvX2 = (TextView) findViewById(R.id.tvX2);
		
		bSkaitlot.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		boolean aB = false;
		boolean bB = false;
		boolean cB = false;
		if(isNumeric(etA.getText().toString())){
			a = Double.parseDouble(etA.getText().toString());
			aB = true;
		}
		
		if(isNumeric(etB.getText().toString())){
			b = Double.parseDouble(etB.getText().toString());
			bB = true;
		}
		if(isNumeric(etC.getText().toString())){
			c = Double.parseDouble(etC.getText().toString());
			cB = true;
		}
		if(aB && bB && cB){
			
			double d = b*b -  4* a*c ;
			
			if(d > 0){
				tvInfo.setText("Diskriminants "+ d+ " ir lielaks par 0, tatad kvadratvienadojumam ir 2 atskirigas saknes.");
				
				double x1 = (-b+ Math.sqrt(d))/(2*a);
				double x2 = (-b- Math.sqrt(d))/(2*a);
				
				tvX1.setText("X1: "+String.format("%.2f", x1));
				tvX2.setText("X2: "+String.format("%.2f", x2));
			}else if(d == 0){
				tvInfo.setText("Diskriminants "+ d+ " ir vienads ar 0, tatad kvadratvienadojumam ir 1 sakne.");
				double x = -b/2*a;
				tvX1.setText("X1: "+String.format("%.2f", x));
				tvX2.setText("X1: "+String.format("%.2f", x));
			}else if(d<0){
				tvInfo.setText("Diskriminants "+ d+ " ir mazaks par 0, tad kvadratvienadojumam nav saknu.");
				tvX1.setText("X1: ");
				tvX2.setText("X1: ");
			}
		}else{
			String a = "";
			if(!aB)
				a = a+ "A ";
			if(!bB)
				a = a+ "B ";
			if(!cB)
				a = a + "C ";
			tvInfo.setText(""+a+" laukos ir ievaditi ne cipari, ludzu izlabojiet un meginiet velreiz!");
		}
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

}
