package top.ttxxly.novel.ui.fragment.user;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.ttxxly.novel.R;
import top.ttxxly.novel.base.BaseFragment;

public class UserFragment extends BaseFragment {

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }


}
