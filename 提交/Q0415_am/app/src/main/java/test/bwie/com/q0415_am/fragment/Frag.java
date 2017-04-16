package test.bwie.com.q0415_am.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import test.bwie.com.q0415_am.R;
import test.bwie.com.q0415_am.utils.GetJson;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag extends Fragment {

    private ListView listView;


    public String Json;
    String uri;
    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag,null);
        listView = (ListView) view.findViewById(R.id.lisview);
        GetJson getJson = new GetJson(getActivity(),listView);
        getJson.getJson(Json);


        return view;
    }

}
