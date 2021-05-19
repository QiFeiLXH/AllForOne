package org.qifei.apitoken.reponseResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/23 13:55
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {

    /** 代码 */
    private String code;

    /** 结果 */
    private String msg;
}
