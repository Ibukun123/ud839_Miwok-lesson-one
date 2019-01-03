package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.media.Image;
import android.provider.UserDictionary;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    //set color resource id
    private int mcolorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mcolorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // check if list item is being reused if not inflate view
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.list_view, parent, false);
        }


        Word currentWord = getItem(position);

        //find view called with id Image in layout
        ImageView image = (ImageView) v.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            //get data and set on the image view
            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        } else {
            //hide image and set visibility to gone
            image.setVisibility(View.GONE);
        }
        //find view called with id miworkTextView in layout
        TextView miworkTextView = (TextView) v.findViewById(R.id.miwork_text_view);

        //get data and set on the text view
        miworkTextView.setText(currentWord.getMiworkTranslation());

        //find view called with id defaultTextView in layout
        TextView defaultTextView = (TextView) v.findViewById(R.id.default_text_view);

        //get data and set on the text view
        defaultTextView.setText(currentWord.getDefaultTranslation());

        //set the theme color for the list view
        View textContainer = v.findViewById(R.id.text_container);

        //find the color to the resource id maps to
       int color = ContextCompat.getColor(getContext(), mcolorResourceId);

       //set the background color
       textContainer.setBackgroundColor(color);
        return v;
    }
}