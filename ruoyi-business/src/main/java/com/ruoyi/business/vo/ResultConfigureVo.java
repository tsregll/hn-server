package com.ruoyi.business.vo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultConfigureVo {

    private Connection conn ;
    private Statement stmt ;
    private ResultSet rs ;

    public ResultConfigureVo() {
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
}
