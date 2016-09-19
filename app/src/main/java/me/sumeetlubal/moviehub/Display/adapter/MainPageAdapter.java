package me.sumeetlubal.moviehub.display.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.sumeetlubal.moviehub.R;

/**
 * Created by SAM on 18-09-2016.
 */
public class MainPageAdapter extends PagerAdapter {
    private static final String TAG = "Pager";
    int count;
    public MainPageAdapter(Context context, int numberOfItem){
        mContext = context;
        count = numberOfItem;
    }
    Context mContext;
    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final View container, final int position, final Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = null;
        if(position==0){
            view = LayoutInflater.from(
                    mContext).inflate(R.layout.item_vp_list, null, false);
            Log.d(TAG,"Home pager clicked"); //for Home we are going with different Views
            final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view); //lets use common RV's here
            recyclerView.setLayoutManager(new LinearLayoutManager(
                            mContext, LinearLayoutManager.VERTICAL, false
                    )
            );
            RecycleAdapter recycleAdapter = new RecycleAdapter(mContext);
            recyclerView.setAdapter(recycleAdapter);
        }else{
            view = LayoutInflater.from(
                    mContext).inflate(R.layout.item_vp_list2, null, false);
            final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(
                            mContext, LinearLayoutManager.VERTICAL, false
                    )
            );
            recyclerView.setAdapter(new GridRecycleViewAdapter(mContext));
        }
        container.addView(view);
        return view;
    }
}
