package com.example.pspsapps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.pspsapps._sliders.FragmentSlider;
import com.example.pspsapps._sliders.SliderIndicator;
import com.example.pspsapps._sliders.SliderPagerAdapter;
import com.example.pspsapps._sliders.SliderView;

import java.util.ArrayList;
import java.util.List;


public class ClubFragment extends Fragment {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_club,container,false);

        sliderView = (SliderView) view.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
        setupSlider();

        Button btnSejarah =(Button)view.findViewById(R.id.btnSejarah);
        Button btnPemain =(Button)view.findViewById(R.id.btnPemain);


        btnSejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new SejarahFragment());
                fr.addToBackStack(null).commit();
            }
        });
        btnPemain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new PemainFragment());
                fr.addToBackStack(null).commit();
            }
        });
        return view;
    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://pspsapps.000webhostapp.com/slide/gambar2.png"));
        fragments.add(FragmentSlider.newInstance("https://pspsapps.000webhostapp.com/slide/gambar3.png"));
        fragments.add(FragmentSlider.newInstance("https://pspsapps.000webhostapp.com/slide/gambar1.png"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}
