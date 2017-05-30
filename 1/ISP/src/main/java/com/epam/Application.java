package com.epam;

import com.epam.cache.BestCache;
import com.epam.cache.Cache;
import com.epam.cache.CacheWithUsage;
import com.epam.cache.WinableLottery;

public class Application {

	public static void main(String[] args) {
		Cache<String> stringCache = new BestCache<String>();
		use(stringCache);
		monitor((CacheWithUsage)stringCache);
		winLottery((WinableLottery)stringCache);
	}

	private static void monitor(CacheWithUsage stringCache) {
		Monitor<String> stringCacheMonitor = new Monitor<String>(stringCache);
		stringCacheMonitor.printInfo();
	}

	private static void use(Cache<String> stringCache) {
		CacheUser cacheUser = new CacheUser(stringCache);
		cacheUser.use();
	}

	private static void winLottery(WinableLottery stringCache) {
		stringCache.callThisMethodToWinTheLottery();
	}

}
