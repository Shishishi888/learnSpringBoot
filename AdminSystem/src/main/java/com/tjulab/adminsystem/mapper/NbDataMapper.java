package com.tjulab.adminsystem.mapper;

import com.tjulab.adminsystem.bean.NbData;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 告诉mybatis这是一个mapper接口
public interface NbDataMapper {
    public NbData getNbDataById(String dataId);

    /**
     * 使用Mybatis
     * 1. 导入mybatis的官方starter
     * 2. 编写mapper接口
     * 3. 编写sql映射文件，并将mapper接口绑定到sql映射文件
     * 4. 在application.yml中设置mybatis的全局配置项，并指定sql映射文件的位置
     */
}
