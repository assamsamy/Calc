package com.breahst.calc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    private ArrayAdapter<Contact> contactArrayAdapter;
    private ArrayList<Contact> contacts;
    private Database db ;
    private ListView contact_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        db = new Database(this, null);
        contact_listview = findViewById(R.id.contact_listview);

        contact_listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                db.deleteContact(contacts.get(position).getId());
                Toast.makeText(getApplicationContext(), "Contact supprimé", Toast.LENGTH_SHORT).show();
                viewData();
                return true;
            }
        });

        contact_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), contacts.get(position).getNom(), Toast.LENGTH_LONG).show();
            }
        });
        viewData();

    }
    public void viewData(){
        contacts = db.getContacts();
        contactArrayAdapter = new ArrayAdapter<Contact>(

               this, R.layout.contact_row, R.id.name_label, contacts
        );
        contact_listview.setAdapter(contactArrayAdapter);

    }

    public void insertContact(View view) {
        String name = ((EditText) findViewById(R.id.name_input)).getText().toString();
        String number = ((EditText) findViewById(R.id.name_input)).getText().toString();
        db.insertContact(new Contact(0,name, number));
        viewData();
        contactArrayAdapter.notifyDataSetChanged();
    }


    class Database extends SQLiteOpenHelper{
        private static final int VERSION = 1;
        private static final String DATABASE = "Contacts.db";
        private static final String TABLENAME = "Contact";
        private static final String COL_ID = "id";
        private static final String COL_NAME = "name";
        private static final String COL_NUMBER = "number";
        private static final String CREATE_RQT = "CREATE TABLE "+ TABLENAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME  + " TEXT, "
                + COL_NUMBER + " TEXT ); ";

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_RQT);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLENAME);
            onCreate(db);
        }



        public Database(Context context, SQLiteDatabase.CursorFactory factory) {
            super(context, DATABASE, factory, VERSION);
        }

        public boolean insertContact(Contact contact){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues content = new ContentValues();
            content.put(COL_NAME, contact.getNom());
            content.put(COL_NUMBER, contact.getNumero());

             return db.insert(TABLENAME,null,content) == 1;

        }

        public ArrayList<Contact> getContacts(){
            SQLiteDatabase db = this.getReadableDatabase();
            ArrayList<Contact> list = new ArrayList<>();
            Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLENAME, null);
            while(cursor.moveToNext()){
                list.add(new Contact(cursor.getInt(0), cursor.getString(1), cursor.getString(2) ));
            }
            return list;
        }

        public boolean deleteContact(int id){
            SQLiteDatabase db = this.getWritableDatabase();
            int count = db.delete(TABLENAME, COL_ID + " =?1", new String[]{String.valueOf(id)});
            db.close();
            return count >0;
        }

        public boolean deleteContact(String name){
            SQLiteDatabase db = this.getWritableDatabase();
            int count = db.delete(TABLENAME, COL_NAME + " =?1", new String[]{name});
            db.close();
            return count >0;
        }



    }
}
