package com.makulabs.controllers;

import java.util.ArrayList;

import com.makulabs.models.CalculatorModel;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Context;
import android.view.View;


import com.makulabs.calculator.*;


public class MainActivityController {

	private Context context;
	private EditText etResult;
	private ArrayList<String> alSavedResults;
	private ArrayAdapter<String> aaSavedResultsListAdapter;
	private ListView lvSavedResults;
	
	public MainActivityController(MainActivity activity) {
		this.context = activity;
		
        etResult = (EditText) activity.findViewById(R.id.editTextResult);
        
        // Data
        this.setupClickListenerForText((Button) activity.findViewById(R.id.button0));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.button1));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.button2));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.button3));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.button4));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.button5));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.button6));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.button7));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.button8));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.button9));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.buttonPlus));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.buttonMinus));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.buttonDivide));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.buttonMultiply));
        this.setupClickListenerForText((Button) activity.findViewById(R.id.buttonDecimal));
        
        // Actions
        this.setupClickListenerForClearInput((Button) activity.findViewById(R.id.buttonClearInput));
        this.setupClickListenerForOperation((Button) activity.findViewById(R.id.buttonEqual));
        this.setupClickListenerForSavingResult((Button) activity.findViewById(R.id.buttonSaveResult));
        this.setupClickListenerForClearingResults((Button) activity.findViewById(R.id.buttonClear));
        this.setupClickListenerForSavedResultViewItem((AdapterView) activity.findViewById(R.id.lvSavedValues));
        
        this.setupSavedResultsListView(activity);
	}
	
	
	// When any number or operation button is clicked
	public void setupClickListenerForText(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView vv = (TextView) v;
				String newText = vv.getText().toString();
				etResult.setText(etResult.getText().toString() + newText);
			}
		});
	}
	
	
	// When "=" is clicked
	public void setupClickListenerForOperation(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String input = etResult.getText().toString();
				String output = new CalculatorModel().process(input);
				etResult.setText(output);
			}
		});
	}
	
	
	// When "Save Result" is clicked
	public void setupClickListenerForSavingResult(Button button) {
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String input = etResult.getText().toString();
				alSavedResults.add(0, input);	// add on top
				aaSavedResultsListAdapter.notifyDataSetChanged();
			}
		});
	}
	
	
	// When user presses clear all
	public void setupClickListenerForClearingResults(Button button) {
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				alSavedResults.clear();
				aaSavedResultsListAdapter.notifyDataSetChanged();
			}
		});
	}
	
	
	// When AC is clicked
	public void setupClickListenerForClearInput(Button button) {
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				etResult.setText("");
			}
		});
	}
	
	
	// When a list item is clicked
	public void setupClickListenerForSavedResultViewItem(AdapterView listView) {
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				etResult.setText(alSavedResults.get(position));
			}
		});
	}
	
	
	// Sets up the saved results list view
	public void setupSavedResultsListView(MainActivity activity) {
		this.lvSavedResults = (ListView) activity.findViewById(R.id.lvSavedValues);

		this.alSavedResults = new ArrayList<String>();
		
		this.aaSavedResultsListAdapter = new ArrayAdapter<String>(this.context, android.R.layout.simple_list_item_1, this.alSavedResults);
		
		// Assign adapter to ListView
		this.lvSavedResults.setAdapter(this.aaSavedResultsListAdapter);
	}
	
}
