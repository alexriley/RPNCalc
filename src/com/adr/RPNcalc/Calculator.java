package com.adr.RPNcalc;

/*	File: Calculator
 * 	Original Author: Alex Riley <alex@riley.cc>
 * 	First Written: 14 December 2013
 * 	Last Modified: 15 December 2013
 * 	Description: This is part of an android app called 'RPN Calc'. The app 
 * 	uses java class RPNStack to make a Reverse Polish Notation Calculator
 * ______________________________________________________________________________
 *     This file is part of RPN Calc.
 *
 *    RPN Calc is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    RPN Calc is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with RPN Calc.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.String;


public class Calculator extends Activity
{	RPNStack numbers = new RPNStack();
	String CurrentNum = new String("");
	TextView display;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {	
        super.onCreate(savedInstanceState);
	
        setContentView(R.layout.activity_calculator);

        display = (TextView) findViewById(R.id.textView1);
    	display.setText(numbers+" "+CurrentNum);
        Button Button1 = (Button) findViewById(R.id.button1);
    	Button Button2 = (Button) findViewById(R.id.button2);
    	Button Button3 = (Button) findViewById(R.id.button3);
        Button Button4 = (Button) findViewById(R.id.button4);
    	Button Button5 = (Button) findViewById(R.id.button5);
    	Button Button6 = (Button) findViewById(R.id.button6);
        Button Button7 = (Button) findViewById(R.id.button7);
    	Button Button8 = (Button) findViewById(R.id.button8);
    	Button Button9 = (Button) findViewById(R.id.button9);
    	Button Button0 = (Button) findViewById(R.id.button0);
    	
    	Button ButtonPlus = (Button) findViewById(R.id.buttonPlus);	
    	Button ButtonMinus = (Button) findViewById(R.id.buttonMinus);
    	Button ButtonMultiply = (Button) findViewById(R.id.buttonMultiply);
    	Button ButtonDivide = (Button) findViewById(R.id.buttonDivide);
    	Button ButtonPoint = (Button) findViewById(R.id.buttonPoint);
    	Button ButtonNeg = (Button) findViewById(R.id.buttonNeg);
    	Button ButtonSpace = (Button) findViewById(R.id.buttonSpace);
    	Button ButtonBack = (Button) findViewById(R.id.buttonBack);
    	Button ButtonClear = (Button) findViewById(R.id.buttonClear);
    	
        Button1.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
				NumPressed('1');
			}
		});
        Button2.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{// TODO Auto-generated method stub
        		CurrentNum +="2";
		        display.setText(inputs() + CurrentNum);
			}
		});
        Button3.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
        		CurrentNum +="3";
		        display.setText(inputs() + CurrentNum);
			}
		}); 
        Button4.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
        		CurrentNum +="4";
		        display.setText(inputs() + CurrentNum);
			}
		}); 
        Button5.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
        		CurrentNum +="5";
		        display.setText(inputs() + CurrentNum);
			}
		}); 
        Button6.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
        		CurrentNum +="6";
		        display.setText(inputs() + CurrentNum);
			}
		}); 

        Button7.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
        		CurrentNum +="7";
		        display.setText(inputs() + CurrentNum);
			}
		}); 
        Button8.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
        		CurrentNum +="8";
		        display.setText(inputs() + CurrentNum);
			}
		}); 
        Button9.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
        		CurrentNum +="9";
		        display.setText(inputs() + CurrentNum);
			}
		}); 
        Button0.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
        		CurrentNum +="0";
		        display.setText(inputs() + CurrentNum);
			}
		}); 
        
        ButtonPlus.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
				PushCurrentNum();
				numbers.op('+');
		        display.setText(inputs() + CurrentNum);
			}
		});
        
        ButtonMinus.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
				PushCurrentNum();
				numbers.op('-');
		        display.setText(inputs() + CurrentNum);
			}
		});
        ButtonMultiply.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
				PushCurrentNum();
				numbers.op('*');
		        display.setText(inputs() + CurrentNum);
			}
		});
        
    	ButtonDivide.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
				PushCurrentNum();
				numbers.op('/');
		        display.setText(inputs() + CurrentNum);
			}
		});
    	ButtonPoint.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
        		CurrentNum +=".";
		        display.setText(inputs() + CurrentNum);
			}
		}); 
    	ButtonNeg.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
        		CurrentNum = "-" + CurrentNum;
		        display.setText(inputs() + CurrentNum);
			}
		}); 
        ButtonSpace.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
				PushCurrentNum();
		        display.setText(inputs() + CurrentNum);
			}
		});
        ButtonBack.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
        		if(CurrentNum.length() > 0) 
        			CurrentNum = CurrentNum.subSequence(0, CurrentNum.length()-1).toString();
        		
        		display.setText(inputs() + CurrentNum);
        		
        	}
		});
        ButtonClear.setOnClickListener(new View.OnClickListener() 
        {	@Override
			public void onClick(View v) 
        	{	// TODO Auto-generated method stub
				CurrentNum = "";
				numbers.clear();
		        display.setText(inputs() + CurrentNum);				
			}
		});
        
        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {	// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }
    
    private void displayRefresh()
    {	display.setText(inputs());
    	
    	
    }
    
    private void NumPressed(char in)
   {	displayRefresh();
        display.setText(inputs() + CurrentNum);
    }
    private void PushCurrentNum()
    {	if(CurrentNum.length() > 0)
    	{	Double a = Double.parseDouble(CurrentNum);
        	CurrentNum="";
        	numbers.push(a);
    	}
    }


    public String inputs()
    {	return numbers.toString()+CurrentNum;
    }

    
}
