package com.epam.cache;

import java.util.Date;

/**
 * Created by Zoltan_Biro on 5/24/2017.
 */
public interface CacheWithUsage {

    // Check cache usage
    public Iterable<String> getKeys();

    public Date getLastAccess(String key);

    public long getNumHits(String key);
}
