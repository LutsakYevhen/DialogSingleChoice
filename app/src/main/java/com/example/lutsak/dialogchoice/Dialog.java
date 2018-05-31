package com.example.lutsak.dialogchoice;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Dialog extends DialogFragment implements View.OnClickListener {

    private static final String LOG_TAG = Dialog.class.getSimpleName();

    private ListView mListView;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(LOG_TAG, "onCreateView");

        getDialog().setTitle(R.string.select_city);

        View v = inflater.inflate(R.layout.dialog,null);
        v.findViewById(R.id.ok_button).setOnClickListener(this);

        mListView = v.findViewById(R.id.dialog_list_view);
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(), R.array.city,
                android.R.layout.simple_list_item_single_choice);

        mListView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
