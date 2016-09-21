package me.sumeetlubal.moviehub.display.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import me.sumeetlubal.moviehub.R;
import me.sumeetlubal.moviehub.display.model.SectionDataModel;
import me.sumeetlubal.moviehub.display.model.SingleItemModel;
import me.sumeetlubal.moviehub.librarymanager.API;
import me.sumeetlubal.moviehub.librarymanager.internalevents.NotifyCompleteEvent;
import me.sumeetlubal.moviehub.librarymanager.internalevents.WorkRequstEvent;

import static me.sumeetlubal.moviehub.librarymanager.internalevents.NotifyCompleteEvent.*;

/**
 * Created by SAM on 18-09-2016.
 */
class HomeScreenRecycleAdapter extends RecyclerView.Adapter<HomeScreenRecycleAdapter.SingleItemRowHolder> {
    private static final String TAG = "HomeScreenAdapter";
    private List<SectionDataModel> dataList;
    private Context mContext;

    HomeScreenRecycleAdapter(Context context) {
        EventBus.getDefault().register(this);
        mContext = context;
        dataList = new ArrayList<>();
        //populate data here using fetcher async task
        //meanwhile we can display progress bar or older data
       new FetchData().execute();
        //createDummyData();
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }
    private void createDummyData() {
        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            dataList.add(dm);

        }
    }
    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {


        final String sectionName = dataList.get(i).getHeaderTitle();

        ArrayList<SingleItemModel> singleSectionItems = dataList.get(i).getAllItemsInSection();

        holder.itemTitle.setText(sectionName);

        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

        holder.recycler_view_list.setHasFixedSize(true);
        holder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.recycler_view_list.setAdapter(itemListDataAdapter);


        holder.recycler_view_list.setNestedScrollingEnabled(false);


       /*  itemRowHolder.recycler_view_list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        //Allow ScrollView to intercept touch events once again.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                // Handle RecyclerView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });*/

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "click event on more, " + sectionName, Toast.LENGTH_SHORT).show();
            }
        });







       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        if(dataList ==null){
            return 0;
        }
        return dataList.size();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NotifyCompleteEvent event) {
        dataList = event.getResult();
        notifyDataSetChanged();
    }
    class SingleItemRowHolder extends RecyclerView.ViewHolder {

        TextView itemTitle;

        RecyclerView recycler_view_list;

        Button btnMore;


        SingleItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            this.btnMore = (Button) view.findViewById(R.id.btnMore);


        }

    }
    private class FetchData extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            //get data from either DB or internet
            //get different data models
            API.APIBuilder builder = new API.APIBuilder();
            builder.APIKey(API.API_KEY_CINEMALYTICS)
                    .DBType(API.DBTYPE.DB_CINEMALYTICS)
                    .Language(API.LANGUAGES.LANGUAGE_ENGLISH)
                    .build();
            //TODO:add simple offline fetched movies to API class
            EventBus.getDefault().post(new WorkRequstEvent(NotifyCompleteEventType.POPULAR));
            Log.d(TAG,"Hey I am done");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d(TAG,"Lets add something");

            //update the list to
            //update data to list
            notifyDataSetChanged();
        }
    }

}
