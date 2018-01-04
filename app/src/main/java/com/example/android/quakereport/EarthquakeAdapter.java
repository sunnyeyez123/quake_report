package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jasmine on 1/2/18.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param earthquakes   A List of word objects to display in a list
     *
     */


    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        String location = currentEarthquake.getLocation();
        int index = location.indexOf("of");
        String primaryLocation  = location.substring(index+3, location.length()-1);
        String locationOffset = getContext().getString(R.string.near_the);

        if (index != -1){

            locationOffset = location.substring(0,index+2);
        }


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView

        offsetTextView.setText(locationOffset);


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        locationTextView.setText(primaryLocation);




        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView

        Date date = new Date(currentEarthquake.getDate());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String formattedDate= formatDate(date);

        dateTextView.setText(formattedDate);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView

        String formattedTime = formatTime(date);

        timeTextView.setText(formattedTime);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        magnitudeTextView.setText(String.valueOf(currentEarthquake.getMagnitude()));

       /* ImageView iconView = (ImageView) listItemView.findViewById(R.id.icon);

        if (currentEarthquake.hasImage()) {
            // Find the ImageView in the list_item.xml layout with the ID list_item_icon

            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentEarthquake.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);


        } else {

            iconView.setVisibility(View.GONE);
        }

        View background = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);

        background.setBackgroundColor(color);
*/


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
