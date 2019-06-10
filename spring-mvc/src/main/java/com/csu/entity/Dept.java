/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: Dept
 * Author:   yuanlin_csu
 * Date:     2019/5/21 11:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author yuanlin_csu
 * @create 2019/5/21
 * @since 1.0.0
 */
@Entity
public class Dept {


    private int deptId;
    private String deptName;
    private String unitMaster;
    private String telephone;
    private String memo;

    @Id
    @Column(name = "DeptId")
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "DeptName")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "UnitMaster")
    public String getUnitMaster() {
        return unitMaster;
    }

    public void setUnitMaster(String unitMaster) {
        this.unitMaster = unitMaster;
    }

    @Basic
    @Column(name = "Telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "Memo")
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return deptId == dept.deptId &&
                Objects.equals(deptName, dept.deptName) &&
                Objects.equals(unitMaster, dept.unitMaster) &&
                Objects.equals(telephone, dept.telephone) &&
                Objects.equals(memo, dept.memo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName, unitMaster, telephone, memo);
    }
}
