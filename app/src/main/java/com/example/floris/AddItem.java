package com.example.floris.floris_pset_4;

/**
 * Created by Floris on 11/23/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends Activity implements OnClickListener {

    private Button addItemBtn;
    private EditText AddItemET;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Record");

        setContentView(R.layout.add_item);

        AddItemET = (EditText) findViewById(R.id.add_item_ET);

        addItemBtn = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addItemBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:

                final String name = AddItemET.getText().toString();
//                final String desc = descEditText.getText().toString();

                dbManager.insert(name);

                Intent main = new Intent(AddItem.this, MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }

}