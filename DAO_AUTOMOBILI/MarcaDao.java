package DAO_AUTOMOBILI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MarcaDao {

	private Marca mappa(ResultSet rs)
	{
		Marca m = new Marca();
		try 
		{
			m.setPKmarca(rs.getInt("PKmarca"));
			m.setMarca(rs.getString("marca"));
			return m;

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	private void mappa(PreparedStatement st,Marca p)
	{
		try
		{
			st.setString(1, p.getMarca());

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Marca lista(int id)
	{
		Marca marca=null;
		try 
		{
			Connection con = DBUtil_auto.connect();
			String sql="SELECT * FROM marca WHERE PKmarca = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs =st.executeQuery();

			while(rs.next())
			{
				marca=mappa(rs);
			}
			rs.close();
			st.close();
			con.close();
			return marca;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	public List<Marca> lista()
	{
		List<Marca> marca=new ArrayList<Marca>();
		try 
		{
			Connection con = DBUtil_auto.connect();
			Statement st = con.createStatement();
			String sql="SELECT * FROM marca";
			ResultSet rs =st.executeQuery(sql);
			
			while(rs.next())
			{
				marca.add(mappa(rs));
			}
			rs.close();
			st.close();
			con.close();
			return marca;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//READ per CHIAVE
	public Marca perChiave(int id)
	{
		Marca p=null;
		try 
		{
			Connection con = DBUtil_auto.connect();
			String sql="SELECT * FROM marca WHERE PKmarca=?";
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
	public Marca perChiave(String marca)
	{
		Marca p=null;
		try 
		{
			Connection con = DBUtil_auto.connect();
			String sql="SELECT * FROM marca WHERE marca=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, marca);
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
	public boolean crea(Marca p)
	{
		boolean esito = false;
		try {
			Connection con = DBUtil_auto.connect();
			String sql="INSERT INTO marca (marca) VALUES (?)";
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
	public boolean modifica(Marca p)
	{
		boolean esito=false;
		try
		{
			Connection con = DBUtil_auto.connect();
			String sql="UPDATE marca SET marca = ? WHERE PKmarca=?";
			PreparedStatement st = con.prepareStatement(sql);
			mappa(st,p);
			st.setInt(2, p.getPKmarca());
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
			String sql="DELETE FROM marca WHERE PKmarca=?";
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
