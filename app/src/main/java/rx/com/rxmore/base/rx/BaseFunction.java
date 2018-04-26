package rx.com.rxmore.base.rx;


import io.reactivex.Observable;
import io.reactivex.functions.Function;
import rx.com.rxmore.base.data.protocol.BaseResp;


/*
    公共数据类型转换
 */
public class BaseFunction<T> implements Function<BaseResp<T>,Observable<T>> {
    @Override
    public Observable<T> apply(BaseResp<T> t) throws Exception {
        if(!t.getCode().equals("200")){
            return Observable.error(new BaseException(t.getCode(),t.getMessage()));
        }
        return Observable.just(t.getData());
    }
}
