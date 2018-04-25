package com.gxb.sdk.des.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.gxb.sdk.des.model.dto.FieldInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author liruobin
 * @since 2018/4/9 下午3:16
 */
public class ParamUtil {
    private static final Logger log = LoggerFactory.getLogger(ParamUtil.class);

    /**
     * 校验参数
     *
     * @param fieldMap
     * @param param
     * @return
     */
    public static boolean checkParamValid(Map<String, FieldInfo> fieldMap, JSONObject param) {
        log.debug("校验参数是否合法");
        try {
            for (Map.Entry<String, FieldInfo> field : fieldMap.entrySet()) {
                FieldInfo fieldInfo = field.getValue();
                if (fieldInfo.getRequired() != null && fieldInfo.getRequired() && param.get(field.getKey()) == null) {
                    log.error("参数校验不通过：{}为非空字段", field.getKey());
                    return false;
                }
                if (param.get(field.getKey()) == null) {
                    continue;
                }
                if ("string".equalsIgnoreCase(fieldInfo.getType())) {
                    param.getString(field.getKey());
                } else if ("integer".equalsIgnoreCase(fieldInfo.getType())) {
                    param.getInteger(field.getKey());
                } else if ("boolean".equalsIgnoreCase(fieldInfo.getType())) {
                    param.getBoolean(field.getKey());
                } else if ("long".equalsIgnoreCase(fieldInfo.getType())) {
                    param.getLong(field.getKey());
                } else if ("float".equalsIgnoreCase(fieldInfo.getType())) {
                    param.getFloat(field.getKey());
                } else if ("double".equalsIgnoreCase(fieldInfo.getType())) {
                    param.getDouble(field.getKey());
                } else if ("date".equalsIgnoreCase(fieldInfo.getType())) {
                    param.getDate(field.getKey());
                }
            }
            return true;
        } catch (JSONException e) {
            log.error("参数校验不通过：{}", e.getMessage());
            return false;
        }
    }
}
