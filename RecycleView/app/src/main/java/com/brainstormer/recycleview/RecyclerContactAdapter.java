package com.brainstormer.recycleview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

                                  //this will create view in runtime
//this class will only be used as an adopter if we inherit both the Recyclerview class
//and Adapter class where we need a viewholder
//so we also need a ViewHolder class
public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {


    //create global variable and use it as default constructor to work anywhere
    Context context;
    ArrayList<ContactModel> arrContacts;
    private  int lastPosition = -1;
    RecyclerContactAdapter(Context context,ArrayList<ContactModel> arrContacts){
        this.context=context;
        this.arrContacts=arrContacts;
    }

    //starting view

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //push the view first using inflater class
       View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);//call the layout, get the layout default size, to make it scrollable we have to make it false(or it will be attached which canceled the concept of recycler view
      ViewHolder viewHolder = new ViewHolder(view);//then crate ViewHolder class's object and pass it
        return viewHolder;
    }


    //set data here and holder class holds data here
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ContactModel model = (ContactModel) arrContacts.get(position);
        holder.imgContact.setImageResource(arrContacts.get(position).img);//id from contactRow.xml and match the position and image, which will bring the model here
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);


       setAnimation(holder.itemView, position);
       holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber=dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                TextView txtView = dialog.findViewById(R.id.txtTitle);

                txtView.setText("Update Contact");
                btnAction.setText("Update");
                edtName.setText(arrContacts.get(position).name);
                edtNumber.setText(arrContacts.get(position).number);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="",number="";
                        if(!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                        }
                        else{
                            Toast.makeText(context, "Please enter contact name", Toast.LENGTH_SHORT).show();
                        }

                        if(!edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        }
                        else{
                            Toast.makeText(context, "Please enter contact name", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.set(position, new ContactModel(arrContacts.get(position).img,name,number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure want to delete?")
                        .setIcon(R.drawable.ic_baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arrContacts.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();

                return true;
            }
        });

    }


    //total item count or my loop last item(total size of array)
    @Override
    public int getItemCount() {
        return arrContacts.size();
    }


    //craete view holder class
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtNumber;
        ImageView imgContact;
        LinearLayout llrow;
        //pass the items here
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
            llrow=itemView.findViewById(R.id.llrow);

        }
    }
    private void setAnimation(View viewToAnimate, int position){
        if(position > lastPosition) {
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(slideIn);
            lastPosition = position;
        }
    }
}
