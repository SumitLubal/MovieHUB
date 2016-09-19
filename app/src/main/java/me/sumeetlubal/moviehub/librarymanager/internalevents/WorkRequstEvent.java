package me.sumeetlubal.moviehub.librarymanager.internalevents;

/**
 * Created by SAM on 20-09-2016.
 */
public class WorkRequstEvent {
    public NotifyCompleteEvent.NotifyCompleteEventType getmType() {
        return mType;
    }

    NotifyCompleteEvent.NotifyCompleteEventType mType;
    public WorkRequstEvent(NotifyCompleteEvent.NotifyCompleteEventType type){
        mType = type;
    }
}
