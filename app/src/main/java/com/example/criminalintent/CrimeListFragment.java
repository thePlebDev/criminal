package com.example.criminalintent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // the container is the parent view. If Attach to view was true then we would attach to that
        // false means that we inflate and return our R.layout.fragment_crime_list view
        //the root can also be container. I put null just to clarify that we do not need it.
                             View view = inflater.inflate(R.layout.fragment_crime_list,null,false);


                             mCrimeRecyclerView = (RecyclerView) view
                                     .findViewById(R.id.crime_recycler_view);//getting the RecyclerView

                             //Sets the layout manager, determining the position and when to recycle the view
                            //Linear layout manager makes this scrollable in the current activity
                             mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                             updateUI();

                             //this view is what we are going to see
                             return view;
    }

    private void updateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes(); //all the crimes from current activity

        mAdapter = new CrimeAdapter(crimes); //creating the adapter
        mCrimeRecyclerView.setAdapter(mAdapter);//adding the adapter to the view
    }

    private class CrimeHolder extends RecyclerView.ViewHolder{
        //this provides all the functionality for your list items;
        //states how our individual views in the list are going to look.
        public TextView mTitleTextView;

        public CrimeHolder(View itemView){
            super(itemView);

            mTitleTextView = (TextView) itemView;
        }
    }
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        // creates view holder objects as needed. And gives them data

        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes){
            mCrimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //creates the an empty viewHolder
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(android.R.layout.simple_list_item_1,parent,false);
            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            //receives the view holder and the position in your data set.
            Crime crime = mCrimes.get(position); // get the data
            holder.mTitleTextView.setText(crime.getmTitle()); //update the view holder

        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }

}
