package cn.xionghuihui.infrastructure.kit.common.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 基础的实体类对象
 *
 * @author huihui.xiong
 * @since 2022-07-06 16:19:02
 */
public class BaseEntity implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 8199049324885973045L;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 创建日期时间
     */
    private LocalDateTime createTime;

    /**
     * 更新日期时间
     */
    private LocalDateTime updateTime;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(createBy, that.createBy)
                && Objects.equals(updateBy, that.updateBy)
                && Objects.equals(createTime, that.createTime)
                && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createBy, updateBy, createTime, updateTime);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
