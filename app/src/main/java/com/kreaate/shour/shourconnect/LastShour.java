package com.kreaate.shour.shourconnect;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LastShour.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LastShour#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class LastShour extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_POSITION = "position";
    private static final String ARG_TITLE = "title";

    private static final String TAB1 = "tab1";
    private static final String TAB2 = "tab2";
    private static final String TAB3 = "tab3";

    // TODO: Rename and change types of parameters
    private int position;
    private String title;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LastShour.
     */
    // TODO: Rename and change types and number of parameters
    public static LastShour newInstance(int position, String title) {
        LastShour fragment = new LastShour();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }
    public LastShour() {
        // Required empty public constructor
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
        Bundle args = new Bundle();
        args.putInt (ARG_POSITION, position);
        args.putString(ARG_TITLE, title);
        setArguments(args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION);
            title = getArguments().getString(ARG_TITLE);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_last_shour, container, false);
        setupTabs(view);
        /*
        TabHost tabHost = (TabHost)view.findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Tab1");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Tab2");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("Tab3");


        View v1 = LayoutInflater.from(tabHost.getContext()).inflate(R.layout.last_shour_tab_indicator, null);
        TextView tv1_1 = (TextView)v1.findViewById (R.id.last_shour_tab_indicator);
        TextView tv2_1 = (TextView)v1.findViewById (R.id.last_shour_tab_subtext);
        tv1_1.setText ("48");
        tv2_1.setText ("Litres");

        //v1.inflate(view.getContext(), R.layout.simple_text_view, (ViewGroup)view);
        tab1.setIndicator(v1);
        //tab1.setIndicator("Tab 1");
        //tab1.setIndicator(view.findViewById(R.id.simple_text_view));
        TabHost.TabContentFactory tabCont = new tabContent (view.getContext());
        tab1.setContent(tabCont);

        //tab2.setIndicator ("Tab 2");
        View v2 = LayoutInflater.from(tabHost.getContext()).inflate(R.layout.last_shour_tab_indicator, null);
        TextView tv1_2 = (TextView)v2.findViewById (R.id.last_shour_tab_indicator);
        TextView tv2_2 = (TextView)v2.findViewById(R.id.last_shour_tab_subtext);
        tv1_2.setText("35");
        tv2_2.setText ("degrees");
        tab2.setIndicator (v2);

        tab2.setContent(new tabContent(view.getContext()));


        View v3 = LayoutInflater.from(tabHost.getContext()).inflate(R.layout.last_shour_tab_indicator, null);
        TextView tv1_3 = (TextView)v3.findViewById (R.id.last_shour_tab_indicator);
        TextView tv2_3 = (TextView)v3.findViewById(R.id.last_shour_tab_subtext);
        tv1_3.setText("0.1");
        tv2_3.setText ("dollars");

        tab3.setIndicator (v3);
        //tab3.setIndicator ("Tab 3");
        tab3.setContent(new tabContent(view.getContext()));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        */


        return view;
    }

    private void setupTabs (View view)
    {

        String text;
        String subText;
        TabHost tabHost = (TabHost)view.findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec(TAB1);
        TabHost.TabSpec tab2 = tabHost.newTabSpec(TAB2);
        TabHost.TabSpec tab3 = tabHost.newTabSpec(TAB3);

        tab1.setIndicator (createTabIndicator("80", "L I T E R S", tabHost));
        tab2.setIndicator (createTabIndicator("35", "D E G R E E S", tabHost));
        tab3.setIndicator (createTabIndicator("0.1", "D O L L A R S", tabHost));

        tab1.setContent (new tabContent(view.getContext()));
        tab2.setContent (new tabContent(view.getContext()));
        tab3.setContent (new tabContent(view.getContext()));

        tabHost.addTab (tab1);
        tabHost.addTab (tab2);
        tabHost.addTab (tab3);

    }

    private View createTabIndicator (String text, String subText, TabHost host){
        View view = LayoutInflater.from(host.getContext()).inflate(R.layout.last_shour_tab_indicator, null);
        TextView tv1 = (TextView)view.findViewById(R.id.last_shour_tab_text);
        TextView tv2 = (TextView)view.findViewById(R.id.last_shour_tab_subtext);
        tv1.setText (text);
        tv2.setText(subText);
        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*    @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            try {
                mListener = (OnFragmentInteractionListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }
    */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

    public class tabContent implements TabHost.TabContentFactory
    {
        private Context mContext;

        //Note that tag will always be the "tag" of the tagSpec when its initialized. Not its
        //indicator
        public View createTabContent (String tag)
        {
            View view;// = new View (mContext);
            TextView tv1, tv1_2, tv2, tv2_2, tv3, tv3_2;

            view = LayoutInflater.from(mContext).inflate(R.layout.last_shour_tab_content, null);
            tv1 = (TextView)view.findViewById(R.id.last_shour_tab_content1_left);
            tv1_2 = (TextView)view.findViewById(R.id.last_shour_tab_content1_right);
            tv2 = (TextView)view.findViewById(R.id.last_shour_tab_content2_left);
            tv2_2 = (TextView)view.findViewById(R.id.last_shour_tab_content2_right);
            tv3 = (TextView)view.findViewById(R.id.last_shour_tab_content3_left);
            tv3_2 = (TextView)view.findViewById(R.id.last_shour_tab_content3_right);

            //view.setMinimumHeight(0);
            //view.setMinimumWidth(0);
            Log.d (tag, tag);
            if (tag.equalsIgnoreCase(TAB1)){
                    tv1.setText ("~40 ");
                    tv1_2.setText("Days of quenched thirst");
                    tv2.setText ("~13 ");
                    tv2_2.setText("Full Toilet Flushes");
                    tv3.setText ("~34 ");
                    tv3_2.setText("Septillion molecules of water");}
            else if (tag.equalsIgnoreCase(TAB2)) {
                tv1.setText("BlahBlahBlah2");
                tv2.setText("BlahBlahBlah2");
                tv3.setText("BlahBlahBlah2");
            }else if (tag.equalsIgnoreCase(TAB3)) {
                tv1.setText("BlahBlahBlah3");
                tv2.setText("BlahBlahBlah3");
                tv3.setText("BlahBlahBlah3");
            }else {}
            return view;
        }

        public tabContent (Context context)
        {
            mContext = context;
        }
    }

}