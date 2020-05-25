package br.com.boavista;

import java.sql.*;

public class DaoCartoiros {

    private static final String SQL_SELECT= "select * from cartoriosBvs where dd=? and foneCeprot=?";
    private static Connection con;
    java.sql.Statement sql = null;
    private String codigoBvs ="";


    public DaoCartoiros(){

        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb?user=ubuntu&password=ubuntu");
            sql = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Erro na conexao do banco " + e.getMessage());
        }
    }

    public  String selecionaCartorio(String ddd , String fone) {

        try {

            PreparedStatement sqlSelect = con.prepareStatement(SQL_SELECT);
            sqlSelect.setString(1, ddd);
            sqlSelect.setString(2,fone);


            ResultSet rs = sqlSelect.executeQuery();
            if (rs.next()) {
                codigoBvs = rs.getString("codigoCartorio");
            }

        }catch (SQLException e){
            System.out.println("Erro ao selecionar registros " +e.getMessage());
        }

        return  codigoBvs;
    }

    public void close(){

        try {
            if (con != null) {
                con.close();
            }
        }catch (SQLException e){
            System.out.println("Erro no fechamento do banco " + e.getMessage());
        }
    }


}
