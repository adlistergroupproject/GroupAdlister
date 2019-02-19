package com.codeup.adlister.util;

public class SQLQuery {

    protected String query;

    public SQLQuery(){
        this.query = "";
    }

    public SQLQuery(String query){
        this.query = query;
    }

    public SQLQuery select(String column){
        return new SQLQuery("SELECT " + column);
    }

    public SQLQuery select(String[] columns){

        if(columns.length == 1){
            return select(columns[0]);
        } else {
            this.query = "SELECT ";
            int index = 0;
            for(String column : columns){
                if(index != columns.length - 1) {
                    this.query += column + ", ";
                }
                else {
                    this.query += column;
                }
            }
            return new SQLQuery(this.query);
        }
    }

    public SQLQuery from(String table){
        return new SQLQuery(this.query + " FROM " + table);
    }

    // standard where query
    public SQLQuery where(String column){
        return new SQLQuery(this.query + " WHERE " + column);
    }

    // WHERE that supports subqueries
    public SQLQuery where(SQLQuery subquery){
        return new SQLQuery(this.query + " WHERE (" + subquery.toString() + ")");
    }

    // standard OR
    public SQLQuery or(String column){
        return new SQLQuery(this.query + " OR " + column);
    }

    // OR that supports subqueries
    public SQLQuery or(SQLQuery subquery){
        return new SQLQuery(this.query + " OR (" + subquery.toString() + ")");
    }

    // standard AND
    public SQLQuery and(String column){
        return new SQLQuery(this.query + " AND " + column);
    }

    // AND that support subqueries
    public SQLQuery and(SQLQuery subquery){
        return new SQLQuery(this.query + " AND (" + subquery.toString() + ")");
    }

    public SQLQuery like(String elem){
        return new SQLQuery(this.query + " like '%" + elem + "%'");
    }

    public SQLQuery done(){
        return new SQLQuery(this.query + ";");
    }

    public String toString(){
        return this.query;
    }

}
