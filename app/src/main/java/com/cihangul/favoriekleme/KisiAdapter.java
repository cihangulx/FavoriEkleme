package com.cihangul.favoriekleme;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cihan on 1.11.2016.
 */

public class KisiAdapter extends BaseAdapter {

    public LayoutInflater layoutInflater;
    public List<Kisi> kisiList;
    public Activity activity;

    public KisiAdapter(Activity mActivity,List<Kisi> mKisi){
        layoutInflater=(LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        kisiList=mKisi;
        activity=mActivity;
    }


    @Override
    public int getCount() {
        return kisiList.size();
    }

    @Override
    public Object getItem(int position) {
        return kisiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.kisi_list_satir,null);


        final ImageView kisiResim = (ImageView) view.findViewById(R.id.kisi_resmi);
        final ImageView kisiFavResim = (ImageView) view.findViewById(R.id.kisi_fav_resim);
        final TextView kisiIsim =(TextView)view.findViewById(R.id.kisi_ismi);

        final Kisi kisi =kisiList.get(position);

        kisiResim.setImageResource(kisi.getKisiResim());
        kisiFavResim.setImageResource(kisi.getKisiFavResim());
        kisiIsim.setText(kisi.getKisIsim());

        kisiFavResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavorilerFragment.favorilereEkle(kisi.getKisIsim(),kisi.getKisiResim(),R.drawable.ic_red_favoriler);
            }
        });

        return view;
    }
}
