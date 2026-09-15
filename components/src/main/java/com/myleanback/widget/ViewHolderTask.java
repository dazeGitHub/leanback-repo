package com.myleanback.widget;

import androidx.recyclerview.widget.RecyclerView;

import org.jspecify.annotations.NonNull;

/**
 * Interface for schedule task on a ViewHolder.
 */
public interface ViewHolderTask {
    /**
     * Runs the task.
     */
    void run(RecyclerView.@NonNull ViewHolder viewHolder);
}
