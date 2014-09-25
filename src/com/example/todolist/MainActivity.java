package com.example.todolist;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends ActionBarActivity {

	private OnNewItemAddedListener onNewItemAddedListener;
	
	private ArrayAdapter<String> aa;
	private ArrayList<String> todoItems;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//inflate your view
		setContentView(R.layout.activity_main);  //fill view
		
		//Get references to UI widgets
		//final EditText myEditText = (EditText)findViewById(R.id.myEditText);
		//ListView myListView = (ListView)findViewById(R.id.myListView);

		//create the array List of to do items
		//final ArrayList<String> todoItems = new ArrayList<String>();
		

		//Create the Array Adapter to bind the array to the List View
		//final ArrayAdapter<String> aa;
		
		//aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,todoItems);
		

		//Bind the Array Adapter to the List View
		//myListView.setAdapter(aa);
		
		/*myEditText.setOnKeyListener(new View.OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				
				if (event.getAction() == KeyEvent.ACTION_DOWN)
					if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER)||
							(keyCode == KeyEvent.KEYCODE_ENTER))
					{
						todoItems.add(0, myEditText.getText().toString());
						aa.notifyDataSetChanged();
						myEditText.setText("");
						
						return true;
					}
				// TODO Auto-generated method stub
				return false;
			}
		}); */
		
		//get references of Fragment
		FragmentManager frm = getFragmentManager();
		
		ToDoListFragment todoListFragment =
				fm.findFragmentById(R.id.TodoListFragment);
		
		// create ArrayList of ToDo Item.
		todoItems = new ArrayList<String>();
		
		//Create ArrayAdapter to bind the array to the listView.
		aa = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1,
				todoItems
				);
		
		//Bind the ArrayAdapter to the ListView.
		todoListFragment.setListAdapter(aa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
