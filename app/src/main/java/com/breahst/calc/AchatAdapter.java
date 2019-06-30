package com.breahst.calc;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class AchatAdapter extends ArrayAdapter<Achat> {

    private ArrayList<Achat> achats;
    private Activity context;


    public AchatAdapter(Activity context, int ressource, ArrayList<Achat> achats) {
        super(context,ressource, achats);
        this.achats = achats;
        this.context = context;
        Log.i("TAG", "AchatAdapter");
        for (Achat a: achats) {
        Log.i("TAG", a.getItem());
    }
}



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.lv_item, null);

        }
        TextView item = convertView.findViewById(R.id.item_label);
        TextView qte = convertView.findViewById(R.id.item_qte);

        item.setText(achats.get(position).getItem());
        qte.setText(String.format("%d", achats.get(position).getQte()));
        ImageButton btn = convertView.findViewById(R.id.btn_delete_lv_item);

        final int i = position;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                dele(i);
            }
        });
        return convertView;


    }

    public void dele(int position){
        achats.remove(position);
        this.notifyDataSetChanged();
    }




}
