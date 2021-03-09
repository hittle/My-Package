package com.lzl.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lzl.entity.Staffs;
import com.lzl.pojo.User;


/**
 * @author lzl
 *
 */
public interface StaffMapper {

	/**
	 * 获取所有员工信息
	 * @return
	 * @throws Exception
	 */
	@Select("select id,name,cardnum,tel,email,sex,identity from staffs")
	public List<Staffs> getAllStaffs()throws Exception;
	
	@Select("select id,name,account,cardnum,sex,tel,email,identity from staffs where account=#{account} and password=#{password}")
	public Staffs getOneStaff(User user)throws Exception;
	
	@Select("select account,password,identity from staffs where account=#{account} and password=#{password}")
	public User getUserIdentity(User user)throws Exception;
	
	@Select("select count(*) from staffs where account = #{account}")
	public Integer getOneStaffAccount(String account)throws Exception;
	
	@Select("select count(*) from staffs where id=#{userId} and password=#{oldPass}")
	public Integer getOldPassword(Map map)throws Exception;
	/**
	 * 登录
	 * @param staffs
	 * @return
	 * @throws Exception
	 */
	@Select("select count(*) from staffs "
			+ "where account = #{account} and password = #{password}")
	public Integer loginCheck(User user)throws Exception;
	
	/**
	 * 更新员工信息
	 * @param staffs
	 * @throws Exception
	 */
	@Update("<script>"
			+ "update staffs"
			+ "<set>"
			+ "<if test = 'photo != null'> photo = #{photo}, </if>"
			+ "<if test = 'tel != null'> tel = #{tel}, </if>"
			+ "<if test = 'email != null' > email = #{email}, </if>"
			+ "<if test = 'cardNum != null' > cardnum = #{cardNum}, </if>"
			+ "<if test = 'name != null' > name = #{name}, </if>"
			+ "<if test = 'sex != null' > sex = #{sex}, </if>"
			+ "</set>"
			+ "where id = #{id}"
			+ "</script>")
	public Integer changeStaffInfo(Map map)throws Exception;
	
	@Update("update staffs set password=#{newPass} where id=#{userId}")
	public Integer changePassword(Map map)throws Exception;
	/**
	 * 注册新员工
	 * @param staffs
	 * @throws Exception
	 */
	@Insert("insert into staffs values(default,#{name}，#{account},"
			+ "#{password},#{photo},#{tel},#{email},#{address},#{cardNum})")
	public void addStaff(Staffs staffs)throws Exception;
	
	/**
	 * 删除员工
	 * @param id
	 * @throws Exception
	 */
	@Delete("delete from staffs where id = #{id}")
	public void delStaff(Integer id)throws Exception;
}
