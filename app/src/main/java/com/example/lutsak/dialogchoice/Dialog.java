package com.example.lutsak.dialogchoice;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Dialog extends DialogFragment implements View.OnClickListener, DialogListener {

    private static final String LOG_TAG = Dialog.class.getSimpleName();


    private ListView mListView;
    private DialogListener mDialogListener;

    //create our own dialog.
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(LOG_TAG, ">> onCreateView");

        //set title of dialog.
        getDialog().setTitle(R.string.select_city);

        //inflate view from dialog layout.
        View view = inflater.inflate(R.layout.dialog, null);
        view.findViewById(R.id.ok_button).setOnClickListener(this);

        //set single mode choice from list on dialog.
        mListView = view.findViewById(R.id.dialog_list_view);
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //create adapter using resource data and set it on our listView.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(), R.array.city,
                android.R.layout.simple_list_item_single_choice);

        mListView.setAdapter(adapter);

        Log.d(LOG_TAG, "<< onCreateView");
        return view;
    }

    @Override
    public void onAttach(Context context) {
        Log.d(LOG_TAG, "onAttach");
        super.onAttach(context);
        try {
            mDialogListener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must implement DialogListener!");
        }
    }

    //by clicking on our ok button we are going to get checked item and send it to MainActivity.
    @Override
    public void onClick(View v) {
        Log.d(LOG_TAG, "onClick");
        mDialogListener.checkedId(mListView.getCheckedItemPosition());
        dismiss();//close our dialog
    }

    @Override
    public void checkedId(int position) {
    }
}
