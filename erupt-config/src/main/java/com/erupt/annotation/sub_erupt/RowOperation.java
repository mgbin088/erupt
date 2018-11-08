package com.erupt.annotation.sub_erupt;

import com.erupt.annotation.fun.OperationHandler;
import com.erupt.annotation.sub_field.Edit;

/**
 * 使用一列或者多列的数据执行特定代码
 * Created by liyuepeng on 10/9/18.
 */
public @interface RowOperation {

    String code();

    String icon();

    String title();

    boolean multi() default true;

    CodeAndEdit[] edits() default {};

    Class<? extends OperationHandler> operationHandler();
}
