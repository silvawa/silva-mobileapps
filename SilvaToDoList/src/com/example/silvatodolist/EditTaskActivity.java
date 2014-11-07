package com.example.silvatodolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class EditTaskActivity extends Activity {

	private ToDoList toDoList;
	public Button buttonAddTask;
	public Button buttonEditTask;
	public Button buttonDeleteTask;
	public Button buttonMainMenu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_task);
		toDoList =  new ToDoList(this);
		
		
		buttonAddTask = (Button)findViewById(R.id.buttonAddTask);
		buttonEditTask = (Button)findViewById(R.id.buttonEditTask);
		buttonDeleteTask = (Button)findViewById(R.id.buttonDeleteTask);
		buttonMainMenu = (Button)findViewById(R.id.buttonMainMenu);
		
		
		 // Get Order information from the PurchaseActivity
		Intent intent = getIntent();
		int taskId = intent.getIntExtra("com.example.silvatodolist.tasksId", 0);
		if (taskId != 0){
			populateTaskData(taskId);
		}
		
	}
private void populateTaskData(int taskId) {
	// Bind to UI Fields
	TextView textID= (TextView)findViewById(R.id.textID);
	CheckBox checkPriority = (CheckBox)findViewById(R.id.checkBoxPriority);
	EditText editDate = (EditText)findViewById(R.id.editDueDate);
	EditText editTask = (EditText)findViewById(R.id.editTask);
	CheckBox checkBoxDone = (CheckBox)findViewById(R.id.checkBoxDone);
	
	//Create Task
	Task t = toDoList.getTask(taskId);
	
	// Display Data
	textId.setText(String.valueOf(t.getId()));
	checkPriority.setChecked(t.getPriority());
	editDate.setText(t.getData());
	editTask.setText(t.getTaskDetails());
	checkBoxDone.setChecked(t.getCompleted());
	
	
}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_task, menu);
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
	
	
	public void handleClick(View v){
		switch (v.getId()){
		case R.id.buttonAddTask:
			askToDo();
			break;
		case R.id.buttonEditTask:
			editTaskData();
			break;
		case R.id.buttonDeleteTask:
			deleteTask();
			break;
		case R.id.buttonMainMenu:
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			break;
			
		}
	}
}
