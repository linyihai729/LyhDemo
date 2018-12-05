package calorierecorder.com.fragmentdemo.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import calorierecorder.com.fragmentdemo.R;
import calorierecorder.com.fragmentdemo.adapter.MessageAdapter;
import calorierecorder.com.fragmentdemo.base.BaseFragment;
import calorierecorder.com.fragmentdemo.bean.MessageBean;

public class MessageFragment extends BaseFragment {

    private String content;
    private RecyclerView rlvMessage;
    private MessageAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("live", "messageFragment++++++onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            content = bundle.getString("content", null);
        }
        Log.e("live", "messageFragment++++++onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // View view=inflater.inflate(R.layout.fragment_home,container,false);
        Log.e("live", "messageFragment++++++onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.e("live", "messageFragment++++++onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("live", "messageFragment++++++onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("live", "messageFragment++++++onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("live", "messageFragment++++++onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("live", "messageFragment++++++onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("live", "messageFragment++++++onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("live", "messageFragment++++++onDestroyView");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_message;
    }

    private List<MessageBean> messageBeanList = new ArrayList<>();

    @Override
    protected void initView(View view) {
        for (int i = 0; i < 10; i++) {
            messageBeanList.add(new MessageBean("赵丽颖" + i));
        }
        rlvMessage = view.findViewById(R.id.rlv_message);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rlvMessage.setLayoutManager(manager);
        mAdapter = new MessageAdapter(messageBeanList, getActivity());
        rlvMessage.setAdapter(mAdapter);
        itemTouchHelper.attachToRecyclerView(rlvMessage);
    }

    private int curren = 1;

    ItemTouchHelper.Callback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            // 获得滑动位置
            final int position = viewHolder.getAdapterPosition();

            if (direction == ItemTouchHelper.RIGHT) {
                // 弹窗确认
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("你确定要删除么？");

                builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // mAdapter.removeItem(position);
                        Toast.makeText(getContext(), "删除", Toast.LENGTH_SHORT).show();
                        // 刷新界面
                        //onResume();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        LinearLayout sonView = (LinearLayout) viewHolder.itemView;
//                        TextView grandsonTextView = (TextView) sonView.findViewById(R.id.iotem_date);
//                        // 判断是否应该显示时间
//                        if (sonView.findViewById(R.id.date_bar).getVisibility() == View.VISIBLE)
//                            GlobalVariables.setmDate("");
//                        else GlobalVariables.setmDate(ioAdapter.getItemDate(position));
//                        ioAdapter.notifyItemChanged(position);
                        Toast.makeText(getContext(), "取消", Toast.LENGTH_SHORT).show();
                    }
                }).show();  // 显示弹窗
            }
        }

    };
    ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);

    @Override
    protected void loadData() {
        Toast.makeText(getActivity(), "message" + "第" + curren++ + "请求", Toast.LENGTH_SHORT).show();
    }
}
