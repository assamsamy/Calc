package com.breahst.calc;

import android.app.Dialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ListV extends AppCompatActivity {

    ListView list;
    ArrayList<Achat> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_v);
        list = findViewById(R.id.list_item);

        items.add(new Achat("Farine", 10));
        items.add(new Achat("Levure", 10));
        items.add(new Achat("Huile", 10));
        items.add(new Achat("Eau", 10));
//        items.addAll(Arrays.asList(new String[]{
//                "10 kgFarine",
//                "10 Levure",
//                "10 Huile",
//                "10 Eau"
//        }));


        final AchatAdapter adapter = new AchatAdapter(this, R.layout.lv_item, items);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), items.get(position).getItem(), Toast.LENGTH_SHORT).show();
            }
        });







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_listv, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();
        if(id == R.id.menu_listv_add){
//            Dialog diag = new Dialog(this);
//            diag.setContentView(R.layout.add_dialog);
//            Button b = findViewById(R.id.addtbn);
//
//            final EditText add_item = findViewById(R.id.item_add);
//            final EditText add_qte = findViewById(R.id.qte);
//            b.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    items.add(new Achat(add_item.getText().toString(), Integer.parseInt(String.valueOf(add_qte.getText())) ));
////                items.add(add_item.getText().toString());
//                    adapter.notifyDataSetChanged();
//                }
//            });
//            diag.show();



        }
        else if( id == R.id.menu_listv_edit){
            Toast.makeText(this, "Modifier", Snackbar.LENGTH_LONG).show();
        }
        return true;
    }
}
