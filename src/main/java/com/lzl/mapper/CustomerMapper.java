package com.lzl.mapper;

import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lzl.entity.Customers;
import com.lzl.pojo.User;

/**
 * @author lzl
 *
 */
public interface CustomerMapper {

	/**
	 * 获取所有用户信息
	 * @return
	 * @throws Exception
	 */
	@Select("select id,name,cardnum,tel,email,sex from customers")
	public List<Customers> getAllCustomers()throws Exception;
	
	@Select("select id,name,account,cardnum,sex,tel,email from customers where account=#{account} and password=#{password}")
	public Customers getCustInfo(User user) throws Exception;
	
	@Select("select id from customers where cardNum=#{cardNum}")
	public Integer getCustId(String cardNum)throws Exception;
	/**
	 * 判断是否存在同样的账号
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@Select("select count(*) from customers where account = #{account}")
	public Integer getOneCustAccount(String account)throws Exception;
	
	/**
	 * 用户登录
	 * @param customers
	 * @return
	 * @throws Exception
	 */
	@Select("select count(*) from customers "
			+ "where account = #{account} and password = #{password}")
	public Integer loginCheckCust(User user)throws Exception;
	
	@Select("select count(*) from customers where cardnum=#{cardNum}")
	public Integer findUser(String cardNum) throws Exception;
	/**
	 * 注册用户账号
	 * @param customers
	 * @throws Exception
	 */
	@Insert("insert into customers values(default,#{name},#{cardNum},#{photo},"
			+ "#{account},#{password},#{sex},#{tel},#{email},#{regTime},#{integral})")
	public void addCust(Customers customers)throws Exception;
	
	/**
	 * 根据条件修改用户信息
	 * @param customers
	 * @throws Exception
	 */
	@Update("<script>"
			+ "update customers "
			+ "<set>"
			+ "<if test = 'photo != null'> photo = #{photo} ,</if>"
			+ "<if test = 'password != null'> password = #{password} ,</if>"
			+ "<if test = 'tel != null'> tel = #{tel} ,</if>"
			+ "<if test = 'name != null'> name = #{name}, </if>"
			+ "<if test = 'email != null'> email = #{email}, </if>"
			+ "<if test = 'sex != null'> sex = #{sex} ,</if>"
			+ "<if test = 'cardNum != null'> cardnum = #{cardNum} ,</if>"
			+ "</set>"
			+ "where id = #{id}"
			+ "</script>")
	public Integer changeInfo(Map map)throws Exception;
	
	@Select("select count(*) from customers where id=#{userId} and password=#{oldPass}")
	public Integer getOldPassword(Map map)throws Exception;
	
	@Update("update customers set password=#{newPass} where id=#{userId}")
	public Integer changePassword(Map map)throws Exception;
	/**
	 * 修改积分
	 * @param integral
	 * @throws Exception
	 */
	@Update("update customers set integral = #{integral} where id = #{id}")
	public void updateIntegral(Integer integral)throws Exception;
}
