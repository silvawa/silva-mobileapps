package com.example.silvatodolist;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class ToDoList {
 private List<Task> toDoList;
 private TasksDAO tasksDataSource;
 
 
 public ToDoList(Context c) {
	 toDoList = new ArrayList<Task>(0);
	 tasksDataSource = new TasksDAO(c);
	 tasksDataSource.open();
 }
 
 // Methods
 public Task getTask(int taskID){
	 return tasksDataSource.getTaskById(taskID);
 }
 
 public Task createTask(Task t){
	 return tasksDataSource.createTask(t);
 }
 public void editTask(Task t){
	tasksDataSource.editTask(t);
 }
 public void deletedTask(Task t) {
	 tasksDataSource.deleteTask(t);
 }
 
 
} // end class ToDoList
