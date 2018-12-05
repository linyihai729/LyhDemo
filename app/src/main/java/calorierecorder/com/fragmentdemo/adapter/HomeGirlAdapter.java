package calorierecorder.com.fragmentdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.common2.utils.GlideRoundTransform;

import java.util.List;

import calorierecorder.com.fragmentdemo.R;
import calorierecorder.com.fragmentdemo.bean.GirlBean;

public class HomeGirlAdapter extends RecyclerView.Adapter {
    private List<GirlBean.ResultsBean> mList;
    private Context mContext;
    private GirlViewHolder mHolder;

    public HomeGirlAdapter(List<GirlBean.ResultsBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rlv_home_items, parent, false);
        return new GirlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof GirlViewHolder) {
            mHolder = (GirlViewHolder) holder;
        }
        Glide.with(mContext)
                .load(mList.get(position).getUrl())
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .centerCrop()
                        //.override(60, 60)
                        //.transform(new GlideRoundTransform())
                        .placeholder(R.mipmap.color_default_header)
                        .error(R.mipmap.color_default_header))
                .into(mHolder.img);
        mHolder.tvDes.setText(mList.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class GirlViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tvDes;

        public GirlViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.rlv_img_girl);
            tvDes = itemView.findViewById(R.id.rlv_txt_des);
        }
    }
}
