package adr.com.rpncalc;

/*	File: Calculator.java
 * 	Original Author: Alex Riley <alex@riley.cc>
 * 	First Written: 14 December 2013
 * 	Last Modified: 17 December 2013
 * 	Description: This is part of an android app called 'RPN Calc'. The app
 * 	uses java class RPNStack (also in this source code) to make a Reverse
 * 	Polish Notation Calculator
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
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;


public class Calculator extends ActionBarActivity
{	RPNStack numbers = new RPNStack();
    String CurrentNum = new String("");
    TextView display;

    Toast InvalidOpToast;

    Button Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8;
    Button Button9, Button0, ButtonPlus, ButtonMinus, ButtonMultiply, ButtonDivide;
    Button ButtonPoint, ButtonNeg, ButtonSpace, ButtonBack, ButtonClear;

    public static final String TAG = "Calculator";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Context context = getApplicationContext();
        InvalidOpToast = Toast.makeText(context,"Operations require 2 numbers",Toast.LENGTH_LONG);
        setContentView(R.layout.activity_calculator);
        Log.v(TAG,"Application started");
        display = (TextView) findViewById(R.id.textView1);
        displayRefresh();

        Button1 = (Button) findViewById(R.id.button1);
        Button2 = (Button) findViewById(R.id.button2);
        Button3 = (Button) findViewById(R.id.button3);
        Button4 = (Button) findViewById(R.id.button4);
        Button5 = (Button) findViewById(R.id.button5);
        Button6 = (Button) findViewById(R.id.button6);
        Button7 = (Button) findViewById(R.id.button7);
        Button8 = (Button) findViewById(R.id.button8);
        Button9 = (Button) findViewById(R.id.button9);
        Button0 = (Button) findViewById(R.id.button0);


        ButtonPlus = (Button) findViewById(R.id.buttonPlus);
        ButtonMinus = (Button) findViewById(R.id.buttonMinus);
        ButtonMultiply = (Button) findViewById(R.id.buttonMultiply);
        ButtonDivide = (Button) findViewById(R.id.buttonDivide);
        ButtonPoint = (Button) findViewById(R.id.buttonPoint);
        ButtonNeg = (Button) findViewById(R.id.buttonNeg);
        ButtonSpace = (Button) findViewById(R.id.buttonSpace);
        ButtonBack = (Button) findViewById(R.id.buttonBack);
        ButtonClear = (Button) findViewById(R.id.buttonClear);

        Button1.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('1');
            }
        });
        Button2.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {// TODO Auto-generated method stub
                ButtonPressed('2');
            }
        });
        Button3.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('3');
            }
        });
        Button4.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('4');
            }
        });
        Button5.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('5');
            }
        });
        Button6.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('6');
            }
        });

        Button7.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('7');
            }
        });
        Button8.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('8');
            }
        });
        Button9.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('9');
            }
        });
        Button0.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('0');
            }
        });

        ButtonPlus.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('+');
            }
        });

        ButtonMinus.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                //Note: ButtonPressed('-') is the minus operator
                //ButtonPressed('n') is the negative sign
                ButtonPressed('-');
            }
        });
        ButtonMultiply.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                PushCurrentNum();
                ButtonPressed('*');
            }
        });

        ButtonDivide.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('/');

            }
        });
        ButtonPoint.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                ButtonPressed('.');
            }
        });
        ButtonNeg.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                //Note: ButtonPressed('-') is the minus operator
                //ButtonPressed('n') is the negative sign
                ButtonPressed('n');
            }
        });
        ButtonSpace.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                PushCurrentNum();
                displayRefresh();
            }
        });
        ButtonBack.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                if(CurrentNum.length() > 0)
                    CurrentNum = CurrentNum.subSequence(0, CurrentNum.length()-1).toString();
                displayRefresh();

            }
        });
        ButtonClear.setOnClickListener(new View.OnClickListener()
        {	@Override
             public void onClick(View v)
            {	// TODO Auto-generated method stub
                CurrentNum = "";
                numbers.clear();
                displayRefresh();
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {	// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    private void displayRefresh()
    {	display.setText(inputs());


    }

    private void ButtonPressed(char in)
    {	switch(in)
        {
            //Note: ButtonPressed('-') is the minus operator
            //ButtonPressed('n') is the negative sign
            case '1': case '2': case '3': case '4': case '5':
            case '6': case '7': case '8': case '9': case '0':
            case '.':
                CurrentNum += in;
                break;
            case 'n':
                CurrentNum = '-'+CurrentNum;
                break;
            case '+': case '-': case '/': case '*':
                PushCurrentNum();
                Log.v(TAG,"Operation entered");
                if(numbers.op(in) == 1)
                {   InvalidOpToast.show();
                    Log.v(TAG,"TESTING: Toast called");
                }
                break;

        }
        displayRefresh();

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



