package com.myleanback.widget;

import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;

/**
 * Interface for schedule task on a ViewHolder.
 */
public interface ViewHolderTask {
    /**
     * Runs the task.
     */
    void run(@NonNull RecyclerView.ViewHolder viewHolder);
}
