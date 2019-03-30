package com.securesoftbd.iote_health.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.securesoftbd.iote_health.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {
        this.context  = context;
    }

    public int[] slide_images =
            {
                    R.drawable.temperature_icon,
                    R.drawable.skin_icon,
                    R.drawable.iot_doctor_icon,
                    R.drawable.cloud_icon,


            };

    public String[] slide_headings =
            {
                    "Temperature Measure",
                    "Skin Humidity",
                    "IOT Doctor",
                    "Cloud Grap"
            };

    public String[] slide_descs =
            {
                    "It can measure your temperature",
                    "It can measure your skin humidity",
                    "It can how your health condition through IOT in both android apps and Internet",
                    "It can save your body condition in cloud"
            };







    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view ==(RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //return super.instantiateItem(container, position);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = view.findViewById(R.id.imageId);
        TextView slideHeading = view.findViewById(R.id.headingId);
        TextView slideDescription = view.findViewById(R.id.detailsId);
try {


    slideImageView.setImageResource(slide_images[position]);
    slideHeading.setText(slide_headings[position]);
    slideDescription.setText(slide_descs[position]);

    container.addView(view);
}catch (Exception e)
{

}
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //  super.destroyItem(container, position, object);
        container.removeView((RelativeLayout) object);
    }
}