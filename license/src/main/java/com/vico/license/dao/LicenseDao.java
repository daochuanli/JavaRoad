package com.vico.license.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vico.license.pojo.LicenseDetail;

/**
 * 
 * @ClassName: LicenseDao
 * @Description: 序列号信息Dao层
 * @author: Liu.Dun
 * @date: 2016年6月27日 下午8:46:25
 */
public interface LicenseDao {
    int deleteByPrimaryKey(Integer serialNumberId);

    int insertLicenseDetail(LicenseDetail licensedetail);

    LicenseDetail selectByPrimaryKey(Integer serialNumberId);

    int updateByPrimaryKey(LicenseDetail licensedetail);
    
    List<LicenseDetail> selectAllLicenses();
    
    List<LicenseDetail> selectLicenseByHospitalNumber(int hospitalNumber);
    
    LicenseDetail selectCodeAndRSAByPrimaryKey(Integer serialNumberId);

	List<LicenseDetail> selectAllLicensesByPage(@Param("start")Integer start, 
												@Param("length")Integer length);

	Integer selectCountLicenses();
}