package com.lapsa.insurance.mesenger;

import java.util.List;

public interface BaseNotifier<T> {
    void notify(T enitity) throws NotificationFailed;

    void notify(List<T> enitities) throws NotificationFailed;

}
