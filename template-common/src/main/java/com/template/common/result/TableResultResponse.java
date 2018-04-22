package com.template.common.result;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouRunBin
 * Date: 2018/4/5 0005
 * Time: 1:19
 * Description:
 */
public class TableResultResponse<T> extends BaseResponse {

    private TableData<T> data;

    public TableResultResponse(long total, List<T> rows) {
        this.data = new TableData<T>(total, rows);
    }

    public TableResultResponse() {
        this.data = new TableData<T>();
    }

    TableResultResponse<T> total(int total) {
        this.data.setTotal(total);
        return this;
    }

    TableResultResponse<T> total(List<T> rows) {
        this.data.setRows(rows);
        return this;
    }

    public TableData<T> getData() {
        return data;
    }

    public void setData(TableData<T> data) {
        this.data = data;
    }

    class TableData<T> {
        long total;
        List<T> rows;

        TableData(long total, List<T> rows) {
            this.total = total;
            this.rows = rows;
        }

        TableData() {}

        public long getTotal() {
            return total;
        }

        void setTotal(long total) {
            this.total = total;
        }

        public List<T> getRows() {
            return rows;
        }

        void setRows(List<T> rows) {
            this.rows = rows;
        }
    }

}
