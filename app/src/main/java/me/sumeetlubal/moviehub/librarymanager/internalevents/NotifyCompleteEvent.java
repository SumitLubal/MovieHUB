package me.sumeetlubal.moviehub.librarymanager.internalevents;

import java.util.List;

import me.sumeetlubal.moviehub.display.model.SectionDataModel;

/**
 * Created by SAM on 20-09-2016.
 */
public class NotifyCompleteEvent {
    List<SectionDataModel> mResult;
    NotifyCompleteEventType type;
    public List<SectionDataModel> getResult() {
        return mResult;
    }
    public NotifyCompleteEventType getType(){
        return type;
    }
    public NotifyCompleteEvent(NotifyCompleteEventType t, List<SectionDataModel> result){
        mResult = result;
        type = t;
    }
    public enum NotifyCompleteEventType{POPULAR,UPCOMING,TOPRATED, NotifyCompleteEventType, NOWTRENDING}
}
