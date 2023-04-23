package com.example.recovery.config;



import com.example.recovery.exception.UnAuthorityException;

import java.util.concurrent.ConcurrentHashMap;

public class UserContextHolder {

    private ThreadLocal<ConcurrentHashMap<String, Object>> threadLocal;

    private UserContextHolder() {
        this.threadLocal = new ThreadLocal<>();
    }

    /**
     * 创建实例
     *
     * @return
     */
    public static UserContextHolder getInstance() {
        return SingletonHolder.sInstance;
    }

    /**
     * 静态内部类单例模式
     * 单例初使化
     */
    private static class SingletonHolder {
        private static final UserContextHolder sInstance = new UserContextHolder();
    }

    /**
     * 用户上下文中放入信息
     *
     * @param map
     */
    public void setContext(ConcurrentHashMap<String, Object> map) {
        threadLocal.set(map);
    }

    /**
     * 获取上下文中的信息
     *
     * @return
     */
    public ConcurrentHashMap<String, Object> getContext() {
        return threadLocal.get();
    }

    /**
     * 获取上下文中的用户ID
     *
     * @return
     */
    public Integer getUserId() {
        Object o = threadLocal.get().get("userId");
        if (o == null){
            throw new UnAuthorityException("当前用户未登录");
        }
        return Integer.parseInt(o.toString());
    }



    /**
     * 清空上下文
     */
    public void clear() {
        threadLocal.remove();
    }
}
