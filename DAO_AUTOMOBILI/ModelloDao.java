package DAO_AUTOMOBILI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModelloDao {

	private Modello mappa(ResultSet rs)
	{
		Modello m = new Modello();
		try 
		{
			m.setPKmodello(rs.getInt("PKmodello"));
			m.setModello(rs.getString("modello"));
			return m;
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	private void mappa(PreparedStatement st,Modello p)
	{
		try
		{
			st.setString(1, p.getModello());

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Modello lista(int id)
	{
		Modello modello=null;
		try 
		{
			Connection con = DBUtil_auto.connect();
			String sql="SELECT * FROM modello WHERE PKmodello = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs =st.executeQuery();
			
			while(rs.next())
			{
				modello=mappa(rs);
			}
			rs.close();
			st.close();
			con.close();
			return modello;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public List<Modello> lista()
	{
		List<Modello> modello=new ArrayList<Modello>();
		try 
		{
			Connection con = DBUtil_auto.connect();
			Statement st = con.createStatement();
			String sql="SELECT * FROM modello";
			ResultSet rs =st.executeQuery(sql);
			
			while(rs.next())
			{
				modello.add(mappa(rs));
			}
			rs.close();
			st.close();
			con.close();
			return modello;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//READ per CHIAVE
	public Modello perChiave(int id)
	{
		Modello p=null;
		try 
		{
			Connection con = DBUtil_auto.connect();
			String sql="SELECT * FROM modello WHERE PKmodello=?";
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
	public Modello perChiave(String modello)
	{
		Modello p=null;
		try 
		{
			Connection con = DBUtil_auto.connect();
			String sql="SELECT * FROM modello WHERE modello=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, modello);
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
	public boolean crea(Modello p)
	{
		boolean esito = false;
		try {
			Connection con = DBUtil_auto.connect();
			String sql="INSERT INTO modello (modello) VALUES (?)";
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
	public boolean modifica(Modello p)
	{
		boolean esito=false;
		try
		{
			Connection con = DBUtil_auto.connect();
			String sql="UPDATE modello SET modello = ? WHERE PKmodello=?";
			PreparedStatement st = con.prepareStatement(sql);
			mappa(st,p);
			st.setInt(2, p.getPKmodello());
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
			Connection con = DBUtil_auto.connect();
			String sql="DELETE FROM modello WHERE PKmodello=?";
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
