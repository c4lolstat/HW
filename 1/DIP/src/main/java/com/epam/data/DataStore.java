package com.epam.data;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Zoltan_Biro on 5/24/2017.
 */
public interface DataStore<T> {
    void add(T t);
    Iterable<T> list();
}
