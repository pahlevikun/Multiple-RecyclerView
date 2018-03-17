package com.github.pahlevikun.multipleselectrecyclerview.presenter.interfaces;

import android.view.View;

/**
 * Created by farhan on 3/17/18.
 */

public interface OnItemClickInterface {
    void onItemClick(View view, int position);

    void onItemLongClick(View view, int position);
}
