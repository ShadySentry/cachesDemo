package com.shadysentry.ehCache2;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class CustomCacheEventLogger implements CacheEventListener {
    @Override
    public void notifyElementPut(net.sf.ehcache.Ehcache cache, Element element) {
        log.info("Cache event = PUT, Key = {}, New value = {}", element.getObjectKey(), element.getObjectValue());
    }

    @Override
    public void notifyElementUpdated(net.sf.ehcache.Ehcache cache, Element element) {
        log.info("Cache event = UPDATED, Key = {}, Old value = {}, New value = {}",
                element.getObjectKey(), element.getObjectValue(), element.getObjectValue());
    }

    @Override
    public void notifyElementRemoved(net.sf.ehcache.Ehcache cache, Element element) {
        log.info("Cache event = REMOVED, Key = {}, Old value = {}", element.getObjectKey(), element.getObjectValue());
    }

    @Override
    public void notifyElementExpired(net.sf.ehcache.Ehcache cache, Element element) {
        log.info("Cache event = EXPIRED, Key = {}, Old value = {}", element.getObjectKey(), element.getObjectValue());
    }

    @Override
    public void notifyElementEvicted(net.sf.ehcache.Ehcache cache, Element element) {
        log.info("Cache event = EVICTED, Key = {}, Old value = {}", element.getObjectKey(), element.getObjectValue());
    }

    @Override
    public void notifyRemoveAll(net.sf.ehcache.Ehcache cache) {
        log.info("Cache event = REMOVE ALL");
    }

    @Override
    public void dispose() {
        // Dispose resources if any
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
