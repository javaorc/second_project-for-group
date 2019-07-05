package com.cskaoyan.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringToListTypeHandler extends BaseTypeHandler<List<String>> {

    /*输入映射*/
    /*List -> String*/
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int index, List<String> strings, JdbcType jdbcType) throws SQLException {

        String s = null;
        StringBuffer stringBuffer = new StringBuffer("[");

        if (strings.size() >= 1) {
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                stringBuffer.append("\"").append(iterator.next()).append("\", ");
            }
            s = stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length()).append("]").toString();
        } else {
            s = stringBuffer.append("]").toString();
        }
        preparedStatement.setString(index, s);
    }

    /*输出映射*/
    /*String -> List*/
    @Override
    public List<String> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return string2List(string);
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return string2List(string);
    }

    @Override
    public List<String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return string2List(string);
    }

    private List<String> string2List(String string) {
        List<String> list = new ArrayList<>();

        if (!"[]".equals(string)) {
            String[] split = string.substring(1, string.length() - 1).split(",");

            for (String str : split) {

                String trim = str.trim();
                String substring = trim.substring(1, trim.length() - 1);
                list.add(substring);
            }
        }
        return list;
    }
}

