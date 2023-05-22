package uz.test.kattabozor.data.model

sealed interface ResultData<T> {
    class Success<T>(val data : T) : ResultData<T>
    class OnFail<T>(val message : Throwable) : ResultData<T>
    class Message<T>(val stringId : Int) : ResultData<T>
}