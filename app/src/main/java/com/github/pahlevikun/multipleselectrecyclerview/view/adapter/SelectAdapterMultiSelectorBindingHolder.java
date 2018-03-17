package com.github.pahlevikun.multipleselectrecyclerview.view.adapter;

import android.support.v7.widget.RebindReportingHolder;
import android.view.View;

import com.bignerdranch.android.multiselector.MultiSelector;
import com.bignerdranch.android.multiselector.SelectableHolder;

/**
 * Created by farhan on 3/17/18.
 */

public abstract class SelectAdapterMultiSelectorBindingHolder extends RebindReportingHolder implements SelectableHolder {
    private final MultiSelector mMultiSelector;

    public SelectAdapterMultiSelectorBindingHolder(View itemView, MultiSelector multiSelector) {
        super(itemView);
        mMultiSelector = multiSelector;
    }

    @Override
    protected void onRebind() {
        mMultiSelector.bindHolder(this, getAdapterPosition(), getItemId());
    }
}