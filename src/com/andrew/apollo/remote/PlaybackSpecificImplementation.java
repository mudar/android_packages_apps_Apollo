
package com.andrew.apollo.remote;

public class PlaybackSpecificImplementation {

    private static boolean isLocal = false;

    /*
     * public static IMusicPlaybackService getMusicPlaybackService(Context
     * context) { return (isLocal ? new MusicPlaybackServiceLocal() : new
     * MusicPlaybackServiceRemote()); }
     */

    public static Class<?> getMusicPlaybackServiceClass() {
        return (isLocal ? MusicPlaybackServiceLocal.class : MusicPlaybackServiceRemote.class);
    }

    public static boolean isLocal() {
        return isLocal;
    }

    public static boolean isRemote() {
        return !isLocal;
    }
}
