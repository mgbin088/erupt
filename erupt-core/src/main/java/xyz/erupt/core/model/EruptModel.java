package xyz.erupt.core.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.core.annotation.EruptDataProcessor;
import xyz.erupt.core.exception.ExceptionUtil;
import xyz.erupt.core.service.DBService;
import xyz.erupt.core.service.DataService;
import xyz.erupt.core.util.AnnotationUtil;
import xyz.erupt.core.util.SpringUtil;

import java.util.*;

/**
 * Created by liyuepeng on 9/29/18.
 */
@Data
public class EruptModel {

    private transient Class<?> clazz;

    private transient Erupt erupt;

    private String eruptName;

    private JsonObject eruptJson;

    private List<EruptFieldModel> eruptFieldModels;

    private transient Map<String, EruptFieldModel> eruptFieldMap;

    public EruptModel(Class<?> eruptClazz) {
        this.clazz = eruptClazz;
        this.erupt = eruptClazz.getAnnotation(Erupt.class);
        this.eruptName = eruptClazz.getSimpleName();
        try {
            this.eruptJson = new JsonParser().parse(AnnotationUtil.annotationToJson(erupt.toString())).getAsJsonObject();
        } catch (Exception e) {
            throw ExceptionUtil.styleEruptException(this, ExceptionUtil.ANNOTATION_PARSE_ERR_STR);
        }
    }
}
