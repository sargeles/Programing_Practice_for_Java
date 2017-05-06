package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

public class C3P0DBUtil {
    private static ComboPooledDataSource comboPooledDataSource = null;
        //��̬�����
        static{
            /*
             * ��ȡc3p0��xml�����ļ���������Դ��c3p0��xml�����ļ�c3p0-config.xml�������srcĿ¼��
             * ʹ��c3p0���������ö�ȡ����Դ
             */
            comboPooledDataSource = new ComboPooledDataSource("c3p0");
        }
        //������Դ�л�ȡ���ݿ������
        public static Connection getConnection() throws SQLException {
                return comboPooledDataSource.getConnection();
        }
        //�ͷ���Դ�������ݿ����ӻ������ݿ����ӳ�
        public static void closeDB(Connection conn,PreparedStatement ps,ResultSet rs) {
                try {
                    if (rs!=null) {
                        rs.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally{
                    try {
                        if (ps!=null) {
                            ps.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally{
                        try {
                            if (conn!=null) {
                                conn.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
        //�ͷ���Դ�������ݿ����ӻ������ݿ����ӳ�
        public static void closeDB(PreparedStatement ps,Connection conn) {
             try {
                if (ps!=null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
                try {
                    if (conn!=null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}