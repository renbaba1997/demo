package model;

public class BaseSearchVo {

    /**
     * 当前页
     */
    private int pageIndex = 1;

    /**
     * 每页显示数
     */

    private int pageSize = Integer.MAX_VALUE;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
