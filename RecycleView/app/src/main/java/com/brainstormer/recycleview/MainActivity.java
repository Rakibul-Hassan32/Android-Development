package com.brainstormer.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //to work with recyclerview and manage number of items

RecyclerView recyclerView;
RecyclerContactAdapter adapter;
FloatingActionButton btnOpenDialog;
//we put ContactModel in the arraylist because we have the structure in ContactModel class
ArrayList<ContactModel> arrContacts=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerContact);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);



        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber=dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="",number="";
                        if(!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please enter contact name", Toast.LENGTH_SHORT).show();
                        }

                        if(!edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please enter contact name", Toast.LENGTH_SHORT).show();
                        }
                        arrContacts.add(new ContactModel(R.drawable.contact,name,number));
                        adapter.notifyItemInserted(arrContacts.size()-1);
                        recyclerView.scrollToPosition(arrContacts.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });





        //layout manager to set how to show the view(recyclerview needs to be must indicated)
       recyclerView.setLayoutManager(new LinearLayoutManager(this));

       //create a layout(xml) which we will use again and again
        //create the structure class and create that much variable that we can show it in the xml class

        //then put data's in that arraylist
        /*
        ContactModel model = new new ContactModel(R.drawable.contact,"Rakibul","01824319780");
        arrContacts.add(model);
        */

        //or we can do it directly
        arrContacts.add(new ContactModel(R.drawable.contact,"Rakibul","01824319780"));
        arrContacts.add(new ContactModel(R.drawable.female,"Afroja","01589319780"));
        arrContacts.add(new ContactModel(R.drawable.child,"Arif","01023619780"));
        arrContacts.add(new ContactModel(R.drawable.old_women,"Jenat","02896329780"));
        arrContacts.add(new ContactModel(R.drawable.old_man,"Miraj","017893023480"));
        arrContacts.add(new ContactModel(R.drawable.contact,"Soyad","01824319780"));
        arrContacts.add(new ContactModel(R.drawable.female,"Sinthiya","01589319780"));
        arrContacts.add(new ContactModel(R.drawable.child,"Gopal","01023619780"));
        arrContacts.add(new ContactModel(R.drawable.old_women,"Fatema","02896329780"));
        arrContacts.add(new ContactModel(R.drawable.old_man,"Habib","017893023480"));
        arrContacts.add(new ContactModel(R.drawable.contact,"Hanif","01824319780"));
        arrContacts.add(new ContactModel(R.drawable.female,"Rimi","01589319780"));
        arrContacts.add(new ContactModel(R.drawable.child,"Saijid","01023619780"));
        arrContacts.add(new ContactModel(R.drawable.old_women,"Atika","02896329780"));
        arrContacts.add(new ContactModel(R.drawable.old_man,"Nabil","017893023480"));
        arrContacts.add(new ContactModel(R.drawable.contact,"Nijhum","01824319780"));
        arrContacts.add(new ContactModel(R.drawable.female,"Sayla","01589319780"));
        arrContacts.add(new ContactModel(R.drawable.child,"Borhan","01023619780"));
        arrContacts.add(new ContactModel(R.drawable.old_women,"Tanjina","02896329780"));
        arrContacts.add(new ContactModel(R.drawable.old_man,"Parvez","017893023480"));
        arrContacts.add(new ContactModel(R.drawable.contact,"Siyam","01824319780"));
        arrContacts.add(new ContactModel(R.drawable.female,"Tanjila","01589319780"));
        arrContacts.add(new ContactModel(R.drawable.child,"Yunus","01023619780"));
        arrContacts.add(new ContactModel(R.drawable.old_women,"Silpi","02896329780"));
        arrContacts.add(new ContactModel(R.drawable.old_man,"Morsalin","017893023480"));



        //we will not call the adapter again and again, we will call it totally
        //so, created a java class to create adapter of the full view
        adapter= new RecyclerContactAdapter(this,arrContacts);
        //adapter1= new RecyclerAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);


    }
}