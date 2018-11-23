package com.erupt.annotation.sub_field;

import com.erupt.annotation.sub_field.sub_edit.*;

/**
 * Created by liyuepeng on 9/28/18.
 */
public @interface Edit {

    String title();

    boolean notNull() default false;

    String desc() default "";

    EditType type() default EditType.INPUT;

    boolean show() default true;

    boolean readOnly() default false;

    int sort() default 0;

    String group() default "基本信息";

    Search search() default @Search(isSearch = false);

    //如下注解虽为数组形式但是实际使用中只取数组为第零个的值(这样做可以避免大量的默认值生成，由此减轻前端json串体积)
    InputType[] inputType() default @InputType;

    ReferenceType[] referenceType() default {};

    BoolType[] boolType() default {};

    ChoiceType[] choiceType() default {};

    DictType[] dictType() default {};

    DateType[] dateType() default {};

    TabType[] tabType() default {};

    LinkType[] linkType() default {};

}
