package com.eazy7x.android.streaming;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;

class StreamingRequestJsHandler {
    public static final String STREAMING_URL = "STREAMING_URL";
    private Context context;

    public StreamingRequestJsHandler(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public String startStreaming(String url) {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.setComponent(new ComponentName("org.videolan.vlc", "org.videolan.vlc.gui.video.VideoPlayerActivity"));
        i.putExtra("url", url);
        i.setDataAndType(Uri.parse(url), "video/*");
        this.context.startActivity(i);
//        Intent i = new Intent(this.context, StreamYoutubeActivity.class);
//        i.putExtra(StreamingRequestJsHandler.STREAMING_URL, url);
//        this.context.startActivity(i);
        return "{'status' : 'OK'}";
    }
}
