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

public class KisilerFragment extends Fragment{
    ListView kisiListesi;
    List<Kisi> kisiList;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.kisiler_fragment,container,false);

        kisiListesi=(ListView)view.findViewById(R.id.kisi_list_view);

        kisiList = new ArrayList<>();
        kisiList.add(new Kisi("Cihan Gül",R.drawable.ic_launcher,R.drawable.ic_favoriler));
        kisiList.add(new Kisi("Cihan Gül",R.drawable.ic_launcher,R.drawable.ic_favoriler));
        kisiList.add(new Kisi("Cihan Gül",R.drawable.ic_launcher,R.drawable.ic_favoriler));

        KisiAdapter kisiAdapter = new KisiAdapter(getActivity(),kisiList);
        kisiListesi.setAdapter(kisiAdapter);


        return view;
    }
}
