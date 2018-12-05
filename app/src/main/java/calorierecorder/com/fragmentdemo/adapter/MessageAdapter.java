package calorierecorder.com.fragmentdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import calorierecorder.com.fragmentdemo.R;
import calorierecorder.com.fragmentdemo.bean.MessageBean;

public class MessageAdapter extends RecyclerView.Adapter {
    private List<MessageBean> mList;
    private Context mContext;
    private MessageHolder mHolder;

    public MessageAdapter(List<MessageBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rlv_message_item, parent, false);
        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MessageHolder) {
            mHolder = (MessageHolder) holder;
        }
        mHolder.name.setText(mList.get(position).getName()+"");
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class MessageHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public MessageHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rlv_message_tex);
        }
    }
}
