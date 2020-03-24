package DAO_AUTOMOBILI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AutomobiliDao {
	private Automobili mappa(ResultSet rs)
	{
		Automobili p = new Automobili();
		try 
		{
			p.setPKauto(rs.getInt("PKauto"));
			p.setFKmarca(rs.getInt("FKmarca"));
			p.setFKmodello(rs.getInt("FKmodello"));
			p.setCilindrata(rs.getFloat("cilindrata"));
			p.setData_imm(rs.getString("data_imm"));
			p.setN_posti(rs.getInt("n_posti"));
			
			return p;
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	
	private void mappa(PreparedStatement st,Automobili p)
	{
		try
		{
			st.setInt(1, p.getFKmarca());
			st.setInt(2, p.getFKmodello());
			st.setFloat(3, p.getCilindrata());
			st.setString(4, p.getData_imm());
			st.setInt(5, p.getN_posti());
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Automobili> lista()
	{
		List<Automobili> automobile=new ArrayList<Automobili>();
		try 
		{
			Connection con = DBUtil_auto.connect();
			Statement st = con.createStatement();
			String sql="SELECT * FROM auto";
			ResultSet rs =st.executeQuery(sql);
			
			while(rs.next())
			{
				automobile.add(mappa(rs));
			}
			rs.close();
			st.close();
			con.close();
			return automobile;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Automobili perChiave(int id)
	{
		Automobili p=null;
		try 
		{
			Connection con = DBUtil_auto.connect();
			String sql="SELECT * FROM auto WHERE PKauto=?";
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
	public boolean crea(Automobili p)
	{
		boolean esito = false;
		try {
			Connection con = DBUtil_auto.connect();
			String sql="INSERT INTO auto (FKmarca, FKmodello, cilindrata, data_imm, n_posti) VALUES (?, ?, ?, ?, ?)";
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
	public boolean modifica(Automobili p)
	{
		boolean esito=false;
		try
		{
			Connection con = DBUtil_auto.connect();
			String sql="UPDATE auto SET FKmarca = ?, FKmodello =?, cilindrata=?, data_imm = ?, n_posti = ? WHERE PKauto=?";
			PreparedStatement st = con.prepareStatement(sql);
			mappa(st,p);
			st.setInt(6, p.getPKauto());
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
			String sql="DELETE FROM auto WHERE PKauto=?";
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
