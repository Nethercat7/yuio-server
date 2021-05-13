package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

/**
 * @Description:岗位实体
 * @Author:赵富源
 * @CreateDate:2021/4/20 18:38
 */
public class ExcelWork {
    @ExcelProperty("ID")
    private Long workId;

    @ExcelProperty("岗位名称")
    private String workName;

    @ExcelProperty("上级ID")
    private Long workPid;

    @ExcelProperty("状态")
    private String workStatus;

    @ExcelProperty("层级")
    private int workLevel;

    @ExcelProperty( "备注")
    private String workRemark;

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Long getWorkPid() {
        return workPid;
    }

    public void setWorkPid(Long workPid) {
        this.workPid = workPid;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public int getWorkLevel() {
        return workLevel;
    }

    public void setWorkLevel(int workLevel) {
        this.workLevel = workLevel;
    }

    public String getWorkRemark() {
        return workRemark;
    }

    public void setWorkRemark(String workRemark) {
        this.workRemark = workRemark;
    }
}
