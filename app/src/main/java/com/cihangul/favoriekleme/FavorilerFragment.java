package com.cihangul.favoriekleme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cihan on 1.11.2016.
 */

public class FavorilerFragment extends Fragment {

    public static ListView favoriListesi;
    public static List<Kisi> favoriList = new ArrayList<>();
    public static FavoriAdapter favoriAdapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favoriler_fragment, container, false);

        favoriListesi = (ListView) view.findViewById(R.id.favoriListView);
        favoriAdapter = new FavoriAdapter(getActivity(), favoriList);
        favoriListesi.setAdapter(favoriAdapter);

        return view;
    }

    public static void favorilereEkle(String mIsim, int mResim, int mFavResim) {
        favoriList.add(new Kisi(mIsim, mResim, mFavResim));
        favoriAdapter.notifyDataSetChanged();
    }

    public static void favoriSil(int position) {
        favoriList.remove(position);
        favoriAdapter.notifyDataSetChanged();
    }
}
