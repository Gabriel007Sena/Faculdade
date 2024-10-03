package org.libertas;

import java.sql.*;
import java.util.LinkedList;

public class TimeDao {

    public void salvar(Time t) {
        if (t.getIdtime() > 0) {
            alterar(t);
        } else {
            inserir(t);
        }
    }

    public void inserir(Time t) {
        try (Connection conn = new Conexao().getConnection()) {
            String sql = "INSERT INTO time (nome, fundacao, estadio, treinador) VALUES (?, ?, ?, ?)";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, t.getNome());
            prep.setString(2, t.getFundacao());
            prep.setString(3, t.getEstadio());
            prep.setString(4, t.getTreinador());
            prep.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterar(Time t) {
        try (Connection conn = new Conexao().getConnection()) {
            String sql = "UPDATE time SET nome = ?, fundacao = ?, estadio = ?, treinador = ? WHERE idtime = ?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, t.getNome());
            prep.setString(2, t.getFundacao());
            prep.setString(3, t.getEstadio());
            prep.setString(4, t.getTreinador());
            prep.setInt(5, t.getIdtime());
            prep.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int idtime) {
        try (Connection conn = new Conexao().getConnection()) {
            String sql = "DELETE FROM time WHERE idtime = ?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, idtime);
            prep.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Time> listar() {
        LinkedList<Time> lista = new LinkedList<>();
        try (Connection conn = new Conexao().getConnection()) {
            String sql = "SELECT * FROM time ORDER BY nome";
            Statement sta = conn.createStatement();
            ResultSet res = sta.executeQuery(sql);
            while (res.next()) {
                Time t = new Time();
                t.setIdtime(res.getInt("idtime"));
                t.setNome(res.getString("nome"));
                t.setFundacao(res.getString("fundacao"));
                t.setEstadio(res.getString("estadio"));
                t.setTreinador(res.getString("treinador"));
                lista.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Time consultar(int id) {
        Time t = new Time();
        try (Connection conn = new Conexao().getConnection()) {
            String sql = "SELECT * FROM time WHERE idtime = ?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, id);
            ResultSet res = prep.executeQuery();
            if (res.next()) {
                t.setIdtime(res.getInt("idtime"));
                t.setNome(res.getString("nome"));
                t.setFundacao(res.getString("fundacao"));
                t.setEstadio(res.getString("estadio"));
                t.setTreinador(res.getString("treinador"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
