
package com.andrew.apollo;

import com.andrew.apollo.remote.IMusicPlaybackService;

/**
 * Listens for playback changes to send the the fragments bound to this activity
 */
public interface MusicStateListener {

    /**
     * Called when {@link IMusicPlaybackService#REFRESH} is invoked
     */
    public void restartLoader();

    /**
     * Called when {@link IMusicPlaybackService#META_CHANGED} is invoked
     */
    public void onMetaChanged();

}
