
package com.andrew.apollo.remote;

import com.andrew.apollo.MediaButtonIntentReceiver;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.IBinder;

public interface IMusicPlaybackService {

    /**
     * Indicates that the music has paused or resumed
     */
    public static final String PLAYSTATE_CHANGED = "com.andrew.apollo.playstatechanged";
    /**
     * Indicates that music playback position within
     * a title was changed
     */
    public static final String POSITION_CHANGED = "com.android.apollo.positionchanged";
    /**
     * Indicates the meta data has changed in some way, like a track change
     */
    public static final String META_CHANGED = "com.andrew.apollo.metachanged";
    /**
     * Indicates the queue has been updated
     */
    public static final String QUEUE_CHANGED = "com.andrew.apollo.queuechanged";
    /**
     * Indicates the repeat mode chaned
     */
    public static final String REPEATMODE_CHANGED = "com.andrew.apollo.repeatmodechanged";
    /**
     * Indicates the shuffle mode chaned
     */
    public static final String SHUFFLEMODE_CHANGED = "com.andrew.apollo.shufflemodechanged";
    /**
     * For backwards compatibility reasons, also provide sticky
     * broadcasts under the music package
     */
    public static final String APOLLO_PACKAGE_NAME = "com.andrew.apollo";
    public static final String MUSIC_PACKAGE_NAME = "com.android.music";
    /**
     * Called to indicate a general service commmand. Used in
     * {@link MediaButtonIntentReceiver}
     */
    public static final String SERVICECMD = "com.andrew.apollo.musicservicecommand";
    /**
     * Called to go toggle between pausing and playing the music
     */
    public static final String TOGGLEPAUSE_ACTION = "com.andrew.apollo.togglepause";
    /**
     * Called to go to pause the playback
     */
    public static final String PAUSE_ACTION = "com.andrew.apollo.pause";
    /**
     * Called to go to stop the playback
     */
    public static final String STOP_ACTION = "com.andrew.apollo.stop";
    /**
     * Called to go to the previous track
     */
    public static final String PREVIOUS_ACTION = "com.andrew.apollo.previous";
    /**
     * Called to go to the next track
     */
    public static final String NEXT_ACTION = "com.andrew.apollo.next";
    /**
     * Called to change the repeat mode
     */
    public static final String REPEAT_ACTION = "com.andrew.apollo.repeat";
    /**
     * Called to change the shuffle mode
     */
    public static final String SHUFFLE_ACTION = "com.andrew.apollo.shuffle";
    /**
     * Called to update the service about the foreground state of Apollo's activities
     */
    public static final String FOREGROUND_STATE_CHANGED = "com.andrew.apollo.fgstatechanged";
    public static final String NOW_IN_FOREGROUND = "nowinforeground";
    /**
     * Used to easily notify a list that it should refresh. i.e. A playlist
     * changes
     */
    public static final String REFRESH = "com.andrew.apollo.refresh";
    /**
     * Called to update the remote control client
     */
    public static final String UPDATE_LOCKSCREEN = "com.andrew.apollo.updatelockscreen";
    public static final String CMDNAME = "command";
    public static final String CMDTOGGLEPAUSE = "togglepause";
    public static final String CMDSTOP = "stop";
    public static final String CMDPAUSE = "pause";
    public static final String CMDPLAY = "play";
    public static final String CMDPREVIOUS = "previous";
    public static final String CMDNEXT = "next";
    public static final String CMDNOTIF = "buttonId";
    /**
     * Moves a list to the front of the queue
     */
    public static final int NOW = 1;
    /**
     * Moves a list to the next position in the queue
     */
    public static final int NEXT = 2;
    /**
     * Moves a list to the last position in the queue
     */
    public static final int LAST = 3;
    /**
     * Shuffles no songs, turns shuffling off
     */
    public static final int SHUFFLE_NONE = 0;
    /**
     * Shuffles all songs
     */
    public static final int SHUFFLE_NORMAL = 1;
    /**
     * Party shuffle
     */
    public static final int SHUFFLE_AUTO = 2;
    /**
     * Turns repeat off
     */
    public static final int REPEAT_NONE = 0;
    /**
     * Repeats the current track in a list
     */
    public static final int REPEAT_CURRENT = 1;
    /**
     * Repeats all the tracks in a list
     */
    public static final int REPEAT_ALL = 2;

    /**
     * {@inheritDoc}
     */
    IBinder onBind(Intent intent);

    /**
     * {@inheritDoc}
     */
    boolean onUnbind(Intent intent);

    /**
     * {@inheritDoc}
     */
    void onRebind(Intent intent);

    /**
     * {@inheritDoc}
     */
    void onCreate();

    /**
     * {@inheritDoc}
     */
    void onDestroy();

    /**
     * {@inheritDoc}
     */
    int onStartCommand(Intent intent, int flags, int startId);

    /**
     * Called when we receive a ACTION_MEDIA_EJECT notification.
     *
     * @param storagePath The path to mount point for the removed media
     */
    void closeExternalStorageFiles(String storagePath);

    /**
     * Registers an intent to listen for ACTION_MEDIA_EJECT notifications. The
     * intent will call closeExternalStorageFiles() if the external media is
     * going to be ejected, so applications can clean up any files they have
     * open.
     */
    void registerExternalStorageListener();

    /**
     * Opens a file and prepares it for playback
     *
     * @param path The path of the file to open
     */
    boolean openFile(String path);

    /**
     * Returns the audio session ID
     *
     * @return The current media player audio session ID
     */
    int getAudioSessionId();

    /**
     * Indicates if the media storeage device has been mounted or not
     *
     * @return 1 if Intent.ACTION_MEDIA_MOUNTED is called, 0 otherwise
     */
    int getMediaMountedCount();

    /**
     * Returns the shuffle mode
     *
     * @return The current shuffle mode (all, party, none)
     */
    int getShuffleMode();

    /**
     * Returns the repeat mode
     *
     * @return The current repeat mode (all, one, none)
     */
    int getRepeatMode();

    /**
     * Removes all instances of the track with the given ID from the playlist.
     *
     * @param id The id to be removed
     * @return how many instances of the track were removed
     */
    int removeTrack(long id);

    /**
     * Removes the range of tracks specified from the play list. If a file
     * within the range is the file currently being played, playback will move
     * to the next file after the range.
     *
     * @param first The first file to be removed
     * @param last The last file to be removed
     * @return the number of tracks deleted
     */
    int removeTracks(int first, int last);

    /**
     * Returns the position in the queue
     *
     * @return the current position in the queue
     */
    int getQueuePosition();

    /**
     * Returns the path to current song
     *
     * @return The path to the current song
     */
    String getPath();

    /**
     * Returns the album name
     *
     * @return The current song album Name
     */
    String getAlbumName();

    /**
     * Returns the song name
     *
     * @return The current song name
     */
    String getTrackName();

    /**
     * Returns the artist name
     *
     * @return The current song artist name
     */
    String getArtistName();

    /**
     * Returns the artist name
     *
     * @return The current song artist name
     */
    String getAlbumArtistName();

    /**
     * Returns the album ID
     *
     * @return The current song album ID
     */
    long getAlbumId();

    /**
     * Returns the artist ID
     *
     * @return The current song artist ID
     */
    long getArtistId();

    /**
     * Returns the current audio ID
     *
     * @return The current track ID
     */
    long getAudioId();

    /**
     * Seeks the current track to a specific time
     *
     * @param position The time to seek to
     * @return The time to play the track at
     */
    long seek(long position);

    /**
     * Returns the current position in time of the currenttrack
     *
     * @return The current playback position in miliseconds
     */
    long position();

    /**
     * Returns the full duration of the current track
     *
     * @return The duration of the current track in miliseconds
     */
    long duration();

    /**
     * Returns the queue
     *
     * @return The queue as a long[]
     */
    long[] getQueue();

    /**
     * @return True if music is playing, false otherwise
     */
    boolean isPlaying();

    /**
     * True if the current track is a "favorite", false otherwise
     */
    boolean isFavorite();

    /**
     * Opens a list for playback
     *
     * @param list The list of tracks to open
     * @param position The position to start playback at
     */
    void open(long[] list, int position);

    /**
     * Stops playback.
     */
    void stop();

    /**
     * Resumes or starts playback.
     */
    void play();

    /**
     * Temporarily pauses playback.
     */
    void pause();

    /**
     * Changes from the current track to the next track
     */
    void gotoNext(boolean force);

    /**
     * Changes from the current track to the previous played track
     */
    void prev();

    /**
     * Toggles the current song as a favorite.
     */
    void toggleFavorite();

    /**
     * Moves an item in the queue from one position to another
     *
     * @param from The position the item is currently at
     * @param to The position the item is being moved to
     */
    void moveQueueItem(int index1, int index2);

    /**
     * Sets the repeat mode
     *
     * @param repeatmode The repeat mode to use
     */
    void setRepeatMode(int repeatmode);

    /**
     * Sets the shuffle mode
     *
     * @param shufflemode The shuffle mode to use
     */
    void setShuffleMode(int shufflemode);

    /**
     * Sets the position of a track in the queue
     *
     * @param index The position to place the track
     */
    void setQueuePosition(int index);

    /**
     * Queues a new list for playback
     *
     * @param list The list to queue
     * @param action The action to take
     */
    void enqueue(long[] list, int action);

    /**
     * @return The album art for the current album.
     */
    Bitmap getAlbumArt();

    /**
     * Called when one of the lists should refresh or requery.
     */
    void refresh();

}
