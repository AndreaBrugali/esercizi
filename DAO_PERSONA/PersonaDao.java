package DAO_PERSONA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao {
	private Persona mappa(ResultSet rs)
	{
		Persona p = new Persona();
		try 
		{
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setCognome(rs.getString("cognome"));
			p.setPesoInKg(rs.getFloat("pesoInKg"));
			return p;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	private void mappa(PreparedStatement st,Persona p)
	{
		try
		{
			st.setString(1, p.getNome());
			st.setString(2, p.getCognome());
			st.setFloat(3, p.getPesoInKg());
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Persona> lista()
	{
		List<Persona> persone=new ArrayList<Persona>();
		try 
		{
			Connection con = DBUtil.connect();
			Statement st = con.createStatement();
			String sql="SELECT * FROM persona";
			ResultSet rs =st.executeQuery(sql);
			
			while(rs.next())
			{
				persone.add(mappa(rs));
			}
			rs.close();
			st.close();
			con.close();
			return persone;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Persona perChiave(int id)
	{
		Persona p=null;
		try 
		{
			Connection con = DBUtil.connect();
			String sql="SELECT * FROM persona WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs =st.executeQuery();
			
			while(rs.next())
			{
				p=mappa(rs);
			}
			rs.close();
			st.close();
			con.close();
			return p;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
//CREA
	public boolean crea(Persona p)
	{
		boolean esito = false;
		try {
			Connection con = DBUtil.connect();
			String sql="INSERT INTO persona (nome, cognome, pesoInKg) VALUES (?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			mappa(st,p);
			st.execute();
			st.close();
			con.close();
			esito=true;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}

//MODIFICA
	public boolean modifica(Persona p)
	{
		boolean esito=false;
		try
		{
			Connection con = DBUtil.connect();
			String sql="UPDATE persona SET nome = ?, cognome =?, pesoInKg=? WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			mappa(st,p);
			st.setInt(4, p.getId());
			st.executeUpdate();
			st.close();
			con.close();
			esito=true;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}
	
//DELETE
	public boolean cancella(int id)
	{
		boolean esito=false;
		try
		{
			Connection con = DBUtil.connect();
			String sql="DELETE FROM persona WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();
			st.close();
			con.close();
			esito=true;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}
	
}
