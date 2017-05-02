package cn.mldn.vshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vshop.dao.IAddressDAO;
import cn.mldn.vshop.vo.Address;

public class AddressDAOImpl extends AbstractDAO implements IAddressDAO {
	@Override
	public List<Address> findAllByMember(String mid) throws SQLException {
		List<Address> all = new ArrayList<Address>() ;
		String sql = "SELECT adid,mid,pid,cid,addr,receiver,phone,deflag FROM address WHERE mid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, mid);
		ResultSet rs = super.pstmt.executeQuery() ;
		while (rs.next()) {
			Address vo = new Address() ;
			vo.setAdid(rs.getInt(1));
			vo.setMid(rs.getString(2));
			vo.setPid(rs.getInt(3));
			vo.setCid(rs.getInt(4));
			vo.setAddr(rs.getString(5));
			vo.setReceiver(rs.getString(6));
			vo.setPhone(rs.getString(7));
			vo.setDeflag(rs.getInt(8));
			all.add(vo) ;
		}
		return all ;
	}
	@Override
	public Integer getCountByMember(String mid) throws SQLException {
		String sql = "SELECT COUNT(*) FROM address WHERE mid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, mid);
		ResultSet rs = super.pstmt.executeQuery() ;
		if (rs.next()) {
			return rs.getInt(1) ;
		}
		return 0 ;
	}
	@Override
	public boolean doCreate(Address vo) throws SQLException {
		String sql = "INSERT INTO address(mid,pid,cid,addr,receiver,phone,deflag) VALUES (?,?,?,?,?,?,?)" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, vo.getMid());
		super.pstmt.setInt(2, vo.getPid());
		super.pstmt.setInt(3, vo.getCid());
		super.pstmt.setString(4, vo.getAddr());
		super.pstmt.setString(5, vo.getReceiver());
		super.pstmt.setString(6, vo.getPhone());
		super.pstmt.setInt(7, vo.getDeflag());
		return super.pstmt.executeUpdate() > 0 ;
	}

	@Override
	public boolean doUpdate(Address vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> findAllSplit(Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> findAllSplit(Integer currentPage, Integer lineSize,
			String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}