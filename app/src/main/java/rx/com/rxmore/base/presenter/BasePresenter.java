package rx.com.rxmore.base.presenter;


import rx.com.rxmore.base.common.MainApplication;
import rx.com.rxmore.base.presenter.view.BaseView;
import rx.com.rxmore.utils.NetworkUtils;


public class BasePresenter<T extends BaseView>{

    protected T mView;

    public void setMV(T v){
        mView = v;
    }

    /**
        检查网络是否可用
     */
    public Boolean checkNetWork(){
        if(NetworkUtils.isNetworkAvailable(MainApplication.getContext())){
            return true;
        }
        mView.onError("网络不可用");
        return false;
    }

}
