package com.zfy.yuio.entity.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zfy.yuio.converter.UvslStatusConverter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:岗位实体
 * @Author:赵富源
 * @CreateDate:2021/4/20 18:38
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysWork {
    @ExcelProperty( value = "ID")
    @JsonProperty("id")
    private Long workId; //DB property

    @ExcelProperty(value = "岗位名称")
    @JsonProperty("name")
    private String workName; //DB property

    @ExcelProperty(value = "层级")
    @JsonProperty("level")
    private int workLevel; //DB property

    @ExcelProperty(value = "上级ID")
    @JsonProperty("pid")
    private Long workPid; //DB property

    @ExcelProperty(value = "状态", converter = UvslStatusConverter.class)
    @JsonProperty("status")
    private String workStatus; //DB property

    @ExcelProperty(value = "备注")
    @JsonProperty("remark")
    private String workRemark; //DB property

    //Ignore properties
    @ExcelIgnore
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime workCreateTime; //DB property

    @ExcelIgnore
    private List<SysWork> children;

    @ExcelIgnore
    private boolean  disabled;

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

    public LocalDateTime getWorkCreateTime() {
        return workCreateTime;
    }

    public void setWorkCreateTime(LocalDateTime workCreateTime) {
        this.workCreateTime = workCreateTime;
    }

    public int getWorkLevel() {
        return workLevel;
    }

    public void setWorkLevel(int workLevel) {
        this.workLevel = workLevel;
    }

    public List<SysWork> getChildren() {
        return children;
    }

    public void setChildren(List<SysWork> children) {
        this.children = children;
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public String getWorkRemark() {
        return workRemark;
    }

    public void setWorkRemark(String workRemark) {
        this.workRemark = workRemark;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
