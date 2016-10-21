package teamtreehouse.com.stormy.adapters;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import teamtreehouse.com.stormy.R;
import teamtreehouse.com.stormy.weather.Day;

public class DayAdapter extends BaseAdapter {

    public static final String TAG = DayAdapter.class.getSimpleName();

    private Context mContext;
    private Day[] mDays;

    public DayAdapter (Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        Log.i(TAG, mDays.length + "");
        return mDays.length;
    }
    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    // we aren't going to use this, Tag item for easy reference.
    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            // brand new
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = mDays[position];
        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(day.getTemperatureMax() + "");
        holder.dayLabel.setText(day.getDayOfTheWeek());

        return convertView;
    }

    private static class ViewHolder{
        // public by default
        ImageView iconImageView;
        TextView temperatureLabel;
        TextView dayLabel;
    }
}












