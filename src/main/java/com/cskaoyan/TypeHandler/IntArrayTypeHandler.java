package com.cskaoyan.TypeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//String→int[] int[]→String
public class IntArrayTypeHandler extends BaseTypeHandler<int[]> {
	//int[]转换成String
	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int index, int[] input, JdbcType jdbcType) throws SQLException {
		StringBuffer sb = new StringBuffer();
		for (int value:input) {
			sb.append(value).append(",");
			//1,2,3,4,
		}
		String substring = sb.substring(0, sb.length() - 1);
		preparedStatement.setString(index,substring);
	}

	@Override
	public int[] getNullableResult(ResultSet resultSet, String column) throws SQLException {
		String string = resultSet.getString(column);
		return transferString2IntArray(string);
	}

	@Override
	public int[] getNullableResult(ResultSet resultSet, int index) throws SQLException {
		String string = resultSet.getString(index);
		return transferString2IntArray(string);
	}

	@Override
	public int[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		String string = callableStatement.getString(i);
		return transferString2IntArray(string);
	}

	private int[] transferString2IntArray(String string)
	{   String substring=string.substring(1,string.length()-1);
		String[] split = substring.split(",");
		int[] ints = new int[split.length];
		for (int i = 0; i < split.length; i++)
		{
			ints[i] = Integer.parseInt(split[i]);
		}

		return ints;
	}
}
