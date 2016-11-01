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

public class FavoriAdapter extends BaseAdapter{
    public LayoutInflater layoutInflater;
    public List<Kisi> favoriList;
    public Activity activity;

    public FavoriAdapter(Activity mActivity,List<Kisi> mFavoriList){
        layoutInflater=(LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        favoriList=mFavoriList;
        activity=mActivity;
    }


    @Override
    public int getCount() {
        return favoriList.size();
    }

    @Override
    public Object getItem(int position) {
        return favoriList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view =layoutInflater.inflate(R.layout.favori_satir,null);

        final ImageView kisiResim = (ImageView) view.findViewById(R.id.f_kisi_resmi);
        final ImageView kisiFavResim = (ImageView) view.findViewById(R.id.f_kisi_fav_resim);
        final TextView kisiIsim =(TextView)view.findViewById(R.id.f_kisi_ismi);

        final Kisi kisi =favoriList.get(position);

        kisiResim.setImageResource(kisi.getKisiResim());
        kisiFavResim.setImageResource(kisi.getKisiFavResim());
        kisiIsim.setText(kisi.getKisIsim());

        kisiFavResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavorilerFragment.favoriSil(position);
            }
        });



        return view;
    }
}
