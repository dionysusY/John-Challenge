package com.boot.challenge.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 标准分页
 * @Author:
 * @Date:
 */

public class PageData<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 查询数据列表
     */
    private List<T> records = Collections.emptyList();
    /**
     * 总数
     */
    private long total;
    /**
     * 每页显示条数，默认 10
     */
    private long size;
    /**
     * 当前页
     */
    private long current;

    /**
     * 构造函数
     */
    public PageData() {
        this(0, 10, 0);
    }

    /**
     * 构造函数
     *
     * @param current 当前页
     * @param size    每页显示条数
     */
    public PageData(long current, long size) {
        this(current, size, 0);
    }

    /**
     * 构造函数
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param total   记录总数
     */
    public PageData(long current, long size, long total) {
        this.current = current;
        this.size = size;
        this.total = total;
    }


    /**
     * 查询数据列表
     */
    public List<T> getRecords() {
        return records;
    }

    /**
     * 查询数据列表
     */
    public void setRecords(List<T> records) {
        this.records = records;
    }

    /**
     * 总数
     */
    public long getTotal() {
        return total;
    }

    /**
     * 总数
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 每页显示条数
     */
    public long getSize() {
        return size;
    }

    /**
     * 每页显示条数
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * 当前页
     */
    public long getCurrent() {
        return current;
    }

    /**
     * 当前页
     */
    public void setCurrent(long current) {
        this.current = current;
    }

    /**
     * 总页数
     *
     * @return
     */
    public long getPages() {
        if (getSize() == 0) {
            return 0L;
        }

        return (getTotal() + getSize() - 1) / getSize();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
