package com.dlh.dlhlibrary.domain.usecase;

/**
 * @author: dlh
 * @date:
 * @description
 */
/**
 * Interface for schedulers, see {@link UseCaseThreadPoolScheduler}.
 */
public interface UseCaseScheduler {

    void execute(Runnable runnable);

    <V extends UseCase.ResponseValue> void notifyResponse(final V response,
                                                          final UseCase.UseCaseCallback<V> useCaseCallback);

    <V extends UseCase.ResponseValue> void onError(
            final UseCase.UseCaseCallback<V> useCaseCallback);
}
